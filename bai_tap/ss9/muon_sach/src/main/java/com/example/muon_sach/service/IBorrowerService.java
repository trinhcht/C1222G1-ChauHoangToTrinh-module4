package com.example.muon_sach.service;

import com.example.muon_sach.model.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<Borrower> findAllBorrower();

    String codeBorrower();
}