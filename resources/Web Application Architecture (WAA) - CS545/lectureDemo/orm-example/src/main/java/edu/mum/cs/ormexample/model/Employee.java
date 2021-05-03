package edu.mum.cs.ormexample.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="emp")
@Setter
@Getter
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private long id;

    @Column(name = "F_NAME")
    private String firstName;

    @Column(name = "L_NAME")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    //@JoinColumn(name="addr_id", nullable = false)
    private List<Address> address;
}
