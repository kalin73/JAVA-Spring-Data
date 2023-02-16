package orm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import orm.annotations.Column;
import orm.annotations.Entity;
import orm.annotations.Id;

public class EntityManager<T> implements DBContext<T> {
	private final Connection connection;

	private static final String CREATE_QUERY_FORMANT = "CREATE TABLE %s (id INT PRIMARY KEY AUTO_INCREMENT, %s)";
	private static final String GET_ALL_COLUMNS_NAMES_BY_TABLE_NAME = "SELECT `COLUMN_NAME` "
			+ "FROM `INFORMATION_SCHEMA`.`COLUMNS` " + "WHERE `TABLE_SCHEMA`='soft_uni' " + "AND `COLUMN_NAME` != 'id' "
			+ "AND `TABLE_NAME`= ?;";
	private static final String ADD_COLUMN_FORMAT = "ADD COLUMN %s %s";
	private static final String ALTER_TABLE_FORMAT = "ALTER TABLE %s %s";
	private static final String DELETE_RECORD_BY_CONDITION_FORMAT = "DELETE FROM %s WHERE %s = %s";

	public EntityManager(Connection connection) {
		this.connection = connection;
	}

	public boolean persist(T entity) throws SQLException, IllegalArgumentException, IllegalAccessException {
		String tableName = this.getTableName(entity.getClass());
		String fieldList = this.getDBFieldsWithoutId(entity);
		String valueList = this.getValuesWithoutIdentity(entity);
		String sql = "";

		Field primaryKey = getId(entity.getClass());
		primaryKey.setAccessible(true);
		Long value = primaryKey.getLong(entity);

		if (value == null || value == 0) {
			sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, fieldList, valueList);
			return this.connection.prepareStatement(sql).execute();
		}
		String key = String.valueOf(value);
		return doUpdate(tableName, fieldList, valueList, key);
	}

	private boolean doUpdate(String tableName, String fieldList, String valueList, String key) throws SQLException {
		String[] fields = fieldList.split(",");
		String[] values = valueList.split(",");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < fields.length; i++) {
			sb.append(fields[i] + "=" + values[i] + ", ");
		}
		String result = sb.substring(0, sb.length() - 2);

		String sql = String.format("UPDATE %s SET %s WHERE id=%s", tableName, result, key);

		return this.connection.prepareStatement(sql).execute();
	}

	private String getValuesWithoutIdentity(T entity) throws IllegalArgumentException, IllegalAccessException {
		Field[] declaredFields = entity.getClass().getDeclaredFields();
		List<String> result = new ArrayList<>();

		for (Field declaredField : declaredFields) {
			if (declaredField.getAnnotation(Column.class) == null) {
				continue;
			}
			declaredField.setAccessible(true);
			Object value = declaredField.get(entity);
			result.add("\"" + value.toString() + "\"");
		}
		return String.join(",", result);
	}

	private String getDBFieldsWithoutId(T entity) {
		return Arrays.stream(entity.getClass().getDeclaredFields()).filter(f -> f.getAnnotation(Column.class) != null)
				.map(f -> f.getAnnotation(Column.class).name()).collect(Collectors.joining(", "));

	}

	private String getTableName(Class<?> clazz) {
		Entity annotation = clazz.getAnnotation(Entity.class);

		if (annotation == null) {
			throw new ORMException("Provided class does not have entity annotation");
		}
		return annotation.name();

	}

	public Iterable<T> find(Class<T> entityType) throws SQLException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return find(entityType, null);
	}

	public T findFirst(Class<T> entityType)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, SQLException {
		return findFirst(entityType, null);
	}

	public Iterable<T> find(Class<T> entityType, String where)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		String tableName = this.getTableName(entityType);
		String sql = String.format("SELECT * FROM %s %s", tableName, where.equals("") ? "" : "WHERE " + where);

		ResultSet resultSet = this.connection.prepareStatement(sql).executeQuery();

		List<T> result = new ArrayList<>();
		T entity = this.createEntity(entityType, resultSet);

		while (entity != null) {
			result.add(entity);
			entity = this.createEntity(entityType, resultSet);
		}

		return result;
	}

	public T findFirst(Class<T> entityType, String where)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		String tableName = this.getTableName(entityType);
		String sql = String.format("SELECT * FROM %s %s LIMIT 1", tableName, where.equals("") ? "" : "WHERE " + where);

		ResultSet result = this.connection.prepareStatement(sql).executeQuery();

		return this.createEntity(entityType, result);
	}

	private T createEntity(Class<T> entityType, ResultSet result)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		if (!result.next()) {
			return null;
		}
		T entity = entityType.getDeclaredConstructor().newInstance();

		Field[] fields = entityType.getDeclaredFields();

		for (Field field : fields) {
			if (!field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class)) {
				continue;
			}

			Column columnAnotation = field.getAnnotation(Column.class);

			String fieldName = columnAnotation == null ? field.getName() : columnAnotation.name();

			String value = result.getString(fieldName);
			entity = this.fillData(entity, field, value);
		}

		return entity;
	}

	private T fillData(T entity, Field field, String value)
			throws NumberFormatException, IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);

		if (field.getType() == long.class || field.getType() == Long.class) {
			field.setLong(entity, Long.parseLong(value));

		} else if (field.getType() == LocalDate.class) {
			field.set(entity, LocalDate.parse(value));

		} else if (field.getType() == String.class) {
			field.set(entity, value);

		} else if (field.getType() == int.class || field.getType() == Integer.class) {
			field.setInt(entity, Integer.parseInt(value));

		} else {
			throw new ORMException("Unsupported type " + field.getType());
		}

		return entity;
	}

	private Field getId(Class<?> entity) {
		return Arrays.stream(entity.getDeclaredFields()).filter(x -> x.isAnnotationPresent(Id.class)).findFirst()
				.orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
	}

	@Override
	public void doCreate(Class<T> entity) throws SQLException {
		final String tableName = getTableName(entity);

		final List<KeyValuePair> fieldsWithTypes = getAllFieldsAndTypesInKeyValuePairs(entity);

		final String fieldsWithTypesFormat = fieldsWithTypes.stream()
				.map(keyValuePair -> String.format("%s %s", keyValuePair.key, keyValuePair.value))
				.collect(Collectors.joining(", "));

		final PreparedStatement createStatement = connection
				.prepareStatement(String.format(CREATE_QUERY_FORMANT, tableName, fieldsWithTypesFormat));

		createStatement.execute();

	}

	private List<KeyValuePair> getAllFieldsAndTypesInKeyValuePairs(Class<T> entity) {
		return getAllFieldsWithoutId(entity).stream()
				.map(field -> new KeyValuePair(getSQLColumnName(field), getSQLType(field.getType()))).toList();

	}

	private String getSQLType(Class<?> type) {
		if (type == Integer.class || type == int.class) {
			return "INT";

		} else if (type == LocalDate.class) {
			return "DATE";

		}

		return "VARCHAR(45)";
	}

	private String getSQLColumnName(Field field) {
		return field.getAnnotationsByType(Column.class)[0].name();
	}

	private List<Field> getAllFieldsWithoutId(Class<T> entity) {
		return Arrays.stream(entity.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Column.class))
				.toList();

	}

	@Override
	public void doAlter(Class<T> entity) throws SQLException {
		final String tableName = getTableName(entity);
		final String columnStatementForNewFields = addColumnsStatementForNewFields(entity, tableName);

		final String alterQuery = String.format(ALTER_TABLE_FORMAT, tableName, columnStatementForNewFields);

		PreparedStatement alterStatement = connection.prepareStatement(alterQuery);

		alterStatement.execute();

	}

	private String addColumnsStatementForNewFields(Class<T> entity, String tableName) throws SQLException {
		final Set<String> sqlColumns = getSQLColumnNames(entity, tableName);
		final List<Field> allFieldsWithoutId = getAllFieldsWithoutId(entity);

		final List<String> newFieldsStatement = new ArrayList<>();

		for (Field field : allFieldsWithoutId) {
			final String fieldName = getSQLColumnName(field);

			if (sqlColumns.contains(fieldName)) {
				continue;
			}
			final String sqlType = getSQLType(field.getClass());

			String addStatement = String.format(ADD_COLUMN_FORMAT, fieldName, sqlType);

			newFieldsStatement.add(addStatement);

		}

		return String.join(", ", newFieldsStatement);
	}

	private Set<String> getSQLColumnNames(Class<T> entity, String tableName) throws SQLException {
		Set<String> allFields = new HashSet<>();

		final PreparedStatement statement = connection.prepareStatement(GET_ALL_COLUMNS_NAMES_BY_TABLE_NAME);
		statement.setString(1, tableName);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			allFields.add(resultSet.getString(1));
		}

		return allFields;
	}

	@Override
	public void doDelete(T entity) throws SQLException, IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException {
		final String tableName = getTableName(entity.getClass());

		final Field idField = getId(entity.getClass());

		final String idName = entity.getClass().getDeclaredField("id").getAnnotation(Id.class).name();
		final Object idValue = getFieldValue(entity, idField);
		final String deleteQuery = String.format(DELETE_RECORD_BY_CONDITION_FORMAT, tableName, idName, idValue);

		final PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);

		deleteStatement.execute();

	}

	private Object getFieldValue(T entity, Field idName) throws IllegalArgumentException, IllegalAccessException {
		idName.setAccessible(true);

		return idName.get(entity);
	}

	private record KeyValuePair(String key, String value) {

	}

}
