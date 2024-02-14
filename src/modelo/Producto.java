
package modelo;


public class Producto {
    private int id;
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int categoria;
    private String categoriaPro;
    private boolean estado;
    
    public Producto(){}

    public Producto(int id, String codigo, String nombre, double precio, int stock, int categoria, String categoriaPro) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.categoriaPro = categoriaPro;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaPro() {
        return categoriaPro;
    }

    public void setCategoriaPro(String categoriaPro) {
        this.categoriaPro = categoriaPro;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    
    
}
