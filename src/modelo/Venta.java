
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Venta {
    private int id;
    private double total;
    private LocalDate fecha;
    private boolean estado;
    private int usuarios_id;
    private LocalTime hora;
    private String nombre_usuario;
    
    public Venta(){}
    
    public Venta(double total, int usuarios_id){
        this.total = total;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.usuarios_id = usuarios_id;
        this.estado = true;
    }

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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    
    
    
}
