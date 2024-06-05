/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;
import java.lang.Object;
import controllers.ScreenSwitchController;
import static controllers.Utils.iconimage;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import models.CategoriesModel;

/**
 *
 * @author Minh Phuong Do
 */
public class MainEmployee extends javax.swing.JFrame {

    /**
     * Creates new form HomeView
     */
    public MainEmployee() {
        initComponents();
        ScreenSwitchController ssController = new ScreenSwitchController(containerPanel);
        ssController.setDashboardForEmployee(management_productPanel, productLabel);

        List<CategoriesModel> listCate = new ArrayList<>();
        //listCate.add(new CategoriesModel("HomePage", home_pagePanel, homepageLabel));
        //listCate.add(new CategoriesModel("ManagementAccount", management_accPanel, accLabel));
        //listCate.add(new CategoriesModel("ManagementEmployee", management_employeePanel, employeeLabel));
        listCate.add(new CategoriesModel("ManagementCustomer", management_customerPanel, customerLabel));
        listCate.add(new CategoriesModel("ManagementProduct", management_productPanel, productLabel));
        listCate.add(new CategoriesModel("ManagementRecept", management_receptPanel, receptLabel));
        //listCate.add(new CategoriesModel("ManagementStatistical", management_statisticalPanel, statistifyLabel));
        ssController.setEvent(listCate);
        
        ImageIcon productIcon=iconimage(26,26,"src/icons/tshirt.png");
        productLabel.setIcon(productIcon);
        ImageIcon customerIcon=iconimage(25,25,"src/icons/thanh_toan.png");
        customerLabel.setIcon(customerIcon);
        ImageIcon receptIcon=iconimage(25,25,"src/icons/quan_Li.png");
        receptLabel.setIcon(receptIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPanel = new javax.swing.JPanel();
        management_customerPanel = new javax.swing.JPanel();
        customerLabel = new javax.swing.JLabel();
        management_productPanel = new javax.swing.JPanel();
        productLabel = new javax.swing.JLabel();
        management_receptPanel = new javax.swing.JPanel();
        receptLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ SHOP THỜI TRANG");

        sidebarPanel.setBackground(new java.awt.Color(153, 153, 153));
        sidebarPanel.setPreferredSize(new java.awt.Dimension(300, 630));
        sidebarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        management_customerPanel.setBackground(new java.awt.Color(75, 123, 236));
        management_customerPanel.setForeground(new java.awt.Color(255, 255, 255));
        management_customerPanel.setPreferredSize(new java.awt.Dimension(270, 50));

        customerLabel.setFont(new java.awt.Font("Candara", 1, 16)); // NOI18N
        customerLabel.setForeground(new java.awt.Color(255, 255, 255));
        customerLabel.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout management_customerPanelLayout = new javax.swing.GroupLayout(management_customerPanel);
        management_customerPanel.setLayout(management_customerPanelLayout);
        management_customerPanelLayout.setHorizontalGroup(
            management_customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, management_customerPanelLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(customerLabel)
                .addGap(45, 45, 45))
        );
        management_customerPanelLayout.setVerticalGroup(
            management_customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sidebarPanel.add(management_customerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 271, 277, -1));

        management_productPanel.setBackground(new java.awt.Color(75, 123, 236));
        management_productPanel.setPreferredSize(new java.awt.Dimension(270, 50));

        productLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        productLabel.setForeground(new java.awt.Color(255, 255, 255));
        productLabel.setText("QUẢN LÝ SẢN PHẨM");

        javax.swing.GroupLayout management_productPanelLayout = new javax.swing.GroupLayout(management_productPanel);
        management_productPanel.setLayout(management_productPanelLayout);
        management_productPanelLayout.setHorizontalGroup(
            management_productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(management_productPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(productLabel)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        management_productPanelLayout.setVerticalGroup(
            management_productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sidebarPanel.add(management_productPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 186, 277, -1));

        management_receptPanel.setBackground(new java.awt.Color(75, 123, 236));
        management_receptPanel.setPreferredSize(new java.awt.Dimension(270, 50));

        receptLabel.setFont(new java.awt.Font("Cambria", 1, 16)); // NOI18N
        receptLabel.setForeground(new java.awt.Color(255, 255, 255));
        receptLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receptLabel.setText("QUẢN LÝ HÓA ĐƠN");

        javax.swing.GroupLayout management_receptPanelLayout = new javax.swing.GroupLayout(management_receptPanel);
        management_receptPanel.setLayout(management_receptPanelLayout);
        management_receptPanelLayout.setHorizontalGroup(
            management_receptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(management_receptPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(receptLabel)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        management_receptPanelLayout.setVerticalGroup(
            management_receptPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receptLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        sidebarPanel.add(management_receptPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 356, 277, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 52)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MINNA SHOP");
        sidebarPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        logoutBtn.setBackground(new java.awt.Color(255, 153, 51));
        logoutBtn.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/thoat.png"))); // NOI18N
        logoutBtn.setText("Đăng xuất");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        sidebarPanel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 739, 133, 38));

        containerPanel.setPreferredSize(new java.awt.Dimension(985, 670));

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 985, Short.MAX_VALUE)
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(containerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addComponent(sidebarPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_logoutBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerPanel;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel management_customerPanel;
    private javax.swing.JPanel management_productPanel;
    private javax.swing.JPanel management_receptPanel;
    private javax.swing.JLabel productLabel;
    private javax.swing.JLabel receptLabel;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
