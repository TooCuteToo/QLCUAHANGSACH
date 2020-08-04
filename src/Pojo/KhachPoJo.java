/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Administrator
 */
public class KhachPoJo {   
    private String makh;
    private String tenkh;
    private String diaChi;
    private String dienThoai;

    public KhachPoJo(String makh, String tenkh, String diaChi, String dienThoai) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public String getMakh() {
        return makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }
}
