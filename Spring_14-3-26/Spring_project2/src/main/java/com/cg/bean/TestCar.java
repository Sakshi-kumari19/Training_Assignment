package com.cg.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Car car = (Car) ctx.getBean("car");
        car.printCar();
    }
}
