package com.cg;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    //In Real-time we dont test controller here, it is done using Postman & Swagger
    //Method of Junit testing should be default (good code quality) not pub or pvt.
    @Autowired
    private MockMvc mockMvc; //mapping will be passed
    @MockitoBean  //it will check with real DB
    private IEmployeeService service;

    @Test
    void getEmployeeById() throws Exception {
        EmployeeDTO edto = new EmployeeDTO(102,"Tanisha", LocalDate.of(2001,4,3),9000);
        when(service.getEmployee(102)).thenReturn(edto);

        mockMvc.perform(get("/api/employee/102")).andExpect(status().isOk()).andExpect(jsonPath("$.fullName").value("Tanisha"));

    }

    @Test
    void getAllEmployee() throws Exception{
        EmployeeDTO edto = new EmployeeDTO(102,"Tanisha", LocalDate.of(2001,4,3),9000);
        EmployeeDTO edto2 = new EmployeeDTO(103,"Saanvi", LocalDate.of(2004,4,13),8000);

        List<EmployeeDTO> empl = new ArrayList<>();
        empl.add(edto);
        empl.add(edto);
        when(service.getAllEmployee()).thenReturn(empl);
        mockMvc.perform(get("/api/employee")).andExpect(status().isOk()).andExpect(jsonPath("$[1].fullName").value("Tanisha"));

    }

    @Test
    void getEmployeeByName() throws Exception {
        EmployeeDTO edto = new EmployeeDTO(102,"Tanisha", LocalDate.of(2001,4,3),9000);
        EmployeeDTO edto2 = new EmployeeDTO(103,"Tanish kumari", LocalDate.of(2004,4,13),8000);

        List<EmployeeDTO> empl = new ArrayList<>();
        empl.add(edto);
        empl.add(edto);
        when(service.getEmployeeByName("Tanisha")).thenReturn(empl);

        mockMvc.perform(get("/api/employee/name/Tanisha")).andExpect(status().isOk()).andExpect(jsonPath("$[1].fullName").value("Tanisha"));

    }
    @Test
    void createEmployee() throws Exception{
        EmployeeDTO dto = new EmployeeDTO("sakshi", LocalDate.of(2001,4,3),50000);
        dto.setEmployeeId(101);
        Employee e = EntityMapper.convertObjectToEntity(dto);
        when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(e);

        mockMvc.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON).content(
                """
            {
                "fullName":"sakshi",
                "dateOfBirth":"03-Apr-2001",
                "salary":50000
            }
        """
        )).andExpect(status().isOk());
    }


    @Test
    void updateEmployee() throws Exception {
         Employee e = new Employee("Sakshi",LocalDate.of(2003,5,11),80000);
         e.setEmpid(1001);

         when(service.updateEmployee(any(EmployeeDTO.class))).thenReturn(e);
         mockMvc.perform(put("/api/employee").contentType(MediaType.APPLICATION_JSON).content(
                 """
            {   "employeeId":"1001",
                "fullName":"Sakshi",
                "dateOfBirth":"11-May-2003",
                "salary":80000
            }
        """
         )).andExpect(status().isOk());

    }

    @Test
    void testDeleteEmployee() throws Exception {
        EmployeeDTO dto = new EmployeeDTO("sakshi", LocalDate.of(2001,4,3),50000);
        dto.setEmployeeId(101);
        when(service.removeEmployee(101)).thenReturn(EntityMapper.convertObjectToEntity(dto));
        mockMvc.perform(delete("/api/employee/id/101")).andExpect(status().isOk());

    }
}
