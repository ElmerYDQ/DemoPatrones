/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import conexion.ConexionSingleton;
import dao.IRutaParaderosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.RutaParaderos;

/**
 *
 * @author Diaz
 */
public class RutaParaderosDaoImpl implements IRutaParaderosDAO {
    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    
    private final String select = "select * from rutaParaderos";
    private final String selectRuta = "select * from rutaParaderos where id_ruta = ?";
    private final String selectId = "select * from rutaParaderos where id_ruta = ? and id_paradero = ?";
    private final String insert = "insert into rutaParaderos (id_ruta, id_paradero) values (?, ?)";
    private final String delete = "delete from rutaParaderos where id_ruta = ? and id_paradero = ?";
    private final String update = "update rutaParaderos set id_paradero = ? where id_paradero = ?";
    
    @Override
    public List<RutaParaderos> getRutaParaderos() {
        RutaParaderos rutaParadero;
        List<RutaParaderos> rutaParaderos = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while(rs.next()) {
                rutaParadero = new RutaParaderos();
                rutaParadero.setIdRuta(rs.getInt(1));
                rutaParadero.setIdParadero(rs.getInt(2));
                rutaParaderos.add(rutaParadero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaParaderos;
    }
    
    @Override
    public List<RutaParaderos> getRutaParaderosRuta(int idRuta) {
        RutaParaderos rutaParadero;
        List<RutaParaderos> rutaParaderos = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(selectRuta);
            pstm.setInt(1, idRuta);
            rs = pstm.executeQuery();
            while(rs.next()) {
                rutaParadero = new RutaParaderos();
                rutaParadero.setIdRuta(rs.getInt(1));
                rutaParadero.setIdParadero(rs.getInt(2));
                rutaParaderos.add(rutaParadero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaParaderos;
    }

    @Override
    public RutaParaderos getRutaParaderosId(int idRuta, int idParadero) {
        RutaParaderos rutaParadero = new RutaParaderos();
        PreparedStatement pstm = null;
        ResultSet rs =  null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, idRuta);
            pstm.setInt(2, idParadero);
            rs = pstm.executeQuery();
            rs.next();
            rutaParadero.setIdRuta(rs.getInt(1));
            rutaParadero.setIdParadero(rs.getInt(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutaParadero;
    }

    @Override
    public void addRutaParaderos(RutaParaderos rutaParaderos) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, rutaParaderos.getIdRuta());
            pstm.setInt(2, rutaParaderos.getIdParadero());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRutaParaderos(int idRuta, int idParadero) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(delete);
            pstm.setInt(1, idRuta);
            pstm.setInt(2, idParadero);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRutaParaderos(RutaParaderos rutaParaderos, int antiguo) {
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(update);
            pstm.setInt(1, rutaParaderos.getIdParadero());
            pstm.setInt(2, antiguo);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
