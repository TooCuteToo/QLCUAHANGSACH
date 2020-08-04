/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.SachPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SachDAO {
    public ArrayList<SachPoJo> getSachList() throws ClassNotFoundException, SQLException {
        ArrayList<SachPoJo> listSach = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from SACH";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String ma_sach = rs.getString("MASH");
            String ten_sach = rs.getString("TENSH");
            
            int so_luong = rs.getInt("SOLUONG");
            String ma_nxb = rs.getString("MANXB");
            
             String ma_tg = rs.getString("MATG");
            String tinh_trang = rs.getString("TINHTRANG");
            
            SachPoJo sach = new SachPoJo(ma_sach, ten_sach,  ma_nxb, ma_tg, tinh_trang, so_luong);
            listSach.add(sach);
        }
        
        provider.close();
        
        return listSach;
    }
    
    public ArrayList<SachPoJo> getSachListBySearch(SachPoJo sach) throws ClassNotFoundException, SQLException {
        ArrayList<SachPoJo> listSach = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from SACH where MASH = ? or TENSH = ? or MANXB = ? or MATG = ? or TINHTRANG = ? or SOLUONG = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, sach.getMaSH());
        provider.preState.setString(2, sach.getTenSH());
        
        provider.preState.setString(3, sach.getMaNXB());
        provider.preState.setString(4, sach.getMaTG());
        
        provider.preState.setString(5, sach.getTinhTrang());
        provider.preState.setInt(6, sach.getSoLuong());
                  
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String ma_sach = rs.getString("MASH");
            String ten_sach = rs.getString("TENSH");
            
            int so_luong = rs.getInt("SOLUONG");
            String ma_nxb = rs.getString("MANXB");
            
            String ma_tg = rs.getString("MATG");
            String tinh_trang = rs.getString("TINHTRANG");
            
            SachPoJo sachSearch = new SachPoJo(ma_sach, ten_sach,  ma_nxb, ma_tg, tinh_trang, so_luong);
            listSach.add(sachSearch);
        }
        
        provider.close();
        
        return listSach;
    }
    
    public void addSach(SachPoJo sach) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT SACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into SACH " + "values(?, ?, ?, ?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, sach.getMaSH());
        provider.preState.setString(2, sach.getTenSH());
        
        provider.preState.setInt(3, sach.getSoLuong());
        provider.preState.setString(4, sach.getMaNXB());
        
        provider.preState.setString(5, sach.getMaTG());
        provider.preState.setString(6, sach.getTinhTrang());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateSach(SachPoJo sach, String maSH) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT SACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "update SACH " + "set MASH= ?, TENSH= ?, SOLUONG = ?, MANXB = ?, MATG = ?, TINHTRANG = ? where MASH = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, sach.getMaSH());
        provider.preState.setString(2, sach.getTenSH());
        
        provider.preState.setInt(3, sach.getSoLuong());
        provider.preState.setString(4, sach.getMaNXB());
        
        provider.preState.setString(5, sach.getMaTG());
        provider.preState.setString(6, sach.getTinhTrang());
        
        provider.preState.setString(7, maSH);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeSach(SachPoJo sach) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete SACH where MASH = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, sach.getMaSH());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
