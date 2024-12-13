/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author WINDOWS 11
 */
public class Pegawai {
    private int idpegawai;
    private  String nama;
    private String alamat;
    private String telepon;
    private String jabatan;
    private String username;
    private String password;

    public int getIdpegawai() {
        return idpegawai;
    }

    public void setIdpegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public Pegawai() {
    }

    public Pegawai(String nama, String alamat, String telepon, String jabatan, String username, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.jabatan = jabatan;
        this.username = username;
        this.password = password;
    }

    
    public Pegawai getById(int id) {
        Pegawai pegawai01 = new Pegawai();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai WHERE idpegawai = " + id + ";");
        try {
            while (rs.next()) {
                pegawai01 = new Pegawai();
                pegawai01.setIdpegawai(rs.getInt("idpegawai"));
                pegawai01.setNama(rs.getString("nama"));
                pegawai01.setAlamat(rs.getString("alamat"));
                pegawai01.setTelepon(rs.getString("telepon"));
                pegawai01.setJabatan(rs.getString("jabatan"));
                pegawai01.setUsername(rs.getString("username"));
                pegawai01.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pegawai01;
    }
    
    public ArrayList<Pegawai> getAll() {
        ArrayList<Pegawai> listPegawai = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pegawai");
        try {
            while (rs.next()) {
                Pegawai pegawai01 = new Pegawai();
                pegawai01.setIdpegawai(rs.getInt("idpegawai"));
                pegawai01.setNama(rs.getString("nama"));
                pegawai01.setAlamat(rs.getString("alamat"));
                pegawai01.setTelepon(rs.getString("telepon"));
                pegawai01.setJabatan(rs.getString("jabatan"));
                pegawai01.setUsername(rs.getString("username"));
                pegawai01.setPassword(rs.getString("password"));
                listPegawai.add(pegawai01);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPegawai;
    }

    public ArrayList<Pegawai> search(String keyword) {
        ArrayList<Pegawai> listPegawai = new ArrayList<>();
        String sql = "SELECT * FROM pegawai WHERE " +
                     "nama LIKE '%" + keyword + "%' " +
                     "OR alamat LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Pegawai pegawai01 = new Pegawai();
                pegawai01.setIdpegawai(rs.getInt("idpegawai"));
                pegawai01.setNama(rs.getString("nama"));
                pegawai01.setAlamat(rs.getString("alamat"));
                pegawai01.setTelepon(rs.getString("telepon"));
                pegawai01.setJabatan(rs.getString("jabatan"));
                pegawai01.setUsername(rs.getString("username"));
                pegawai01.setPassword(rs.getString("password"));
                listPegawai.add(pegawai01);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPegawai;
    }

    public void save() {
        if (getById(idpegawai).getIdpegawai()== 0) {
            String SQL = "INSERT INTO pegawai (nama, alamat, telepon, jabatan, username, password) VALUES (" +
                         "'" + this.nama + "', " +
                         "'" + this.alamat + "', " +
                        "'" + this.telepon + "', " +
                        "'" + this.jabatan + "', " +
                        "'" + this.username + "', " +
                         "'" + this.password + "' )";
            this.idpegawai = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pegawai SET " +
             "nama = '" + this.nama + "', " +
             "alamat = '" + this.alamat + "', " +  
             "telepon = '" + this.telepon + "', " +
             "jabatan = '" + this.jabatan + "', " +
             "username = '" + this.username + "', " +
             "password = '" + this.password + "' " +
             "WHERE idpegawai = " + this.idpegawai;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete(){
        String SQL = "DELETE FROM pegawai WHERE idpegawai = '" + this.idpegawai + "'";
        DBHelper.executeQuery(SQL);
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
