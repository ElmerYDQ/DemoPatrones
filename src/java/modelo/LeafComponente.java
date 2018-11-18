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
public class LeafComponente extends Componente {
    private RutaParaderos rutaParaderos;
    
    public LeafComponente(RutaParaderos rutaParaderos) {
        this.rutaParaderos = rutaParaderos;
    }

    public RutaParaderos getRutaParaderos() {
        return rutaParaderos;
    }
    
    @Override
    public void add(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
