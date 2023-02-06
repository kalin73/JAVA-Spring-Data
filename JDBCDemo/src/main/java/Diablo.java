import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Diablo {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		Properties props = new Properties();
		props.setProperty("user", "root");
		props.setProperty("password", "root");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

		System.out.println("Enter username:");
		String username = sc.nextLine();

		PreparedStatement statement = connection
				.prepareStatement("SELECT user_name, first_name, last_name, (SELECT COUNT(*)" 
						+ " FROM users_games WHERE user_id = u.id) AS games_count "
						+ "FROM users AS u" 
						+ " WHERE user_name = ?");
		statement.setString(1, username);

		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			String dbUsername = rs.getString("user_name");
			String dbFirstName = rs.getString("first_name");
			String dbLastName = rs.getString("last_name");
			int dbGamesCount = rs.getInt("games_count");

			System.out.printf("User: %s %n%s %s has played %d games", dbUsername, dbFirstName, dbLastName,
					dbGamesCount);

		} else {
			System.out.println("No such user exist");
		}
		sc.close();
	}

}
