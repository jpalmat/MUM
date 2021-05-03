package com.fekadu.bookreview.service;

import com.fekadu.bookreview.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);
    List<Comment> getAll();
    Comment findById(Long id);
    List<Comment> getCommentsByBookId(Long id);
}
