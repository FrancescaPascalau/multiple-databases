package com.francesca.pascalau.domain.service;

import com.francesca.pascalau.data.entities.Employee;
import com.francesca.pascalau.data.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> findEmployees() {
        return repository.findAll();
    }

    public Employee findEmployeeById(Long employeeId) {
        return repository.findById(employeeId).orElse(null);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }
}
