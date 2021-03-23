package com.mincu.bookstore.service;

import com.mincu.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {

    @Override
    List<Book> findAll();
}
