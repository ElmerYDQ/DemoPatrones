/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.HistorialConductor;

/**
 *
 * @author Diaz
 */
public interface IHistorialDAO<T> {
    public List<T> getHistoriales();
    
    public T getHistorialId(int id1, int id2);
    
    public void addHistorial(T historial);
    
    public void deleteHistorial(int id1, int id2);
}
