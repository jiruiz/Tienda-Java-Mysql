
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Ignacio Ruiz
 */
public class Cls_Conexion {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String URL = "jdbc:mysql://localhost:3306/tienda?autoReconnect=true&useSSL=false";
    private Connection CN;
    
    public Cls_Conexion(){
        CN = null;
    }
    
    public Connection getConnection(){
        try {
            Class.forName(DRIVER);
            CN = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    
        return CN;
    }
    
    public void close(){
        try {
        
            CN.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al conectar la base de datos", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
