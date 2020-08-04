/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.SachDAO;
import Pojo.SachPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class SachModel extends AbstractTableModel  {
    private ArrayList<SachPoJo> listSach;

    public SachModel() throws ClassNotFoundException, SQLException {
        listSach = new SachDAO().getSachList();
    }
//    
//    public void getBySearch(SachPoJo sach) throws ClassNotFoundException, SQLException {
//        listSach = new SachDAO().getKhachListBySearch(sach);
//        super.fireTableDataChanged();
//    }
    
    public SachPoJo getByIndex(int rowIndex) {
        return listSach.get(rowIndex);     
    }
    
    public void addElement(SachPoJo sach) {
        listSach.add(sach);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(SachPoJo sach) throws ClassNotFoundException, SQLException {
        listSach = new SachDAO().getSachListBySearch(sach);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listSach.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listSach.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SachPoJo sach = listSach.get(rowIndex);
        switch(columnIndex){
            case 0: return sach.getMaSH();
            case 1: return sach.getTenSH();
            case 2: return sach.getSoLuong();
            case 3: return sach.getMaNXB();
            case 4: return sach.getMaTG();
            case 5: return sach.getTinhTrang();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA SACH";
            case 1: return "TEN SACH";
            case 2: return "SO LUONG";
            case 3: return "MA NXB";
            case 4: return "MA TAC GIA";
            case 5: return "TINH TRANG";
            default: return null;
        }
    }
}
