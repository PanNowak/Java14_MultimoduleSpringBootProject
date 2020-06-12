package com.github.pannowak.repoapi.repository;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;
import com.github.pannowak.repoapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Long id) throws EmployeePersistenceException;

    List<Employee> findAll() throws EmployeePersistenceException;

    Employee insert(Employee employee) throws EmployeePersistenceException;

    void update(Employee employee) throws EmployeePersistenceException;

    void deleteById(Long id) throws EmployeePersistenceException;
}
