/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.NhaXBDAO;
import Pojo.NhaXBPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class NhaXBModel extends AbstractTableModel {
    private ArrayList<NhaXBPoJo> listNXB;

    public NhaXBModel() throws ClassNotFoundException, SQLException {
        listNXB = new NhaXBDAO().getNhaXBList();
    }
    
    public NhaXBPoJo getByIndex(int rowIndex) {
        return listNXB.get(rowIndex);     
    }
    
    public void addElement(NhaXBPoJo nha_xb) {
        listNXB.add(nha_xb);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(NhaXBPoJo nha_xb) throws ClassNotFoundException, SQLException {
        listNXB = new NhaXBDAO().getNXBListBySearch(nha_xb);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listNXB.remove(rowIndex);
        super.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return listNXB.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NhaXBPoJo nha_xb = listNXB.get(rowIndex);
        switch(columnIndex){
            case 0: return nha_xb.getMaNXB();
            case 1: return nha_xb.getTenNXB();
            case 2: return nha_xb.getDienThoai();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA NHA XUAT BAN";
            case 1: return "TEN NHA XUAT BAN";
            case 2: return "DIEN THOAI";
            default: return null;
        }
    }
}
