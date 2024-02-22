
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Compra {
    private int id;
    private double total;
    private LocalDate fecha;
    private LocalTime hora;
    private int proveedores_id;
    private int usuarios_id;
    private boolean estado;
    private String nombre_usuario;
    
    
    public Compra(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getProveedores_id() {
        return proveedores_id;
    }

    public void setProveedores_id(int proveedores_id) {
        this.proveedores_id = proveedores_id;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    
    
    
}
