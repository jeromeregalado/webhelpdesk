package com.example.WebHelperDesk.dto.update;

import com.example.WebHelperDesk.entity.ticketing.Severity;
import com.example.WebHelperDesk.entity.ticketing.Status;

public class UpdateTicketDTO {
    private Integer ticketNumber;
    private String title;
    private String description;
    private Severity severity;
    private Status status;

    public Integer getTicketNumber() {
        return ticketNumber;
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
}
