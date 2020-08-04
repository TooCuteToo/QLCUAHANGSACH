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
import pojo.KhachPoJo;

/**
 *
 * @author Administrator
 */
public class KhachDAO {
    public ArrayList<KhachPoJo> getKhachList() throws ClassNotFoundException, SQLException {
        ArrayList<KhachPoJo> listStaff = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from KHACH";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String makh = rs.getString("MAKH");
            String tenkh = rs.getString("TENKH");
            
            String diaChi = rs.getString("DCHI");
            String dienThoai = rs.getString("DTHOAI");
            
            KhachPoJo khach = new KhachPoJo(makh, tenkh, diaChi, dienThoai);
            listStaff.add(khach);
        }
        
        provider.close();
        
        return listStaff;
    }
    
    public ArrayList<KhachPoJo> getKhachListBySearch(KhachPoJo khach) throws ClassNotFoundException, SQLException {
        ArrayList<KhachPoJo> listStaff = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from KHACH where MAKH = ? or TENKH = ? or DCHI = ? or DTHOAI = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, khach.getMakh());
        provider.preState.setString(2, khach.getTenkh());
        provider.preState.setString(3, khach.getDiaChi());
        provider.preState.setString(4, khach.getDienThoai());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String makh = rs.getString("MAKH");
            String tenkh = rs.getString("TENKH");
            
            String diaChi = rs.getString("DCHI");
            String dienThoai = rs.getString("DTHOAI");
            
            KhachPoJo khachSearch = new KhachPoJo(makh, tenkh, diaChi, dienThoai);
            listStaff.add(khachSearch);
        }
        
        provider.close();
        
        return listStaff;
    }
    
    public void addKhach(KhachPoJo khach) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into KHACH " + "values(?, ?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, khach.getMakh());
        provider.preState.setString(2, khach.getTenkh());
        
        provider.preState.setString(3, khach.getDiaChi());
        provider.preState.setString(4, khach.getDienThoai());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateKhach(KhachPoJo khach, String maKH) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "";
   
        sql = "update KHACH " + "set MAKH = ?, TENKH = ?, DCHI = ?, DTHOAI = ? where MAKH = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, khach.getMakh());
        provider.preState.setString(2, khach.getTenkh());

        provider.preState.setString(3, khach.getDiaChi());
        provider.preState.setString(4, khach.getDienThoai());
        provider.preState.setString(5, maKH);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeStaff(KhachPoJo khach) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete KHACH where MAKH = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, khach.getMakh());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
