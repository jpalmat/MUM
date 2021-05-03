package com.fekadu.bookreview.service;

import com.fekadu.bookreview.domain.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getAll();
    Book findById(Long id);
}
