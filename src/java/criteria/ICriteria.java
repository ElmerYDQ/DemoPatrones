/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criteria;

import java.util.List;
import modelo.Bus;
import modelo.Conductor;

/**
 *
 * @author Diaz
 */
public interface ICriteria<T> {
    
    public List<T> filtrar(List<T> lista, int id);
}
