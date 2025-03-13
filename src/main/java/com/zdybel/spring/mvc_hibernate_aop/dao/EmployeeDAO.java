package com.zdybel.spring.mvc_hibernate_aop.dao;

import com.zdybel.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
}
