/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.FileController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Kien Ninh
 */
public class Order {
    private Integer orderID;
    private Integer customerID;
    private String date;
    private String status;

    public Order(Integer orderID,Integer customerID,String date,String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.date = date;
        this.status=status;
    }

     public Order() {
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getDate() {
       
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getTotalMoneyDouble() {
        Float totalMoneyDouble=0f;
        List<OrderDetail> odl=new ArrayList<>();
        odl=FileController.readOrderDetailFromFile("orderDetail.txt");
        for(int i=0;i<odl.size();i++){
            if(odl.get(i).getOrderID().equals(this.orderID)){
                totalMoneyDouble+=odl.get(i).money();
            }
        }
        if(this.getPoint()>10000000){
            totalMoneyDouble*=0.95f;
        }
        
        return totalMoneyDouble;
    }
    public void setPoint(Float diem,Float moi){
        List<Customer> odl=new ArrayList<>();
        Float Point=0f;
        odl=FileController.readCustomerFromFile("customer.txt");
        for(int i=0;i<odl.size();i++){
            if(odl.get(i).getCustomerId().equals(this.getCustomerID())){
               
                 Point=odl.get(i).getAccumulatePoints();
                 odl.get(i).setAccumulatePoints(Point-diem+moi);
                break;
            }
        }
       
                
        FileController.writeListCustomerFile("customer.txt", odl);
        
        
    }
       public Float getPoint() {
        List<Customer> odl=new ArrayList<>();
        Float Point=0f;
        odl=FileController.readCustomerFromFile("customer.txt");
        for(int i=0;i<odl.size();i++){
            if(odl.get(i).getCustomerId().equals(this.getCustomerID())){
                Point=odl.get(i).getAccumulatePoints();
                break;
            }
        }
        
        return Point;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", customerID=" + customerID + ", date=" + date  + ", totalMoneyDouble=" + getTotalMoneyDouble() + ", status=" + status +"}";
    }

    
    
    
    
    
    
            
}
