package com.cg.main;

import com.cg.bean.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //xml based conf.
        //class path - src folder
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld h = (HelloWorld)ctx.getBean("hello");
        HelloWorld g = (HelloWorld)ctx.getBean("hello");



        System.out.println(h.hello());
//        System.out.println(g.hello());
//        System.out.println(h==g);
        System.out.println(h.getLanguage());

        ((ClassPathXmlApplicationContext)ctx).close();

    }
}
