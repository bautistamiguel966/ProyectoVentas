
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String BuscarNombreUsuario(int usuario_id) {
        String nombre = "";
        String sql = "SELECT nombre, apellido FROM usuarios WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombre = (rs.getString("nombre")) + " " +(rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return nombre;
    }
}
