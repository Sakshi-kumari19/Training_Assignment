package com.cg.main;

import com.cg.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        this is without using spring framework....

//        HelloWorld h = new HelloWorld();
//        System.out.println(h.sayHello("Pragya"));


//        this is using spring framework

//        class path-> source folder
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        HelloWorld  h1=(HelloWorld)context.getBean("hello");
        HelloWorld  h2=(HelloWorld)context.getBean("hello");
//
//
//        System.out.println(h1.sayHello("Pragya"));
//        System.out.println(h2.sayHello("Aniket"));
//
//        System.out.println(h1);
//        System.out.println(h2);
//        System.out.println(h1==h2);

//        h1.setName("pragya");
        System.out.println(h1.sayHello());
        System.out.println(h2.sayHello());
        System.out.println(h1==h2);

        System.out.println(h1.sayHello());
        System.out.println("--------languages--------");
        System.out.println(h1.getLanguage());
        ((ClassPathXmlApplicationContext)context).close();

    }
}