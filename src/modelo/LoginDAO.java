
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public LoginModelo log(String nombre_usuario, String password){
        LoginModelo l = new LoginModelo();
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre_usuario);
            ps.setString(2, password);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setNombre(rs.getString("apellido"));
                l.setNombre_usuario(rs.getString("nombre_usuario"));
                l.setPassword(rs.getString("password"));
                l.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    public boolean Registrar(LoginModelo reg){
        String sql = "INSERT INTO usuarios (nombre, apellido, nombre_usuario, password, telefono, fecha_creacion, estado ) VALUES (?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getApellido());
            ps.setString(3, reg.getNombre_usuario());
            ps.setString(4, reg.getPassword());
            ps.setString(5, reg.getTelefono());
            ps.setDate(6, java.sql.Date.valueOf(LocalDate.now()));
            ps.setBoolean(7, true);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public List ListarUsuarios(){
       List<LoginModelo> Lista = new ArrayList();
       String sql = "SELECT * FROM usuarios";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               LoginModelo lg = new LoginModelo();
               lg.setId(rs.getInt("id"));
               lg.setNombre(rs.getString("nombre"));
               lg.setNombre(rs.getString("apellido"));
               lg.setNombre_usuario(rs.getString("nombre_usuario"));
               lg.setTelefono(rs.getString("telefono"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Lista;
   }
}
