package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.dao.IEmployeeRepo;
import com.cg.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//IOC will create object for this
@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo erepo;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> emps = erepo.findAll();
        List<EmployeeDTO> employees = new ArrayList<>();
        emps.forEach(e->employees.add(EntityMapper.convertEntityToDto(e)));
        return employees;
    }

    @Override
    public Employee createEmployee(EmployeeDTO emp) {

        return erepo.saveAndFlush(EntityMapper.convertObjectToEntity(emp));
    }

    @Override
    public EmployeeDTO getEmployee(int empid){
        Optional<Employee> op = erepo.findById(empid);
        if(op.isPresent()){
            Employee e = op.get();
            return EntityMapper.convertEntityToDto(e);
            //return new EmployeeDTO(e.getEmpid(),e.getName(),e.getDob(),e.getSalary());
        }
        else
            throw new EmployeeNotFoundException("Employee Not found");
    }

    @Override
    public Employee removeEmployee(int empid) {
        Optional<Employee> op = erepo.findById(empid);
        if(op.isPresent()){
            erepo.deleteById(op.get().getEmpid());
            return op.get();
        }
        return null;

    }

    @Override
    public Employee updateEmployee(EmployeeDTO e) {
        Optional<Employee> op = erepo.findById(e.getEmployeeId());
        if(op.isPresent()) {
              Employee e1 = op.get();
              if(e.getFullName()!=null)
                  e1.setName(e.getFullName());
              if (e.getDateOfBirth()!=null) {
                  e1.setDob(e.getDateOfBirth());
              }
              if (e.getSalary()!=0) {
                  e1.setSalary(e.getSalary());
              }
              //return EntityMapper.convertEntityToDto(erepo.saveAndFlush(e1));
              return erepo.saveAndFlush(e1); //conversion of employee to dto object is done in controller class to avoid AssertionFail error in testing
        }
        return null;

    }

    @Override
    public List<EmployeeDTO> getEmployeeByName(String name) {
        List<Employee> emps = erepo.findByName(name);
        List<EmployeeDTO> empsdto = new ArrayList<>();
        emps.forEach(e->empsdto.add(EntityMapper.convertEntityToDto(e)));
        return empsdto;
    }
}
