package com.cg;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {

//    @Test
//    void contextLoads() {
//    }

//    Autowiring it will lead autowiring of repo class
//    @Autowired
//    private IEmployeeService service;

//    @Test
//    void testEmployeeId(){
//        assertNotNull(service.getEmployee(1));
//        assertThrows(EmployeeNotFoundException.class,()->service.getEmployee(900));
//        assertEquals("Sakshi",service.getEmployee(302).getFullName());
//    }

     @Mock
     private IEmployeeRepo repo;
     @InjectMocks
     private EmployeeService service;

     @Test
     void testEmployeeById(){
         EmployeeDTO eDto = new EmployeeDTO("Nishant", LocalDate.of(2003,6,1),78000);
         eDto.setEmployeeId(1032);
         Employee e = EntityMapper.convertObjectToEntity(eDto);
         Optional<Employee> op = Optional.of(e);
         when(repo.findById(1032)).thenReturn(op);
         assertNotNull(service.getEmployee(1032));
     }
     @Test
     void testEmployeeByIdWithException(){
         when(repo.findById(1002)).thenThrow(EmployeeNotFoundException.class);
         assertThrows(EmployeeNotFoundException.class,()->service.getEmployee(1002));
     }

     @Test
     void testGetAllEmployee(){
          EmployeeDTO e1 = new EmployeeDTO(101,"sakshi",LocalDate.of(2001,4,3),50000);
          EmployeeDTO e2 = new EmployeeDTO(102,"Rohan",LocalDate.of(2004,11,2),60000);

          List<Employee> elst = new ArrayList<>();
          elst.add(EntityMapper.convertObjectToEntity(e1));
          elst.add(EntityMapper.convertObjectToEntity(e2));
          when(repo.findAll()).thenReturn(elst);

          assertEquals(2,service.getAllEmployee().size());
     }
     @Test
     void testCreateEmployee(){
         EmployeeDTO dto = new EmployeeDTO("sakshi", LocalDate.of(2001, 4, 3), 50000);
         dto.setEmployeeId(101);

         Employee e1 = EntityMapper.convertObjectToEntity(dto);

         when(repo.saveAndFlush(any(Employee.class))).thenReturn(e1);


         assertEquals(e1,service.createEmployee(dto));
     }

     @Test
     void testRemoveEmployee(){
         EmployeeDTO edto = new EmployeeDTO("sakshi", LocalDate.of(2001, 4, 3), 50000);
         edto.setEmployeeId(1011);
         Employee emp = EntityMapper.convertObjectToEntity(edto);
         emp.setEmpid(1011);
         when(repo.findById(1011)).thenReturn(Optional.of(emp));



         assertEquals(emp,service.removeEmployee(1011));
         verify(repo).findById(1011);
         verify(repo).deleteById(1011);
     }

     @Test
     void testUpdateEmployee(){
          Employee e = new Employee("Sakshi",LocalDate.of(2002,3,2),80000);
          e.setEmpid(1002);

          when(repo.findById(1002)).thenReturn(Optional.of(e));
          when(repo.saveAndFlush(e)).thenReturn(e);

          EmployeeDTO edto = new EmployeeDTO();
          edto.setEmployeeId(1002);
          edto.setFullName("Sakshi Kumari");

          assertEquals(e,service.updateEmployee(edto));



     }
//     @Test
     void testGetEmployeeByName(){
         Employee e1 = new Employee("Sumit",LocalDate.of(2005,4,11),80000);
         e1.setEmpid(143);
         Employee e2 = new Employee("Sumit Kr",LocalDate.of(2003,12,11),76000);
         e1.setEmpid(144);

         List<Employee> emps = new ArrayList<>();
         emps.add(e1);
         emps.add(e2);



         when(repo.findByName("Sumit")).thenReturn(emps);
         assertEquals(2,service.getEmployeeByName("Sumit").size());



     }
}
