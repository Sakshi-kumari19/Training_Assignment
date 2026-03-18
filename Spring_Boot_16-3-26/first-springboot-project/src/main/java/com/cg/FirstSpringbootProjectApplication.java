package com.cg; //com.cg is treated as root package

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

//below annotation provides auto config
@SpringBootApplication
//@ComponentScan("com")
@PropertySource("classpath:data.properties")
public class FirstSpringbootProjectApplication {

    public static void main(String[] args) {
        //below line is initialising the IOC container , .run() return ApplCationContest
        ApplicationContext ctx = SpringApplication.run(FirstSpringbootProjectApplication.class, args);

        //it will scan root package and its child packages , if required file not in root package then use ComponentScan
        HelloWorld h = ctx.getBean(HelloWorld.class);
        System.out.println(h.sayHello("Sakshi"));


        Employee e = ctx.getBean(Employee.class);
        e.printEmployeeDetails();

    }

}
