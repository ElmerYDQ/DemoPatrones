/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IEstadoBusDAO;
import dao.impl.EstadoBusDaoImpl;
import java.util.List;
import modelo.EstadoBus;
import service.IEstadoBusService;

/**
 *
 * @author Diaz
 */
public class EstadoBusService implements IEstadoBusService {
    
    private IEstadoBusDAO dao = new EstadoBusDaoImpl();
    
    @Override
    public List<EstadoBus> listar() {
        return dao.listar();
    }

    @Override
    public EstadoBus getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(EstadoBus t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(EstadoBus t) {
        dao.update(t);
    }
    
}
