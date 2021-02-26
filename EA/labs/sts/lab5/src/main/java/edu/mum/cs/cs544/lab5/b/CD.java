package edu.mum.cs.cs544.lab5.b;

import javax.persistence.Entity;

@Entity
public class CD extends Product1 {

    private String artist;

    public CD() {
    }

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}