/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.ConnexionSingleton;

/**
 *
 * @author juzoo
 */
public class ProductDaoImp implements IProductDao{
     

    @Override
    public Product addProduct(Product p) {
        ConnexionSingleton conn=ConnexionSingleton.getInstance();
        try{
            PreparedStatement ps = conn.getCnx().prepareStatement("insert into product(name,quantity,description,category,price) values(?,?,?,?,?)");
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getCategory());
            ps.setFloat(5, p.getPrice());
            ps.executeUpdate();
            System.out.println("product added");
            
        }
        catch(SQLException e){
        e.printStackTrace();
        }
        return p ; 
    }

    @Override
    public List<Product> getProduct() {
        List<Product> prods= new ArrayList<Product>();
       ConnexionSingleton conn=ConnexionSingleton.getInstance();
 
 try {
     
    PreparedStatement ps= conn.getCnx().prepareStatement("select * from Product");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    Product p = new Product();
    p.setIdP(rs.getInt("IdP"));
    p.setName(rs.getString("name"));
    p.setDescription(rs.getString("quantity"));
    p.setDescription(rs.getString("description"));
    p.setCategory(rs.getString("category"));
    prods.add(p);
    
 
    }
        } catch (SQLException e) {
            System.out.println("problem in getproduct");
            e.printStackTrace();
            
}
return prods;

    }

    @Override
    public Product updateProduct(Product p) {
        ConnexionSingleton conn=ConnexionSingleton.getInstance();
 try {
    PreparedStatement ps= conn.getCnx().prepareStatement("UPDATE Product SET name=?,quantity=?,description=?,category=?,price=? WHERE idP=?");
    ps.setString(1, p.getName());
    ps.setInt(2, p.getQuantity());
    ps.setString(3, p.getDescription());
    ps.setString(4, p.getCategory());
    ps.setFloat(5, p.getPrice());
    ps.setInt(6, p.getIdP());
    ps.executeUpdate();
    ps.close();
    System.out.println("product updated");
    } catch (SQLException e) {
    e.printStackTrace();
    }
    return p;
    }

    @Override
    public void deleteProduct(int idP) {
      ConnexionSingleton conn=ConnexionSingleton.getInstance();
        try {
       PreparedStatement ps= conn.getCnx().prepareStatement("DELETE FROM Product WHERE idP = ?");
       ps.setLong(1, idP);
       ps.executeUpdate();
       ps.close();
       System.out.println("product deleted");
       } catch (SQLException e) {
       e.printStackTrace();
       }
    
      
}
    
}
