package com.example.muon_sach.service.impl;
import com.example.muon_sach.exception.QuantityLowerThanZeroException;
import com.example.muon_sach.exception.WrongCodeException;
import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.repository.IBookRepository;
import com.example.muon_sach.repository.IBorrowerRepository;
import com.example.muon_sach.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("")
public class BookService implements IBookService {
    private final
    IBookRepository bookRepository;

    private final
    IBorrowerRepository borrowerRepository;

    public BookService(IBookRepository bookRepository, IBorrowerRepository borrowerRepository) {
        this.bookRepository = bookRepository;
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public List<Book> findAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public boolean borrowerBook(Borrower borrower) throws WrongCodeException {
        Book book = bookRepository.findById(borrower.getBook().getId()).orElse(null);
        if (book == null) {
            return false;
        }
        if (book.getQuantity() <= 0) {
            throw new WrongCodeException("Số lượng sách đã hết");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
            borrowerRepository.save(borrower);
            return true;
        }
    }

    @Override
    public boolean returnBook(String code) throws QuantityLowerThanZeroException {
        Borrower borrower = borrowerRepository.findByCode(code);
        if (borrower == null) {
            throw new QuantityLowerThanZeroException("Mã mượn sách không hợp lệ");
        }

        Book book = bookRepository.findById(borrower.getBook().getId()).orElse(null);
        if (book == null) {
            return false;
        }

        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowerRepository.deleteById(borrower.getId());
        return true;
    }
}
