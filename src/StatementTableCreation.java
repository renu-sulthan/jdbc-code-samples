import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTableCreation {
	public static void main(String[] args) {
		// 1. Get connection
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false",
				"root", "ROoT@SmY12.");
				// 2. Create Statement
				Statement statement = connection.createStatement();) {
			// 3. Execute Query
			int result = statement.executeUpdate(createTableQuery());

			System.out.println("Table 'products' created successfully and result : " + result);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("not Connected to the database!");
		}
	}

	private static String createTableQuery() {

		return "CREATE TABLE IF NOT EXISTS products (" + "product_id INT AUTO_INCREMENT PRIMARY KEY, "
				+ "product_name VARCHAR(100) NOT NULL, " + "description TEXT, " + "price DECIMAL(10, 2) NOT NULL, "
				+ "stock_quantity INT NOT NULL);";

	}

}
