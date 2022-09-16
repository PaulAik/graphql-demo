package com.paulaikman.graphqldemo.controllers;

import com.paulaikman.graphqldemo.entities.Employee;
import com.paulaikman.graphqldemo.mappers.EmployeeMapper;
import com.paulaikman.graphqldemo.models.EmployeeModel;
import com.paulaikman.graphqldemo.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("hi")
    public String hello(){
        return "hello world!";
    }

    @GetMapping("employees")
    public List<Employee> employees(){
        return employeeRepository.findAll();
    }

    @SchemaMapping(typeName = "Query",value = "getEmployees")
    public List<EmployeeModel> findAll() {
        var employees = employeeRepository.findAll();

        List<EmployeeModel> employeeModels = employees
                .stream()
                .map(x -> EmployeeMapper.convert(x))
                .toList();

        return employeeModels;
    }

    @SchemaMapping(typeName = "Query",value = "getEmployee")
    public EmployeeModel findOne(@Argument Integer id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElse(null);

        if(employee != null) {
            return EmployeeMapper.convert(employee);
        }

        return null;
    }

}
