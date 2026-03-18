package com.cg.main;

import com.cg.bean.HelloWorld;
import com.cg.cfg.MyConfig;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
    public static void main(String[] args) {
        // ApplicationContext is a child of BeanFactory and it has a wider scope than beanFactory and these are the two ways to initialize the IOC container
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //BeanFactory context=new ClassPathXmlApplicationContext("bean.xml");

        HelloWorld h=(HelloWorld)context.getBean("h");
        System.out.println(h.sayHello());

      //Another way to call when we don't have id
        HelloWorld h2=context.getBean(HelloWorld.class);
        System.out.println(h2.sayHello());

        System.out.println(h==h2);    // if we dont use the scope annotation in the MyConfig then it will give true
    }
}