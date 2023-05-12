package com.example.muon_sach.service.impl;

import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.repository.IBorrowerRepository;
import com.example.muon_sach.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("borrowerService")
public class BorrowerService implements IBorrowerService {
    @Autowired
    private IBorrowerRepository iBorrowerRepository;

    @Override
    public List<Borrower> findAll() {
        return iBorrowerRepository.findAll();
    }

    @Override
    public Borrower findById(int idBorrower) {
        return iBorrowerRepository.findById(idBorrower);
    }
}
