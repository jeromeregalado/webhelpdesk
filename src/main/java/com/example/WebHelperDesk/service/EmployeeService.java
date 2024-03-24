package com.example.WebHelperDesk.service;

import com.example.WebHelperDesk.dto.UpdateEmployeeDTO;
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
            Employee employee = employeeOptional.get();
            List<HelpdeskTicket> helpdeskTicketList = ticketingRepository.findByAssigneeId(employee.getId());
            if(!helpdeskTicketList.isEmpty()){
                return "Has assigned ticket. Employee cannot be deleted";
            }
            else{
                employeeRepository.deleteById(employee.getId());
                String employeeDeleted = employeeNumber + " has been deleted";
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
    public Employee viewEmployee(Integer employeeNumber) throws RecordNotFoundException {
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            return employee;
        }
        else{
            throw new RecordNotFoundException();
        }
    }

    public Employee updateEmployee(Integer employeeNumber, UpdateEmployeeDTO updateEmployeeDTO){
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setFirstName(updateEmployeeDTO.getFirstName());
            employee.setMiddleName(updateEmployeeDTO.getMiddleName());
            employee.setLastName(updateEmployeeDTO.getLastName());
            employee.setDepartment(updateEmployeeDTO.getDepartment());
            return employeeRepository.save(employee);
        }
        else{
            throw new RecordNotFoundException();
        }
    }

    public List<HelpdeskTicket> getListOfAssignedTickets(Integer employeeNumber){
        Optional<Employee> employeeOptional = employeeRepository.findByEmployeeNumber(employeeNumber);
        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            return ticketingRepository.findByAssigneeId(employee.getId());
        }
        else{
            throw new RecordNotFoundException();
        }
    }
}
