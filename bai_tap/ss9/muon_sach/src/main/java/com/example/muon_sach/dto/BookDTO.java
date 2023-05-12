package com.example.muon_sach.dto;

import com.example.muon_sach.model.Borrower;
import com.example.muon_sach.model.Book;

import javax.persistence.*;

@Entity(name = "bookDTO")
@Table(name = "bookDTO")
public class BookDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bookDTO")
    private Integer idBookDTO;

    @Column(name = "book_DTO",unique = true)
    private Integer bookDTO;

    @Column(name = "day_borrow")
    private String dayBorrow;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn (name = "idBorrower")
    private Borrower borrower;

    public BookDTO() {
    }

    public BookDTO(Integer idBookDTO, Integer bookDTO, String dayBorrow, Book book, Borrower borrower) {
        this.idBookDTO = idBookDTO;
        this.bookDTO= bookDTO;
        this.dayBorrow = dayBorrow;
        this.book = book;
        this.borrower = borrower;
    }


    public Integer getIdBookDTO() {
        return idBookDTO;
    }

    public void setIdBookDTO(Integer idBookDTO) {
        this.idBookDTO = idBookDTO;
    }

    public Integer getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(Integer bookCode) {
        this.bookDTO = bookDTO;
    }

    public String getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(String dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}

