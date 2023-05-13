package com.example.muon_sach.service;

import com.example.muon_sach.exception.QuantityLowerThanZeroException;
import com.example.muon_sach.exception.WrongCodeException;
import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.Borrower;

public interface IBookService {
    Iterable<Book> findAllBook();

    boolean borrowerBook(Borrower borrower) throws WrongCodeException;

    boolean returnBook(String code) throws QuantityLowerThanZeroException;
}
