/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Product;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author juzoo
 */
public interface IProductDao {
    public Product addProduct(Product p);
    public List<Product> getProduct();
    public Product updateProduct(Product p);
    public void deleteProduct(int idP);
    public ObservableList<Product> getSearchProduct(String name);
    public ObservableList<Product> getAllProduct();
    
}
