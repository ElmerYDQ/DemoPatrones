/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IParaderoDAO;
import dao.impl.ParaderoDaoImpl;
import java.util.List;
import modelo.Paradero;
import service.IParaderoService;

/**
 *
 * @author Diaz
 */
public class ParaderoService implements IParaderoService {
    
    private IParaderoDAO dao = new ParaderoDaoImpl();
    
    @Override
    public List<Paradero> listar() {
        return dao.listar();
    }

    @Override
    public Paradero getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(Paradero t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Paradero t) {
        dao.update(t);
    }
    
}
