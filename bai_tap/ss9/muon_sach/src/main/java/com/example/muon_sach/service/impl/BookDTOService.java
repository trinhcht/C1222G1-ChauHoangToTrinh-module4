package com.example.muon_sach.service.impl;

import com.example.muon_sach.dto.BookDTO;
import com.example.muon_sach.repository.IBookDTORepository;
import com.example.muon_sach.service.IBookDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookDTOService")
public class BookDTOService implements IBookDTOService {
    @Autowired
    private IBookDTORepository iBookDTORepository;

    @Override
    public List<BookDTO> findAll() {
        return iBookDTORepository.findAll();
    }

    @Override
    public BookDTO findById(int idBookDTO) {
        return iBookDTORepository.findById(idBookDTO);
    }

    @Override
    public void save(BookDTO bookDTO) {
        iBookDTORepository.save(bookDTO);
    }

    @Override
    public void delete(int idBookDTO) {
        iBookDTORepository.delete(findById(idBookDTO));
    }

    @Override
    public void remove(int bookDTO) {
    }
}
