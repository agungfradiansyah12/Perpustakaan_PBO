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

public class Peminjaman {
    private int idPeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private Pegawai pegawai = new Pegawai();
    private String tglPinjam;
    private String tglKembali;

    public int getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(int idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public String getTanggalPinjam() {
        return tglPinjam;
    }

    public void setTanggalPinjam(String tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public String getTanggalKembali() {
        return tglKembali;
    }

    public void setTanggalKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

    public Peminjaman() {}

    public Peminjaman(Anggota anggota, Buku buku, Pegawai pegawai, String tglPinjam, String tglKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.pegawai = pegawai;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery(
            "SELECT p.idpeminjaman, p.tglpinjam, p.tglkembali, " +
            "a.idanggota, a.nama AS nama_anggota, b.idbuku, b.judul AS judul_buku, " +
            "pg.idpegawai, pg.nama AS nama_pegawai " +
            "FROM peminjaman p " +
            "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
            "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
            "LEFT JOIN pegawai pg ON p.idpegawai = pg.idpegawai " +
            "WHERE p.idpeminjaman = " + id
        );

        try {
            while (rs.next()) {
                peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama_anggota"));
                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul_buku"));
                peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                peminjaman.getPegawai().setNama(rs.getString("nama_pegawai"));
                peminjaman.setTanggalPinjam(rs.getString("tglpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tglkembali"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery(
            "SELECT p.idpeminjaman, p.tglpinjam, p.tglkembali, " +
            "a.idanggota, a.nama AS nama_anggota, b.idbuku, b.judul AS judul_buku, " +
            "pg.idpegawai, pg.nama AS nama_pegawai " +
            "FROM peminjaman p " +
            "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
            "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
            "LEFT JOIN pegawai pg ON p.idpegawai = pg.idpegawai"
        );

        try {
            while (rs.next()) {
                Peminjaman peminjaman = new Peminjaman();
                peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
                peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
                peminjaman.getAnggota().setNama(rs.getString("nama_anggota"));
                peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
                peminjaman.getBuku().setJudul(rs.getString("judul_buku"));
                peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
                peminjaman.getPegawai().setNama(rs.getString("nama_pegawai"));
                peminjaman.setTanggalPinjam(rs.getString("tglpinjam"));
                peminjaman.setTanggalKembali(rs.getString("tglkembali"));
                ListPeminjaman.add(peminjaman);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPeminjaman;
    }
    
    public ArrayList<Peminjaman> search(String keyword) {
    ArrayList<Peminjaman> ListPeminjaman = new ArrayList<>();
    String sql = "SELECT p.idpeminjaman, p.tglpinjam, p.tglkembali, " +
                 "a.idanggota, a.nama AS nama_anggota, b.idbuku, b.judul AS judul_buku, " +
                 "pg.idpegawai, pg.nama AS nama_pegawai " +
                 "FROM peminjaman p " +
                 "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                 "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
                 "LEFT JOIN pegawai pg ON p.idpegawai = pg.idpegawai " +
                 "WHERE a.nama LIKE '%" + keyword + "%' " +
                 "OR b.judul LIKE '%" + keyword + "%' " +
                 "OR pg.nama LIKE '%" + keyword + "%'";

    ResultSet rs = DBHelper.selectQuery(sql);

    try {
        while (rs.next()) {
            Peminjaman peminjaman = new Peminjaman();
            peminjaman.setIdPeminjaman(rs.getInt("idpeminjaman"));
            peminjaman.getAnggota().setIdanggota(rs.getInt("idanggota"));
            peminjaman.getAnggota().setNama(rs.getString("nama_anggota"));
            peminjaman.getBuku().setIdbuku(rs.getInt("idbuku"));
            peminjaman.getBuku().setJudul(rs.getString("judul_buku"));
            peminjaman.getPegawai().setIdpegawai(rs.getInt("idpegawai"));
            peminjaman.getPegawai().setNama(rs.getString("nama_pegawai"));
            peminjaman.setTanggalPinjam(rs.getString("tglpinjam"));
            peminjaman.setTanggalKembali(rs.getString("tglkembali"));
            ListPeminjaman.add(peminjaman);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return ListPeminjaman;
}

    public void save() {
    String SQL;
    SQL = "INSERT INTO peminjaman (idanggota, idbuku, tglpinjam, tglkembali, idpegawai) VALUES ("
        + "'" + this.getAnggota().getIdanggota() + "', "
        + "'" + this.getBuku().getIdbuku()+ "', "
        + "'" + this.getTanggalPinjam() + "', "
        + (this.getTanggalKembali().isEmpty() ? "NULL" : "'" + this.getTanggalKembali() + "'") + ", "
        + this.getPegawai().getIdpegawai() + ")";
    
    this.idPeminjaman = DBHelper.insertQueryGetId(SQL);
}

    
    public void update(){
        String SQL = "UPDATE peminjaman SET " +
//                    " idanggota = '" + this.getAnggota().getIdanggota() + "', " +
//                    " idbuku = '" + this.getBuku().getIdbuku() + "', " +
//                    " idpegawai = '" + this.getPegawai().getIdpegawai() + "', " +
//                    " tglpinjam = '" + this.tglPinjam + "', " +
                    " tglkembali = '" + this.tglKembali + "' " +
                    " WHERE idpeminjaman = '" + this.idPeminjaman + "'";
            DBHelper.executeQuery(SQL);
        
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idPeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}
