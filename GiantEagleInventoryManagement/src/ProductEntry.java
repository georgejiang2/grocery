/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author potato
 */

import java.sql.Timestamp;
import java.util.Calendar;


public class ProductEntry {
    private String productID;
    private String name;
    private String type;
    private double price;
    private Timestamp expiration;
    private Timestamp openDate;
    private double weight;
    
    public ProductEntry(String productID, String name, String type, double price, double weight) {
        
        this.productID = productID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.weight = weight;
                
    }
    
    public String getProductID() {
        return productID;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
        
    }
    
    public double getPrice() {
        return price;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public Timestamp getExpiration() {
        return expiration;
    }
    public Timestamp getOpenDate() {
        return openDate;
    }
    

}
