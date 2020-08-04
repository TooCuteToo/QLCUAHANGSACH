/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Pojo.ChiTietHDPoJo;
import Dao.ChiTietHDDAO;
import Model.ChiTietHDModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Administrator
 */
public class ChiTietHDPane extends javax.swing.JPanel {

    ChiTietHDModel cthd_model;
    ChiTietHDDAO cthd_DAO;

    /**
     * Creates new form ChiTietHDPane
     */
    public ChiTietHDPane() {
        initComponents();

        cthd_DAO = new ChiTietHDDAO();

        try {
            initChiTietHDTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view.NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(view.NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initChiTietHDTable() throws ClassNotFoundException, SQLException {
        cthd_model = new ChiTietHDModel();
        jTable1.setModel(cthd_model);
        handleSelected();
    }

    private void handleSelected() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override

            // ! -> selected 
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    if (!lse.getValueIsAdjusting()) {
                        ChiTietHDPoJo cthd = (ChiTietHDPoJo) cthd_model.getByIndex(jTable1.getSelectedRow());

                        ma_hd_txt.setText(cthd.getMaHD());
                        ma_nv_txt.setText(cthd.getMaNV());

                        ngay_ban_txt.setText(cthd.getNgayBan());
                        ma_kh_txt.setText(cthd.getMaKH());

                        tien_ban_txt.setText(String.valueOf(cthd.getTienBan()));
                        so_luong_txt.setText(String.valueOf(cthd.getSoLuong()));

                        giam_gia_txt.setText(String.valueOf(cthd.getGiamGia()));
                        gia_ban_txt.setText(String.valueOf(cthd.getGiaBan()));

                        thanh_tien_txt.setText(String.valueOf(cthd.getThanhToan()));

                        xoa_btn.setEnabled(true);
                        cap_nhat_btn.setEnabled(true);
                    }
                } catch (Exception e) {
                    System.out.print("hello");
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    private void resetTxtChiTietHD() {
        ma_hd_txt.setText(null);
        ma_nv_txt.setText(null);

        ma_kh_txt.setText(null);
        ngay_ban_txt.setText(null);

        so_luong_txt.setText(null);
        tien_ban_txt.setText(null);

        giam_gia_txt.setText(null);
        gia_ban_txt.setText(null);

        thanh_tien_txt.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ma_hd_txt = new javax.swing.JTextField();
        ngay_ban_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        them_btn = new javax.swing.JButton();
        cap_nhat_btn = new javax.swing.JButton();
        xoa_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ma_kh_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        so_luong_txt = new javax.swing.JTextField();
        ma_nv_txt = new javax.swing.JTextField();
        init_btn = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tien_ban_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        giam_gia_txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        thanh_tien_txt = new javax.swing.JTextField();
        gia_ban_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "THÔNG TIN SÁCH", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("MÃ HD");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NGÀY BÁN");

        them_btn.setText("THÊM");
        them_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them_btnActionPerformed(evt);
            }
        });

        cap_nhat_btn.setText("CẬP NHẬT");
        cap_nhat_btn.setEnabled(false);
        cap_nhat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cap_nhat_btnActionPerformed(evt);
            }
        });

        xoa_btn.setText("XOÁ");
        xoa_btn.setEnabled(false);
        xoa_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa_btnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("MÃ KH");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("MÃ NV");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("SỐ LƯỢNG");

        init_btn.setText("LOAD LẠI");
        init_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_btnActionPerformed(evt);
            }
        });

        search_btn.setText("TÌM KIẾM");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("THÀNH TIỀN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("GIÁ BÁN");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("TIỀN BÁN");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("GIẢM GIÁ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(init_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(search_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(them_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cap_nhat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xoa_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(gia_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tien_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thanh_tien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ma_hd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ma_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(ngay_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(ma_kh_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(so_luong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(giam_gia_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ma_hd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ma_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ma_kh_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(so_luong_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ngay_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(giam_gia_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tien_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(thanh_tien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gia_ban_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa_btn)
                    .addComponent(cap_nhat_btn)
                    .addComponent(them_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(init_btn)
                    .addComponent(search_btn))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void them_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them_btnActionPerformed
        try {
            // TODO add your handling code here:
            String ma_hd = ma_hd_txt.getText();
            String ma_kh = ma_kh_txt.getText();

            String ngay_ban = ngay_ban_txt.getText();
            String ma_nv = ma_nv_txt.getText();

            int so_luong = Integer.parseInt(so_luong_txt.getText());
            float giam_gia = Float.parseFloat(giam_gia_txt.getText());
            float tien_ban = Float.parseFloat(tien_ban_txt.getText());

            float gia_ban = Float.parseFloat(gia_ban_txt.getText());
            float thanh_tien = Float.parseFloat(thanh_tien_txt.getText());

            ChiTietHDPoJo cthd = new ChiTietHDPoJo(ma_hd, ngay_ban, ma_nv, ma_kh, tien_ban, giam_gia, so_luong, gia_ban, thanh_tien);
            cthd_DAO.addChiTietHD(cthd);

            cthd_model.addElement(cthd);
            resetTxtChiTietHD();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_them_btnActionPerformed

    private void cap_nhat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cap_nhat_btnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String maHD = cthd_model.getByIndex(jTable1.getSelectedRow()).getMaHD();
            
            String ma_hd = ma_hd_txt.getText();
            String ma_kh = ma_kh_txt.getText();

            String ngay_ban = ngay_ban_txt.getText();
            String ma_nv = ma_nv_txt.getText();

            int so_luong = Integer.parseInt(so_luong_txt.getText());
            float giam_gia = Float.parseFloat(giam_gia_txt.getText());
            float tien_ban = Float.parseFloat(tien_ban_txt.getText());

            float gia_ban = Float.parseFloat(gia_ban_txt.getText());
            float thanh_tien = Float.parseFloat(thanh_tien_txt.getText());

            ChiTietHDPoJo cthd_cap_nhat = new ChiTietHDPoJo(ma_hd, ngay_ban, ma_nv, ma_kh, tien_ban, giam_gia, so_luong, gia_ban, thanh_tien);
            cthd_DAO.updateChiTietHD(cthd_cap_nhat, maHD);
            
            initChiTietHDTable();
            resetTxtChiTietHD();

            cap_nhat_btn.setEnabled(false);
            xoa_btn.setEnabled(false);
            resetTxtChiTietHD();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_cap_nhat_btnActionPerformed

    private void xoa_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa_btnActionPerformed
        try {
            // TODO add your handling code here:
            int index = jTable1.getSelectedRow();
            ChiTietHDPoJo cthd = cthd_model.getByIndex(index);

            cthd_DAO.removeChiTietHD(cthd);
            cthd_model.removeElement(index);

            cap_nhat_btn.setEnabled(false);
            xoa_btn.setEnabled(false);
            resetTxtChiTietHD();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_xoa_btnActionPerformed

    private void init_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_init_btnActionPerformed
        try {
            initChiTietHDTable();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_init_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        try {
            // TODO add your handling code here:
            String ma_hd = ma_hd_txt.getText();
            String ma_kh = ma_kh_txt.getText();

            String ngay_ban = ngay_ban_txt.getText();
            String ma_nv = ma_nv_txt.getText();

            int so_luong = -1;
            float giam_gia = -1, tien_ban = -1, gia_ban = -1, thanh_tien = -1;

            if (!so_luong_txt.getText().isEmpty()) {
                so_luong = Integer.parseInt(so_luong_txt.getText());
            }

            if (!giam_gia_txt.getText().isEmpty()) {
                giam_gia = Float.parseFloat(giam_gia_txt.getText());
            }

            if (!tien_ban_txt.getText().isEmpty()) {
                tien_ban = Float.parseFloat(tien_ban_txt.getText());
            }

            if (!gia_ban_txt.getText().isEmpty()) {
                gia_ban = Float.parseFloat(gia_ban_txt.getText());
            }

            if (!thanh_tien_txt.getText().isEmpty()) {
                thanh_tien = Float.parseFloat(thanh_tien_txt.getText());
            }

            ChiTietHDPoJo cthd = new ChiTietHDPoJo(ma_hd, ngay_ban, ma_nv, ma_kh, tien_ban, giam_gia, so_luong, gia_ban, thanh_tien);
            cthd_model.getBySearch(cthd);
            resetTxtChiTietHD();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_search_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cap_nhat_btn;
    private javax.swing.JTextField gia_ban_txt;
    private javax.swing.JTextField giam_gia_txt;
    private javax.swing.JButton init_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ma_hd_txt;
    private javax.swing.JTextField ma_kh_txt;
    private javax.swing.JTextField ma_nv_txt;
    private javax.swing.JTextField ngay_ban_txt;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField so_luong_txt;
    private javax.swing.JTextField thanh_tien_txt;
    private javax.swing.JButton them_btn;
    private javax.swing.JTextField tien_ban_txt;
    private javax.swing.JButton xoa_btn;
    // End of variables declaration//GEN-END:variables
}