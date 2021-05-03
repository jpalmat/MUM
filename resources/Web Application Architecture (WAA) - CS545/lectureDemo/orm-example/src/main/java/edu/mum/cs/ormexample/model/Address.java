package edu.mum.cs.ormexample.model;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
public class Address implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String street;
    private String zipCode;
    private String state;

    @ManyToOne
    private Employee employee;

//    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//
//    private Employee employee;

}