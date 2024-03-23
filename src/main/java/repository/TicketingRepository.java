package repository;

import entity.employee.Employee;
import entity.ticketing.HelpdeskTicket;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketingRepository extends PagingAndSortingRepository<HelpdeskTicket, Integer> {

    HelpdeskTicket save(HelpdeskTicket helpdeskTicket);

    Optional<HelpdeskTicket> findByTicketNumber(Integer ticketNumber);

    boolean findByAssignee(Optional<Employee> employeeOptional);
}
