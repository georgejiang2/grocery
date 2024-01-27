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

public class ProductQueries {
    private static Connection connection;
    private static PreparedStatement getAllProducts;
    private static PreparedStatement addProduct;
//    private static PreparedStatement getAllCourseCodes;
//    private static PreparedStatement getCourseSeats;
    private static PreparedStatement deleteProduct;
    private static ResultSet resultSet;
    
    public static void addProduct(String productID, String name, String type, double price, double weight) {
        
        connection = DBConnection.getConnection();
        try {
            addProduct = connection.prepareStatement("insert into app.product (productid, name, type, price, weight) values (?,?,?,?,?)");
            addProduct.setString(1,productID);
            addProduct.setString(2,name);
            addProduct.setString(3,type);
            addProduct.setDouble(4, price);
            addProduct.setDouble(5, weight);
            addProduct.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public static ArrayList<ProductEntry> getAllProducts() {
        connection = DBConnection.getConnection();
        ArrayList<ProductEntry> products = new ArrayList<ProductEntry>();
        try {
            getAllProducts = connection.prepareStatement("SELECT * FROM app.product order by productID");
            resultSet = getAllProducts.executeQuery();
            
            while (resultSet.next()) {
                products.add(new ProductEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(7)));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return products;
    }
    
//    public static ArrayList<String> getAllProductNames() {
//        connection = DBConnection.getConnection();
//        ArrayList<String> names = new ArrayList<String>();
//        try {
//            getAllCourseCodes = connection.prepareStatement("SELECT name FROM app.product order by name");
//            resultSet = getAllCourseCodes.executeQuery();
//            
//            while (resultSet.next()) {
//                names.add(resultSet.getString(1));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return names;
//    }
    
//    public static int getCourseSeats(String semester, String courseCode) {
//        connection = DBConnection.getConnection();
//        int seats = 0;
//        try {
//            getCourseSeats = connection.prepareStatement("SELECT seats FROM app.COURSE where (semester = ? AND coursecode = ?)");
//            getCourseSeats.setString(1,semester);
//            getCourseSeats.setString(2,courseCode);
//            resultSet = getCourseSeats.executeQuery();    
//            while(resultSet.next()) {
//                seats = resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return seats;
//    }    
    
    public static void deleteProduct(String productID) {
        connection = DBConnection.getConnection();
        try {
            deleteProduct = connection.prepareStatement("delete from app.product where productID = ?");
            deleteProduct.setString(1, productID);
            deleteProduct.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}