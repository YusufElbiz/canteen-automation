﻿/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bp2proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusuf
 */
public class urunlistesi extends javax.swing.JFrame {

    private String kullaniciTuru;
    DefaultTableModel uruntablosu;

    /**
     * Creates new form urunlistesi
     */
    

    public urunlistesi(String kullaniciTuru) {
        this.kullaniciTuru = kullaniciTuru;
        initComponents();

        uruntablosu = (DefaultTableModel) tableurun.getModel();

        urunleriListele();
    }

    private void urunleriListele() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen?user=root&password= ");
            String query = "SELECT urunadi, urunfiyati, urunadedi, urunkalorisi, id FROM urunlistesi";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String urunAdi = rs.getString("urunadi");
                double urunFiyati = rs.getDouble("urunfiyati");
                int urunAdedi = rs.getInt("urunadedi");
                int urunKalorisi = rs.getInt("urunkalorisi");
                int id = rs.getInt("id");

                uruntablosu.addRow(new Object[]{urunAdi, urunFiyati, urunAdedi, urunKalorisi, id});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ürünler yüklenirken hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        urunadiekletxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        urununfiyatiniekletxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        urunadediekletxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        urununkalorisiniekletxt = new javax.swing.JTextField();
        urunsilbutonu = new javax.swing.JButton();
        urunueklemebutonu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableurun = new javax.swing.JTable();
        siparisveregeridonbutonu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Ürün Adı");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Ürün Fiyatı");

        urununfiyatiniekletxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urununfiyatiniekletxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Ürün Adedi");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Ürün Kalorisi");

        urununkalorisiniekletxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urununkalorisiniekletxtActionPerformed(evt);
            }
        });

        urunsilbutonu.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        urunsilbutonu.setForeground(new java.awt.Color(0, 51, 153));
        urunsilbutonu.setText("Ürün Sil");
        urunsilbutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunsilbutonuActionPerformed(evt);
            }
        });

        urunueklemebutonu.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        urunueklemebutonu.setForeground(new java.awt.Color(0, 51, 153));
        urunueklemebutonu.setText("Ürünü Ekle");
        urunueklemebutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunueklemebutonuActionPerformed(evt);
            }
        });

        tableurun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "urun adiwdqwa", "urun fiyati", "urun adedi", "urun kalorisi", "id"
            }
        ));
        jScrollPane1.setViewportView(tableurun);

        siparisveregeridonbutonu.setFont(new java.awt.Font("Arial Black", 0, 10)); // NOI18N
        siparisveregeridonbutonu.setForeground(new java.awt.Color(0, 51, 153));
        siparisveregeridonbutonu.setText("Sipariş Vere Geri Dön");
        siparisveregeridonbutonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siparisveregeridonbutonuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Wide Latin", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stok Sayfası");

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setText("Ürün Oluştur");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(61, 61, 61)
                                            .addComponent(urununkalorisiniekletxt, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGap(79, 79, 79))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(61, 61, 61)))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(urunadiekletxt, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                .addComponent(urununfiyatiniekletxt)
                                                .addComponent(urunadediekletxt))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(urunsilbutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(urunueklemebutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(siparisveregeridonbutonu)
                                .addGap(108, 108, 108))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urunadiekletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(urununfiyatiniekletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(urunadediekletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(urununkalorisiniekletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siparisveregeridonbutonu)
                    .addComponent(urunsilbutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(urunueklemebutonu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(568, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void urunueklemebutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunueklemebutonuActionPerformed

        String urunAdi = urunadiekletxt.getText();
        String urunFiyatiStr = urununfiyatiniekletxt.getText();
        String urunAdediStr = urunadediekletxt.getText();
        String urunKalorisiStr = urununkalorisiniekletxt.getText();

        // Regex desenleri
        String urunAdiDeseni = "^[a-zA-ZğüşöçıİĞÜŞÖÇ\\s]+$"; // Sadece harfler ve boşluk
        String sayiDeseni = "\\d+"; // Sadece rakamlar

        // Doğrulamalar
        if (!urunAdi.matches(urunAdiDeseni)) {
            JOptionPane.showMessageDialog(this, "Ürün adı yalnızca harflerden oluşmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!urunFiyatiStr.matches(sayiDeseni)) {
            JOptionPane.showMessageDialog(this, "Ürün fiyatı yalnızca rakamlardan oluşmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!urunAdediStr.matches(sayiDeseni)) {
            JOptionPane.showMessageDialog(this, "Ürün adedi yalnızca rakamlardan oluşmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!urunKalorisiStr.matches(sayiDeseni)) {
            JOptionPane.showMessageDialog(this, "Ürün kalorisi yalnızca rakamlardan oluşmalıdır!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double urunFiyati = Double.parseDouble(urunFiyatiStr);
            int urunAdedi = Integer.parseInt(urunAdediStr);
            int urunKalorisi = Integer.parseInt(urunKalorisiStr);

            // Veritabanına ekle
            boolean isAddedToSQL = urunEkleVeyaStokArtir(urunAdi, urunFiyati, urunAdedi, urunKalorisi);

            if (isAddedToSQL) {
                // Tabloya ekle
                uruntablosu.addRow(new Object[]{urunAdi, urunFiyati, urunAdedi, urunKalorisi, "Yeni"});
                JOptionPane.showMessageDialog(this, "Ürün başarıyla eklendi!");
            } else {
                JOptionPane.showMessageDialog(this, "Ürün SQL'e eklenemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Lütfen geçerli sayı formatında değerler girin!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_urunueklemebutonuActionPerformed

    private boolean urunEkleVeyaStokArtir(String urunAdi, double urunFiyati, int urunAdedi, int urunKalorisi) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    // Sorguyu Statement yerine PreparedStatement ile de yazabiliriz; 
    // ama 'ON DUPLICATE KEY' ifadesi için bazen Statement ile direkt string oluşturmak daha pratik. 
    // Yine de PreparedStatement içinde da string birleştirerek yapacağız:

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen?user=root&password= ");
        
        // Burada "INSERT" sonrası "ON DUPLICATE KEY UPDATE" ekliyoruz:
        // 'urunadi' UNIQUE ise, aynı isim gelince "duplicate key" devreye girecek ve update işlemini yapacak.
        String query = "INSERT INTO urunlistesi (urunadi, urunfiyati, urunadedi, urunkalorisi) "
                     + "VALUES (?, ?, ?, ?) "
                     + "ON DUPLICATE KEY UPDATE "
                     + "urunadedi = urunadedi + VALUES(urunadedi), "   // stok adedini artır
                     + "urunfiyati = VALUES(urunfiyati), "           // fiyatı güncelle
                     + "urunkalorisi = VALUES(urunkalorisi)";        // kaloriyi güncelle

        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, urunAdi);
        pstmt.setDouble(2, urunFiyati);
        pstmt.setInt(3, urunAdedi);
        pstmt.setInt(4, urunKalorisi);

        int affectedRows = pstmt.executeUpdate();
        return (affectedRows > 0);

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "SQL Hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        return false;
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void siparisveregeridonbutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siparisveregeridonbutonuActionPerformed
        // TODO add your handling code here:
        sipraisver siparisFrame = new sipraisver(kullaniciTuru); // Kullanıcı türünü aktar
        siparisFrame.setLocationRelativeTo(null);
        siparisFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_siparisveregeridonbutonuActionPerformed

    private void urunsilbutonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunsilbutonuActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableurun.getSelectedRow(); // Table'dan seçili satırı al

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz ürünü seçin!", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Seçili satırdaki ürün adı ve ID'sini al
        String urunAdi = (String) tableurun.getValueAt(selectedRow, 0);
        int urunId = (int) tableurun.getValueAt(selectedRow, 4); // ID sütununun indeksine göre

        // Kullanıcıdan onay al
        int confirm = JOptionPane.showConfirmDialog(this, urunAdi + " adlı ürünü silmek istediğinizden emin misiniz?", "Onay", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen?user=root&password= ");

                // SQL'den ürünü sil
                String deleteQuery = "DELETE FROM urunlistesi WHERE id = ?";
                pstmt = conn.prepareStatement(deleteQuery);
                pstmt.setInt(1, urunId);
                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    // Table'dan ürünü kaldır
                    DefaultTableModel model = (DefaultTableModel) tableurun.getModel();
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "Ürün başarıyla silindi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ürün SQL'den silinemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_urunsilbutonuActionPerformed

    private void urununkalorisiniekletxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urununkalorisiniekletxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urununkalorisiniekletxtActionPerformed

    private void urununfiyatiniekletxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urununfiyatiniekletxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urununfiyatiniekletxtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(urunlistesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(urunlistesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(urunlistesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(urunlistesi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        String kullaniciTuru = "standart"; // Varsayılan olarak standart kullanıcı türü
        java.awt.EventQueue.invokeLater(() -> {
            new urunlistesi(kullaniciTuru).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton siparisveregeridonbutonu;
    private javax.swing.JTable tableurun;
    private javax.swing.JTextField urunadediekletxt;
    private javax.swing.JTextField urunadiekletxt;
    private javax.swing.JButton urunsilbutonu;
    private javax.swing.JButton urunueklemebutonu;
    private javax.swing.JTextField urununfiyatiniekletxt;
    private javax.swing.JTextField urununkalorisiniekletxt;
    // End of variables declaration//GEN-END:variables
}

