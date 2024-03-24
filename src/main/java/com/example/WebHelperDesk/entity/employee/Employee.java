package com.example.WebHelperDesk.entity.employee;

import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private Integer employeeNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Department department;
    @ManyToMany
    @Column(unique = true)
    private List<HelpdeskTicket> ticketsWatching;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HelpdeskTicket> getTicketsWatching() {
        return ticketsWatching;
    }

    public void setTicketsWatching(List<HelpdeskTicket> ticketsWatching) {
        this.ticketsWatching = ticketsWatching;
    }
}
