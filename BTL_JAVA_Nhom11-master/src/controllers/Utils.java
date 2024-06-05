package controllers;

import java.awt.Color;
import java.awt.Image;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static views.ManagementCustomerView.model;

/**
 *
 * @author Minh Phuong Do
 */
public class Utils {
    public static void filterByColummTable(TextField fieldName, DefaultTableModel tableModel, JTable tableName, int searchColumn){
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(tableModel);

        tableName.setRowSorter(rowSorter);
        String searchUsername = fieldName.getText().trim().toLowerCase();

        if(searchUsername.trim().length() == 0){
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchUsername, searchColumn));
        }
    }

    public static void filterByTable(TextField fieldName, DefaultTableModel tableModel, JTable tableName){
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(tableModel);

        tableName.setRowSorter(rowSorter);
        String search = fieldName.getText().trim().toLowerCase();

        if(search.trim().length() == 0){
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        }
    }

    public static void setBgButtonNull(JButton addBtn, JButton updateBtn, JButton deleteBtn){
        addBtn.setBackground(new Color(75,123,236));
        updateBtn.setBackground(new Color(223, 230, 233));
        deleteBtn.setBackground(new Color(223, 230, 233));
    }
    public static void setBgButtonNull(JButton addBtn, JButton updateBtn, JButton deleteBtn, JButton detailBtn){
        addBtn.setBackground(new Color(75,123,236));
        updateBtn.setBackground(new Color(0,153,51));
        deleteBtn.setBackground(new Color(223, 230, 233));
        detailBtn.setBackground(new Color(223, 230, 233));
    }

    public static void setBgButtonHasColor(JButton addBtn, JButton updateBtn, JButton deleteBtn){
        addBtn.setBackground(new Color(223, 230, 233));
       updateBtn.setBackground(new Color(0,153,51));
        deleteBtn.setBackground(new Color(204,37,31));      
    }
    
    public static void setBgColor(JButton addBtn, JButton updateBtn, JButton deleteBtn){
        addBtn.setBackground(new Color(75,123,236));
        updateBtn.setBackground(new Color(0,153,51));
        deleteBtn.setBackground(new Color(204,37,31));      
    }
    public static void setBgButtonHasColor(JButton addBtn, JButton updateBtn, JButton deleteBtn,JButton detailBtn){
        addBtn.setBackground(new Color(223, 230, 233));
        updateBtn.setBackground(new Color(0,153,51));
        deleteBtn.setBackground(new Color(204,37,31));  
        detailBtn.setBackground(new Color(255,255,102));      
    }
    public static ImageIcon iconimage(int w,int h,String link){
        ImageIcon Icon = new ImageIcon(link);
        Image img= Icon.getImage();
        Image imgScale=img.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        ImageIcon Scale=new ImageIcon(imgScale);
        return Scale;
        }
    public static void rightRender(JTable tbl,int column){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tbl.getColumnModel().getColumn(column).setCellRenderer(rightRenderer);
    }
}
