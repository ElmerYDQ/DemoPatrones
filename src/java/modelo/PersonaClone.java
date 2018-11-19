/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Hashtable;

/**
 *
 * @author Diaz
 */
public class PersonaClone {
    private Hashtable<String, Persona> map = new Hashtable<String, Persona>();
    
    public PersonaClone() {
        loadCache();
    }
    
    public Object createBasicItem(String type) {
        return map.get(type).clone();
    }
    
    private void loadCache(){
        Conductor conductor = new Conductor();
        map.put("conductor", conductor);
        
        Administrador administrador = new Administrador();
        map.put("administrador", administrador);
    }
}
