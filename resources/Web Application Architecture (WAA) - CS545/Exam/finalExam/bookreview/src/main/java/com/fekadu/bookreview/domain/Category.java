package com.fekadu.bookreview.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy ="category", cascade = CascadeType.ALL)
    private List<Book> books;
}