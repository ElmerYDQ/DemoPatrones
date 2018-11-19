/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IRutaDAO;
import dao.impl.RutaDaoImpl;
import java.util.List;
import modelo.Ruta;
import service.IRutaService;

/**
 *
 * @author Diaz
 */
public class RutaService implements IRutaService {
    
    private IRutaDAO dao = new RutaDaoImpl();
    
    @Override
    public List<Ruta> listar() {
        return dao.listar();
    }

    @Override
    public Ruta getId(int id) {
        return dao.getId(id);
    }

    @Override
    public void add(Ruta t) {
        dao.add(t);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(Ruta t) {
        dao.update(t);
    }
    
}
