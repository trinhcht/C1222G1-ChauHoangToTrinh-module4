package com.example.muon_sach.service.impl;

import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.repository.IBorrowerRepository;
import com.example.muon_sach.service.IBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("borrowerService")
public class BorrowerService implements IBorrowerService {
    private final
    IBorrowerRepository borrowerRepository;
    private Set<String> existingCodes = new HashSet<>();

    public BorrowerService(IBorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public List<Borrower> findAllBorrower() {
        return borrowerRepository.findAll();
    }

    @Override
    public String codeBorrower() {
        String code;
        do {
            code = String.format("%05d", (int) (Math.random() * 100000));
        } while (existingCodes.contains(code));
        existingCodes.add(code);
        return code;
    }
}
