/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IAvenidaDAO;
import dao.impl.AvenidaDaoImpl;
import java.util.List;
import modelo.Avenida;
import service.IAvenidaService;

/**
 *
 * @author Diaz
 */
public class AvenidaService implements IAvenidaService {
    
    private IAvenidaDAO dao = new AvenidaDaoImpl();
    
    @Override
    public List<Avenida> listar() {
        return dao.listar();
    }

    @Override
    public Avenida getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(Avenida t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Avenida t) {
        dao.update(t);
    }
    
}
