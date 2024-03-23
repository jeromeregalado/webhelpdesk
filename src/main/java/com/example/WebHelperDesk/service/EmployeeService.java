package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.repository.EmployeeRepository;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TicketingRepository ticketingRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public String DeleteEmployee(Integer employeeNumber){
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        if(employeeOptional.isPresent()) {
            if(ticketingRepository.findByAssignee(employeeOptional)){
                return "Has assigned ticket. Employee cannot be deleted";
            }
            else{
                Employee employee = employeeOptional.get();
                String employeeDeleted = employee.getEmployeeNumber() + " has been deleted";
                employeeRepository.deleteByEmployeeNumber(employeeNumber);
                return employeeDeleted;
            }
        }
        else{
            return "employee does not exist";
        }
    }

    public List<Employee> viewAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee viewEmployee(Integer employeeNumber){
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            return employee;
        }
        else{
            throw new RuntimeException("No such employee");
        }
    }
}
