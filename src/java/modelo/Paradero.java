/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Diaz
 */
public class Paradero {
    private int idParadero;
    private int idAvenida;
    private String nombre;
    private String direccion;

    public int getIdParadero() {
        return idParadero;
    }

    public void setIdParadero(int idParadero) {
        this.idParadero = idParadero;
    }

    public int getIdAvenida() {
        return idAvenida;
    }

    public void setIdAvenida(int idAvenida) {
        this.idAvenida = idAvenida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Paradero{" + "idParadero=" + idParadero + ", idAvenida=" + idAvenida + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
    
}
