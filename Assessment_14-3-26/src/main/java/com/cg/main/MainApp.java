package com.cg.main;

import com.cg.bean.Librarian;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Librarian lib = (Librarian)ctx.getBean("lib");
        lib.issueBook();

    }
}
