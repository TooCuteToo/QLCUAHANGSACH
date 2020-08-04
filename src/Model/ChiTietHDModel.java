/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.ChiTietHDDAO;
import Pojo.ChiTietHDPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class ChiTietHDModel extends AbstractTableModel  {
    private ArrayList<ChiTietHDPoJo> listChiTietHD;

    public ChiTietHDModel() throws ClassNotFoundException, SQLException {
        listChiTietHD = new ChiTietHDDAO().getChiTietHDList();
    }
//    
//    public void getBySearch(ChiTietHDPoJo ctdh) throws ClassNotFoundException, SQLException {
//        listChiTietHD = new ChiTietHDDAO().getKhachListBySearch(ctdh);
//        super.fireTableDataChanged();
//    }
    
    public ChiTietHDPoJo getByIndex(int rowIndex) {
        return listChiTietHD.get(rowIndex);     
    }
    
    public void addElement(ChiTietHDPoJo ctdh) {
        listChiTietHD.add(ctdh);
        super.fireTableDataChanged();   
    }
    
    public void getBySearch(ChiTietHDPoJo ctdh) throws ClassNotFoundException, SQLException {
        listChiTietHD = new ChiTietHDDAO().getChiTietHDListBySearch(ctdh);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listChiTietHD.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listChiTietHD.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ChiTietHDPoJo ctdh = listChiTietHD.get(rowIndex);
        switch(columnIndex){
            case 0: return ctdh.getMaHD();
            case 1: return ctdh.getNgayBan();
            case 2: return ctdh.getMaNV();
            case 3: return ctdh.getMaKH();
            case 4: return ctdh.getTienBan();
            case 5: return ctdh.getGiamGia();
            case 6: return ctdh.getSoLuong();
            case 7: return ctdh.getGiaBan();
            case 8: return ctdh.getThanhToan();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA HOA DON";
            case 1: return "NGAY BAN";
            case 2: return "MA NHAN VIEN";
            case 3: return "MA KHACH";
            case 4: return "TIEN BAN";
            case 5: return "GIAM GIA";
            case 6: return "SO LUONG";
            case 7: return "GIA BAN";
            case 8: return "THANH TOAN";
            default: return null;
        }
    }
}
