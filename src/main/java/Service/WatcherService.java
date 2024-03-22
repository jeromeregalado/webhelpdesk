package Service;

import Repository.EmployeeRepository;
import Repository.TicketingRepository;
import entity.employee.Employee;
import entity.ticketing.HelpdeskTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatcherService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;


    public Employee saveWatcher(Long employeeId, HelpdeskTicket helpdeskTicket) throws RuntimeException {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            Employee.;
            return ticketingRepository.save(helpdeskTicket);
        } else {
            throw new RuntimeException();
        }
    }

}
