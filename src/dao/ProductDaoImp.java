/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import entity.Product;
import entity.User;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
    public ObservableList<Product> getAllProduct()
   {
        ObservableList<Product> product =FXCollections.observableArrayList();
        ConnexionSingleton conn=ConnexionSingleton.getInstance();
        
 try {
     
    PreparedStatement ps= conn.getCnx().prepareStatement("select * from Product");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    Product p = new Product();
    p.setIdP(rs.getInt("IdP"));
    p.setName(rs.getString("name"));
    p.setDescription(rs.getString("description"));
    p.setQuantity(rs.getInt("quantity"));
    p.setCategory(rs.getString("category"));
    p.setPrice(rs.getFloat("price"));
    product.add(p);
    
 
    }
        } catch (SQLException e) {
            System.out.println("problem in getproduct");
            e.printStackTrace();
            
}
return product;
   }
   
       // return data which i search about it as observable list because table parmetar is observable
   public ObservableList<Product> getSearchProduct(String name)
   {
        ConnexionSingleton conn=ConnexionSingleton.getInstance();
        ObservableList<Product> product =FXCollections.observableArrayList();
        try {
           
            PreparedStatement ps =  conn.getCnx().prepareStatement("SELECT * FROM Product WHERE name LIKE '%"+name+"%'");
            ResultSet rs = ps.executeQuery();
            
           
          while (rs.next()) {
    Product p = new Product();
    p.setIdP(rs.getInt("IdP"));
    p.setName(rs.getString("name"));
    p.setDescription(rs.getString("description"));
    p.setQuantity(rs.getInt("quantity"));
    p.setCategory(rs.getString("category"));
    p.setPrice(rs.getFloat("price"));
    product.add(p);         
            }
        } catch (SQLException ex) {
            System.out.println("problem in dao getsearch product");
        }
     
       return product;
   }
   public void writeToExcel(JTable jt){
        ConnexionSingleton conn=ConnexionSingleton.getInstance();
        try {
            DefaultTableModel model = new DefaultTableModel(new String[]{
            "Id",
            "Name",
             "Quantity",
             "Description",
             "Category",
             "Price"
            },0);
     
    PreparedStatement ps= conn.getCnx().prepareStatement("select * from Product");

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    int id = rs.getInt("IdP");
    String name = rs.getString("name");
    int quantity = rs.getInt("quantity");
    String description = rs.getString("description");
    String category = rs.getString("category");
    Float price = rs.getFloat("price");
    
    model.addRow(new Object[]{
    id,name,quantity,description,category,price
    });
    jt.setModel(model);
    
   
   
    
 
    }
        } catch (SQLException e) {
            System.out.println("problem in getproduct");
            e.printStackTrace();
            
}
        
       
   };
   public void openFile(String file){
   
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            System.out.println("problem in openfile");
        }
   }
   
   
      
       
         public void writetoExcel()  {
             ConnexionSingleton conn=ConnexionSingleton.getInstance();
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet ws = wb.createSheet("products");
        
 
        Row headerRow = ws.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Product Name");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Quantity");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Description");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Category");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Price");
            
            
            
            int rowCount = 1;
            
            PreparedStatement ps= conn.getCnx().prepareStatement("select * from Product");
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IdP");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                String category = rs.getString("category");
                Float price = rs.getFloat("price");
                
                Row row = ws.createRow(rowCount++);
                
                int columnCount = 0;
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(name);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(quantity);
                
                cell = row.createCell(columnCount++);
                cell.setCellValue(description);
                cell = row.createCell(columnCount++);
                cell.setCellValue(category);
                cell = row.createCell(columnCount++);
                cell.setCellValue(price);
                
                
               
                wb.write(new FileOutputStream("products.xls"));
            }
           
        } catch (SQLException ex) {
           System.out.println("problem in excel");
           
           
       
    }   catch (FileNotFoundException ex) {
            Logger.getLogger(ProductDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

    
   
    
}

    @Override
    public void payment(int idc) {
            ConnexionSingleton conn=ConnexionSingleton.getInstance();
            Stripe.apiKey = "sk_test_51K9oMoFGG3TCydWDIAAn0Ewahl2peotVjBwuq6aaox3rDW2Bqs1ned3JHuCwRqicCtI4pgOEp1HwQQ4tYtqAClul00dXq3fpiH";
            try {
                
     
    PreparedStatement ps= conn.getCnx().prepareStatement("select * from User where id = ?");
    ps.setInt(1,idc);
    ResultSet rs = ps.executeQuery();
   
    Map< String , Object> customerParameter = new HashMap<String,Object>();
   while (rs.next()) {
    int idclient1 = rs.getInt("id");
    String idclient = idclient1+"";
    String emailclient = rs.getString("email");
    customerParameter.put("email",emailclient);
            Customer cus = Customer.create(customerParameter);

    Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
		cardParam.put("number", "4111111111111111");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2026");
		cardParam.put("cvc", "123");
                 Customer customer = Customer.retrieve(cus.getId());
                Card card = (Card)customer.getSources().create(cardParam);

         Map<String, Object> params = new HashMap<>();
		params.put("amount", 3000);
		params.put("currency", "usd");
		params.put("customer", cus.getId());

		Charge charge = Charge.create(params);
		System.out.println(charge);
                
         System.out.println("done");
   }
 
    }
         catch (SQLException e) {
            System.out.println("problem in payment methode");
            e.printStackTrace();
            
}       catch (StripeException ex) {
            Logger.getLogger(ProductDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
       
    }
}
