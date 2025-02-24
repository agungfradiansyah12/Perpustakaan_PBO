/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.ParseException;

/**
 *
 * @author WINDOWS 11
 */
public class FrmPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form FrmPeminjaman
     */
    public FrmPeminjaman() {
        initComponents();
        tampilkanData();
        tampilkanCmbPegawai();
        kosongkanForm();
    }
    
     public  void  kosongkanForm(){
        txtIdBuku.setText("0");
        cmbPegawai.setSelectedIndex(0);
        txtIdAnggota.setText("");
        txtIdPeminjaman.setText("");
        tglPinjam_jFormattedTextField.setText("");
        tglKembali_jFormattedTextField.setText("");
    }
    public void tampilkanData() {
        String[] kolom = {"ID", "Pegawai", "Anggota", "Buku", "Tanggal Pinjam", "Tanggal Kembali"};
        ArrayList<Peminjaman> list = new Peminjaman().getAll();
        Object rowData[] = new Object[6];

        tblPeminjaman.setModel(new DefaultTableModel(new Object[][] {}, kolom));

        for (int p = 0; p < list.size(); p++) {
            rowData[0] = list.get(p).getIdPeminjaman();
            rowData[1] = list.get(p).getPegawai().getNama();  // Mengakses nama pegawai
            rowData[2] = list.get(p).getAnggota().getNama();  // Mengakses nama anggota
            rowData[3] = list.get(p).getBuku().getJudul();    // Mengakses judul buku
            rowData[4] = list.get(p).getTanggalPinjam();
            rowData[5] = list.get(p).getTanggalKembali();
            ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
        }
    }

    public String cariNamaPegawai(String idPegawai) {
    String namaPegawai = null; 
    String sql = "SELECT nama FROM pegawai WHERE id_pegawai = '" + idPegawai + "'";

    ResultSet rs = DBHelper.selectQuery(sql);

    try {
        if (rs.next()) {
            namaPegawai = rs.getString("nama");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return namaPegawai; 
}
    
    public void cari(String keyword) {
    String[] kolom = {"ID Peminjaman", "Pegawai", "Anggota", "Buku", "Tanggal Pinjam", "Tanggal Kembali"};
    ArrayList<Peminjaman> list = new Peminjaman().search(keyword);
    Object[] rowData = new Object[6];

    tblPeminjaman.setModel(new DefaultTableModel(new Object[][] {}, kolom));

    for (Peminjaman peminjaman : list) {
        rowData[0] = peminjaman.getIdPeminjaman();
        rowData[1] = peminjaman.getPegawai().getNama();
        rowData[2] = peminjaman.getAnggota().getNama();
        rowData[3] = peminjaman.getBuku().getJudul();
        rowData[4] = peminjaman.getTanggalPinjam();
        rowData[5] = peminjaman.getTanggalKembali();

        ((DefaultTableModel) tblPeminjaman.getModel()).addRow(rowData);
    }
}

    
     public void tampilkanCmbPegawai(){
         cmbPegawai.setModel(new DefaultComboBoxModel(new Pegawai().getAll().toArray()));
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnTambahBaru = new javax.swing.JButton();
        txtIdPeminjaman = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPeminjaman = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdAnggota = new javax.swing.JTextField();
        btnCekAnggota = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtIdBuku = new javax.swing.JTextField();
        btnCekBuku = new javax.swing.JButton();
        tglPinjam_jFormattedTextField = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tglKembali_jFormattedTextField = new javax.swing.JFormattedTextField();
        cmbPegawai = new javax.swing.JComboBox<>();
        lblNamaAnggota = new javax.swing.JLabel();
        lblJudulBuku23 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        lblJudulBuku = new javax.swing.JLabel();
        lblJudulBuku2 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });
        getContentPane().add(btnTambahBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 264, -1, -1));

        txtIdPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPeminjamanActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 58, 302, -1));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 264, -1, -1));

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 264, 224, -1));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 264, -1, -1));

        tblPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPeminjaman);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 305, 486, 309));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM PEMINJAMAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 633, -1));

        jLabel2.setText("ID Peminjaman");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, -1, -1));

        jLabel6.setText("ID Pegawai");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 90, -1, -1));

        jLabel7.setText("ID Anggota");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 118, -1, -1));

        txtIdAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 115, 203, -1));

        btnCekAnggota.setText("Cari");
        btnCekAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekAnggotaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCekAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 115, -1, -1));

        jLabel8.setText("ID Buku");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 147, -1, -1));

        txtIdBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdBukuActionPerformed(evt);
            }
        });
        getContentPane().add(txtIdBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 144, 203, -1));

        btnCekBuku.setText("Cari");
        btnCekBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBukuActionPerformed(evt);
            }
        });
        getContentPane().add(btnCekBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 144, -1, -1));

        tglPinjam_jFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglPinjam_jFormattedTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(tglPinjam_jFormattedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 173, 147, -1));

        jLabel9.setText("Tanggal Pinjam");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, -1, -1));

        jLabel10.setText("Tanggal Kembali");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 204, -1, -1));

        tglKembali_jFormattedTextField.setEnabled(false);
        getContentPane().add(tglKembali_jFormattedTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 201, 170, -1));

        cmbPegawai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 87, 106, -1));

        lblNamaAnggota.setText("Cek Nama");
        getContentPane().add(lblNamaAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        lblJudulBuku23.setText("Cek nama");
        getContentPane().add(lblJudulBuku23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        lblJudulBuku.setText("YYYY-MM-DD");
        getContentPane().add(lblJudulBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        lblJudulBuku2.setText("YYYY-MM-DD");
        getContentPane().add(lblJudulBuku2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        try {
        // Mengambil ID Anggota dan ID Buku dari input text field
        int idAnggota = Integer.parseInt(txtIdAnggota.getText());
        int idBuku = Integer.parseInt(txtIdBuku.getText());

        // Mengambil tanggal peminjamanjam dan tanggal kembali dari JFormattedTextField
        String tglPinjam = tglPinjam_jFormattedTextField.getText();  
        String tglKembali = tglKembali_jFormattedTextField.getText(); 

        // Mendapatkan data Anggota dan Buku berdasarkan ID
        Anggota anggota = new Anggota().getById(idAnggota);
        Buku buku = new Buku().getById(idBuku);

        // Mengecek apakah anggota dan buku ditemukan
        if (anggota.getIdanggota() != 0 && buku.getIdbuku() != 0) {
            // Membuat objek peminjaman dan menambahkan pegawai dari JComboBox
            Peminjaman peminjaman = new Peminjaman(anggota, buku, new Pegawai(), tglPinjam, tglKembali);

            // Mengatur pegawai berdasarkan pilihan dari combo box
            peminjaman.setPegawai((Pegawai) cmbPegawai.getSelectedItem());

            // Menyimpan data peminjaman
            peminjaman.save();
            
            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Peminjaman berhasil!");

            // Memperbarui tampilan data peminjaman (misal dengan memanggil tampilkanData())
            tampilkanData();
        } else {
            JOptionPane.showMessageDialog(this, "Anggota atau Buku tidak ditemukan!");
        }
    }catch (NumberFormatException e) {
        // Menampilkan pesan jika ID anggota dan ID buku bukan angka
        JOptionPane.showMessageDialog(this, "ID Anggota dan ID Buku harus berupa angka.");
    }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        kosongkanForm();
        
        // Mengatur properti komponen
        txtIdPeminjaman.setEnabled(true);      // ID Peminjaman diaktifkan
        txtIdAnggota.setEnabled(true);        // ID Anggota diaktifkan
        cmbPegawai.setEnabled(true);
        txtIdBuku.setEnabled(true);           // ID Buku diaktifkan
        tglPinjam_jFormattedTextField.setEnabled(true); // Tanggal Pinjam diaktifkan
        tglKembali_jFormattedTextField.setEnabled(false); // Tanggal Kembali hanya dibaca (disabled)

        // Mengatur tombol
        btnSimpan.setEnabled(true);  // Tombol Simpan diaktifkan
        btnUpdate.setEnabled(false); // Tombol Update dinonaktifkan
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void txtIdPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPeminjamanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tblPeminjaman.getModel();
        int row = tblPeminjaman.getSelectedRow();

        Peminjaman peminjaman = new Peminjaman().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        peminjaman.delete();
        kosongkanForm();
        tampilkanData();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPeminjamanMouseClicked
         DefaultTableModel model = (DefaultTableModel) tblPeminjaman.getModel();
    int row = tblPeminjaman.getSelectedRow();
    Peminjaman peminjaman = new Peminjaman();

    // Memastikan bahwa baris dipilih
    if (row >= 0) {
        // Mengambil ID Peminjaman dari tabel dan mendapatkan detail data
        peminjaman = peminjaman.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        // Mengisi data ke form
        txtIdPeminjaman.setText(String.valueOf(peminjaman.getIdPeminjaman()));
        txtIdAnggota.setText(String.valueOf(peminjaman.getAnggota().getIdanggota()));
        txtIdBuku.setText(String.valueOf(peminjaman.getBuku().getIdbuku()));
        tglPinjam_jFormattedTextField.setText(peminjaman.getTanggalPinjam());
        tglKembali_jFormattedTextField.setText(peminjaman.getTanggalKembali());
        cmbPegawai.getModel().setSelectedItem(peminjaman.getPegawai());

        // Mengatur properti komponen
        txtIdPeminjaman.setEnabled(false); // ID Peminjaman hanya dibaca (disabled)
        cmbPegawai.setEnabled(false);
        txtIdAnggota.setEnabled(false);   // ID Anggota hanya dibaca (disabled)
        txtIdBuku.setEnabled(false);      // ID Buku hanya dibaca (disabled)
        tglPinjam_jFormattedTextField.setEnabled(false); // Tanggal Pinjam hanya dibaca (disabled)
        tglKembali_jFormattedTextField.setEnabled(true); // Tanggal Kembali diaktifkan

        // Mengatur tombol
        btnSimpan.setEnabled(false); // Tombol Update diaktifkan
        btnUpdate.setEnabled(true); // Tombol Simpan dinonaktifkan
    } else {
        // Jika tidak ada baris yang dipilih, tombol Update dinonaktifkan
        btnSimpan.setEnabled(false);
    }
    }//GEN-LAST:event_tblPeminjamanMouseClicked

    private void txtIdAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdAnggotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdAnggotaActionPerformed

    private void btnCekAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekAnggotaActionPerformed
        // TODO add your handling code here:
         try {
        int idAnggota = Integer.parseInt(txtIdAnggota.getText()); // Ambil ID Anggota
        Anggota anggota = new Anggota().getById(idAnggota);
        if (anggota.getIdanggota() != 0) {
            lblNamaAnggota.setText("Nama Anggota: " + anggota.getNama());
        } else {
            JOptionPane.showMessageDialog(this, "Anggota dengan ID tersebut tidak ditemukan.");
            lblNamaAnggota.setText("Nama Anggota: -");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Anggota harus berupa angka.");
    }
    }//GEN-LAST:event_btnCekAnggotaActionPerformed

    private void txtIdBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdBukuActionPerformed

    private void btnCekBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBukuActionPerformed
        // TODO add your handling code here:
        try {
        int idBuku = Integer.parseInt(txtIdBuku.getText()); // Ambil ID Buku
        Buku buku = new Buku().getById(idBuku);
        if (buku.getIdbuku() != 0) {
            lblJudulBuku23.setText("Judul Buku: " + buku.getJudul());
        } else {
            JOptionPane.showMessageDialog(this, "Buku dengan ID tersebut tidak ditemukan.");
            lblJudulBuku23.setText("Judul Buku: -");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Buku harus berupa angka.");
    }
    }//GEN-LAST:event_btnCekBukuActionPerformed

    private void tglPinjam_jFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglPinjam_jFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglPinjam_jFormattedTextFieldActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
         try {
        // Mengambil data dari form
        int idPeminjaman = Integer.parseInt(txtIdPeminjaman.getText()); // ID Peminjaman
        String tanggalKembali = tglKembali_jFormattedTextField.getText(); // Tanggal Kembali dari field
        Pegawai selectedPegawai = (Pegawai) cmbPegawai.getSelectedItem(); // Pegawai yang dipilih dari combo box

        // Membuat objek peminjaman baru dan mengatur nilainya
        Peminjaman pjm = new Peminjaman();
        pjm.setIdPeminjaman(idPeminjaman); // Set ID Peminjaman
        pjm.setTanggalKembali(tanggalKembali); // Set Tanggal Kembali
        pjm.setPegawai(selectedPegawai); // Set Pegawai

        // Memperbarui data ke database
        pjm.update();

        // Menampilkan data di tabel dan membersihkan form
        tampilkanData();
        kosongkanForm();

        // Menampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data peminjaman berhasil diperbarui!");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Peminjaman harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCekAnggota;
    private javax.swing.JButton btnCekBuku;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbPegawai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblJudulBuku;
    private javax.swing.JLabel lblJudulBuku2;
    private javax.swing.JLabel lblJudulBuku23;
    private javax.swing.JLabel lblNamaAnggota;
    private javax.swing.JTable tblPeminjaman;
    private javax.swing.JFormattedTextField tglKembali_jFormattedTextField;
    private javax.swing.JFormattedTextField tglPinjam_jFormattedTextField;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtIdAnggota;
    private javax.swing.JTextField txtIdBuku;
    private javax.swing.JTextField txtIdPeminjaman;
    // End of variables declaration//GEN-END:variables
}
