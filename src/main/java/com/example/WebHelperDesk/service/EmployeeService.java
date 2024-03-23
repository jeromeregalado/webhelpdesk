package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.repository.EmployeeRepository;
import com.example.WebHelperDesk.repository.TicketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void DeleteEmployee(Integer employeeId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(ticketingRepository.findByAssignee(employeeOptional)){
            System.out.println("Cannot be deleted");
        }
        else{
            employeeRepository.deleteById(employeeId);
        }
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
