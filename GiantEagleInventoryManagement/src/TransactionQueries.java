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

public class TransactionQueries {
    private static Connection connection;
    private static PreparedStatement addTransactionEntry;
    private static PreparedStatement getTransactionByCustomer;
//    private static PreparedStatement getScheduledStudentCount;
//    private static PreparedStatement getScheduledStudentsByCourse;
//    private static PreparedStatement getWaitlistedStudentsByCourse;
    private static PreparedStatement deleteTransactionByCustomer;
//    private static PreparedStatement dropScheduleByCourse;
//    private static PreparedStatement updateScheduleEntry;
    
    private static ResultSet resultSet;
//    private static final String DBServer = "jdbc:derby://localhost:1527";
//    private static final String DBName = "CourseSchedulerDBGeorgeJianggfj5101";
 
    public static void addTransactionEntry(TransactionEntry transaction) {
        connection = DBConnection.getConnection();
        try {
            addTransactionEntry = connection.prepareStatement("INSERT into app.customertransaction (productid, weight, cost, customerid, date, transactionid) values (?,?,?,?,?,?)");
            addTransactionEntry.setString(1, transaction.getProductID());
            addTransactionEntry.setDouble(2, transaction.getWeight());
            addTransactionEntry.setDouble(3, transaction.getCost());
            addTransactionEntry.setString(4, transaction.getCustomerID());
            addTransactionEntry.setTimestamp(5, transaction.getDate());
            addTransactionEntry.setInt(6, transaction.getTransactionID());
            
            addTransactionEntry.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<TransactionEntry> getTransactionByCustomer(String customerID) {
        connection = DBConnection.getConnection();

        ArrayList<TransactionEntry> transactions = new ArrayList<TransactionEntry>();
        try {
            getTransactionByCustomer = connection.prepareStatement("select productID, weight, cost, customerid, date, transactionid from app.customertransaction where customerid = ? order by coursecode");
            getTransactionByCustomer.setString(1, customerID);
            resultSet = getTransactionByCustomer.executeQuery();
            while(resultSet.next()) {
                transactions.add(new TransactionEntry(resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(3), resultSet.getString(4), resultSet.getTimestamp(5), resultSet.getInt(6)));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return transactions;
    }
    
//    public static int getScheduledStudentCount(String currentSemester, String courseCode) {
//        connection = DBConnection.getConnection();
//
//        int count = 0;
//        try {
//            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from app.schedule where semester = ? and courseCode = ?");
//            getScheduledStudentCount.setString(1, currentSemester);
//            getScheduledStudentCount.setString(2, courseCode);
//            resultSet = getScheduledStudentCount.executeQuery();
//            while(resultSet.next()) {
//                count = resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return count;
//    }
    
//    public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode) {
//        connection = DBConnection.getConnection();
//
//        ArrayList<ScheduleEntry> students = new ArrayList<ScheduleEntry>();
//        try {
//           getScheduledStudentsByCourse = connection.prepareStatement("select * from app.schedule where semester = ? AND coursecode = ? AND status = ?");
//           getScheduledStudentsByCourse.setString(1, semester);
//           getScheduledStudentsByCourse.setString(2, courseCode);
//           getScheduledStudentsByCourse.setString(3, "S");
//           resultSet = getScheduledStudentsByCourse.executeQuery();
//           
//           while(resultSet.next()) {
//               students.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));
//               
//           }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
    
//    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode) {
//        connection = DBConnection.getConnection();
//
//        ArrayList<ScheduleEntry> students = new ArrayList<ScheduleEntry>();
//        try {
//            getWaitlistedStudentsByCourse = connection.prepareStatement("select * from app.schedule where semester = ? AND coursecode = ? AND status = ? order by Timestamp");
//            getWaitlistedStudentsByCourse.setString(1, semester);
//            getWaitlistedStudentsByCourse.setString(2, courseCode);
//            getWaitlistedStudentsByCourse.setString(3, "W");
//            resultSet = getWaitlistedStudentsByCourse.executeQuery();
//            
//            while(resultSet.next()) {
//                students.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
    
    public static void deleteTransactionByCustomer(String transactionID) {
        connection = DBConnection.getConnection();

        try {
            deleteTransactionByCustomer = connection.prepareStatement("delete from app.customertransaction where transactionID = ?");
            deleteTransactionByCustomer.setString(1, transactionID);
            deleteTransactionByCustomer.executeUpdate();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
    }
    
//    public static void dropScheduleByCourse(String semester, String courseCode) {
//        connection = DBConnection.getConnection();
//
//        try {
//            dropScheduleByCourse = connection.prepareStatement("delete from app.schedule where semester = ? AND courseCode = ?");
//            dropScheduleByCourse.setString(1, semester);
//            dropScheduleByCourse.setString(2, courseCode);
//            dropScheduleByCourse.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
//    public static void updateScheduleEntry(String semester, ScheduleEntry entry) {
//        connection = DBConnection.getConnection();
//
//        dropStudentScheduleByCourse(semester, entry.getStudentID(), entry.getCourseCode());
//        
//        addScheduleEntry(new ScheduleEntry(entry.getSemester(), entry.getStudentID(), entry.getCourseCode(), "S", entry.getTimestamp()));
////        try {
////            
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
//    }
    
}
