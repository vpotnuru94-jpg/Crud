import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insert {

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_schema",
                    "root",
                    "manager"
            );

            System.out.println("dbConnected");

            // SQL query
            String sql = "INSERT INTO users (id, name, marks) VALUES (?, ?, ?)";

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // First record
            ps.setInt(1, 101);
            ps.setString(2, "laxmi");
            ps.setInt(3, 60);
            ps.addBatch();

            // Second record
            ps.setInt(1, 102);
            ps.setString(2, "naveen");
            ps.setInt(3, 90);
            ps.addBatch();

            // Execute both records
            ps.executeBatch();

            System.out.println("Records inserted successfully");

            // Close connection
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
