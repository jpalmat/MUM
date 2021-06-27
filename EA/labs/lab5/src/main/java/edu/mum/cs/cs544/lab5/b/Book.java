package edu.mum.cs.cs544.lab5.b;

import javax.persistence.Entity;

@Entity
public class Book extends Product1 {

    private String title;

    public Book() {

    }

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}