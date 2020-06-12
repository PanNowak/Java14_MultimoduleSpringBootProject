package com.github.pannowak.mainapp.controller;

import com.github.pannowak.repoapi.exception.EmployeePersistenceException;
import com.github.pannowak.repoapi.model.Employee;
import com.github.pannowak.repoapi.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees() throws EmployeePersistenceException {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeePersistenceException {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee, HttpServletRequest request) throws EmployeePersistenceException {
        Employee savedEmployee = employeeRepository.insert(newEmployee);
        return ResponseEntity
                .created(URI.create(request.getLocalName() + "/" + savedEmployee.getId()))
                .body(savedEmployee);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
            throws EmployeePersistenceException {
        employee.setId(id);
        employeeRepository.update(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) throws EmployeePersistenceException {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
