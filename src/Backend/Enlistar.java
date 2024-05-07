package Backend;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Enlistar {

    public static void main(String[] args) throws ClassNotFoundException, SQLException,InstantiationException,IllegalAccessException{

        String usuario="Luffy";
        String clave="234";

        
        boolean bnd=verificacionUsuario(usuario,clave);

        if(bnd){
            System.out.println("usuario bienvenido "+ usuario);
        }else{
            System.out.println("usuario no permitido");
        }


    }

    public static boolean verificacionUsuario(String usuario, String contraseña)throws ClassNotFoundException, SQLException,InstantiationException,IllegalAccessException{
        Connection cnx = Conectar.conexion();
        String consulta= "select * from usuarios";

        Statement s = cnx.createStatement();
        ResultSet resultado = s.executeQuery(consulta);

        
        while(resultado.next()){
            if(resultado.getString("username").equals(usuario) && resultado.getString("password").equals(contraseña)){
                int id = resultado.getInt("id");
                cnx.close();
                s.close();
                resultado.close();
                ingresarUsuario(usuario, id);
                return true;
            }
        }
        cnx.close();
        s.close();
        resultado.close();
        return false;
    }

    public static void ingresarUsuario(String usuario, int id) throws ClassNotFoundException, SQLException,InstantiationException,IllegalAccessException{
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM HH:mm");
        String fechaHoraFormateada = fechaHoraActual.format(formatter);

        int fecha = Integer.parseInt(fechaHoraFormateada.substring(0,2));
        int hora = Integer.parseInt(fechaHoraFormateada.substring(3,5));;
        int mes = Integer.parseInt(fechaHoraFormateada.substring(6,8));;

        Connection cnx = Conectar.conexion();
        String consulta= "INSERT INTO ingresos (id_usuario, dia, mes, hora) VALUES (" + id + ", "+ fecha + ", "+ hora + ", "+ mes + ")";

        Statement s = cnx.createStatement();
        s.executeUpdate(consulta);
        cnx.close();
        s.close();
    }
}