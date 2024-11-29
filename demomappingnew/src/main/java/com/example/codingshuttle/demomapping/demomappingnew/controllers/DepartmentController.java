package com.example.codingshuttle.demomapping.demomappingnew.controllers;

import com.example.codingshuttle.demomapping.demomappingnew.entities.DepartmentEntity;
import com.example.codingshuttle.demomapping.demomappingnew.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
   @GetMapping("/hello")
   public String namdege(){
        return "server on ";
   }
    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity){
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping(path="/{departmentId}/manager/{employeeId}")
    public DepartmentEntity assignManagerToDept(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return departmentService.assignManagerToDept(departmentId,employeeId);
    }

    @PutMapping(path="/{departmentId}/worrker/{employeeId}")
    public DepartmentEntity assinnworkerToDept(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return departmentService.assignWorkerToDept(departmentId,employeeId);
    }

    @PutMapping(path="/{departmentId}/freelancer/{employeeId}")
    public DepartmentEntity freelancerToDept(@PathVariable Long departmentId, @PathVariable Long employeeId){
        return departmentService.freelancerToDept(departmentId,employeeId);
    }
}
