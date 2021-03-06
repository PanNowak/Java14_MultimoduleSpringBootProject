package com.github.pannowak.repomybatis.repository;

import com.github.pannowak.repoapi.model.Employee;
import com.github.pannowak.repoapi.repository.EmployeeRepository;
import com.github.pannowak.repomybatis.exception.MyBatisEmployeePersistenceException;
import com.github.pannowak.repomybatis.mapper.EmployeeMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeMapper employeeMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    EmployeeRepositoryImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Optional<Employee> findById(Long id) throws MyBatisEmployeePersistenceException {
        try {
            return employeeMapper.findById(id);
        } catch (PersistenceException e) {
            String errorMessage = String.format("Failed to query employee by id: %s", id);
            throw new MyBatisEmployeePersistenceException(errorMessage, e);
        }
    }

    @Override
    public List<Employee> findAll() throws MyBatisEmployeePersistenceException {
        try {
            return employeeMapper.findAll();
        } catch (PersistenceException e) {
            String errorMessage = "Failed to query all employees";
            throw new MyBatisEmployeePersistenceException(errorMessage, e);
        }
    }

    @Override
    public Employee insert(Employee employee) throws MyBatisEmployeePersistenceException {
        try {
            employeeMapper.insert(employee);
            return employee;
        } catch (PersistenceException e) {
            String errorMessage = String.format("Failed to save employee: %s", employee);
            throw new MyBatisEmployeePersistenceException(errorMessage, e);
        }
    }

    @Override
    public void update(Employee employee) throws MyBatisEmployeePersistenceException {
        try {
            employeeMapper.update(employee);
        } catch (PersistenceException e) {
            String errorMessage = String.format("Failed to save employee: %s", employee);
            throw new MyBatisEmployeePersistenceException(errorMessage, e);
        }
    }

    @Override
    public void deleteById(Long id) throws MyBatisEmployeePersistenceException {
        try {
            employeeMapper.deleteById(id);
        } catch (PersistenceException e) {
            String errorMessage = String.format("Failed to delete employee with id: %s", id);
            throw new MyBatisEmployeePersistenceException(errorMessage, e);
        }
    }
}
