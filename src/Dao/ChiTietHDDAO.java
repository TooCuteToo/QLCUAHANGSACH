/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.ChiTietHDPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ChiTietHDDAO {
    public ArrayList<ChiTietHDPoJo> getChiTietHDList() throws ClassNotFoundException, SQLException {
        ArrayList<ChiTietHDPoJo> listChiTietHD = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from CHITIETHD";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String ma_hd = rs.getString("MAHD");
            String ngay_ban = rs.getString("NGAYBAN");
            
            String ma_nv = rs.getString("MANV");
            String ma_kh = rs.getString("MAKH");
            
            float tien_ban = rs.getFloat("TIENBAN");
            float giam_gia = rs.getFloat("GIAMGIA");
            
            int so_luong = rs.getInt("SOLUONG");
            
            float gia_ban = rs.getFloat("GIABAN");
            float thanh_tien = rs.getFloat("THANHTOAN");
                       
            ChiTietHDPoJo cthd = new ChiTietHDPoJo(ma_hd, ngay_ban,  ma_nv, ma_kh, tien_ban, giam_gia, so_luong, gia_ban, thanh_tien);
            listChiTietHD.add(cthd);
        }
        
        provider.close();
        
        return listChiTietHD;
    }
    
    public ArrayList<ChiTietHDPoJo> getChiTietHDListBySearch(ChiTietHDPoJo cthd) throws ClassNotFoundException, SQLException {
        ArrayList<ChiTietHDPoJo> listChiTietHD = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from CHITIETHD where MAHD = ? or NGAYBAN = ? or MANV = ? or MAKH = ? or TIENBAN = ? or GIAMGIA= ? or SOLUONG = ? or GIABAN = ? or THANHTOAN = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, cthd.getMaHD());
        provider.preState.setString(2, cthd.getNgayBan());
        
        provider.preState.setString(3, cthd.getMaNV());
        provider.preState.setString(4, cthd.getMaKH());
        
        provider.preState.setFloat(5, cthd.getTienBan());
        provider.preState.setFloat(6, cthd.getGiamGia());
        
        provider.preState.setInt(7, cthd.getSoLuong());
        provider.preState.setFloat(8, cthd.getGiaBan());
        
        provider.preState.setFloat(9, cthd.getThanhToan());
                  
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String ma_hd = rs.getString("MAHD");
            String ngay_ban = rs.getString("NGAYBAN");
            
            String ma_nv = rs.getString("MANV");
            String ma_kh = rs.getString("MAKH");
            
            float tien_ban = rs.getFloat("TIENBAN");
            float giam_gia = rs.getFloat("GIAMGIA");
            
            int so_luong = rs.getInt("SOLUONG");
            
            float gia_ban = rs.getFloat("GIABAN");
            float thanh_tien = rs.getFloat("THANHTOAN");
                       
            ChiTietHDPoJo cthdSearch = new ChiTietHDPoJo(ma_hd, ngay_ban,  ma_nv, ma_kh, tien_ban, giam_gia, so_luong, gia_ban, thanh_tien);
            listChiTietHD.add(cthdSearch);
        }
        
        provider.close();
        
        return listChiTietHD;
    }
    
    public void addChiTietHD(ChiTietHDPoJo cthd) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        String sql = "insert into CHITIETHD " + "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, cthd.getMaHD());
        provider.preState.setString(2, cthd.getNgayBan());
        
        provider.preState.setString(3, cthd.getMaNV());
        provider.preState.setString(4, cthd.getMaKH());
        
        provider.preState.setFloat(5, cthd.getTienBan());
        provider.preState.setFloat(6, cthd.getGiamGia());
        
        provider.preState.setInt(7, cthd.getSoLuong());
        provider.preState.setFloat(8, cthd.getGiaBan());
        
        provider.preState.setFloat(9, cthd.getThanhToan());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateChiTietHD(ChiTietHDPoJo cthd, String maHD) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        String sql = "update CHITIETHD " + "set MAHD = ?, NGAYBAN = ?, MANV = ?, MAKH = ?, TIENBAN = ?, GIAMGIA= ?, SOLUONG = ?, GIABAN = ?, THANHTOAN = ? where MAHD = ?";
        
        provider.preState = provider.connection.prepareStatement(sql);
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, cthd.getMaHD());
        provider.preState.setString(2, cthd.getNgayBan());
        
        provider.preState.setString(3, cthd.getMaNV());
        provider.preState.setString(4, cthd.getMaKH());
        
        provider.preState.setFloat(5, cthd.getTienBan());
        provider.preState.setFloat(6, cthd.getGiamGia());
        
        provider.preState.setInt(7, cthd.getSoLuong());
        provider.preState.setFloat(8, cthd.getGiaBan());
        
        provider.preState.setFloat(9, cthd.getThanhToan());
        System.out.print(maHD);
        provider.preState.setString(10, maHD);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeChiTietHD(ChiTietHDPoJo cthd) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete CHITIETHD where MAHD = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, cthd.getMaHD());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
