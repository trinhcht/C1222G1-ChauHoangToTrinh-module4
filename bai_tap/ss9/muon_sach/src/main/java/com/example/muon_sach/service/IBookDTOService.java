package com.example.muon_sach.service;

import com.example.muon_sach.dto.BookDTO;

import java.util.List;

public interface IBookDTOService {
    List<BookDTO> findAll();

    BookDTO findById(int idBookDTO);

    void save(BookDTO bookDTO);

    void delete(int idBookDTO);
    void remove(int bookDTO);
}
