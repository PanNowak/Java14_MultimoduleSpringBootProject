package com.github.pannowak.mainapp;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;
import com.github.pannowak.repoapi.model.Address;
import com.github.pannowak.repoapi.model.Employee;
import com.github.pannowak.repoapi.repository.EmployeeRepository;
import com.github.pannowak.springconfigurationprovider.SpringApplicationProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
    
    public static void main(String[] args) {
        new SpringApplicationBuilder(MainApplication.class)
                .sources(SpringApplicationProvider.getSources())
                .run(args);
    }

    private final EmployeeRepository employeeRepository;

    MainApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws EmployeePersistenceException {
        employeeRepository.insert(new Employee("Luke", "Skywalker",
                new Address("Desert", "Tatooine")));
        employeeRepository.insert(new Employee("Leia", "Organa",
                new Address("Palace", "Alderaan")));
        employeeRepository.insert(new Employee("Yoda", "???",
                new Address("Cave", "Dagobah")));
    }
}
