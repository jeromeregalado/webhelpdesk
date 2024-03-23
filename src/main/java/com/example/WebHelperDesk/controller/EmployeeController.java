package com.example.WebHelperDesk.controller;

import com.example.WebHelperDesk.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.WebHelperDesk.service.EmployeeService;

@RestController
@RequestMapping("/employees")
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
    public Employee getEmployee(Integer employeeNumber){
        return employeeService.viewEmployee(employeeNumber);
    }
}
