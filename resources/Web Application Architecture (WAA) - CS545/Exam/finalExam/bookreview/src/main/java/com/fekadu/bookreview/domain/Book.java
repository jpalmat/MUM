package com.fekadu.bookreview.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Fetch(FetchMode.JOIN)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
//    @JoinColumn(name = "book_id")
    private List<Comment> comments;
}