import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
	private static final String GET_MINION_NAME_AND_AGE_BY_VILLIAN_ID = "SELECT m.name, m.age " 
			+ "FROM minions as m "
			+ "JOIN minions_villains mv ON m.id = mv.minion_id " 
			+ "WHERE mv.villain_id = ?";
	private static final String COLUMN_LABEL_AGE = "age";
	private static final String GET_VILLAIN_NAME_BY_ID = "SELECT name FROM villains v WHERE v.id = ?";
	private static final String VILLAIN_FORMAT = "Villain: %s%n";
	private static final String NO_VILLAIN_FORMAT = "No villain with ID %d exists in the database.";
	private static final String MINION_FORMAT = "%d. %s %d%n";

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		final Connection connection = Utils.getSQLConnection();
		final PreparedStatement villainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);

		final int villainId = sc.nextInt();
		villainStatement.setInt(1, villainId);

		final ResultSet villainSet = villainStatement.executeQuery();

		if (!villainSet.next()) {
			System.out.printf(NO_VILLAIN_FORMAT, villainId);
			sc.close();
			connection.close();
			return;
		}
		final String villainName = villainSet.getString(Constants.COLUMN_LABEL_NAME);
		System.out.printf(VILLAIN_FORMAT, villainName);

		final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINION_NAME_AND_AGE_BY_VILLIAN_ID);
		minionsStatement.setInt(1, villainId);
		final ResultSet minionsSet = minionsStatement.executeQuery();

		for (int i = 1; minionsSet.next(); i++) {
			final String minionName = minionsSet.getString(Constants.COLUMN_LABEL_NAME);
			final int minionAge = minionsSet.getInt(COLUMN_LABEL_AGE);

			System.out.printf(MINION_FORMAT, i, minionName, minionAge);

		}
		sc.close();
		connection.close();
	}
}
