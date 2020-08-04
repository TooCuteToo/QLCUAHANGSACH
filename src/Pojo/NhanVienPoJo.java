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
public class NhanVienPoJo {
    private String ma_nhan_vien;
    private String ten_nhan_vien;
    private String dien_thoai;
    
    public NhanVienPoJo(String ma_nhan_vien, String ten_nhan_vien, String dien_thoai) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.ten_nhan_vien = ten_nhan_vien;
        this.dien_thoai = dien_thoai;
    }

    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public String getTen_nhan_vien() {
        return ten_nhan_vien;
    }

    public String getDien_thoai() {
        return dien_thoai;
    }    
}
