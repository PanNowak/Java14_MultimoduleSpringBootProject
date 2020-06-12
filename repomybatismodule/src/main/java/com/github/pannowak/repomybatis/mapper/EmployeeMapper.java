package com.github.pannowak.repomybatis.mapper;

import com.github.pannowak.repoapi.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void insert(Employee employee);

    void update(Employee employee);

    void deleteById(Long id);
}
