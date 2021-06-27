package edu.mum.cs.cs544.exercises.e;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation1 {

	@Id
    @GeneratedValue
    private int id;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Book1 book;


    public Reservation1() {
    }

    public Reservation1(Date date){
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Book1 getBook() {
		return book;
	}

	public void setBook(Book1 book) {
		this.book = book;
	}
	
}