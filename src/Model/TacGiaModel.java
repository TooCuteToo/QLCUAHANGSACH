/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.TacGiaDAO;
import Pojo.TacGiaPoJo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TacGiaModel extends AbstractTableModel {
    private ArrayList<TacGiaPoJo> listTG;

    public TacGiaModel() throws ClassNotFoundException, SQLException {
        listTG = new TacGiaDAO().getTacGiaList();
    }
//    
//    public void getBySearch(TacGiaPoJo tg) throws ClassNotFoundException, SQLException {
//        listTG = new TacGiaDAO().getKhachListBySearch(tg);
//        super.fireTableDataChanged();
//    }
    
    public TacGiaPoJo getByIndex(int rowIndex) {
        return listTG.get(rowIndex);     
    }
    
    public void addElement(TacGiaPoJo tg) {
        listTG.add(tg);
        super.fireTableDataChanged();
    }
    
    public void getBySearch(TacGiaPoJo nv) throws ClassNotFoundException, SQLException {
        listTG = new TacGiaDAO().getTGListBySearch(nv);
        super.fireTableDataChanged();
    }
    
    public void removeElement(int rowIndex) {
        listTG.remove(rowIndex);
        super.fireTableDataChanged();
    }
    

    @Override
    public int getRowCount() {
        return listTG.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TacGiaPoJo tg = listTG.get(rowIndex);
        switch(columnIndex){
            case 0: return tg.getMaTG();
            case 1: return tg.getTenTG();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "MA TAC GIA";
            case 1: return "TEN TAC GIA";
            default: return null;
        }
    }
}
