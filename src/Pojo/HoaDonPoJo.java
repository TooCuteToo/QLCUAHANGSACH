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
public class HoaDonPoJo {
    private String maHD;
    private String maSH;
    private String maKH;
    private float thanhTien;

    public HoaDonPoJo(String maHD, String maSH, String maKH, float thanhTien) {
        this.maHD = maHD;
        this.maSH = maSH;
        this.maKH = maKH;
        this.thanhTien = thanhTien;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaSH() {
        return maSH;
    }
    
    public String getMaKH() {
        return maKH;
    }

    public float getThanhTien() {
        return thanhTien;
    }
}
