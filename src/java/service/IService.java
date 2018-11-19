/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import modelo.Conductor;

/**
 *
 * @author Diaz
 */
public interface IService<T> {
    public List<T> listar();
    
    public T getId(int id);
    
    public void add(T t);
    
    public void delete(int id);
    
    public void update(T t);
}
