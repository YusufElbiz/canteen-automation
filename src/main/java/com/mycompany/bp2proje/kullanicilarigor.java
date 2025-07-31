/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bp2proje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author yusuf
 */
public class kullanicilarigor extends javax.swing.JFrame {
  private JList<String> kullaniciListesi;
    private DefaultListModel<String> listModel;
    private JLabel kullaniciDetaylari;
    private String kullaniciTuru;

    /**
     * Creates new form kullanicilarigor
     */
    public kullanicilarigor(String kullaniciTuru) {
        this.kullaniciTuru = kullaniciTuru; // Kullanıcı türünü al ve sakla
        setTitle("Kullanıcıları Gör");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Sol taraftaki liste
        listModel = new DefaultListModel<>();
        kullaniciListesi = new JList<>(listModel);
kullaniciListesi.setBackground(new Color(255, 153, 0)); // Arka plan rengini açık gri yapar
    kullaniciListesi.setForeground(Color.WHITE);
        // Sağ taraftaki detaylar
        kullaniciDetaylari = new JLabel("Kullanıcı detayları burada gösterilecek");
        kullaniciDetaylari.setVerticalAlignment(JLabel.TOP);

        // SplitPane oluştur
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(kullaniciListesi), new JScrollPane(kullaniciDetaylari));
        splitPane.setDividerLocation(200);

        // Sipariş Verme Ekranına Dön butonu
        JButton siparisveregeridon = new JButton("Sipariş Verme Ekranına Dön");
        siparisveregeridon.addActionListener(evt -> {
            if ("admin".equals(kullaniciTuru)) {
                System.out.println("Admin için sipariş ekranına dönüyor...");
                sipraisver siparisFrame = new sipraisver(kullaniciTuru);
                siparisFrame.setLocationRelativeTo(null);
                siparisFrame.setVisible(true);
                this.dispose();
            } else if ("standart".equals(kullaniciTuru)) {
                System.out.println("Standart kullanıcı için program kapanıyor...");
                JOptionPane.showMessageDialog(this, "Sipariş süreci tamamlandı. Program kapatılıyor.", "Bilgilendirme", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        // Ana panel oluştur
        JPanel anaPanel = new JPanel(new BorderLayout());
        anaPanel.add(splitPane, BorderLayout.CENTER);
        anaPanel.add(siparisveregeridon, BorderLayout.SOUTH);

        // Paneli çerçeveye ekle
        add(anaPanel);

        // Kullanıcı adlarını veritabanından yükle
        loadKullaniciAdlari();

        // Liste seçimi dinleyicisi ekle
        kullaniciListesi.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedKullanici = kullaniciListesi.getSelectedValue();
                if (selectedKullanici != null) {
                    loadKullaniciDetaylari(selectedKullanici);
                }
            }
        });

        setVisible(true);
    }
    
   
           private void loadKullaniciDetaylari(String selectedKullanici) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen?user=root&password= ");
        String query = "SELECT * FROM kayitolma WHERE kullaniciadi = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, selectedKullanici); // Burada doğru değişkeni kullanıyoruz
        rs = pstmt.executeQuery();

        if (rs.next()) {
            StringBuilder detaylar = new StringBuilder();
            detaylar.append("<html>Kullanıcı Adı: ").append(rs.getString("kullaniciadi")).append("<br>");
            detaylar.append("Okul Numarası: ").append(rs.getInt("okulnumarasi")).append("<br>");
            detaylar.append("E-mail: ").append(rs.getString("email")).append("<br>");
            detaylar.append("Kayıt Türü: ").append(rs.getString("kayitolmaturu")).append("</html>");

            kullaniciDetaylari.setText(detaylar.toString());
        } else {
            kullaniciDetaylari.setText("Detaylar bulunamadı.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Kullanıcı detayları yüklenirken hata oluştu: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage());
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jLabel1.setBackground(new java.awt.Color(255, 153, 0));
        jSplitPane1.setRightComponent(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(kullanicilarigor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kullanicilarigor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kullanicilarigor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kullanicilarigor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                java.awt.EventQueue.invokeLater(() -> new kullanicilarigor("admin").setVisible(true));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    private void loadKullaniciAdlari() {
Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/canteen?user=root&password= ");
            String query = "SELECT kullaniciadi FROM kayitolma";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                listModel.addElement(rs.getString("kullaniciadi"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kullanıcı adları yüklenirken hata oluştu: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Bağlantı kapatılırken hata oluştu: " + ex.getMessage());
            }
        }
    }

}

