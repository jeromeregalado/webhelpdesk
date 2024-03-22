package entity.employee;

import entity.ticketing.HelpdeskTicket;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer employeeNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Department department;
    @ManyToOne
    private HelpdeskTicket helpdeskTicket;
}
