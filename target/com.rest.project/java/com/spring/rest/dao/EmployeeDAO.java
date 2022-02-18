package com.spring.rest.dao;


import com.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployyes();
    public void saveEmployees(Employee employee);
    public Employee getEmployees(int id);
    public void delEmployees(int id);
}
