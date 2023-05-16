package com.example.cinema.service;

import com.example.cinema.model.SuatChieu;

import java.util.List;

public interface ISuatChieuService {
    List<SuatChieu> findAllSuatChieu();

    SuatChieu createSuatChieu(SuatChieu suatChieu);
    void delete(int id);
    void edit(SuatChieu suatChieu);
    SuatChieu findById(int id);
}
