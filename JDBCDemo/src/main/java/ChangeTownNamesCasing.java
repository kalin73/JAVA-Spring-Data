import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeTownNamesCasing {
	private static final String UPDATE_TOWN_NAME = "UPDATE towns t SET name = upper(name) WHERE t.country = ?";
	private static final String GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME = "SELECT t.name FROM towns t WHERE t.country = ?";

	private static final String COUNT_OF_AFFECTED_TOWN_FORMAT = "%d town names were affected.%n";
	private static final String NO_TOWNS_AFFECTED_MESSAGE = "No town names were affected.";

	public static void main(String[] args) throws SQLException {
		final Connection connection = Utils.getSQLConnection();
		Scanner sc = new Scanner(System.in);

		final String countryName = sc.nextLine();

		final PreparedStatement statement = connection.prepareStatement(UPDATE_TOWN_NAME);
		statement.setString(1, countryName);
		final int updatedCount = statement.executeUpdate();

		if (updatedCount == 0) {
			System.out.println(NO_TOWNS_AFFECTED_MESSAGE);
			connection.close();
			sc.close();
			return;
		}

		System.out.printf(COUNT_OF_AFFECTED_TOWN_FORMAT, updatedCount);

		final PreparedStatement selectAllTowns = connection.prepareStatement(GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME);
		selectAllTowns.setString(1, countryName);
		final ResultSet allTownsResult = selectAllTowns.executeQuery();

		ArrayList<String> towns = new ArrayList<>();

		while (allTownsResult.next()) {
			towns.add(allTownsResult.getString(Constants.COLUMN_LABEL_NAME));
		}

		System.out.println(towns);
		
		connection.close();
		sc.close();

	}

}
