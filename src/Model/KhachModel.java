/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.KhachDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pojo.KhachPoJo;

/**
 *
 * @author Administrator
 */
public class KhachModel extends AbstractTableModel {
    private ArrayList<KhachPoJo> listStaff;

    public KhachModel() throws ClassNotFoundException, SQLException {
        listStaff = new KhachDAO().getKhachList();
    }
    
    public void getBySearch(KhachPoJo khach) throws ClassNotFoundException, SQLException {
        listStaff = new KhachDAO().getKhachListBySearch(khach);
        super.fireTableDataChanged();
    }
    
    public KhachPoJo getByIndex(int rowIndex) {
        return listStaff.get(rowIndex);     
    }
    
    public void addElement(KhachPoJo staff) {
        listStaff.add(staff);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listStaff.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listStaff.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KhachPoJo khach = listStaff.get(rowIndex);
        switch(columnIndex){
            case 0: return khach.getMakh();
            case 1: return khach.getTenkh();
            case 2: return khach.getDiaChi();
            case 3: return khach.getDienThoai();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MAKHACH";
            case 1: return "TEN KHACH";
            case 2: return "DIA CHI";
            case 3: return "DIEN THOAI";
            default: return null;
        }
    }
}
