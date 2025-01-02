import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementQuery {

	public static void main(String[] args) {
		
		// 1.get database connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false",
				"root", "ROoT@SmY12.");

				// 2.Create statement
				Statement statement = connection.createStatement();

				// 3 execute statement
				ResultSet resultSet = statement.executeQuery("select * from users");) {

			// 4. process result
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");

				System.out.println("id: " + id + ", name: " + name);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" not Connected to the database!");

		}

	}

}
