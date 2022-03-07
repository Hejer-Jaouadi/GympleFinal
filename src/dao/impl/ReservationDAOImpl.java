/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.ReservationDAO;
import entities.Reservation;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.CrudUtils;

/**
 *
 * @author amorl
 */
public class ReservationDAOImpl implements ReservationDAO {
    public static ReservationDAOImpl instance;

    @Override
    public boolean insert(Reservation reservation) throws Exception {
        return CrudUtils.executeUpdate("INSERT INTO reservations VALUES (?,?,?,?,?,?)",reservation.getRid(),reservation.getReserved_date(),reservation.getCoachName(),reservation.getCourseName(),reservation.getType(),reservation.getReserved_time()) > 0;
    }

    @Override
    public boolean update(Reservation entity) throws Exception {
        return CrudUtils.executeUpdate("UPDATE reservations SET coach_name=?, course_name=?, reserved_date=?, reserved_time=?, type=? WHERE rid=?", entity.getCoachName(), entity.getCourseName(),entity.getReserved_date(),entity.getReserved_time(),entity.getType(),entity.getRid()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
                return CrudUtils.executeUpdate("DELETE From reservations where rid=?", id) > 0;
    }

    @Override
    public Reservation search(String id) throws Exception {
        ResultSet rs = CrudUtils.executeQuery("Select * From reservations where rid=?", id);
        if (rs.next()) {
            return new Reservation(rs.getInt("rid"), rs.getString("coach_name"), rs.getString("course_name"), rs.getString("reserved_date"),rs.getString("released_time"),rs.getString("type"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Reservation> getLatest() throws Exception {
        ArrayList<Reservation> latestReservations = new ArrayList();
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM Movie");
        while (rst.next()) {
            latestReservations.add(new Reservation(rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)));
        }
        return latestReservations;
    }

    @Override
    public ArrayList<Reservation> getAll() throws Exception {
        ArrayList<Reservation> reservationsList = new ArrayList();
        ResultSet rst = CrudUtils.executeQuery("SELECT * FROM reservations");
        while (rst.next()) {
            reservationsList.add(
                new Reservation(
                rst.getInt(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                rst.getString(6)
                )
            );
        }
        return reservationsList;
    }
    
    public static ReservationDAOImpl getInstance() {
        if (instance == null) {
            instance = new ReservationDAOImpl();
        }
        
        return instance;
    }
    
}
