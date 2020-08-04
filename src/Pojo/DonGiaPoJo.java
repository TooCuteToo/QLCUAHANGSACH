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
public class DonGiaPoJo {
    private String maSH;
    private float gia;

    public DonGiaPoJo(String maSH, float gia) {
        this.maSH = maSH;
        this.gia = gia;
    }

    public String getMaSH() {
        return maSH;
    }

    public float getGia() {
        return gia;
    }
}
