/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Kien Ninh
 */


import controllers.FileController;
import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDetail {
   
    private Integer orderID;
    private Integer productID;
    
    private Integer quantity;

    public OrderDetail(Integer orderID, Integer productID, Integer quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }
    

    public OrderDetail() {
       
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    public  Float money(){
        List<product> products =new ArrayList<>();
        products=FileController.readProductFromFile("product.txt");
        float tong=0;
        
        for(product item:products){
           
            if(item.getmaSP().equals(getProductID())){
                tong=getQuantity()*item.getGiaBan()-(getQuantity()*item.getGiaBan())*item.getGiamGia()/100f;
            }}
        return tong;
    }

       @Override
    public String toString() {
        return "OrderDetail{" + "orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity + ", money=" + money() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetail other = (OrderDetail) obj;
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        if (!Objects.equals(this.quantity, other.quantity)) {
            return false;
        }
        return true;
    }

    
}
