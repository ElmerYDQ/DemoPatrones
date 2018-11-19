/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Diaz
 */
public class Paradero implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idParadero;
        hash = 11 * hash + this.idAvenida;
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.direccion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paradero other = (Paradero) obj;
        if (this.idParadero != other.idParadero) {
            return false;
        }
        if (this.idAvenida != other.idAvenida) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return true;
    }
    
}
