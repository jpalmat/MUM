package com.fekadu.bookreview.controller;

import com.fekadu.bookreview.domain.Book;
import com.fekadu.bookreview.domain.Comment;
import com.fekadu.bookreview.service.BookService;
import com.fekadu.bookreview.service.BookServiceImpl;
import com.fekadu.bookreview.service.CommentService;
import com.fekadu.bookreview.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    BookService bookService;

    @Autowired
    CommentService commentService;

    @GetMapping("/view/{id}")
    public String viewBook(@ModelAttribute("comment") Comment comment, @PathVariable("id") Long id, Model model){
//        model.addAttribute("bookId", id);
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("comments", commentService.getCommentsByBookId(id));

        return "comment";
    }

    @GetMapping("/post")
    public String postComment(Comment comment, Model model){

        Book book = bookService.findById(comment.getBook().getId());

        comment.setBook(book);

        commentService.save(comment);

        return "redirect:/comment/view/"+comment.getBook().getId();
    }
}