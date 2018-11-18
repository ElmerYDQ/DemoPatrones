/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.EstadoBus;

/**
 *
 * @author Diaz
 */
public interface IEstadoBusDAO {
    public List<EstadoBus> getEstadoBuses();
    
    public EstadoBus getEstadoBusId(int id);
    
    public void addEstadoBus(EstadoBus estado);
    
    public void deleteEstadoBus(int id);
    
    public void updateEstadoBus(EstadoBus estado);
}
