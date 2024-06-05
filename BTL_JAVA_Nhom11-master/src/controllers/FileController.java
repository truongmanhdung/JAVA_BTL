package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Customer;
import java.io.IOException;
import models.Order;
import models.OrderDetail;
import models.Employee;
import models.product;

/**
 *
 * @author Minh Phuong Do
 */
public class FileController {
    static FileWriter fileWriter;
    static BufferedWriter bufWriter;
    static FileReader fileReader;
    static BufferedReader bufReader;

    public static void writeAccountToFile(String filename, Account account){
        try {
            fileWriter = new FileWriter(filename, true);
            bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write(account.toFile());
            System.out.println("write file successfully...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufWriter.close();  
                fileWriter.close();
            } catch (Exception e) {         
                System.out.println("error1: " + e);  
            }
        }
    }

    public static List<Account> readAccountFromFile(String filename){
        List<Account> listAcc = new ArrayList<Account>();
        try {
            fileReader = new FileReader(filename);
            bufReader = new BufferedReader(fileReader);
            File file = new File(filename);
                if(file.exists()){
                file.createNewFile();
            }
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] data = line.split("\\|");
                Account account = new Account(Integer.parseInt(data[0]), data[1],data[2], data[3]);
                listAcc.add(account);
            }
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            try {
                bufReader.close();  
                fileReader.close();
            } catch (Exception e) {         
                System.out.println("error3: " + e);  
            }
        }
        return listAcc;
    }

    public static void updateListAccountToFile(String filename, List<Account> listAcc){
        try {
            fileWriter = new FileWriter(filename, false);
            bufWriter = new BufferedWriter(fileWriter);
            for(Account item : listAcc){
                bufWriter.write(item.toFile());
            }
            System.out.println("update file successfully...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufWriter.close();  
                fileWriter.close();
            } catch (Exception e) {         
                System.out.println("error4: " + e);  
            }
        }
    }
    
    
    public static void writeCustomerToFile(String filename, Customer cus)
    {
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, true);
            bw= new BufferedWriter(fw);
            bw.write("\n"+cus.getCustomerId()+";"+cus.getCustomerName()+";"+cus.getCustomerPhone()+";"+cus.getAccumulatePoints());  
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi close" + ex);
            }
        }
    }
    
    public static void writeListCustomerFile(String filename, List<Customer> Customers){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, false);
            bw= new BufferedWriter(fw);
            for(Customer cus: Customers){
                bw.write(cus.getCustomerId()+";"+cus.getCustomerName()+";"+cus.getCustomerPhone()+";"+cus.getAccumulatePoints());  
                bw.newLine();
            }  
        } catch (IOException ex) {
            System.out.println("Loi ghi file");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi close");
            }
        }
    }
    
    
    public static List<Customer> readCustomerFromFile(String filename){
        List<Customer> customers = new ArrayList<>();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr= new FileReader(filename);
            br= new BufferedReader(fr);
            String line="";
            while( (line=br.readLine())!=null ){
                String str[]= line.split(";");
                customers.add(new Customer(Integer.parseInt(str[0]), str[1], str[2], Float.parseFloat(str[3])));
            }
        } catch (IOException ex) {
            System.out.println("Loi doc file" + ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException ex) {
                System.out.println("Loi close" + ex);
            }
        }
        return customers;
    }
//        public static void writeEmployeeToFile(String filename, Employee employee){
//        try {
//            fileWriter = new FileWriter(filename, true);
//            bufWriter = new BufferedWriter(fileWriter);
//            bufWriter.write(employee.toFile());
//        } catch (Exception e0) {
//            System.out.println(e0);
//        } finally {
//            try {
//                bufWriter.close();  
//                fileWriter.close();
//            } catch (Exception e1) {         
//                System.out.println(e1);  
//            }
//        }
//    }
    public static void writeEmployeeToFile(String filename,Employee employee)
    {
        System.out.println("bbb");
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, true);
            bw= new BufferedWriter(fw);
            bw.write(employee.getEmployeeId()+"|"+employee.getEmployeeName()+"|"+employee.getEmployeePhone()+"|"+employee.getEmployeeAddress()+"|"+employee.getEmployeeSalary()+"|"+employee.getEmployeeDate()+"\n");  
        } catch (IOException e0) {
            System.out.println("Error0: " + e0);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e1) {
                System.out.println("Error1: " + e1);
            }
        }
    }
    public static List<Employee> readEmployeeFromFile(String filename){
        List<Employee> employees = new ArrayList<Employee>();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine())!= null){
                String[] data = line.split("\\|");
                Employee employee = new Employee(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4]),data[5]);
                employees.add(employee);
            }
        } catch (Exception e0) {
            System.out.println("Error0: " + e0);
        } finally {
            try {
                br.close();  
                fr.close();
            } catch (Exception e1) {         
                System.out.println("Error1: " + e1);  
            }
        }
        return employees;
    }

        public static void updateEmployeeToFile(String filename, List<Employee> employees){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(filename,false);
            bw = new BufferedWriter(fw);
            for(Employee item : employees){
                bw.write(item.getEmployeeId()+"|"+item.getEmployeeName()+"|"+item.getEmployeePhone()+"|"+item.getEmployeeAddress()+"|"+item.getEmployeeSalary()+"|"+item.getEmployeeDate()+"\n");
            }
        } catch (Exception e0) {
            System.out.println("Error: "+e0);
        } finally {
            try {
                bw.close();  
                fw.close();
            } catch (Exception e1) {         
                System.out.println("Error: " + e1);  
            }
        }
    }
        //====================================================================================================================
        //File product
        
         public static void writeProductToFile(String filename, product product){
        try {
            fileWriter = new FileWriter(filename, true);
            bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write(product.toFile());
            System.out.println("write file successfully...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufWriter.close();  
                fileWriter.close();
            } catch (Exception e) {         
                System.out.println("error1: " + e);  
            }
        }
    }
    public static List<product> readProductFromFile(String filename){
        List<product> listProduct = new ArrayList<product>();
        try {
            fileReader = new FileReader(filename);
            bufReader = new BufferedReader(fileReader);
            File file = new File(filename);
                if(file.exists()){
                file.createNewFile();
            }
            String line = "";
            while((line = bufReader.readLine()) != null){
                String[] data = line.split("\\|");
                product Product = new product(Integer.parseInt(data[0]), data[1],Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Integer.parseInt(data[5]));
                listProduct.add(Product);
            }
        } catch (Exception e) {
            System.out.println("error2: " + e);
        } finally {
            try {
                bufReader.close();  
                fileReader.close();
            } catch (Exception e) {         
                System.out.println("error3: " + e);  
            }
        }
        return listProduct;
    }
    
    public static void updateListProductToFile(String filename, List<product> listProduct){
        try {
            fileWriter = new FileWriter(filename, false);
            bufWriter = new BufferedWriter(fileWriter);
            for(product item : listProduct){
                bufWriter.write(item.toFile());
            }
            System.out.println("update file successfully...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufWriter.close();  
                fileWriter.close();
            } catch (Exception e) {         
                System.out.println("error4: " + e);  
            }
        }
    }        
        
        //====================================================================================================================
        
      public static void writeOrderToFile(String filename, Order order){
        try {
            fileWriter=new FileWriter(filename, true);
            bufWriter =new BufferedWriter(fileWriter);
           bufWriter.write(order.getOrderID()+"|"+order.getCustomerID()+"|"+order.getDate()+"|"+order.getStatus()+"\n");  
        } catch (Exception e) {
            System.out.println("Lỗi  ghi file order  !"+e);
        } finally {
            try {
               
                bufWriter.close(); 
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Không thể đóng file doc order !"+e);
            }
        }
      
    }
    public static List<Order>readOrderFromFile(String filename){
        List<Order> orders=new ArrayList<Order>();
        try {
            fileReader=new FileReader(filename);
             bufReader=new BufferedReader(fileReader);
             File file= new File(filename);
             if(file.exists()){
                file.createNewFile();
             }
             String line="";
             while((line= bufReader.readLine())!=null){
                 String []data=line.split("\\|");
                 Order order;
                 order = new Order(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3]);
                 orders.add(order);
                 
             }
             
        } catch (Exception e) {
            System.out.println(" Lỗi đọc file order !"+e);        }
       finally{
            try {
                bufReader.close();
                fileReader.close();
            } catch (Exception e) {
                System.out.println("không thể đóng file order !"+e);
            }
        }
            return orders;    
    }
     
    public static void writeOrderDetailToFile(String filename, OrderDetail orderDetail){
        try {
            fileWriter=new FileWriter(filename, true);
            bufWriter =new BufferedWriter(fileWriter);
             bufWriter.write(orderDetail.getOrderID()+"|"+orderDetail.getProductID()+"|"+orderDetail.getQuantity()+"\n");  
        } catch (Exception e) {
            System.out.println("Lỗi ghi file  order !"+e);
        } finally {
            try {
                bufWriter.close();
                fileWriter.close();
               
            } catch (Exception e) {
                System.out.println("Không thể đóng file order  !"+e);
            }
        }
      
    }
    public static List<OrderDetail>readOrderDetailFromFile(String filename){
        List<OrderDetail> orderDetails=new ArrayList<>();
        try {
            fileReader=new FileReader(filename);
             bufReader=new BufferedReader(fileReader);
             File file= new File(filename);
             if(file.exists()){
                file.createNewFile();
             }
             String line="";
             while((line= bufReader.readLine())!=null){
                 String []data=line.split("\\|");
                 OrderDetail orderDetail=new OrderDetail(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                 orderDetails.add(orderDetail);
                 
             }
             
        } catch (Exception e) {
            System.out.println(" Lỗi đọc ghi file order !"+e);        }
       finally{
            try {
                bufReader.close();
                fileReader.close();
            } catch (Exception e) {
                System.out.println("không thể đóng file doc order !"+e);
            }
        }
            return orderDetails;    
    }

   
    public  static void updatelistOrderToFile(String filename, List<Order> orders) {
       
         FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, false);
            bw= new BufferedWriter(fw);
            orders.forEach(item -> {
                writeOrderToFile(filename, item);
             });  
            
            System.out.println("update file order  successfully...");
        } catch (IOException ex) {
            System.out.println("loi update file order  file");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi khong the dong file order ");
            }
        }
    }

   

    public static void updateListOrderDetail(String filename, List<OrderDetail> orderDetails) {
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw= new FileWriter(filename, false);
            bw= new BufferedWriter(fw);
            orderDetails.forEach(item -> {
                writeOrderDetailToFile(filename, item);
             });  
            
            System.out.println("update file orderDetail successfully...");
        } catch (IOException ex) {
            System.out.println("loi update file orderdetail ");
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                System.out.println("Loi khong thẻ dong file orderdetail ");
            }
        }
    }
             
    
       
        
}
