package orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface DBContext<T> {
	boolean persist(T entity) throws SQLException, IllegalArgumentException, IllegalAccessException;

	Iterable<T> find(Class<T> entityType) throws SQLException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

	T findFirst(Class<T> entityType) throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException;

	Iterable<T> find(Class<T> entityType, String where)
			throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException;

	T findFirst(Class<T> entityType, String where) throws SQLException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

	void doCreate(Class<T> entity) throws SQLException;

	void doAlter(Class<T> entity) throws SQLException;

	void doDelete(T entity) throws SQLException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;

}
