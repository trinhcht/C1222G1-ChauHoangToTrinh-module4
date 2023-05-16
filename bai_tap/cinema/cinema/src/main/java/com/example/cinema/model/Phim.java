package com.example.cinema.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "phim")
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tenPhim;
    @OneToMany(mappedBy = "phim")
    private List<SuatChieu> suatChieu;

    public Phim() {
    }

    public Phim(int id, String tenPhim) {
        this.id = id;
        this.tenPhim = tenPhim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public List<SuatChieu> getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(List<SuatChieu> suatChieu) {
        this.suatChieu = suatChieu;
    }
}
