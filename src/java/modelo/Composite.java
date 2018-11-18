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
public class Composite extends Componente {
    private List<Componente> listaRuta;
    
    public Composite() {
        this.listaRuta = new ArrayList<>();
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
