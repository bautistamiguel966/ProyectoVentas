
package modelo;


public class DetalleVenta {
    private int id;
    private int cantidad;
    private double precio_unitario;
    private boolean estado;
    private int ventas_id;
    private int productos_id;

    public DetalleVenta() {
    }

    public DetalleVenta(int id, int cantidad, double precio_unitario, int ventas_id, int productos_id) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.ventas_id = ventas_id;
        this.productos_id = productos_id;
        this.estado = true;
    }

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

    public int getVentas_id() {
        return ventas_id;
    }

    public void setVentas_id(int ventas_id) {
        this.ventas_id = ventas_id;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }
    
    
    
    
}
