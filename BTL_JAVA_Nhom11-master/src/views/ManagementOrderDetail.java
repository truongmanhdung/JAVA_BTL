package views;

import controllers.FileController;
import static controllers.Utils.iconimage;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Customer;
import models.Order;
import models.OrderDetail;
import models.product;
import controllers.Utils;
import static controllers.Utils.iconimage;
import static controllers.Utils.rightRender;
import static controllers.Utils.setBgButtonHasColor;
import static controllers.Utils.setBgButtonNull;
import static controllers.Utils.setBgColor;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kien Ninh
 */
public class ManagementOrderDetail extends javax.swing.JFrame {

    /**
     * Creates new form ManagementOrderDetail
     */
    static DefaultTableModel modelDetail;
    static DefaultTableModel modelPro;
    
    static List<OrderDetail> orderDetails = new ArrayList<>();
    static  List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<product> products = new ArrayList<>();
    String maKH = "";
    public static Integer orderIndex = 0;
    static FileController fileController;
    private ManagementReceptView homeRecept;
    static DecimalFormat numberFormat = new DecimalFormat( "###,###,###" );
    
    static Integer orderID = 0;
   
 
    public ManagementOrderDetail(ManagementReceptView parent ,String mahd, String makh, String ngay) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        homeRecept=(ManagementReceptView)parent;
        ipnorderID.setText(mahd);
        maKH = makh;
        ipnCustomerID.setText(makh);
        ipnDate.setText(ngay);
        orders = fileController.readOrderFromFile("order.txt");
        customers = fileController.readCustomerFromFile("customer.txt");
        modelPro = (DefaultTableModel) productTbl.getModel();
        products = FileController.readProductFromFile("product.txt");
        
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderID()==Integer.parseInt(mahd)) {
                orderIndex = i;
            }
        }
        
        ipnTotal.setText(orders.get(orderIndex).getTotalMoneyDouble() + "");
        modelDetail = (DefaultTableModel) orderDetailTbl.getModel();
        orderDetails = FileController.readOrderDetailFromFile("orderDetail.txt");
        orderID =Integer.parseInt(ipnorderID.getText().trim());
        ProductDisplay();
        OrderDetailDisplay();     
      
        ImageIcon addIcon=iconimage(24,24,"src/icons/add-product.png");
        addBtn.setIcon(addIcon);
        ImageIcon deleteIcon=iconimage(25,25,"src/icons/bin2.png");
        deleteBtn.setIcon(deleteIcon);
        ImageIcon updateIcon=iconimage(25,25,"src/icons/update.png");
        updateBtn.setIcon(updateIcon);
        ImageIcon closeIcon=iconimage(40,40,"src/icons/return.png");
        closeBtn.setIcon(closeIcon);

        setBgColor(addBtn,updateBtn,deleteBtn);
        
        
    }
  
    
    private ManagementOrderDetail() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        JPanel1 = new javax.swing.JPanel();
        ipnProductID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ipnPrice = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ipnQuantity = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderDetailTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ipnDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ipnorderID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ipnTotal = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        productTbl = new javax.swing.JTable();
        closeBtn = new javax.swing.JButton();
        ipnCustomerID = new javax.swing.JTextField();
        showError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết hóa đơn");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(75, 123, 236));
        jLabel7.setText("CHI TIẾT HÓA ĐƠN");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        JPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        JPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ipnProductID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ipnProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipnProductIDActionPerformed(evt);
            }
        });
        JPanel1.add(ipnProductID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 275, 35));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mã sản phẩm");
        JPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Số lượng");
        JPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        ipnPrice.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        JPanel1.add(ipnPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 275, 35));

        addBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addBtn.setText("Thêm ");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        JPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 130, 50));

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setText("Cập nhật");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        JPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 130, 50));

        deleteBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteBtn.setText("Xóa");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        JPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 130, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Giá bán");
        JPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        ipnQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JPanel1.add(ipnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 275, 35));

        getContentPane().add(JPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 620, 230));

        orderDetailTbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        orderDetailTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderDetailTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderDetailTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(orderDetailTbl);
        if (orderDetailTbl.getColumnModel().getColumnCount() > 0) {
            orderDetailTbl.getColumnModel().getColumn(0).setPreferredWidth(30);
            orderDetailTbl.getColumnModel().getColumn(1).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 410, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ngày tạo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 20));

        ipnDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(ipnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 275, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 110, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã khách hàng");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, 20));

        ipnorderID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ipnorderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipnorderIDActionPerformed(evt);
            }
        });
        getContentPane().add(ipnorderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 275, 35));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 100, 20));

        ipnTotal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(ipnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 275, 35));

        productTbl.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        productTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Giảm giá", "Số lượng còn"
            }
        ));
        productTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTblMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(productTbl);
        if (productTbl.getColumnModel().getColumnCount() > 0) {
            productTbl.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 610, 260));

        closeBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, 40));

        ipnCustomerID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(ipnCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 275, 35));

        showError.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(showError, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 420, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("In hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 670, -1, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int row = orderDetailTbl.getSelectedRow();
        //lấy sản phẩm cũ
        System.out.println("Cap nhat");
        Integer OrderID = Integer.parseInt(ipnorderID.getText());
        Integer ProductID = (Integer)modelDetail.getValueAt(row, 0);
        Integer sl = (Integer)modelDetail.getValueAt(row, 1);
        //lấy sản phẩm mới
        
        String ipnQuantityString=ipnQuantity.getText();
        
        if(ipnQuantityString.compareTo("")==0){
            showError.setText("Nhập số lượng sản phẩm cần mua");
            return;
        }
        String regQuantity="^\\d+$";
        Pattern pattern=Pattern.compile(regQuantity);
        Matcher match=pattern.matcher(ipnQuantityString);
        if(!match.matches()){
            showError.setText("Bạn cần nhập 1 số nguyên");
            return;
        }
        Integer Quantity = Integer.parseInt(ipnQuantityString);
        OrderDetail od=new OrderDetail(OrderID,ProductID,sl);
        //Kiếm tra số lượng hàng
        for(int a=0;a<products.size();a++)
        {
            if(products.get(a).getmaSP()==ProductID)
            {
                if (Quantity >(products.get(a).getSoLuong()+sl))
                {
                    showError.setText("Số sản phẩm không đủ");
                    return;
                }
                
            }
        }
        Float Point =orders.get(orderIndex).getTotalMoneyDouble();
        for (int j= 0; j < products.size() ; j++) 
                {
                    if (products.get(j).getmaSP()== ProductID)
                    {
                        products.get(j).setSoLuong(products.get(j).getSoLuong()+sl - Quantity);
                        modelPro.setValueAt(products.get(j).getSoLuong(), j, 4);

                    }
                }
        for (int i=0;i<orderDetails.size();i++)
        {
            if(orderDetails.get(i).equals(od))
            {
                fileController.updateListProductToFile("product.txt", products);
                orderDetails.set(i, new OrderDetail(OrderID, ProductID,Quantity ));
                Float Money = orderDetails.get(i).money();
                fileController.updateListOrderDetail("orderDetail.txt", orderDetails);
                modelDetail.setValueAt(ProductID, row, 0);
                modelDetail.setValueAt(Quantity, row, 1);
                modelDetail.setValueAt(Money, row, 2);
                ipnTotal.setText(orders.get(orderIndex).getTotalMoneyDouble() + "");

                setNullIPN();

                orders.get(orderIndex).setPoint(Point,Float.parseFloat(ipnTotal.getText()));
            }       
        }

        JOptionPane.showMessageDialog(null,"Cập nhật hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateBtnActionPerformed
    

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try
        {
        int row = productTbl.getSelectedRow();
        int sl = (int) productTbl.getValueAt(row, 4);
        Integer ProductID = Integer.parseInt(ipnProductID.getText());   
        String ipnQuantityString=ipnQuantity.getText();
        if(ipnQuantityString.compareTo("")==0){
            showError.setText("Nhập số lượng sản phẩm cần mua");
            return;
        }
        String regQuantity="^\\d+$";
        Pattern pattern=Pattern.compile(regQuantity);
        Matcher match=pattern.matcher(ipnQuantityString);
        if(!match.matches()){
            showError.setText("Bạn cần nhập 1 số nguyên");
            return;
        }
        Integer Quantity = Integer.parseInt(ipnQuantityString);
        if (Quantity > sl) {
            showError.setText("Số lượng sản phẩm không đủ");
            return;
        }
        Float Point =orders.get(orderIndex).getTotalMoneyDouble();
        boolean check=false;
        int index=0;
        for(int j=0;j<orderDetails.size();j++)
        {
           
            if((orderDetails.get(j).getOrderID()== orders.get(orderIndex).getOrderID())&&
                (orderDetails.get(j).getProductID()== ProductID)){
                check=true;
                index=j;
                break;
            }
             
        }
        if(check)
        {
            orderDetails.get(index).setQuantity(orderDetails.get(index).getQuantity()+Quantity);
           
        }
        else
        {
            OrderDetail od = new OrderDetail(orders.get(orderIndex).getOrderID(), ProductID, Quantity);
            orderDetails.add(od);
                
        }  
        fileController.updateListOrderDetail("orderDetail.txt", orderDetails);
        OrderDetailDisplay();
        //cap nhat lai bang san pham
        for (int i = 0; i <= products.size() - 1; i++) {
            if (Objects.equals(products.get(i).getmaSP(), ProductID)) {
                
                products.get(i).setSoLuong(products.get(i).getSoLuong() - Quantity);
                
                modelPro.setValueAt(products.get(i).getSoLuong(), i, 4);
                
            }
        }
        fileController.updateListProductToFile("product.txt", products);
        
        ipnTotal.setText(orders.get(orderIndex).getTotalMoneyDouble() + "");
        setNullIPN();
        orders.get(orderIndex).setPoint(Point,Float.parseFloat(ipnTotal.getText()));
        }
        catch (Exception e)
        {
            showError.setText("Vui lòng nhập đầy đủ thông tin"+e.toString());
        }
    }//GEN-LAST:event_addBtnActionPerformed
    private void orderDetailTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderDetailTblMouseClicked
        //hiển thị bảng chi tiết hóa đơn
        addBtn.setEnabled(false);
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        int row = orderDetailTbl.getSelectedRow();
        Integer ProductID = (Integer) orderDetailTbl.getValueAt(row, 0);
        Integer quantity = (Integer) orderDetailTbl.getValueAt(row, 1);
//        float Money = (Float) orderDetailTbl.getValueAt(row, 2);
        //sdet dữ liệu lên ô text
        ipnProductID.setText(ProductID + "");
        for (product a : products) {
            if (a.getmaSP().equals(ProductID)) {
                ipnPrice.setText(a.getGiaBan() + "");
            }            
        }
        
        ipnQuantity.setText(quantity + "");
        ProductDisplay();
        
    }//GEN-LAST:event_orderDetailTblMouseClicked

    private void ipnProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipnProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipnProductIDActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int row = orderDetailTbl.getSelectedRow();
        int answer = JOptionPane.showConfirmDialog(null,
                "Bạn có chắc muốn xóa sản phẩm này?", "Xác nhận",
                JOptionPane.YES_NO_OPTION, 0);
        if (answer == 0) 
        {
            Integer OrderID=Integer.parseInt(ipnorderID.getText());
            Integer ProductID=(Integer)modelDetail.getValueAt(row, 0);
            Integer Quantity=(Integer)modelDetail.getValueAt(row, 1);
            OrderDetail od=new OrderDetail(OrderID,ProductID,Quantity);
            for (int j=0;j<orderDetails.size();j++)
            {   if(orderDetails.get(j).equals(od))
                {
                    for(int i=0; i<products.size();i++)
                    {
                        if(Objects.equals(products.get(i).getmaSP(), ProductID))
                        {
                            products.get(i).setSoLuong(products.get(i).getSoLuong()+Quantity);
                            modelPro.setValueAt(products.get(i).getSoLuong(), i,4);
                            break;
                        }
                    }
                    Float Point =orders.get(orderIndex).getTotalMoneyDouble();
                    //xoa tren giao dien
                    modelDetail.removeRow(row);
                    orderDetails.remove(j);
                    fileController.updateListProductToFile("product.txt", products);
                    FileController.updateListOrderDetail("orderDetail.txt", orderDetails);
                    ipnTotal.setText(orders.get(orderIndex).getTotalMoneyDouble()+"");
                    orders.get(orderIndex).setPoint(Point,Float.parseFloat(ipnTotal.getText()));  
                    break;
                }  
            }
        }
       setNullIPN();
       
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
            
        homeRecept.actionDisplay();
        homeRecept.CustomersDisplay();
        this.dispose();
         
    }//GEN-LAST:event_closeBtnActionPerformed

    private void productTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTblMouseClicked
        int row = productTbl.getSelectedRow();
        Integer productID = (Integer) modelPro.getValueAt(row, 0);
        float Price = (Float) modelPro.getValueAt(row, 2);
        float Saleprice = (Float) modelPro.getValueAt(row, 3);
        Integer quantity = (Integer) modelPro.getValueAt(row, 4);
        ipnProductID.setText(productID + "");
        ipnPrice.setText(Price + "");
        OrderDetailDisplay();
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        addBtn.setEnabled(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_productTblMouseClicked

    private void ipnorderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipnorderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipnorderIDActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        deleteBtn.setEnabled(false);
        updateBtn.setEnabled(false);
        addBtn.setEnabled(true);
        ProductDisplay();
        OrderDetailDisplay();
        setNullIPN();
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String date = ipnDate.getText();
        String orderNumber = ipnorderID.getText().trim();
        String customerID = ipnCustomerID.getText().trim();

        PrintBill bill = new PrintBill(orderNumber, customerID, date);
        bill.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagementOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagementOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagementOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagementOrderDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                ManagementOrderDetail detail = new ManagementOrderDetail();
                detail.pack();
                detail.setLocationRelativeTo(null);
                detail.setVisible(true);
                detail.setVisible(true);
            }
        });        
    }
    
    public void setNullIPN() {
        ipnProductID.setText("");
        ipnPrice.setText("");
        ipnQuantity.setText("");
        showError.setText("");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField ipnCustomerID;
    private javax.swing.JTextField ipnDate;
    private javax.swing.JTextField ipnPrice;
    private javax.swing.JTextField ipnProductID;
    private javax.swing.JTextField ipnQuantity;
    private javax.swing.JTextField ipnTotal;
    private javax.swing.JTextField ipnorderID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable orderDetailTbl;
    private javax.swing.JTable productTbl;
    private javax.swing.JLabel showError;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables

    private void ProductDisplay() 
    {
       modelPro.setRowCount(0);
        for (product a : products) {
            modelPro.addRow(new Object[]{
                a.getmaSP(), a.getTenSP(), a.getGiaBan(), a.getGiamGia(), a.getSoLuong()
            });
        }
        rightRender(productTbl,2);
    }
    
    private void OrderDetailDisplay() 
    {
        modelDetail.setRowCount(0);
        for (OrderDetail a : orderDetails) {
            if (a.getOrderID().equals(orderID)) {
                modelDetail.addRow(new Object[]{
                    a.getProductID(), a.getQuantity(), numberFormat.format(a.money())
                });
            }
        }
        rightRender(orderDetailTbl,2);   
    }
}
