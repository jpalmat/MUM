package mum.cs.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

public class User {
    @Size(min=2, max=30)
    private String name;

    @NotBlank
    @Email(message = "{email.validation}")
    private String email;

    @NotNull
    private Integer age;

    @Past
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDay;
    @NotBlank
    private String role;
    @Valid
    private Address addr;
    public User() {
    }

    public User(String name, String email, Integer age, Date birthDay, String role, Address addr) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.birthDay = birthDay;
        this.role = role;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", role='" + role + '\'' +
                ", addr=" + addr +
                '}';
    }
}