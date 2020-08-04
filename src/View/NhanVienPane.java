/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Dao.NhanVienDAO;
import Model.NhanVienModel;
import Pojo.NhanVienPoJo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author LENOVO
 */
public class NhanVienPane extends javax.swing.JPanel {

    NhanVienModel nv_model;
    NhanVienDAO nv_DAO;

    /**
     * Creates new form NhanVienPane
     */
    public NhanVienPane() {
        initComponents();
        nv_DAO = new NhanVienDAO();

        try {
            initNhanVienTable();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view.NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(view.NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        //handleSelected();
    }

    public void initNhanVienTable() throws ClassNotFoundException, SQLException {
        nv_model = new NhanVienModel();
        jTable1.setModel(nv_model);
        handleSelected();
    }

    private void handleSelected() {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override

            // ! -> selected 
            public void valueChanged(ListSelectionEvent lse) {
                try {
                    if (!lse.getValueIsAdjusting()) {
                        NhanVienPoJo nv = (NhanVienPoJo) nv_model.getByIndex(jTable1.getSelectedRow());

                        ma_nv_txt.setText(nv.getMa_nhan_vien());
                        ten_nv_txt.setText(nv.getTen_nhan_vien());
                        dien_thoai_txt.setText(nv.getDien_thoai());

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

    private void resetTxtNV() {
        ma_nv_txt.setText(null);
        ten_nv_txt.setText(null);
        dien_thoai_txt.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ma_nv_txt = new javax.swing.JTextField();
        ten_nv_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        dien_thoai_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        them_btn = new javax.swing.JButton();
        cap_nhat_btn = new javax.swing.JButton();
        xoa_btn = new javax.swing.JButton();
        init_btn = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("MÃ NV");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TÊN NV");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ĐIỆN THOẠI");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dien_thoai_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ma_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ten_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(them_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(init_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cap_nhat_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(xoa_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ma_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ten_nv_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dien_thoai_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xoa_btn)
                    .addComponent(cap_nhat_btn)
                    .addComponent(them_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(init_btn)
                    .addComponent(search_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void them_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them_btnActionPerformed
        try {
            // TODO add your handling code here:
            String ma_nv = ma_nv_txt.getText();
            String ten_nv = ten_nv_txt.getText();
            String dien_thoai = dien_thoai_txt.getText();

            NhanVienPoJo nv = new NhanVienPoJo(ma_nv, ten_nv, dien_thoai);
            nv_DAO.addNhanVien(nv);

            nv_model.addElement(nv);
            resetTxtNV();

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
            String maNV = nv_model.getByIndex(jTable1.getSelectedRow()).getMa_nhan_vien();    
            String ma_nv = ma_nv_txt.getText();
            String ten_nv = ten_nv_txt.getText();
            String dien_thoai = dien_thoai_txt.getText();

            int index = jTable1.getSelectedRow();
            NhanVienPoJo nv = nv_model.getByIndex(index);

            NhanVienPoJo nv_cap_nhat = new NhanVienPoJo(ma_nv,  ten_nv, dien_thoai);

            nv_DAO.updateNhanVien(nv_cap_nhat, maNV);
            initNhanVienTable();
            resetTxtNV();
            cap_nhat_btn.setEnabled(false);
            xoa_btn.setEnabled(false);

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
            NhanVienPoJo nv = nv_model.getByIndex(index);

            nv_DAO.removeNhanVien(nv);
            nv_model.removeElement(index);

            cap_nhat_btn.setEnabled(false);
            xoa_btn.setEnabled(false);

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_xoa_btnActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        try {
            // TODO add your handling code here:
            String ma_nv = ma_nv_txt.getText();
            String ten_nv = ten_nv_txt.getText();
            String dien_thoai = dien_thoai_txt.getText();

            NhanVienPoJo nv = new NhanVienPoJo(ma_nv, ten_nv, dien_thoai);
            nv_model.getBySearch(nv);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_search_btnActionPerformed

    private void init_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_init_btnActionPerformed
        try {
            initNhanVienTable();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu không hơp lệ");
        }
    }//GEN-LAST:event_init_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cap_nhat_btn;
    private javax.swing.JTextField dien_thoai_txt;
    private javax.swing.JButton init_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ma_nv_txt;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField ten_nv_txt;
    private javax.swing.JButton them_btn;
    private javax.swing.JButton xoa_btn;
    // End of variables declaration//GEN-END:variables
}
