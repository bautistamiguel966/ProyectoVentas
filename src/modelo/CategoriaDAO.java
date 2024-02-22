
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import modelo.Categoria;
import modelo.Conexion;
import modelo.Proveedor;


public class CategoriaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarCategoria(Categoria cat){
        String sql = "INSERT INTO categorias (nombre, estado) VALUES (?,?)";
        try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, cat.getNombre());
           ps.setBoolean(2, true);
           ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarCategoria(){
        List<Categoria> ListaCat = new ArrayList();
        String sql = "SELECT * FROM categorias WHERE estado = true";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNombre(rs.getString("nombre"));
                ListaCat.add(cat);
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCat;
    }
    
    
    public void consultarCategoria(JComboBox categoria){
        String sql = "SELECT nombre FROM categorias WHERE estado = true";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                categoria.addItem(rs.getString("nombre"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean EliminarCategoria(int id){
        String sql = "UPDATE categorias SET estado=false WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean ModificarCategoria(Categoria cat){
        String sql = "UPDATE categorias SET nombre=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getNombre());
            ps.setInt(2, cat.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public Categoria BuscarCategoria(String nombre){
        Categoria cat = new Categoria();
        String sql = "SELECT * FROM categorias WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                cat.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cat;
    }
}
