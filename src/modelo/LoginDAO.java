
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public LoginModelo log(String correo, String password){
        LoginModelo l = new LoginModelo();
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs= ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setNombre(rs.getString("apellido"));
                l.setCorreo(rs.getString("correo"));
                l.setPassword(rs.getString("password"));
                l.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    
    public boolean Registrar(LoginModelo reg){
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, password, telefono ) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getApellido());
            ps.setString(3, reg.getCorreo());
            ps.setString(4, reg.getPassword());
            ps.setString(5, reg.getTelefono());
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
               lg.setCorreo(rs.getString("correo"));
               lg.setTelefono(rs.getString("telefono"));
               Lista.add(lg);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return Lista;
   }
}
