package com.cg.main;

import com.cg.bean.Employee;
import com.cg.cfg.MyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Employee e=(Employee)context.getBean("emp");
        e.printEmployeeDetails();
    }
}