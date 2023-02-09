import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddMinion {
	private static final String GET_TOWN_BY_NAME = "SELECT t.id FROM towns t WHERE t.name = ?";
	private static final String GET_VILLAIN_BY_NAME = "SELECT v.id FROM villains v WHERE v.name = ?";
	private static final String GET_LAST_MINION = "SELECT m.id FROM minions m ORDER BY m.id desc limit 1";

	private static final String INSERT_INTO_TOWNS = "INSERT into towns(name)values(?)";
	private static final String INSERT_INTO_VILLAINS = "INSERT into villains(name, evilness_factor)values(?,?)";
	private static final String INSERT_INTO_MINIONS = "INSERT into minions(name, age, town_id)values(?,?,?)";
	private static final String INSERT_INTO_MINIONS_VILLAINS = "INSERT into minions_villains(minion_id, villain_id)values(?,?)";

	private static final String TOWN_ADDED_FORMAT = "Town %s was added to the database.%n";
	private static final String MINION_ADDED_FORMAT = "Successfully added %s to be minion of %s%n";
	private static final String VILLAIN_ADDED_FORMAT = "Villain %s was added to the database.%n";

	private static final String COLUMN_LABEL_ID = "id";
	private static final String EVILNESS_FACTOR = "evil";

	public static void main(String[] args) throws SQLException {
		final Connection connection = Utils.getSQLConnection();
		final Scanner sc = new Scanner(System.in);

		final String[] minionInfo = sc.nextLine().split(" ");

		final String minionName = minionInfo[1];
		final int minionAge = Integer.parseInt(minionInfo[2]);
		final String minionTown = minionInfo[3];

		final String villainName = sc.nextLine().split(" ")[1];

		final int townId = getId(connection, List.of(minionTown), GET_TOWN_BY_NAME, INSERT_INTO_TOWNS,
				TOWN_ADDED_FORMAT);
		final int villainId = getId(connection, List.of(villainName, EVILNESS_FACTOR), GET_VILLAIN_BY_NAME,
				INSERT_INTO_VILLAINS, VILLAIN_ADDED_FORMAT);

		final PreparedStatement insertMinionStatement = connection.prepareStatement(INSERT_INTO_MINIONS);

		insertMinionStatement.setString(1, minionName);
		insertMinionStatement.setInt(2, minionAge);
		insertMinionStatement.setInt(3, townId);

		insertMinionStatement.executeUpdate();

		final PreparedStatement lastMinion = connection.prepareStatement(GET_LAST_MINION);
		final ResultSet resultSet = lastMinion.executeQuery();
		resultSet.next();

		final int lastMinionId = resultSet.getInt(COLUMN_LABEL_ID);

		final PreparedStatement insertIntoMinionVillains = connection.prepareStatement(INSERT_INTO_MINIONS_VILLAINS);
		insertIntoMinionVillains.setInt(1, lastMinionId);
		insertIntoMinionVillains.setInt(2, villainId);
		insertIntoMinionVillains.executeUpdate();

		System.out.printf(MINION_ADDED_FORMAT, minionName, villainName);

		connection.close();
		sc.close();
	}

	private static int getId(Connection connection, List<String> arguments, String selectQuery, String insertQuery,
			String printFormat) throws SQLException {
		final String name = arguments.get(0);

		final PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
		selectStatement.setString(1, name);
		final ResultSet resultSet = selectStatement.executeQuery();

		if (!resultSet.next()) {
			PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

			for (int i = 1; i <= arguments.size(); i++) {
				insertStatement.setString(i, arguments.get(i - 1));
			}

			insertStatement.executeUpdate();

			final ResultSet newResultSet = selectStatement.executeQuery();
			newResultSet.next();
			int id = newResultSet.getInt(COLUMN_LABEL_ID);

			System.out.printf(printFormat, name);

			return id;
		}

		return resultSet.getInt(COLUMN_LABEL_ID);
	}
}
