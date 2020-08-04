/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.DonGiaPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class DonGiaDAO {  
    public ArrayList<DonGiaPoJo> getDonGiaList() throws ClassNotFoundException, SQLException {
        ArrayList<DonGiaPoJo> listDonGia = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from DONGIA";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String mash = rs.getString("MASH");
            float gia = rs.getFloat("GIA");            
            
            DonGiaPoJo don_gia = new DonGiaPoJo(mash, gia);
            listDonGia.add(don_gia);
        }
        
        provider.close();
        
        return listDonGia;
    }
    
    public ArrayList<DonGiaPoJo> getDonGiaListBySearch(DonGiaPoJo don_gia) throws ClassNotFoundException, SQLException {
        ArrayList<DonGiaPoJo> listDonGia = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from DONGIA where MASH = ? or GIA = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, don_gia.getMaSH());
        provider.preState.setFloat(2, don_gia.getGia());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String mash = rs.getString("MASH");
            float gia = rs.getFloat("GIA");
            
            DonGiaPoJo don_giaSearch = new DonGiaPoJo(mash, gia);
            listDonGia.add(don_giaSearch);
        }
        
        provider.close();
        
        return listDonGia;
    }
    
    public void addDonGia(DonGiaPoJo don_gia) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT DONGIA ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into DONGIA " + "values(?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, don_gia.getMaSH());
        provider.preState.setFloat(2, don_gia.getGia());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateDonGia(DonGiaPoJo don_gia, String maSH) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT DONGIA ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "update DONGIA " + "set MASH = ?, GIA = ?  where MASH = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, don_gia.getMaSH());
        provider.preState.setFloat(2, don_gia.getGia());
        
        provider.preState.setString(3, maSH);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeDonGia(DonGiaPoJo don_gia) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete DONGIA where MASH = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, don_gia.getMaSH());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
