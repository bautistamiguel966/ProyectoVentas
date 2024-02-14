
package modelo;


public class Config {
    private int id;
    private String nombre_negocio;
    private String direccion;
    private String telefono;
    private boolean estado;
    
    public Config(){}
    
    public Config(int id, String nombre_negocio, String direccion, String telefono){
        this.id = id;
        this.nombre_negocio = nombre_negocio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_negocio() {
        return nombre_negocio;
    }

    public void setNombre_negocio(String nombre_negocio) {
        this.nombre_negocio = nombre_negocio;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
