package com.cg.bean;

import java.util.List;
import java.util.Set;

public class HelloWorld {
    private String name;
    private List<String> language;

//    public String sayHello(String name) {
//        return "Hello " + name+"!";
//    }



    public String sayHello(){
        return "Hello "+name.toUpperCase()+"!";
    }

//    for setter injection

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    //    for constructor injection
    public HelloWorld(){}
    public HelloWorld(String name){
        this.name=name;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }
}