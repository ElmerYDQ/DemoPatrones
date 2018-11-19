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
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idRuta;
    private int paraderoInicio;
    private int paraderoFinal;
    private String nombre;

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getParaderoInicio() {
        return paraderoInicio;
    }

    public void setParaderoInicio(int paraderoInicio) {
        this.paraderoInicio = paraderoInicio;
    }

    public int getParaderoFinal() {
        return paraderoFinal;
    }

    public void setParaderoFinal(int paraderoFinal) {
        this.paraderoFinal = paraderoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ruta{" + "idRuta=" + idRuta + ", paraderoInicio=" + paraderoInicio + ", paraderoFinal=" + paraderoFinal + ", nombre=" + nombre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idRuta;
        hash = 97 * hash + this.paraderoInicio;
        hash = 97 * hash + this.paraderoFinal;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Ruta other = (Ruta) obj;
        if (this.idRuta != other.idRuta) {
            return false;
        }
        if (this.paraderoInicio != other.paraderoInicio) {
            return false;
        }
        if (this.paraderoFinal != other.paraderoFinal) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
}
