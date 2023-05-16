package com.example.cinema.service.impl;

import com.example.cinema.model.Phim;
import com.example.cinema.repository.IPhimRepository;
import com.example.cinema.repository.ISuatChieuRepository;
import com.example.cinema.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhimService implements IPhimService {
    @Autowired
    private IPhimRepository iPhimRepository;
    @Override
    public List<Phim> getAll() {
        return iPhimRepository.findAll();
    }
}
