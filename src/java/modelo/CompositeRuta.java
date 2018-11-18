/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diaz
 */
public class CompositeRuta extends Componente {
    
    private int idRuta;
    private int paraderoInicio;
    private int paraderoFinal;
    private String nombre;
    private List<Componente> listaRuta;
    
    public CompositeRuta() {
        this.listaRuta = new ArrayList<>();
    }

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
    public void add(Componente componente) {
        listaRuta.add(componente);
    }

    @Override
    public void remove(Componente componente) {
        listaRuta.remove(componente);
    }

    public List<Componente> getListaRuta() {
        return listaRuta;
    }
    
}
