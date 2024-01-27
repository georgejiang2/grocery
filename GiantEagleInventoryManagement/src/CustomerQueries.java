/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author potato
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerQueries {
    private static Connection connection;
    private static PreparedStatement addCustomer;
    private static PreparedStatement getAllCustomers;
    private static PreparedStatement getCustomer;
    private static PreparedStatement deleteCustomer;
    private static ResultSet resultSet;
    
    public static void addCustomer(CustomerEntry customer) {
        connection = DBConnection.getConnection();
        try {
            addCustomer = connection.prepareStatement("INSERT into app.customer (customerid, firstname, lastname) values (?,?,?)");
            addCustomer.setString(1,customer.getCustomerID());
            addCustomer.setString(2,customer.getFirstName());
            addCustomer.setString(3,customer.getLastName());
            addCustomer.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<CustomerEntry> getAllCustomers() {
        connection = DBConnection.getConnection();
        ArrayList<CustomerEntry> customers = new ArrayList<CustomerEntry>();
        
        try {
            getAllCustomers = connection.prepareStatement("SELECT * from app.customer order by customerid");
            resultSet = getAllCustomers.executeQuery();
            
            while (resultSet.next()) {
                customers.add(new CustomerEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customers;
    }
    
    public static CustomerEntry getCustomer(String customerID) {
        connection = DBConnection.getConnection();
        CustomerEntry se = new CustomerEntry("", "", "");
        
        try {
            getCustomer = connection.prepareStatement("SELECT * from app.customer where customerID = ?");
            getCustomer.setString(1, customerID);
            resultSet = getCustomer.executeQuery();
            while (resultSet.next()) {
                se = new CustomerEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return se;
    }
    
    public static void deleteCustomer(String customerID) {
        connection = DBConnection.getConnection();
        
        try {
            deleteCustomer = connection.prepareStatement("delete from app.customer where customerID = ?");
            deleteCustomer.setString(1, customerID);
            deleteCustomer.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
