package com.example.muon_sach.service.impl;

import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.repository.IBorrowerRepository;
import com.example.muon_sach.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("borrowerService")
public class BorrowerService implements IBorrowerService {
    private final
    IBorrowerRepository borrowerRepository;

    public BorrowerService(IBorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public List<Borrower> findAllBorrower() {
        return borrowerRepository.findAll();
    }
    @Override
    public List<Borrower> findByCode(String code){
        return borrowerRepository.findByCode(code);
    }

    @Override
    public String codeBorrower() {
        String code;
        do {
            code = String.format("%05d", (int) (Math.random() * 100000));
        } while ();
        return code;
    }
}
