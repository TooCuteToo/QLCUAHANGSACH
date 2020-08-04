/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.NhanVienPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class NhanVienDAO {
    public ArrayList<NhanVienPoJo> getNhanVienList() throws ClassNotFoundException, SQLException {
        ArrayList<NhanVienPoJo> listNhanVien = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from NHANVIEN";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String ma_nv = rs.getString("MANV");
            String ten_nv = rs.getString("TENNV");           
            String dien_thoai = rs.getString("DTHOAI");
            
            NhanVienPoJo nhan_vien = new NhanVienPoJo(ma_nv, ten_nv, dien_thoai);
            listNhanVien.add(nhan_vien);
        }
        
        provider.close();
        
        return listNhanVien;
    }
    
    public void addNhanVien(NhanVienPoJo nhan_vien) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into NHANVIEN " + "values(?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nhan_vien.getMa_nhan_vien());
        provider.preState.setString(2, nhan_vien.getTen_nhan_vien());
       
        provider.preState.setString(3, nhan_vien.getDien_thoai());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public ArrayList<NhanVienPoJo> getNVListBySearch(NhanVienPoJo nv) throws ClassNotFoundException, SQLException {
        ArrayList<NhanVienPoJo> listStaff = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from NHANVIEN where MANV = ? or TENNV = ? or DTHOAI = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nv.getMa_nhan_vien());
        provider.preState.setString(2, nv.getTen_nhan_vien());
        provider.preState.setString(3, nv.getDien_thoai());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String ma_nv = rs.getString("MANV");
            String ten_nv = rs.getString("TENNV");
            String dienThoai = rs.getString("DTHOAI");
            
            NhanVienPoJo nvSearch = new NhanVienPoJo(ma_nv, ten_nv, dienThoai);
            listStaff.add(nvSearch);
        }
        
        provider.close();
        
        return listStaff;
    }
    
    public void updateNhanVien(NhanVienPoJo nv, String maNV) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT KHACH ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "update NHANVIEN " + "set MANV = ?, TENNV = ?, DTHOAI = ? where MANV = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, nv.getMa_nhan_vien());
        provider.preState.setString(2, nv.getTen_nhan_vien());
        
        provider.preState.setString(3, nv.getDien_thoai());
        provider.preState.setString(4, maNV);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeNhanVien(NhanVienPoJo nv) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete NHANVIEN where MANV = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, nv.getMa_nhan_vien());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}


