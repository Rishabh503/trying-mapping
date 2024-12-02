package com.example.codingshuttle.demomapping.demomappingnew.controllers;


import com.example.codingshuttle.demomapping.demomappingnew.entities.EmployeeEntity;
import com.example.codingshuttle.demomapping.demomappingnew.repositories.EmployeeRepository;
import com.example.codingshuttle.demomapping.demomappingnew.services.EmployeeService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping
    public List<EmployeeEntity> getallem(){
        return employeeService.getall();
    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.createNewEmployee(employeeEntity);
    }
}
