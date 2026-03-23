package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    //below are the Business Requirement
    public List<EmployeeDTO> getAllEmployee();
    public Employee createEmployee(EmployeeDTO emp);
    public EmployeeDTO getEmployee(int empid);
    public Employee removeEmployee(int empid);
    public Employee updateEmployee(EmployeeDTO e);
    public List<EmployeeDTO> getEmployeeByName(String name);
}
