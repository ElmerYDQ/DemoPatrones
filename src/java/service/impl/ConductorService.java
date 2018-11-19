/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IConductorDAO;
import dao.impl.ConductorDaoImpl;
import java.util.List;
import modelo.Conductor;
import service.IConductorService;

/**
 *
 * @author Diaz
 */
public class ConductorService implements IConductorService {
    
    private IConductorDAO dao = new ConductorDaoImpl();
    
    @Override
    public List<Conductor> listar() {
        return dao.listar();
    }

    @Override
    public Conductor getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(Conductor t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Conductor t) {
        dao.update(t);
    }
    
}
