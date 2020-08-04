/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.HoaDonDAO;
import Pojo.HoaDonPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class HoaDonModel extends AbstractTableModel {
    private ArrayList<HoaDonPoJo> listHoaDon;

    public HoaDonModel() throws ClassNotFoundException, SQLException {
        listHoaDon = new HoaDonDAO().getHoaDonList();
    }
    
    public HoaDonPoJo getByIndex(int rowIndex) {
        return listHoaDon.get(rowIndex);     
    }
    
    public void addElement(HoaDonPoJo hoa_don) {
        listHoaDon.add(hoa_don);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(HoaDonPoJo hoa_don) throws ClassNotFoundException, SQLException {
        listHoaDon = new HoaDonDAO().getHoaDonListBySearch(hoa_don);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listHoaDon.remove(rowIndex);
        super.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listHoaDon.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HoaDonPoJo hoa_don = listHoaDon.get(rowIndex);
        switch(columnIndex){
            case 0: return hoa_don.getMaHD();
            case 1: return hoa_don.getMaSH();
            case 2: return hoa_don.getMaKH();
            case 3: return hoa_don.getThanhTien();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA HOA DON";
            case 1: return "MA SACH";
            case 2: return "MA KHACH";
            case 3: return "THANH TIEN";
            default: return null;
        }
    }
}
