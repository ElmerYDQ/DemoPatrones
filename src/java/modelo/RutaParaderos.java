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
public class RutaParaderos {
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
    
}
