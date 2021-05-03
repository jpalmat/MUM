package com.fekadu.bookreview.repository;

import com.fekadu.bookreview.domain.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query(value = "SELECT c FROM Comment c WHERE c.book.id= ?1")
    List<Comment> getCommentsByBookId(Long bookId);
}