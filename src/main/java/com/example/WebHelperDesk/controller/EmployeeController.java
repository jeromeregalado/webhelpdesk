package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.dto.update.UpdateEmployeeDTO;
import com.example.WebHelperDesk.entity.employee.Employee;
import com.example.WebHelperDesk.entity.ticketing.HelpdeskTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.WebHelperDesk.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200/*")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/xd")
    public String xd(){
        return "xd";
    }

    @GetMapping("/view/{employeeNumber}")
    public Employee getEmployee(@PathVariable Integer employeeNumber){
        return employeeService.viewEmployee(employeeNumber);
    }

    @GetMapping("/viewAll")
    public List<Employee> viewAllEmployees(){
        return employeeService.viewAllEmployees();
    }

    @DeleteMapping("/delete/{employeeNumber}")
    public String deleteEmployee(@PathVariable Integer employeeNumber){
        return employeeService.DeleteEmployee(employeeNumber);
    }

    @PutMapping("/update/{employeeNumber}")
    public Employee updateEmployee(@PathVariable Integer employeeNumber, @RequestBody UpdateEmployeeDTO updateEmployeeDTO){
        return employeeService.updateEmployee(employeeNumber,updateEmployeeDTO);
    }
    @GetMapping("/viewAssignedTickets/{employeeNumber}")
    public List<HelpdeskTicket> getListOfAssignedTickets(@PathVariable Integer employeeNumber){
        return employeeService.getListOfAssignedTickets(employeeNumber);
    }
}
