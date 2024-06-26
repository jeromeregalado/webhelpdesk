package com.example.WebHelperDesk.repository;

import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketingRepository extends PagingAndSortingRepository<HelpdeskTicket, Integer> {

    HelpdeskTicket save(HelpdeskTicket helpdeskTicket);

    List<HelpdeskTicket> findAll();

    Optional<HelpdeskTicket> findByTicketNumber(Integer ticketNumber);

    List<HelpdeskTicket> findByAssigneeId(Integer employeeId);

    void delete(HelpdeskTicket helpdeskTicket);
}
