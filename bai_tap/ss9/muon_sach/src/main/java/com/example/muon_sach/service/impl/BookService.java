package com.example.muon_sach.service.impl;

import com.example.muon_sach.dto.BookDTO;
import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.repository.IBookDTORepository;
import com.example.muon_sach.repository.IBookRepository;
import com.example.muon_sach.repository.IBorrowerRepository;
import com.example.muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Autowired
    private IBookDTORepository iBookCodeRepository;
    @Autowired
    private IBorrowerRepository iBorrowerRepository;

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void borrow(int id, int idBorrower) {
        Book book = iBookRepository.findById(id);
        book.setQuantity(book.getQuantity() - 1);
        int codeBook = (int) Math.floor((Math.random() * 89999) + 10000);
        Borrower borrower = iBorrowerRepository.findById(idBorrower);

        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookDTO(codeBook);
        bookDTO.setBook(book);
        bookDTO.setDayBorrow(Date.from(Instant.now()).toString());
        bookDTO.setBorrower(borrower);
        iBookCodeRepository.save(bookDTO);
        iBookRepository.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }
}
