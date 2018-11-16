/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import conexion.ConexionSingleton;
import dao.IConductorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Conductor;

/**
 *
 * @author Diaz
 */
public class ConductorDaoImpl implements IConductorDAO {
    
    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    
    private final String select = "select * from conductor";
    private final String selectId = "select * from conductor where id_conductor = ?";
    private final String insert = "insert into conductor (nombres, apellidos, dni, brevete, telefono, direccion, email) values (?, ?, ?, ?, ?, ?, ?)";
    private final String delete = "delete from conductor where id_conductor = ?";
    private final String update = "update conductor set nombres = ?, apellidos = ?, dni = ?, brevete = ?, telefono = ?, direccion = ?, email = ? where id_conductor = ?";
    
    @Override
    public List<Conductor> getConductores() {
        Conductor conductor;
        List<Conductor> conductores = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while(rs.next()) {
                conductor  = new Conductor();
                conductor.setIdConductor(rs.getInt(1));
                conductor.setNombre(rs.getString(2));
                conductor.setApellido(rs.getString(3));
                conductor.setDni(rs.getString(4));
                conductor.setBrevete(rs.getString(5));
                conductor.setTelefono(rs.getString(6));
                conductor.setDireccion(rs.getString(7));
                conductor.setEmail(rs.getString(8));
                conductores.add(conductor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conductores;
    }

    @Override
    public Conductor getConductorId(int id) {
        Conductor conductor = new Conductor();
        PreparedStatement pstm = null;
        ResultSet rs =  null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            conductor.setIdConductor(rs.getInt(1));
            conductor.setNombre(rs.getString(2));
            conductor.setApellido(rs.getString(3));
            conductor.setDni(rs.getString(4));
            conductor.setBrevete(rs.getString(5));
            conductor.setTelefono(rs.getString(6));
            conductor.setDireccion(rs.getString(7));
            conductor.setEmail(rs.getString(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conductor;
    }

    @Override
    public void addConductor(Conductor conductor) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setString(1, conductor.getNombre());
            pstm.setString(2, conductor.getApellido());
            pstm.setString(3, conductor.getDni());
            pstm.setString(4, conductor.getBrevete());
            pstm.setString(5, conductor.getTelefono());
            pstm.setString(6, conductor.getDireccion());
            pstm.setString(7, conductor.getEmail());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteConductor(int id) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(delete);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateConductor(Conductor conductor) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setString(1, conductor.getNombre());
            pstm.setString(2, conductor.getApellido());
            pstm.setString(3, conductor.getDni());
            pstm.setString(4, conductor.getBrevete());
            pstm.setString(5, conductor.getTelefono());
            pstm.setString(6, conductor.getDireccion());
            pstm.setString(7, conductor.getEmail());
            pstm.setInt(8, conductor.getIdConductor());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
