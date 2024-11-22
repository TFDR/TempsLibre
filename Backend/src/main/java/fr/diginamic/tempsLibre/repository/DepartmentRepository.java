package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.Department;
import fr.diginamic.tempsLibre.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String departmentName);
}
