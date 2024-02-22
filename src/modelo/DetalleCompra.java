
package modelo;


public class DetalleCompra {
    private int id;
    private int cantidad;
    private double precio_unitario;
    private boolean estado;
    private int compras_id;
    private int productos_id;
    
    
    public DetalleCompra(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCompras_id() {
        return compras_id;
    }

    public void setCompras_id(int compras_id) {
        this.compras_id = compras_id;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }
    
    
    
}
