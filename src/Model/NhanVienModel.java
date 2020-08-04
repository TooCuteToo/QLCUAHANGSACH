/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.NhanVienDAO;
import Pojo.NhanVienPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class NhanVienModel extends AbstractTableModel {
    private ArrayList<NhanVienPoJo> listNhanVien;

    public NhanVienModel() throws ClassNotFoundException, SQLException {
        listNhanVien = new NhanVienDAO().getNhanVienList();
    }
//    
//    public void getBySearch(NhanVienPoJo nhan_vien) throws ClassNotFoundException, SQLException {
//        listNhanVien = new NhanVienDAO().getKhachListBySearch(nhan_vien);
//        super.fireTableDataChanged();
//    }
    
    public NhanVienPoJo getByIndex(int rowIndex) {
        return listNhanVien.get(rowIndex);     
    }
    
    public void addElement(NhanVienPoJo staff) {
        listNhanVien.add(staff);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(NhanVienPoJo nv) throws ClassNotFoundException, SQLException {
        listNhanVien = new NhanVienDAO().getNVListBySearch(nv);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listNhanVien.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listNhanVien.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NhanVienPoJo nhan_vien = listNhanVien.get(rowIndex);
        switch(columnIndex){
            case 0: return nhan_vien.getMa_nhan_vien();
            case 1: return nhan_vien.getTen_nhan_vien();
            case 2: return nhan_vien.getDien_thoai();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA NHAN VIEN";
            case 1: return "TEN NHAN VIEN";
            case 2: return "DIEN THOAI";
            default: return null;
        }
    }
}
