
package modelo;


public class Proveedor {
    private int id;
    private String nombre;
    private boolean estado;
    private String direccion;
    private String telefono;
    
    public Proveedor(){}
    
    public Proveedor(int id, String nombre, String direccion, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.estado = true;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   
    
    
}
