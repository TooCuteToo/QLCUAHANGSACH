/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.NhaXBPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhaXBDAO {
    public ArrayList<NhaXBPoJo> getNhaXBList() throws ClassNotFoundException, SQLException {
        ArrayList<NhaXBPoJo> listNhaXB = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from NHAXB";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String ma_nxb = rs.getString("MANXB");
            String ten_nxb = rs.getString("TENNXB");           
            String dien_thoai = rs.getString("DTHOAI");
            
            NhaXBPoJo nxb = new NhaXBPoJo(ma_nxb, ten_nxb, dien_thoai);
            listNhaXB.add(nxb);
        }
        
        provider.close();
        
        return listNhaXB;
    }
    
    public void addNhaXB(NhaXBPoJo nxb) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into NHAXB " + "values(?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nxb.getMaNXB());
        provider.preState.setString(2, nxb.getTenNXB());
        provider.preState.setString(3, nxb.getDienThoai());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public ArrayList<NhaXBPoJo> getNXBListBySearch(NhaXBPoJo nxb) throws ClassNotFoundException, SQLException {
        ArrayList<NhaXBPoJo> listStaff = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from NHAXB where MANXB = ? or TENNXB = ? or DTHOAI = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nxb.getMaNXB());
        provider.preState.setString(2, nxb.getTenNXB());
        provider.preState.setString(3, nxb.getDienThoai());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String ma_nxb = rs.getString("MANXB");
            String ten_nxb = rs.getString("TENNXB");
            String dienThoai = rs.getString("DTHOAI");
            
            NhaXBPoJo nxbSearch = new NhaXBPoJo(ma_nxb, ten_nxb, dienThoai);
            listStaff.add(nxbSearch);
        }
        
        provider.close();
        
        return listStaff;
    }
    
    public void updateNhaXB(NhaXBPoJo nxb, String maNXB) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "update NHAXB " + "set MANXB = ?, TENNXB = ?, DTHOAI = ? where MANXB = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, nxb.getMaNXB());
        provider.preState.setString(2, nxb.getTenNXB());
        provider.preState.setString(3, nxb.getDienThoai());
        provider.preState.setString(4, maNXB);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeNhaXB(NhaXBPoJo nxb) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete NHAXB where MANXB = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nxb.getMaNXB());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
