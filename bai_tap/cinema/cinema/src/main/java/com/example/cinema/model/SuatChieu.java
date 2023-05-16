package com.example.cinema.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "suat_chieu")
public class SuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private Date ngayChieu;
    private int soLuongVe;
    @ManyToOne
    @JoinColumn(name = "phim_id",referencedColumnName = "id")
    private Phim phim;


    public SuatChieu() {
    }

    public SuatChieu(int id, String code, Date ngayChieu, int soLuongVe, Phim phim) {
        this.id = id;
        this.code = code;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
        this.phim = phim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(Date ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }
}
