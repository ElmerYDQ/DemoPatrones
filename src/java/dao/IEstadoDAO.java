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
public interface IEstadoDAO {
    public List<EstadoBus> getEstadoes();
    
    public EstadoBus getEstadoId(int id);
    
    public void addEstado(EstadoBus estado);
    
    public void deleteEstado(int id);
    
    public void updateEstado(EstadoBus estado);
}
