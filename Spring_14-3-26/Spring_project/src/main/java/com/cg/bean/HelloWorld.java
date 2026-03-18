package com.cg.bean;

import java.util.List;
import java.util.Set;

public class HelloWorld {
    private String name;
    private Set<String> language;

    //for constructor injection
    public HelloWorld() {}
    public HelloWorld(String name, Set<String> language) {
        this.name = name;
        this.language = language;
    }

//    public HelloWorld(){}
//    public HelloWorld(String name) {
//        this.name = name;
//    }

    //for setter injection
    public void setName(String name) {
        this.name = name;
    }
    public void setLanguage(Set<String> language) {
        this.language = language;
    }
    public String hello() {
        return "Hello "+name.toUpperCase()+" !";
    }

    public Set<String> getLanguage() {
        return language;
    }



}
