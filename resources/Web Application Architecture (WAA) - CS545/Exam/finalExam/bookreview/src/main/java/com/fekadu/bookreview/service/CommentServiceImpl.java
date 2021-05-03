package com.fekadu.bookreview.service;

import com.fekadu.bookreview.domain.Comment;
import com.fekadu.bookreview.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>)commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getCommentsByBookId(Long id) {
        return commentRepository.getCommentsByBookId(id);
    }


}
