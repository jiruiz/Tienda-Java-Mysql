
package logica;

import conexion.Cls_Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Ignacio Ruiz
 */
public class Cls_Productos {
    private final String SQL_INSERT = "INSERT INTO productos (pro_descripcion, pro_categoria,pro_cantidad,pro_costo,pro_precio,pro_estado) values(?,?,?,?,?,?)";
    private PreparedStatement PS;
    private final Cls_Conexion CN;
    
    public Cls_Productos(){
        PS = null;
        CN = new Cls_Conexion();
    }
    
    public int insertDatos(String des, String cat, int can, float cos, float pre, String est){
        try{
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setString(1, des);
            PS.setString(2, cat);
            PS.setInt(3, can);
            PS.setFloat(4, cos);
            PS.setFloat(5, pre);
            PS.setString(6, est);
            int res = PS.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado..");
            }
        } catch(SQLException e){
            System.out.println("Error al guardar los datos en la db: " + e.getMessage());
        } finally {
            PS = null;
            CN.close();
        }
        return 0;
    }
}
