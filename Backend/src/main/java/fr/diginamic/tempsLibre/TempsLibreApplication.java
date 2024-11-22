package fr.diginamic.tempsLibre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TempsLibreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TempsLibreApplication.class, args);

		// à decommenter pour initialiser les données
        /*
        DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        InitDataLoader initDataLoader = new InitDataLoader(departmentRepository, employeeRepository);
        initDataLoader.initData();
        */
	}
}