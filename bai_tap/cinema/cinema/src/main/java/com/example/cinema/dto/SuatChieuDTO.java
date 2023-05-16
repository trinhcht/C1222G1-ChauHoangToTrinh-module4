package com.example.cinema.dto;

import com.example.cinema.model.Phim;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.util.Date;


public class SuatChieuDTO  {
    private  int id;
    @Pattern(regexp = "^CI-\\d{4}$")
    private String code;
    private Date ngayChieu;
    private int soLuongVe;
    private Phim phim;

    public SuatChieuDTO() {
    }

    public SuatChieuDTO(int id, String code, Date ngayChieu, int soLuongVe) {
        this.id = id;
        this.code = code;
        this.ngayChieu = ngayChieu;
        this.soLuongVe = soLuongVe;
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
