package com.example.muon_sach.repository;

import com.example.muon_sach.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IBookRepository extends PagingAndSortingRepository<Book, Integer> {

}
