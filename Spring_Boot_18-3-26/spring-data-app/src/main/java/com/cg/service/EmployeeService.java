package com.cg.service;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//for documentation purpose
@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepo erepo;
    public String createEmployee(Employee emp){
           Employee e = erepo.saveAndFlush(emp);  // save will commit the data into the DB, saveandflush will also remove the data from the cache memory
           return "Employee created empId = "+e.getEmpid()+"empname: "+e.getName();
    }

    public List<Employee> getAllEmployee(){
           return erepo.findAll();
    }
    public Employee getEmployee(int id){
           Optional<Employee> op = erepo.findById(id);
           if(op.isPresent()){
               return op.get();
           }
           else
               return null;

    }
    public String removeEmployee(int empid){
           Optional<Employee> op = erepo.findById(empid);
           if(op.isPresent()){
               erepo.deleteById(op.get().getEmpid());
               return "Employee removed";
           }
           else {
               return "Employee not found";
           }
    }

    public String updateEmployee(Employee e){
           erepo.saveAndFlush(e);
           return "Employee updated";
    }

    public List<Employee> getEmployeeByName(String name){
           return erepo.findByNa(name);
    }

    public List<Employee> getEmployeeBySalLessThan(int sal){
        return erepo.findBySalaryLessThan(sal);
    }

    public List<Employee> getEmployeeByDob(LocalDate st,LocalDate en){
        return erepo.findByDobBetween(st,en);
    }
}
