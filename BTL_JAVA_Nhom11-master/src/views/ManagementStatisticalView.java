/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controllers.FileController;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import models.Order;
import models.OrderDetail;
import models.product;
import static views.ManagementCustomerView.model;


/**
 *
 * @author ADMIN
 */
public class ManagementStatisticalView extends javax.swing.JPanel {

    /**
     * Creates new form ManagementStatisticalView
     */
    
    static List<OrderDetail> orderDetails = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static List<product> products = new ArrayList<>();
    static DecimalFormat numberFormat = new DecimalFormat( "###,###,###" );
    
    public ManagementStatisticalView() {
        initComponents();
        List<OrderDetail> orderDetailstest = new ArrayList<>();
        model = (DefaultTableModel) tblReport.getModel();
        orderDetails = FileController.readOrderDetailFromFile("orderDetail.txt");
        orders = FileController.readOrderFromFile("order.txt");
        products = FileController.readProductFromFile("product.txt");
        
  }  
  

    public void showTable(List<OrderDetail> orDetail)
    {
        List<Integer> listProductID = new ArrayList<>();
        List<String> listProductName = new ArrayList<>();
        List<Float> listProductPrice = new ArrayList<>();
        List<Integer> listProductSold = new ArrayList<>();
        List<Float> listProductRevenue = new ArrayList<>();
        Float total = 0f;
        String choiceFilter = cbxFilter.getSelectedItem().toString();
        
        for(int i=0; i<orDetail.size(); i++)
            if(!listProductID.contains(orDetail.get(i).getProductID())) 
                listProductID.add(orDetail.get(i).getProductID());
        
        Collections.sort(listProductID);
        
        for(int i=0; i<listProductID.size(); i++)
            for(int j=0; j<products.size(); j++)
                if(products.get(j).getmaSP() == listProductID.get(i)) 
                {
                    listProductName.add(products.get(j).getTenSP());
                    listProductPrice.add(products.get(j).getGiaBan());
                    break;
                }
        
        for(int i=0; i<listProductID.size(); i++)
        {
            Integer totalQuantity = 0;
            Float totalRevenue = 0f;
            for(int j=0; j<orDetail.size(); j++)
                if(orDetail.get(j).getProductID() == listProductID.get(i)) 
                {
                    totalQuantity += orDetail.get(j).getQuantity();
                    totalRevenue += orDetail.get(j).money();        
                }
            total += totalRevenue;
            listProductSold.add(totalQuantity);
            listProductRevenue.add(totalRevenue);
        }
        switch(choiceFilter)
        {
            case "Mã sản phẩm":
            {
                model.setRowCount(0); 
                for (int i=0; i<listProductID.size(); i++) 
                    model.addRow(new Object[]{
                        listProductID.get(i), listProductName.get(i), listProductSold.get(i), numberFormat.format(listProductPrice.get(i)) , numberFormat.format(listProductRevenue.get(i))
                    });  
                break;
            }
            case "Doanh thu":
            {          
                List<Integer> index = new ArrayList<>();
                for(int i=0; i<listProductRevenue.size();i++)
                {
                    index.add(i);
                }
                for(int i=0; i<listProductRevenue.size()-1;i++)
                {
                    for(int j=i+1; j<listProductRevenue.size();j++)
                        if(listProductRevenue.get(i) > listProductRevenue.get(j))
                        {
                            Float tg = listProductRevenue.get(i);
                            listProductRevenue.set(i, listProductRevenue.get(j));
                            listProductRevenue.set(j, tg);        
                            
                            Integer tg1 = index.get(i);
                            index.set(i, index.get(j));
                            index.set(j, tg1);  
                        }
                }
                
                model.setRowCount(0); 
                for (int i=0; i<listProductRevenue.size(); i++) 
                    model.addRow(new Object[]{
                        listProductID.get(index.get(i)), listProductName.get(index.get(i)), listProductSold.get(index.get(i)), numberFormat.format(listProductPrice.get(index.get(i))) , numberFormat.format(listProductRevenue.get(i))
                    });  
                break;
            }
            case "Số lượng":
            {
                List<Integer> index = new ArrayList<>();
                for(int i=0; i<listProductRevenue.size();i++)
                {
                    index.add(i);
                }
                for(int i=0; i<listProductSold.size()-1;i++)
                {
                    for(int j=i+1; j<listProductSold.size();j++)
                        if(listProductSold.get(i) > listProductSold.get(j))
                        {
                            Integer tg = listProductSold.get(i);
                            listProductSold.set(i, listProductSold.get(j));
                            listProductSold.set(j, tg);        
                            
                            Integer tg1 = index.get(i);
                            index.set(i, index.get(j));
                            index.set(j, tg1);  
                        }
                }
                
                model.setRowCount(0); 
                for (int i=0; i<listProductSold.size(); i++) 
                    model.addRow(new Object[]{
                        listProductID.get(index.get(i)), listProductName.get(index.get(i)), listProductSold.get(i), numberFormat.format(listProductPrice.get(index.get(i))) , numberFormat.format(listProductRevenue.get(index.get(i)))
                    });  
                break;
            }
        }
         
        tblReport.setAutoCreateRowSorter(true);
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        tblReport.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tblReport.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblReport.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tblReport.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        
        String totalFormat = numberFormat.format(total);
        labTotal.setText(totalFormat + " VND");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        inpMonth = new com.toedter.calendar.JMonthChooser();
        inpYear = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();
        labDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labTotal = new javax.swing.JLabel();
        cbxFilter = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(75, 123, 236));
        jLabel2.setText("THỐNG KÊ BÁO CÁO");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 35, -1, -1));

        inpMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inpMonth.setPreferredSize(new java.awt.Dimension(300, 300));
        inpMonth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpMonthPropertyChange(evt);
            }
        });
        add(inpMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 29));

        inpYear.setFocusable(false);
        inpYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                inpYearPropertyChange(evt);
            }
        });
        add(inpYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 71, 29));

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số Lượng", "Giá Bán", "Doanh Thu"
            }
        ));
        jScrollPane1.setViewportView(tblReport);
        if (tblReport.getColumnModel().getColumnCount() > 0) {
            tblReport.getColumnModel().getColumn(0).setMinWidth(100);
            tblReport.getColumnModel().getColumn(0).setMaxWidth(150);
            tblReport.getColumnModel().getColumn(1).setMinWidth(200);
            tblReport.getColumnModel().getColumn(2).setMinWidth(150);
            tblReport.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 827, 392));

        labDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(labDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 124, 307, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Tổng:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 570, -1, 23));

        labTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(labTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 570, 188, 23));

        cbxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Số lượng", "Doanh thu" }));
        cbxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFilterActionPerformed(evt);
            }
        });
        add(cbxFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 90, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void inpMonthPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpMonthPropertyChange
        // TODO add your handling code here:
        filter();
        
    }//GEN-LAST:event_inpMonthPropertyChange

    private void inpYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_inpYearPropertyChange
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_inpYearPropertyChange

    private void cbxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFilterActionPerformed
        // TODO add your handling code here:
        filter();
    }//GEN-LAST:event_cbxFilterActionPerformed

    public void filter()
    {
        Integer month = inpMonth.getMonth() + 1;
        Integer year = inpYear.getYear();

        labDate.setText("Tháng "+(month)+" Năm " +(year));
        List<OrderDetail> listByDate = new ArrayList<>();
        List<String> listDate = new ArrayList<>();
        
        for(int i=0; i<orders.size(); i++)
        {
            Integer orderMonth = Integer.parseInt(orders.get(i).getDate().substring(3, 5));
            Integer orderYear = Integer.parseInt(orders.get(i).getDate().substring(6));
            
            if(orderMonth.equals(month) && orderYear.equals(year)) 
                for(int j=0; j<orderDetails.size(); j++)
                    if(orders.get(i).getOrderID() == orderDetails.get(j).getOrderID())
                        listByDate.add(orderDetails.get(j));                       
        }        
        showTable(listByDate);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxFilter;
    private com.toedter.calendar.JMonthChooser inpMonth;
    private com.toedter.calendar.JYearChooser inpYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labDate;
    private javax.swing.JLabel labTotal;
    private javax.swing.JTable tblReport;
    // End of variables declaration//GEN-END:variables
}
