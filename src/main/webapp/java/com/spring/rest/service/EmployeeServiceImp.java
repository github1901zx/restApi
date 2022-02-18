package com.spring.rest.service;


import com.spring.rest.dao.EmployeeDAO;
import com.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployyes();
    }

    @Override
    public void saveEmployees(Employee employee) {
        employeeDAO.saveEmployees(employee);
    }

    @Override
    public Employee getEmployees(int id) {
        Employee employee = employeeDAO.getEmployees(id);
        return employee;
    }

    @Override
    public void delEmployees(int id) {
        employeeDAO.delEmployees(id);
    }
}