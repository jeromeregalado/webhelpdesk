package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.dto.AssignRequest;
import com.example.WebHelperDesk.dto.update.UpdateTicketDTO;
import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import com.example.WebHelperDesk.exception.RecordNotFoundException;
import com.example.WebHelperDesk.repository.EmployeeRepository;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelpdeskTicketService {
    @Autowired
    TicketingRepository ticketingRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public HelpdeskTicket addTicket(HelpdeskTicket ticket){
        return ticketingRepository.save(ticket);
    }

    public HelpdeskTicket viewTicketByTicketNumber(Integer ticketNumber) throws RecordNotFoundException{
        Optional<HelpdeskTicket> ticketOptional = ticketingRepository.findByTicketNumber(ticketNumber);
        if(ticketOptional.isPresent()){
            HelpdeskTicket helpdeskTicket = ticketOptional.get();
            return helpdeskTicket;
        }
        else{
            throw new RecordNotFoundException();
        }
    }

    public List<HelpdeskTicket> viewAllTickets(){
        return ticketingRepository.findAll();
    }

    public String assignEmployeeToTicket(AssignRequest assignRequest) throws RecordNotFoundException {
        Optional<HelpdeskTicket> ticketOptional = ticketingRepository
                .findByTicketNumber(assignRequest.getTicketNumber());
        Optional<Employee> employeeOptional = employeeRepository
                .findByEmployeeNumber(assignRequest.getEmployeeNumber());
        if(ticketOptional.isPresent() && employeeOptional.isPresent()){
            HelpdeskTicket helpdeskTicket = ticketOptional.get();
            Employee employee = employeeOptional.get();
            helpdeskTicket.setAssignee(employee);
            ticketingRepository.save(helpdeskTicket);
            return employee.getFirstName() + " " + employee.getLastName() + " has been assigned to ticket " +
                    helpdeskTicket.getTitle();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public String deleteTicket(Integer ticketNumber) throws RecordNotFoundException {
        Optional<HelpdeskTicket> ticketOptional = ticketingRepository
                .findByTicketNumber(ticketNumber);
        if (ticketOptional.isPresent()) {
            HelpdeskTicket ticket = ticketOptional.get();
            ticketingRepository.delete(ticket);
            return ticketNumber + " has been deleted";
        } else {
            throw new RecordNotFoundException();
        }
    }

    public HelpdeskTicket updateTicket(UpdateTicketDTO updateTicketDTO){
        Optional<HelpdeskTicket> ticketOptional = ticketingRepository
                .findByTicketNumber(updateTicketDTO.getTicketNumber());
        if(ticketOptional.isPresent()){
            HelpdeskTicket ticketToBeUpdated = ticketOptional.get();
            ticketToBeUpdated.setTitle(updateTicketDTO.getTitle());
            ticketToBeUpdated.setDescription(updateTicketDTO.getDescription());
            ticketToBeUpdated.setSeverity(updateTicketDTO.getSeverity());
            ticketToBeUpdated.setStatus(updateTicketDTO.getStatus());
            return ticketingRepository.save(ticketToBeUpdated);
        }
        else{
            throw new RecordNotFoundException();
        }
    }
}
