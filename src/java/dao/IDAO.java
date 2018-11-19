/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Diaz
 */
public interface IDAO<T> {
    
    public List<T> listar();
    
    public T getId(int id);
    
    public void add(T t);
    
    public void delete(int id);
    
    public void update(T t);
}
