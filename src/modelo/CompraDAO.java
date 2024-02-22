
package modelo;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.filechooser.FileSystemView;


public class CompraDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdCompra(){
        int id = 0;
        String sql = "SELECT MAX(id) FROM compras";
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
    
    public int RegistrarCompra(Compra c){
        String sql = "INSERT INTO compras (usuarios_id, total, fecha, hora, estado, proveedores_id) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getUsuarios_id());
            ps.setDouble(2, c.getTotal());
            ps.setDate(3, java.sql.Date.valueOf(c.getFecha()));
            ps.setTime(4, Time.valueOf(c.getHora()));
            ps.setBoolean(5, true);
            ps.setInt(6, c.getProveedores_id());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    public int RegistrarDetalle(DetalleCompra Dc){
       String sql = "INSERT INTO detalles_compra (productos_id, cantidad, precio_unitario, compras_id, estado) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dc.getProductos_id());
            ps.setInt(2, Dc.getCantidad());
            ps.setDouble(3, Dc.getPrecio_unitario());
            ps.setInt(4, Dc.getCompras_id());
            ps.setBoolean(5, true);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return r;
    }
    
    
    public List ListarComprasPorUsuario(){
       List<Compra> ListaCompra = new ArrayList();
       String sql = "SELECT u.id AS id_usuario, u.nombre, c.* FROM usuarios u INNER JOIN compras c ON u.id = c.usuarios_id";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Compra compra = new Compra();
               compra.setId(rs.getInt("id"));
               compra.setNombre_usuario(rs.getString("nombre"));
               compra.setTotal(rs.getDouble("total"));
               ListaCompra.add(compra);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaCompra;
   }
    public List ListarCompras(){
       List<Compra> ListaCompra = new ArrayList();
       String sql = "SELECT * FROM compras";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Compra compra = new Compra();
               compra.setId(rs.getInt("id"));
               compra.setTotal(rs.getDouble("total"));
               compra.setFecha(rs.getDate("fecha").toLocalDate());
               compra.setHora(rs.getTime("hora").toLocalTime());
               compra.setUsuarios_id(rs.getInt("usuarios_id"));
               compra.setProveedores_id(rs.getInt("proveedores_id"));
               ListaCompra.add(compra);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaCompra;
   }
        
    public Compra BuscarCompra(int id){
        Compra c = new Compra();
        String sql = "SELECT * FROM compras WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setTotal(rs.getDouble("total"));
                c.setUsuarios_id(rs.getInt("usuarios_id"));
                c.setFecha(rs.getDate("fecha").toLocalDate());
                c.setHora(rs.getTime("hora").toLocalTime());
                c.setProveedores_id(rs.getInt("proveedores_id"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return c;
    }
    public void pdfC(int idcompra, double total, String usuario) {
        try {
            java.util.Date date = new java.util.Date();
            FileOutputStream archivo;
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File salida = new File(url + "compra.pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance(getClass().getResource("/Img/logo_pdf.png"));
            //Fecha
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Vendedor: " + usuario + "\nFolio: " + idcompra + "\nFecha: "
                    + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\nHora: " + LocalTime.now() + "\n\n");
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{20f, 30f, 70f, 60f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            Encabezado.addCell("");
            //info empresa
            String config = "SELECT * FROM configuraciones";
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(config);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Encabezado.addCell("\nNombre: " + rs.getString("nombre_negocio") + "\nTeléfono: " + rs.getString("telefono") + "\nDirección: " + rs.getString("direccion") + "\n\n");
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            //
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
 
            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.getDefaultCell().setBorder(0);
            float[] columnWidths = new float[]{10f, 50f, 15f, 15f};
            tabla.setWidths(columnWidths);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell c1 = new PdfPCell(new Phrase("Cant.", negrita));
            PdfPCell c2 = new PdfPCell(new Phrase("Descripción.", negrita));
            PdfPCell c3 = new PdfPCell(new Phrase("P. unt.", negrita));
            PdfPCell c4 = new PdfPCell(new Phrase("P. Total", negrita));
            c1.setBorder(Rectangle.NO_BORDER);
            c2.setBorder(Rectangle.NO_BORDER);
            c3.setBorder(Rectangle.NO_BORDER);
            c4.setBorder(Rectangle.NO_BORDER);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
            String product = "SELECT d.id, d.productos_id, d.compras_id, d.precio_unitario, d.cantidad, p.id, p.nombre FROM detalles_compra d INNER JOIN productos p ON d.productos_id = p.id WHERE d.compras_id = ?";
            try {
                ps = con.prepareStatement(product);
                ps.setInt(1, idcompra);
                rs = ps.executeQuery();
                while (rs.next()) {
                    double subTotal = rs.getInt("cantidad") * rs.getDouble("precio_unitario");
                    tabla.addCell(rs.getString("cantidad"));
                    tabla.addCell(rs.getString("nombre"));
                    tabla.addCell(rs.getString("precio_unitario"));
                    tabla.addCell(String.valueOf(subTotal));
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            doc.add(tabla);
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total S/: " + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion \n\n");
            firma.add("------------------------------------\n");
            firma.add("Firma \n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            Paragraph gr = new Paragraph();
            gr.add(Chunk.NEWLINE);
            gr.setAlignment(Element.ALIGN_CENTER);
            doc.add(gr);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(salida);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
}

