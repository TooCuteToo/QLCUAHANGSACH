/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.DonGiaDAO;
import Pojo.DonGiaPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class DonGiaModel extends AbstractTableModel {
    private ArrayList<DonGiaPoJo> listDonGia;

    public DonGiaModel() throws ClassNotFoundException, SQLException {
        listDonGia = new DonGiaDAO().getDonGiaList();
    }
//    
//    public void getBySearch(DonGiaPoJo don_gia) throws ClassNotFoundException, SQLException {
//        listDonGia = new DonGiaDAO().getKhachListBySearch(don_gia);
//        super.fireTableDataChanged();
//    }
    
    public DonGiaPoJo getByIndex(int rowIndex) {
        return listDonGia.get(rowIndex);     
    }
    
    public void addElement(DonGiaPoJo don_gia) {
        listDonGia.add(don_gia);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(DonGiaPoJo don_gia) throws ClassNotFoundException, SQLException {
        listDonGia = new DonGiaDAO().getDonGiaListBySearch(don_gia);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listDonGia.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listDonGia.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DonGiaPoJo don_gia = listDonGia.get(rowIndex);
        switch(columnIndex){
            case 0: return don_gia.getMaSH();
            case 1: return don_gia.getGia();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA SACH";
            case 1: return "GIA";
            default: return null;
        }
    }
}
