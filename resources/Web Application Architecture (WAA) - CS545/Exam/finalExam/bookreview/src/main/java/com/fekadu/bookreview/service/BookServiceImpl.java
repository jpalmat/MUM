package com.fekadu.bookreview.service;

import com.fekadu.bookreview.domain.Book;
import com.fekadu.bookreview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }
}
