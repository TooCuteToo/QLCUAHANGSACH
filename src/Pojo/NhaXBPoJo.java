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
public class NhaXBPoJo {
    private String maNXB;
    private String tenNXB;
    private String dienThoai;

    public NhaXBPoJo(String maNXB, String tenNXB, String dienThoai) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.dienThoai = dienThoai;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public String getDienThoai() {
        return dienThoai;
    }
}
