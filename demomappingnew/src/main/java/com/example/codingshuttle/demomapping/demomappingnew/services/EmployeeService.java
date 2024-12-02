package com.example.codingshuttle.demomapping.demomappingnew.services;

import com.example.codingshuttle.demomapping.demomappingnew.entities.EmployeeEntity;
import com.example.codingshuttle.demomapping.demomappingnew.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public EmployeeEntity getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> getall() {
        return employeeRepository.findAll();
    }
}
