/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.IAdministradorDAO;
import dao.IConductorDAO;
import dao.impl.AdministradorDaoImpl;
import dao.impl.ConductorDaoImpl;
import java.util.List;
import modelo.Administrador;
import modelo.Conductor;
import modelo.Paradero;
import modelo.PersonaClone;
import service.IConductorService;
import service.IParaderoService;
import service.impl.ConductorService;
import service.impl.ParaderoService;

/**
 *
 * @author Diaz
 */
public class Principal {
    public static void main(String[] args) {
        /*IConductorService service = new ConductorService();
        PersonaClone clone = new PersonaClone();
        Conductor conductor = (Conductor) clone.createBasicItem("conductor");
        conductor = service.getId(7);
        System.out.println(conductor.toString());
        conductor.setDireccion("la");
        service.update(conductor);*/
        
        IParaderoService service = new ParaderoService();
        for(Paradero paradero : service.listar()) {
            System.out.println(paradero.toString());
        }
    }
}
