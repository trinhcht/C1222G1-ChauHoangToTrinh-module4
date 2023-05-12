package com.example.muon_sach.repository;

import com.example.muon_sach.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookDTORepository extends JpaRepository<BookDTO,Integer> {
    List<BookDTO> findAll();
    BookDTO findById(int idBookDTO);
}
