package edu.mum.cs.cs544.exercises.d;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {

	@Id
    @GeneratedValue
    private int id;
    @Temporal(value = TemporalType.DATE)
    private Date date;


    public Reservation() {
    }

    public Reservation(Date date){
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
}