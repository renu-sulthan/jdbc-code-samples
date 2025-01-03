import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {

    public static void main(String[] args) {
        String insertQuery = "INSERT INTO products (product_name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";

        String url = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false";
        String username = "root";
        String password = "ROoT@SmY12.";

        // 1. Establish connection
        try (Connection connection = DriverManager.getConnection(url, username, password);

             // 2. Create PreparedStatement
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // 3. Set parameters
            preparedStatement.setString(1, "Headphones");
            preparedStatement.setString(2, "Wireless headphones with noise cancellation");
            preparedStatement.setDouble(3, 99.99);
            preparedStatement.setInt(4, 150);

            // 4. Execute the query
            int rowsInserted = preparedStatement.executeUpdate();

            System.out.println(rowsInserted + " row(s) inserted!");

        } catch (SQLException e) {
            System.out.println("Error connecting to the database or executing the query.");
            e.printStackTrace();
        }
    }
}
