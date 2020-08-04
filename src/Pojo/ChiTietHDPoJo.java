/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

/**
 *
 * @author Administrator
 */
public class ChiTietHDPoJo {
    private String maHD;
    private String ngayBan;
    
    private String maNV;
    private String maKH;
    
    private float tienBan;
    private float giamGia;
    
    private int soLuong;
    private float  giaBan;
    
    private float thanhToan;

    public ChiTietHDPoJo(String maHD, String ngayBan, String maNV, String maKH, float tienBan, float giamGia, int soLuong, float giaBan, float thanhToan) {
        this.maHD = maHD;
        this.ngayBan = ngayBan;
        
        this.maNV = maNV;
        this.maKH = maKH;
        
        this.tienBan = tienBan;
        this.giamGia = giamGia;
        
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhToan = thanhToan;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public float getTienBan() {
        return tienBan;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public float getThanhToan() {
        return thanhToan;
    }

}
