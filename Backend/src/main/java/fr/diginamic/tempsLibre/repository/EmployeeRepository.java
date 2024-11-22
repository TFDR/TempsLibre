package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
