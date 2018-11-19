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
public class Bus implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idBus;
    private int idEstado;
    private String placa;
    private String soat;
    private int capacidad;
    private int anho;

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        return "Bus{" + "idBus=" + idBus + ", idEstado=" + idEstado + ", placa=" + placa + ", SOAT=" + soat + ", capacidad=" + capacidad + ", anho=" + anho + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idBus;
        hash = 31 * hash + this.idEstado;
        hash = 31 * hash + Objects.hashCode(this.placa);
        hash = 31 * hash + Objects.hashCode(this.soat);
        hash = 31 * hash + this.capacidad;
        hash = 31 * hash + this.anho;
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
        final Bus other = (Bus) obj;
        if (this.idBus != other.idBus) {
            return false;
        }
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        if (this.anho != other.anho) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.soat, other.soat)) {
            return false;
        }
        return true;
    }
    
}
