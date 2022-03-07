/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.ReservationDAOImpl;

/**
 *
 * @author amorl
 */
public class DAOFactory {
    public enum DAOTypes{
        PAYMENT,RESERVATION;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch(daoType){
            
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            default:
                return null;
        }
    }
}
