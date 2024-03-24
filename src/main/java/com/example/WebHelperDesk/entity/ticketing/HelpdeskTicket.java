package com.example.WebHelperDesk.entity.ticketing;

import com.example.WebHelperDesk.entity.employee.Employee;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class HelpdeskTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketNumber;
    private String title;
    private String description;
    private Severity severity;
    private Status status;
    @OneToOne
    private Employee assignee;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Employee> watchers = new HashSet<>();

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    public Set<Employee> getWatchers() {
        return watchers;
    }

    public void setWatchers(Set<Employee> watchers) {
        this.watchers = watchers;
    }
}
