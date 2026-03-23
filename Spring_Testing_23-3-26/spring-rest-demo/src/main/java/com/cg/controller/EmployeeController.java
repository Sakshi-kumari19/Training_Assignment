package com.cg.controller;

import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
@Tag(name = "EmployeeAPI", description = "Provide CRUD operations on employee object")
public class EmployeeController {

    //@Autowired - instead of using autowired we are using constructor to do the same task
    private IEmployeeService service;

    public EmployeeController(IEmployeeService service) {
        super();
        this.service = service;
    }


    @GetMapping(produces = {"application/json","application/xml"})
    public List<EmployeeDTO> getEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO>  getEmployeeById(@PathVariable int id){
        EmployeeDTO e = service.getEmployee(id);
        if(e!=null)
            return new ResponseEntity<EmployeeDTO>(e, HttpStatus.OK);
        else
            return new ResponseEntity("Employee not found",HttpStatus.NOT_FOUND);
            //return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/name/{name}")
    public List<EmployeeDTO> getByName(@PathVariable String name){
        return service.getEmployeeByName(name);
    }

    @PostMapping(consumes = {"application/json","application/xml"})
    public EmployeeDTO ceateNewEmployee(@RequestBody EmployeeDTO e){

        return EntityMapper.convertEntityToDto(service.createEmployee(e));
    }

    @DeleteMapping("/id/{id}")
    public EmployeeDTO deleteEmployee(@PathVariable int id){
        return EntityMapper.convertEntityToDto(service.removeEmployee(id));
    }

    @PutMapping
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO emp){
        return EntityMapper.convertEntityToDto(service.updateEmployee(emp));
    }

}
