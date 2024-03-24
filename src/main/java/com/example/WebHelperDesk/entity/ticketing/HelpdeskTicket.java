package com.example.WebHelperDesk.entity.ticketing;

import com.example.WebHelperDesk.entity.employee.Employee;
import jakarta.persistence.*;

import java.util.List;
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
    @ManyToMany(mappedBy = "ticketsWatching", fetch = FetchType.LAZY)
    private List<Employee> watchers;

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

    public List<Employee> getWatchers() {
        return watchers;
    }

    public void setWatchers(List<Employee> watchers) {
        this.watchers = watchers;
    }
}
