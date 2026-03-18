package com.cg;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import com.cg.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringDataAppApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(SpringDataAppApplication.class, args);

//        IEmployeeRepo erepo = ctx.getBean(IEmployeeRepo.class);
//        erepo.save(new Employee("Sakshi", LocalDate.of(2002,4,1),60000));
//        System.out.println("Employee created...");

          EmployeeService es = ctx.getBean(EmployeeService.class);

          //CREATE EMPLOYEE
//          System.out.println(es.createEmployee(new Employee("Manish",LocalDate.of(2023,5,23),53000)));


          //GET ALL EMPLOYEE
        //es.getAllEmployee().forEach(e-> System.out.println(e));

        //READ OPERATION
//        System.out.println(es.getEmployee(52));

        //DELETE OPERATION
//        System.out.println(es.removeEmployee(52));


        //UPDATE OPERATION
//          Employee e = es.getEmployee(9);
//          if(e!=null){
//          e.setSalary(76000);
//          System.out.println(es.updateEmployee(e));
//          }
//          else {
//              System.out.println("Employee doesn't exist");
//          }


        //GET EMPLOYEE BY NAME
//        es.getEmployeeByName("Manish").forEach(e-> System.out.println(e));

        //GET EMPLOYE WHOSE SALARY IS LESS THAN 50000
//        es.getEmployeeBySalLessThan(50000).forEach(e-> System.out.println(e));

        //GET EMPLOYEE WHOSE DOB IS IN A PARTICULAR YEAR AND MONTH
        es.getEmployeeByDob(LocalDate.of(2003,1,1),LocalDate.of(2020,12,31)).forEach(e-> System.out.println(e));






    }

}
