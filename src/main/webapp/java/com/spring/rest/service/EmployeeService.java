package com.spring.rest.service;

import com.spring.rest.entity.Employee;


import java.util.List;


public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployees(Employee employee);
    public Employee getEmployees(int id);
    public void delEmployees(int id);
}