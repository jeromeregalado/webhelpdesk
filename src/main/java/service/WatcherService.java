package service;

import repository.EmployeeRepository;
import repository.TicketingRepository;
import entity.employee.Employee;
import entity.ticketing.HelpdeskTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatcherService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;


    public HelpdeskTicket saveWatcher(Integer ticketNumber, Employee employee) throws RuntimeException {
        Optional<HelpdeskTicket> watcherOptional = ticketingRepository.findByTicketNumber(ticketNumber);
        if (watcherOptional.isPresent()) {
            HelpdeskTicket helpdeskTicket = watcherOptional.get();
            employee.setHelpdeskTicket(helpdeskTicket);
            return ticketingRepository.save(helpdeskTicket);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Employee> findAllWatchers(Integer ticketNumber, Pageable pageable) throws RuntimeException {
            return ticketingRepository.findByTicketNumber(ticketNumber).get().getWatchers();
    }

}
