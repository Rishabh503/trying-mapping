package com.example.codingshuttle.demomapping.demomappingnew.services;

import com.example.codingshuttle.demomapping.demomappingnew.entities.DepartmentEntity;
import com.example.codingshuttle.demomapping.demomappingnew.entities.EmployeeEntity;
import com.example.codingshuttle.demomapping.demomappingnew.repositories.DepartmentRepository;
import com.example.codingshuttle.demomapping.demomappingnew.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity assignManagerToDept(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
                    department.setManager(employee);
                    return departmentRepository.save(department);
                })).orElse(null);
    }

    public DepartmentEntity assignWorkerToDept(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
            employee.setWorkerDepartment(department);
            employeeRepository.save(employee);

            department.getWorkers().add(employee);
            return department;
        })).orElse(null);
    }

    public DepartmentEntity freelancerToDept(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity=departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department->
                employeeEntity.map(employee->{
                   employee.getFreelanceDepartments().add(department);
                   employeeRepository.save(employee);

                   department.getFreelancers().add(employee);
                   return department;
                })).orElse(null);
    }
}
