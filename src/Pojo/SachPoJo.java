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
public class SachPoJo {
    private String maSH;
    private String tenSH;
    
    private String maNXB;
    private String maTG;
    
    private String tinhTrang;
    private int soLuong;

    public SachPoJo(String maSH, String tenSH, String maNXB, String maTG, String tinhTrang, int soLuong) {
        this.maSH = maSH;
        this.tenSH = tenSH;
        
        this.maNXB = maNXB;
        this.maTG = maTG;
        
        this.tinhTrang = tinhTrang;
        this.soLuong = soLuong;
    }

    public String getMaSH() {
        return maSH;
    }

    public String getTenSH() {
        return tenSH;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public String getMaTG() {
        return maTG;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    
}
