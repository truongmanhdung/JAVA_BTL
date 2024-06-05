/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.CategoriesModel;
import views.HomePageView;
import views.ManagementAccountView;
import views.ManagementCustomerView;
import views.ManagementEmployeeView;
import views.ManagementProductView;
import views.ManagementReceptView;
import views.ManagementStatisticalView;

/**
 *
 * @author ADMIN
 */
public class ScreenSwitchController {
    private String kindSelected = "";
    private JPanel jPanelRoot;
    private List<CategoriesModel> listCategory = null;
//    HomePageView homePageView = new HomePageView();

    public ScreenSwitchController(JPanel jPanelRoot){
        this.jPanelRoot = jPanelRoot;
    }

    public void setDashboard(JPanel jpanelItem, JLabel jlabelItem){
        kindSelected = "HomePage";
        jpanelItem.setBackground(new Color(253, 203, 110));
        jlabelItem.setBackground(new Color(253, 203, 110));

        jPanelRoot.removeAll();
        jPanelRoot.setLayout(new BorderLayout());
        jPanelRoot.add(new HomePageView());
        jPanelRoot.validate();
        jPanelRoot.repaint();
    }

    public void setDashboardForEmployee(JPanel jpanelItem, JLabel jlabelItem){
        kindSelected = "HomePage";
        jpanelItem.setBackground(new Color(253, 203, 110));
        jlabelItem.setBackground(new Color(253, 203, 110));

        jPanelRoot.removeAll();
        jPanelRoot.setLayout(new BorderLayout());
        jPanelRoot.add(new ManagementProductView());
        jPanelRoot.validate();
        jPanelRoot.repaint();
    }

    public void setEvent(List<CategoriesModel> listCategory) {
        this.listCategory = listCategory;
        for(CategoriesModel item : listCategory){
            item.getJpanel().addMouseListener(new LabelEvent(item.getKind(), item.getJpanel(), item.getJlabel()));
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpanelItem;
        private JLabel jlabeItem;

        public LabelEvent(String kind, JPanel jpanelItem, JLabel jlabeItem) {
            this.kind = kind;
            this.jpanelItem = jpanelItem;
            this.jlabeItem = jlabeItem;
        }

        @Override public void mouseClicked(MouseEvent e){

        }

        @Override
        public void mousePressed(MouseEvent e) { 
            kindSelected = kind;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            switch (kind) {
                case "HomePage":
                    node = new HomePageView();
                    break;
                case "ManagementAccount":
                    node = new ManagementAccountView();
                    break;
                case "ManagementEmployee":
                    node = new ManagementEmployeeView();
                    break;
                case "ManagementCustomer":
                    node = new ManagementCustomerView();
                    break;
                case "ManagementProduct":
                    node = new ManagementProductView();
                    break;
                case "ManagementRecept":
                    node = new ManagementReceptView();
                    break; 
                case "ManagementStatistical":
                    node = new ManagementStatisticalView();
                    break;
                default:
                    break;
            }
            jPanelRoot.removeAll();
            jPanelRoot.setLayout(new BorderLayout());
            jPanelRoot.add(node);
            jPanelRoot.validate();
            jPanelRoot.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mouseEntered(MouseEvent e) { //Được triệu hồi khi một nút chuột ĐÃ được nhấn trên một thành phần.
//            jpanelItem.setBackground(new Color(108, 92, 231));
//            jlabeItem.setBackground(new Color(108, 92, 231));
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private void setChangeBackground(String kind) { //khi một panel trong menu được chọn
        for (CategoriesModel item : listCategory) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJlabel().setBackground(new Color(253, 203, 110));
                item.getJpanel().setBackground(new Color(253, 203, 110));
            } else {
                item.getJlabel().setBackground(new Color(75,123,236));
                item.getJpanel().setBackground(new Color(75,123,236));
            }
        }
    }
}
