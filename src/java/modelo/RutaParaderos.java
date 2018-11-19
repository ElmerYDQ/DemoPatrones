/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Diaz
 */
public class RutaParaderos implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idRuta;
    private int idParadero;

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdParadero() {
        return idParadero;
    }

    public void setIdParadero(int idParadero) {
        this.idParadero = idParadero;
    }

    @Override
    public String toString() {
        return "RutaParaderos{" + "idRuta=" + idRuta + ", idParadero=" + idParadero + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idRuta;
        hash = 59 * hash + this.idParadero;
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
        final RutaParaderos other = (RutaParaderos) obj;
        if (this.idRuta != other.idRuta) {
            return false;
        }
        if (this.idParadero != other.idParadero) {
            return false;
        }
        return true;
    }
    
}
