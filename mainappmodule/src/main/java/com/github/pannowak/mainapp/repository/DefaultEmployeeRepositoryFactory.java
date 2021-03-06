package com.github.pannowak.mainapp.repository;

import com.github.pannowak.repoapi.model.Employee;
import com.github.pannowak.repoapi.repository.EmployeeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DefaultEmployeeRepositoryFactory {

    @Bean
    @ConditionalOnMissingBean
    public EmployeeRepository defaultEmployeeRepository() {
        return new EmployeeRepository() {

            private final Map<Long, Employee> employeesById = new ConcurrentHashMap<>();

            @Override
            public Optional<Employee> findById(Long id) {
                return Optional.ofNullable(employeesById.get(id));
            }

            @Override
            public List<Employee> findAll() {
                return new ArrayList<>(employeesById.values());
            }

            @Override
            public Employee insert(Employee employee) {
                Long newId = generateNewId();
                employee.setId(newId);
                employeesById.put(newId, employee);
                return employee;
            }

            @Override
            public void update(Employee employee) {
                employeesById.put(employee.getId(), employee);
            }

            @Override
            public void deleteById(Long id) {
                employeesById.remove(id);
            }

            private Long generateNewId() {
                return employeesById.keySet().stream()
                        .max(Comparator.naturalOrder())
                        .orElse(0L) + 1;
            }
        };
    }
}
