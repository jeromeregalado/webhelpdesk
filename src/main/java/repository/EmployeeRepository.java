package repository;

import entity.employee.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    Optional<Employee> findById(Integer employeeId);

    Employee save(Employee employee);

    void deleteById(Integer employeeId);
}
