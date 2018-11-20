/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criteria;

import java.util.ArrayList;
import java.util.List;
import modelo.Bus;
import modelo.Conductor;
import modelo.HistorialBus;

/**
 *
 * @author Diaz
 */
public class HistorialBusCriteria implements ICriteria<HistorialBus> {

    @Override
    public List<HistorialBus> filtrar(List<HistorialBus> lista,int id) {
        List<HistorialBus> listaRuta = new ArrayList<>();
        for(HistorialBus historial : lista) {
            if(historial.getIdRuta() == id) {
                listaRuta.add(historial);
            }
        }
        return listaRuta;
    }

}
