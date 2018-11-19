/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Diaz
 */
public class HistorialConductor implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idBus;
    private int idConductor;
    private Date fecha;

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "HistorialConductor{" + "idBus=" + idBus + ", idConductor=" + idConductor + ", fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idBus;
        hash = 17 * hash + this.idConductor;
        hash = 17 * hash + Objects.hashCode(this.fecha);
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
        final HistorialConductor other = (HistorialConductor) obj;
        if (this.idBus != other.idBus) {
            return false;
        }
        if (this.idConductor != other.idConductor) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
}
