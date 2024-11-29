package com.example.codingshuttle.demomapping.demomappingnew.repositories;

import com.example.codingshuttle.demomapping.demomappingnew.entities.DepartmentEntity;
import com.example.codingshuttle.demomapping.demomappingnew.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
