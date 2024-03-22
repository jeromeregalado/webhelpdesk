package Service;

import Repository.EmployeeRepository;
import Repository.TicketingRepository;
import entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;

    public void DeleteEmployee(Integer employeeId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(ticketingRepository.findByAssignee(employeeOptional)){
            System.out.println("Cannot be deleted");
        }
        else{
            employeeRepository.deleteById(employeeId);
        }
    }
}
