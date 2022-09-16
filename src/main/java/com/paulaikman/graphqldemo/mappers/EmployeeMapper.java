package com.paulaikman.graphqldemo.mappers;

import com.paulaikman.graphqldemo.entities.Employee;
import com.paulaikman.graphqldemo.models.EmployeeModel;
import com.paulaikman.graphqldemo.models.TitleModel;

public class EmployeeMapper {

    public static EmployeeModel convert(Employee employee) {
        EmployeeModel model = new EmployeeModel();
        model.setFirstName(employee.getFirstName());
        model.setLastName(employee.getLastName());
        model.setFullName(employee.getFirstName() + " " + employee.getLastName());

        model.setTitles(
                employee.getTitles().stream().map(x -> {
                    return new TitleModel(x.getTitle(), x.getFromDate(), x.getToDate());
                }).toList());

        return model;
    }
}
