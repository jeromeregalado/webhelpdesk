package com.example.WebHelperDesk.repository;

import com.example.WebHelperDesk.entity.employee.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Optional<Employee> findById(Integer Id);
    Optional<Employee> findByEmployeeNumber(Integer employeeNumber);

    Employee save(Employee employee);

    void deleteById(Integer employeeId);
    @Query("DELETE FROM Employee e WHERE e.employeeNumber=:employeeNumber")
    void deleteByEmployeeNumber(Integer employeeNumber);

    List<Employee> findAll();
}
