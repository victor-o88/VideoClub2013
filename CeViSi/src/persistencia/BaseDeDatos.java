
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;
/**
 *
 * @author Alejandrux
 */
public class BaseDeDatos {
    
    protected static Connection instance = null;
    
    public static Connection getInstance()throws ClassNotFoundException, SQLException{
        
        if(instance == null){
            String url = "jdbc:postgresql://127.0.0.1:5432/cevisi";
            String driver = "org.postgresql.Driver";
            String user = "postgres";
            String pass = "1234567";
            Class.forName(driver);
            instance = DriverManager.getConnection(url, user, pass);
        }
        return instance;
    }
    
    
}
