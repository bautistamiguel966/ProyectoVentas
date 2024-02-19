
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConfigDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public ConfigDAO() {
        con = cn.getConnection();
    }
    
    public int BuscarUsuario(){
        int id = 0;
        String sql = "SELECT usuario_id FROM configuraciones LIMIT 1";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    
    
    public boolean ModificarDatos(Config conf){
       String sql = "UPDATE configuraciones SET nombre_negocio=?, telefono=?, direccion=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, conf.getNombre_negocio());
           ps.setString(2, conf.getTelefono());
           ps.setString(3, conf.getDireccion());
           ps.setInt(4, conf.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }
   }
 
}
