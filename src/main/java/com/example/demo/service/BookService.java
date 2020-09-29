package com.example.demo.service;

import com.example.demo.models.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);
    Iterable<Book> findAll();

    Book createBook(Book book);
}
