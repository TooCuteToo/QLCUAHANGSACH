/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Pojo.HoaDonPoJo;

/**
 *
 * @author Administrator
 */
public class HoaDonDAO {
    public ArrayList<HoaDonPoJo> getHoaDonList() throws ClassNotFoundException, SQLException {
        ArrayList<HoaDonPoJo> listHoaDon = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from HOADON";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String mahd = rs.getString("MAHD");
            String tenhd = rs.getString("MASH");        
            
            String makh = rs.getString("MAKH");        
            float thanh_tien = rs.getFloat("THANHTIEN");
            
            HoaDonPoJo hoa_don = new HoaDonPoJo(mahd, tenhd, makh, thanh_tien);
            listHoaDon.add(hoa_don);
        }
        
        provider.close();
        
        return listHoaDon;
    }
    
    public ArrayList<HoaDonPoJo> getHoaDonListBySearch(HoaDonPoJo hoa_don) throws ClassNotFoundException, SQLException {
        ArrayList<HoaDonPoJo> listHoaDon = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from HOADON where MAHD = ?  or MASH = ? or MAKH = ? or THANHTIEN = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, hoa_don.getMaHD());
        provider.preState.setString(2, hoa_don.getMaSH());
        
        provider.preState.setString(3, hoa_don.getMaKH());
        provider.preState.setFloat(4, hoa_don.getThanhTien());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String mahd = rs.getString("MAHD");
            String mash = rs.getString("MASH");
            
            String makh = rs.getString("MAKH");   
            float thanh_tien = rs.getFloat("THANHTIEN");
            
            HoaDonPoJo hoa_donSearch = new HoaDonPoJo(mahd, mash, makh, thanh_tien);
            listHoaDon.add(hoa_donSearch);
        }
        
        provider.close();
        
        return listHoaDon;
    }
    
    public void addHoaDon(HoaDonPoJo hoa_don) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT HOADON ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into HOADON " + "values(?, ?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, hoa_don.getMaHD());
        provider.preState.setString(2, hoa_don.getMaSH());
        provider.preState.setString(3, hoa_don.getMaKH());
        provider.preState.setFloat(4, hoa_don.getThanhTien());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateHoaDon(HoaDonPoJo hoa_don, String maHD) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT HOADON ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "update HOADON " + "set MAHD = ?, MASH = ?, MAKH = ?, THANHTIEN = ? where MAHD = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, hoa_don.getMaHD());
        provider.preState.setString(2, hoa_don.getMaSH());
        
        provider.preState.setString(3, hoa_don.getMaKH());
        provider.preState.setFloat(4, hoa_don.getThanhTien());
        provider.preState.setString(5, maHD);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeHoaDon(HoaDonPoJo hoa_don) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete HOADON where MAHD = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, hoa_don.getMaHD());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
