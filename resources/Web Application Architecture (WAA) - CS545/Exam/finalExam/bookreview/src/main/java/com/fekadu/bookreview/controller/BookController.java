package com.fekadu.bookreview.controller;

import com.fekadu.bookreview.domain.Book;
import com.fekadu.bookreview.service.BookService;
import com.fekadu.bookreview.service.BookServiceImpl;
import com.fekadu.bookreview.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping (value = {"/","/add"}, method = RequestMethod.GET)
    public String getBookList(@ModelAttribute("book") Book book, Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("books", bookService.getAll());
        return "bookListForm";
    }

    @PostMapping("/add")
    public String saveBook (@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/book/add";
    }
}