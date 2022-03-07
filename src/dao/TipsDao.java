/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Planning;
import entity.Tips;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.ConnexionSingleton;

/**
 *
 * @author Adnene
 */
public class TipsDao implements Idao<Tips> {

    private static TipsDao instance;
    private Statement st;
    private ResultSet rs;

    public TipsDao() throws ClassNotFoundException {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static TipsDao getInstance() throws ClassNotFoundException {
        if (instance == null) {
            instance = new TipsDao();
        }
        return instance;
    }

    @Override
    public void insert(Tips o) {
        String req = "insert into tip (caption, category) values ('" + o.getCaption() + "','" + o.getCategory() + "')";
        //try {
        //    st.executeUpdate(req);
       // } catch (SQLException ex) {
         //   Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    @Override
    public void delete(Tips o) {
        String req = "delete from tip where id=" + o.getId();
        Tips p = displayById(o.getId());

        if (p != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("doesen't exist");
        }
    }

    @Override
    public ObservableList<Tips> displayAll() {
        String req = "select * from tip";
        ObservableList<Tips> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Tips p = new Tips();
                p.setId(rs.getInt("id"));
                p.setCaption(rs.getString("caption"));
                p.setCategory(rs.getString("category"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Tips> displayAllList() {
        String req = "select * from tip";
        List<Tips> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Tips p = new Tips();
                p.setId(rs.getInt("id"));
                p.setCaption(rs.getString("caption"));
                p.setCategory(rs.getString("category"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Tips displayById(int id) {
        String req = "select * from tip where id =" + id;
        Tips p = new Tips();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setCaption(rs.getString("caption"));
            p.setCategory(rs.getString("category"));

        } catch (SQLException ex) {
            Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(Tips p) {
        String qry = "UPDATE tip SET caption = '" + p.getCaption() + "', category = '" + p.getCategory() + "' WHERE id = " + p.getId() + ");";

        try {
            if (st.executeUpdate(qry) > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(TipsDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    private Statement prepareStatement(String insert_into_Tip_Caption_category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
