/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Member;
import entity.Trainer;
import entity.User;
import utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author wiemhjiri
 */
public class UserDao implements Idao<User> {

    private static UserDao instance;
    private Statement st;
    private ResultSet rs;

    private UserDao() {
        ConnexionSingleton cs = ConnexionSingleton.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public void insert(User o) {
        String req = "insert into user (role,first_name,last_name,email,password) values ('admin','" + o.getFirst_name() + "','" + o.getLast_name() + "','" + o.getEmail() + "','" + o.getPassword() + "')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(User o) {
        String req = "delete from user where id=" + o.getId();
        User p = displayById(o.getId());

        if (p != null) {
            try {

                st.executeUpdate(req);

            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("n'existe pas");
        }
    }

    @Override
    public ObservableList<User> displayAll() {
        String req = "select * from user";
        ObservableList<User> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                User p = new User();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<User> displayAllList() {
        String req = "select * from user";
        List<User> list = new ArrayList<>();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                User p = new User();
                p.setId(rs.getInt("id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setEmail(rs.getString("email"));
                p.setPassword(rs.getString("password"));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User displayById(int id) {
        String req = "select * from user where id =" + id;
        User p = new User();
        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            p.setId(rs.getInt("id"));
            p.setFirst_name(rs.getString("first_name"));
            p.setLast_name(rs.getString("last_name"));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));

            //}  
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean update(User p) {
        String qry = "UPDATE user SET first_name = '" + p.getFirst_name() + "', last_name = '" + p.getLast_name() + "', email = '" + p.getEmail() + "', password = '" + p.getPassword() + "' WHERE id = " + p.getId();

        try {
            if (st.executeUpdate(qry) > 0) {

                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public User Login(String email, String password) {
        String req = "select * from user where email ='" + email + "' and password='" + password + "'";

        try {
            rs = st.executeQuery(req);
            // while(rs.next()){
            rs.next();
            switch (rs.getString("role")) {
                case "member":
                    Member m = new Member();
                    m.setId(rs.getInt("id"));
                    m.setFirst_name(rs.getString("first_name"));
                    m.setLast_name(rs.getString("last_name"));
                    m.setEmail(rs.getString("email"));
                    m.setPassword(rs.getString("password"));
                    m.setHeight(rs.getFloat("height"));
                    m.setWeight(rs.getFloat("weight"));
                    m.setId_card(rs.getInt("id_card"));
                    m.setTraining_level(rs.getString("training_level"));
                    MembershipDao md = MembershipDao.getInstance();
                    m.setMembership(md.displayById(rs.getInt("membership")));
                    m.setRole("member");
                    return m;
                    
                case "trainer":
                    Trainer t = new Trainer();
                    t.setId(rs.getInt("id"));
                    t.setFirst_name(rs.getString("first_name"));
                    t.setLast_name(rs.getString("last_name"));
                    t.setEmail(rs.getString("email"));
                    t.setPassword(rs.getString("password"));
                    t.setCost_per_hour(rs.getFloat("cost_per_hour"));
                    t.setDescription(rs.getString("description"));
                    t.setExperience(rs.getString("experience"));
                    t.setGym(null);
                    t.setRole("trainer");
                    return t;
                    
                    
                case "admin":
                    User u=new User();
                    u.setId(rs.getInt("id"));
                    u.setFirst_name(rs.getString("first_name"));
                    u.setLast_name(rs.getString("last_name"));
                    u.setEmail(rs.getString("email"));
                    u.setPassword(rs.getString("password"));
                    u.setRole("admin");
                    return u;
                 
                    
            }

            //}  
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
