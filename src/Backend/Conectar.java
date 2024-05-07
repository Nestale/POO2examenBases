package Backend;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class Conectar {
    

    public static Connection conexion() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String url = "jdbc:mysql://127.0.0.1:3300/examen2?user=root&password=SPLATjose2431";
        Driver d = (Driver)Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection(url);

        return conn; 
    } 
}
