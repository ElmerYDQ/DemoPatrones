/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import dao.IConductorDAO;
import daoimpl.ConductorDaoImpl;
import modelo.Conductor;

/**
 *
 * @author Diaz
 */
public class Principal {
    public static void main(String[] args) {
        IConductorDAO dao = new ConductorDaoImpl();
        /*Conductor conductor = new Conductor();
        conductor.setNombre("joel");
        conductor.setApellido("bejar");
        conductor.setDni("74025623");
        conductor.setBrevete("123456");
        conductor.setDireccion("villa maria");
        conductor.setEmail("bejar@gamil.com");
        conductor.setTelefono("123456987");
        dao.addConductor(conductor);
        for (Conductor c : dao.getConductores()) {
            System.out.println(c.toString());
        }
        conductor.setNombre("antonio");
        dao.updateConductor(conductor);
        for (Conductor c : dao.getConductores()) {
            System.out.println(c.toString());
        }*/
        dao.deleteConductor(2);
        dao.deleteConductor(3);
        for (Conductor c : dao.getConductores()) {
            System.out.println(c.toString());
        }
        System.out.println(dao.getConductorId(1));
    }
}
