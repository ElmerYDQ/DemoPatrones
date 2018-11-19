/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IBusDAO;
import dao.impl.BusDaoImpl;
import java.util.List;
import modelo.Bus;
import service.IBusService;

/**
 *
 * @author Diaz
 */
public class BusService implements IBusService {
    
    private IBusDAO dao = new BusDaoImpl();
    
    @Override
    public List<Bus> listar() {
        return dao.listar();
    }

    @Override
    public Bus getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(Bus t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Bus t) {
        dao.update(t);
    }
    
}
