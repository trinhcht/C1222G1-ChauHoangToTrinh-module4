package com.example.cinema.service.impl;

import com.example.cinema.model.SuatChieu;
import com.example.cinema.repository.ISuatChieuRepository;
import com.example.cinema.service.ISuatChieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuService implements ISuatChieuService {
    @Autowired
    private ISuatChieuRepository iSuatChieuRepository;


    @Override
    public List<SuatChieu> findAllSuatChieu() {
        return iSuatChieuRepository.findAll();
    }

    @Override
    public SuatChieu createSuatChieu(SuatChieu suatChieu) {
        return iSuatChieuRepository.save(suatChieu);
    }

    @Override
    public void delete(int id) {
        iSuatChieuRepository.deleteById(id);
    }

    @Override
    public void edit(SuatChieu suatChieu) {
        iSuatChieuRepository.save(suatChieu);
    }

    @Override
    public SuatChieu findById(int id) {
        return iSuatChieuRepository.findById(id).get();
    }

}
