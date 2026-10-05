import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class update{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_schema", "root", "manager");
            String sql="Update users set marks=? where id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2,98);
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("row's updated");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
