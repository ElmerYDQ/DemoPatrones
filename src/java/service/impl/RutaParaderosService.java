/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.IRutaParaderosDAO;
import dao.impl.RutaParaderosDaoImpl;
import java.util.List;
import modelo.RutaParaderos;
import service.IRutaParaderosService;

/**
 *
 * @author Diaz
 */
public class RutaParaderosService implements IRutaParaderosService {
    
    IRutaParaderosDAO dao = new RutaParaderosDaoImpl();
    
    @Override
    public List<RutaParaderos> listar() {
        return dao.listar();
    }

    @Override
    public List<RutaParaderos> getRutaParaderosRuta(int id) {
        return dao.getRutaParaderosRuta(id);
    }

    @Override
    public RutaParaderos getId(int idRuta, int idParadero) {
        return dao.getId(idRuta, idParadero);
    }

    @Override
    public void add(RutaParaderos rutaParaderos) {
        dao.add(rutaParaderos);
    }

    @Override
    public void delete(int idRuta, int idParadero) {
        dao.delete(idRuta, idParadero);
    }

    @Override
    public void update(RutaParaderos rutaParaderos, int antiguo) {
        dao.update(rutaParaderos, antiguo);
    }
    
}
