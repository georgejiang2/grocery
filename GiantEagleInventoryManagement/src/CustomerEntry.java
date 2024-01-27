/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author potato
 */
public class CustomerEntry {
    private String customerID;
    private String firstName;
    private String lastName;
    
    public CustomerEntry(String customerID, String firstName, String lastName) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getCustomerID() {
        return customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
        
    }
    
}
