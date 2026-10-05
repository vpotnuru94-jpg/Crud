import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class create{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_schema",
                    "root",
                    "manager"
            );

            System.out.println("dbConnected");

            Statement st = con.createStatement();

            st.executeUpdate(
                    "CREATE TABLE users (id INT, name VARCHAR(50), marks INT)"
            );

            System.out.println("Table Created");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
