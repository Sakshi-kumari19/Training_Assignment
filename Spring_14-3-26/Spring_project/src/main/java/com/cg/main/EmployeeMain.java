package com.cg.main;

import com.cg.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

        //used for using xml based configuration
        //Employee e = (Employee) ctx.getBean("e");

        //used for Annotation based configuration
        Employee e = (Employee) ctx.getBean(Employee.class);
        e.printdetails();
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
