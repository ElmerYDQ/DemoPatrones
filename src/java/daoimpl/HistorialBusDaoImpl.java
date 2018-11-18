/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimpl;

import conexion.ConexionSingleton;
import dao.IHistorialDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialBus;

/**
 *
 * @author Diaz
 */
public class HistorialBusDaoImpl<T> implements IHistorialDAO<T> {
    private ConexionSingleton singleton = ConexionSingleton.getInstance();
    private Connection con = singleton.getConnection();
    
    private final String select = "select * from historialbus";
    private final String selectId = "select * from historialbus where id_ruta = ?, id_bus = ?";
    private final String insert = "insert into historialbus (id_ruta, id_bus, fecha) values (?, ?, ?)";
    
    @Override
    public List<T> getHistoriales() {
        HistorialBus historialBus;
        List<HistorialBus> historialBuses = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement(select);
            rs = pstm.executeQuery();
            while(rs.next()) {
                historialBus  = new HistorialBus();
                historialBus.setIdRuta(rs.getInt(1));
                historialBus.setIdBus(rs.getInt(2));
                historialBus.setFecha(rs.getDate(3));
                historialBuses.add(historialBus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (List<T>) historialBuses;
    }

    @Override
    public T getHistorialId(int idRuta, int idBus) {
        HistorialBus historialBus = new HistorialBus();
        PreparedStatement pstm = null;
        ResultSet rs =  null;
        try {
            pstm = con.prepareStatement(selectId);
            pstm.setInt(1, idRuta);
            pstm.setInt(2, idBus);
            rs = pstm.executeQuery();
            rs.next();
            historialBus.setIdRuta(rs.getInt(1));
            historialBus.setIdBus(rs.getInt(2));
            historialBus.setFecha(rs.getDate(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) historialBus;
    }

    @Override
    public void addHistorial(T historial) {
        HistorialBus historialBus = (HistorialBus) historial;
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement(insert);
            pstm.setInt(1, historialBus.getIdRuta());
            pstm.setInt(2, historialBus.getIdBus());
            pstm.setDate(3, historialBus.getFecha());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
