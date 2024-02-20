
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
    
    public Config BuscarConfiguracion(){
        Config config = new Config();
        String sql = "SELECT id, usuario_id FROM configuraciones LIMIT 1";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                config.setId(rs.getInt("id"));
                config.setId(rs.getInt("usuario_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return config;
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
    
    public boolean ModificarUsuarioConectado(int usuario_id, int configuracion_id){
       String sql = "UPDATE configuraciones SET usuario_id=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, usuario_id);
           ps.setInt(2, configuracion_id);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }
   }
 
}
