/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author pham thi hoan
 */
public class Employee {
    private Integer employeeId;
    private String employeeName;
    private String employeePhone;
    private String employeeAddress;
    private Integer employeeSalary;
    private String employeeDate;

    public Employee(){
        
    }
    public Employee(Integer employeeId, String employeeName, String employeePhone, String employeeAddress, Integer employeeSalary,String employeeDate ){
        this.employeeId=employeeId;
        this.employeeName=employeeName;
        this.employeePhone=employeePhone;
        this.employeeAddress=employeeAddress;
        this.employeeSalary=employeeSalary;
        this.employeeDate=employeeDate;
           
    }
    public Integer getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId){
        this.employeeId=employeeId;
    }
    public String getEmployeeName(){
            return employeeName;
    }
    public void getEmployeeName(String employeeName){
            this.employeeName=employeeName;
    }
    public String getEmployeePhone(){
            return employeePhone;
    }
    public void setEmployeePhone(String employeePhone){
        this.employeePhone=employeePhone;
    }
    public String getEmployeeAddress(){
            return employeeAddress;
    }
    public void setEmployeeAddress(String employeeAddress){
            this.employeeAddress=employeeAddress;
    }
    public Integer getEmployeeSalary(){
            return employeeSalary;
    }
    public void setEmployeeSalary(Integer employeeSalary){
            this.employeeSalary=employeeSalary;
    }
    public String getEmployeeDate(){
            return employeeDate;
    }
    public void setEmployeeDate(String employeeDate){
            this.employeeDate=employeeDate;
    }
    public String toFile(){
        return String.format("%d|%s|%s|%s|%d|%s",employeeId , employeeName, employeePhone, employeeAddress,employeeSalary,employeeDate);
    }
}