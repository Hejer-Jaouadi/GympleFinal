/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author juzoo
 */


/**
 *
 * @author juzoo
 */
public class Product implements Serializable{
    private int idP;
    private String name; 
    private int quantity; 
    private String description;
    private String category;
    private float price;
    
    public Product( int idP,String name, int quantity, String description, String category,float price) {
        this.idP = idP;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Product() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

 

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
    public int getIdP() {
        return idP;
    }

  
    public void setIdP(int  idP) {
        this.idP = idP;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "idP=" + idP + ", name=" + name + ", quantity=" + quantity + ", description=" + description + ", category=" + category + ", price=" + price + '}';
    }

    

    

    
}
