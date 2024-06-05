/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Nguyen Hai Luyen
 */
public class Customer {
    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private Float accumulatePoints;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Float getAccumulatePoints() {
        return accumulatePoints;
    }

    public void setAccumulatePoints(Float accumulatePoints) {
        this.accumulatePoints = accumulatePoints;
    }

    public Customer() {
    }
    

    public Customer(Integer customerId, String customerName, String customerPhone, Float accumulatePoints) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.accumulatePoints = accumulatePoints;
    }  
}
