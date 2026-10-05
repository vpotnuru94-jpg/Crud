import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class delete {
    public  static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "manager");
            String sql ="Delete  from users where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,2);
            int row=ps.executeUpdate();
            if(row>0){
                System.out.println("Row Deleted Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
