package com.paulaikman.graphqldemo.repositories;

import com.paulaikman.graphqldemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}