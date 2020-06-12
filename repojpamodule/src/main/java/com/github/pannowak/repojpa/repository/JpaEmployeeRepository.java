package com.github.pannowak.repojpa.repository;

import com.github.pannowak.repoapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaEmployeeRepository extends JpaRepository<Employee, Long> {}
