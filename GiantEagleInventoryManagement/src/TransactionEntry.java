/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author potato
 */

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

// transaction id = 
public class TransactionEntry {
    private String productID;
    private double weight;
    private double cost;
    private String customerID;
    private Timestamp date;
    private int transactionID;
    private Connection connection = DBConnection.getConnection();
    private static ResultSet resultSet;

    public TransactionEntry(String productID, double weight, double cost, String customerID, Timestamp date, int transactionID) {
        this.productID = productID;
        this.weight = weight;
        this.cost = cost;
        this.customerID = customerID;
        this.date = date;    
        this.transactionID = transactionID;
        
//        try {
//            PreparedStatement idquery = connection.prepareStatement("select MAX(transactionid) as maxtransactionid from app.customertransaction");
//            resultSet = idquery.executeQuery();
//            while (resultSet.next()) {
//                this.transactionID = resultSet.getInt(1);
//                exists = true;
//            }
//            if (!exists) {
//                this.transactionID = 1;
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    
    public String getProductID() {
        return productID;
    }
    public double getWeight() {
        return weight;
    }
    public double getCost() {
        return cost;
        
    }
    public String getCustomerID() {
        return customerID;
    }
    public Timestamp getDate() {
        return date;
    }
    public int getTransactionID() {
        return transactionID;
    }
}
