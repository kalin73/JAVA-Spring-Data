import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetVillainsNames {

	private static final String GET_VILLAINS_NAMES = "SELECT v.name, " + "count(distinct mv.minion_id) minions_count "
			+ "from villains v " + "JOIN minions_villains mv on v.id = mv.villain_id " + "GROUP by mv.villain_id "
			+ "HAVING minions_count > ? " + "ORDER by minions_count;";

	private static final String COLUMN_LABEL_NAME = "name";
	private static final String COLUMN_LABEL_NAME_MINION_COUNT = "minions_count";

	public static void main(String[] args) throws SQLException {
		final Connection connection = Utils.getSQLConnection();
		final PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAMES);
		statement.setInt(1, 15);
		final ResultSet result = statement.executeQuery();

		if (result.next()) {
			final String name = result.getString(COLUMN_LABEL_NAME);
			final int count = result.getInt(COLUMN_LABEL_NAME_MINION_COUNT);

			System.out.printf("%s %d", name, count);
		}
		connection.close();
	}

}
