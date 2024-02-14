
package modelo;


public class Categoria {
    private int id;
    private String nombre;
    private boolean estado;
    
    public Categoria(){}
    
    public Categoria(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.estado = true;
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
    
    
    
}
