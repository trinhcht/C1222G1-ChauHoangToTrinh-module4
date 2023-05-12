package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    Book findById(int id);
    List<Book> findAll();
    void borrow(int id, int idBorrower);
    void returnBook(Book book);
}
