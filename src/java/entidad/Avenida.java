/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Diaz
 */
public class Avenida {
    private int idAvenida;
    private String nombre;

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

    @Override
    public String toString() {
        return "Avenida{" + "idAvenida=" + idAvenida + ", nombre=" + nombre + '}';
    }
    
}
