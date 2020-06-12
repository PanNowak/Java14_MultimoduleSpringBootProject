package com.github.pannowak.repojpa.repository;

import com.github.pannowak.repoapi.model.Employee;
import com.github.pannowak.repoapi.repository.EmployeeRepository;
import com.github.pannowak.repojpa.exception.EmployeeDeletionException;
import com.github.pannowak.repojpa.exception.EmployeeRetrievalException;
import com.github.pannowak.repojpa.exception.EmployeeStorageException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JpaEmployeeRepository delegate;

    EmployeeRepositoryImpl(JpaEmployeeRepository delegate) {
        this.delegate = delegate;
    }

    @Override
    public Optional<Employee> findById(Long id) throws EmployeeRetrievalException {
        try {
            return delegate.findById(id);
        } catch (RuntimeException e) {
            throw new EmployeeRetrievalException(e);
        }
    }

    @Override
    public List<Employee> findAll() throws EmployeeRetrievalException {
        try {
            return delegate.findAll();
        } catch (RuntimeException e) {
            throw new EmployeeRetrievalException(e);
        }
    }

    @Override
    public Employee insert(Employee employee) throws EmployeeStorageException {
        employee.setId(null);
        return save(employee);
    }

    @Override
    public void update(Employee employee) throws EmployeeStorageException {
        save(employee);
    }

    @Override
    public void deleteById(Long id) throws EmployeeDeletionException {
        try {
            delegate.deleteById(id);
        } catch (RuntimeException e) {
            throw new EmployeeDeletionException(e);
        }
    }

    private Employee save(Employee employee) throws EmployeeStorageException {
        try {
            return delegate.save(employee);
        } catch (RuntimeException e) {
            throw new EmployeeStorageException(e);
        }
    }
}
