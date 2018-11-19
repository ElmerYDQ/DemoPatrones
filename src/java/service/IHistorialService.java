/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Diaz
 */
public interface IHistorialService<T> {
    public List<T> getHistoriales();
    
    public T getHistorialId(int id1, int id2);
    
    public void addHistorial(T historial);
}
