package com.example.muon_sach.repository;

import com.example.muon_sach.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBorrowerRepository extends JpaRepository<Borrower,Integer> {
    List<Borrower> findAll();
    Borrower findById(int idBorrower);
}
