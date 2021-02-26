package edu.mum.cs.cs544.exercises.f;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
	@Id
    @GeneratedValue
    private int id;
    private int roomNumber;
    private String building;

    @OneToMany(mappedBy="office")
    private Set<Employee1> employees = new HashSet<Employee1>();

    public Office() {
    }

    public Office(int roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Set<Employee1> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee1> employees) {
        this.employees = employees;
    }


    public void addEmployee(Employee1 employee){
        employee.setOffice(this);
        employees.add(employee);
    }
}
