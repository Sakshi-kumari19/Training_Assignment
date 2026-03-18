package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {
    //@Value("${carname}")  // look for the carname and assign it into name (${carname}-->This is Spring  Expression Language->SPEL)
    private String name;
    @Autowired
//    @Qualifier("CNGEngine")  // // either we can make use of class name or can also give the id in the Component annotation
    //here the class name is not written with good naming convention therefore i am using "CNGEngine" but usually it takes first letter in smallCase
    @Qualifier("cng")
    private IEngine engine;

    @Autowired
    @Qualifier("jk")
    //@Qualifier("JKTyre")
    private ITyre tyre;

    public Car(){}
    public Car(IEngine engine, ITyre tyre){
        super();
        this.engine = engine;
        this.tyre = tyre;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IEngine getEngine() {
        return engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
    }

    public ITyre getTyre() {
        return tyre;
    }

    public void setTyre(ITyre tyre) {
        this.tyre = tyre;
    }

    public void printCar(){
        System.out.println("Car name: " + this.getName());
        System.out.println("BHP: "+engine.getBHP() );
        System.out.println("Tyre: " +tyre.getTyreDetail() );
    }
}
