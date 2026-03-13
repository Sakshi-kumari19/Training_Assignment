package com.cg.bean;

import java.util.List;
import java.util.Set;

public class HelloWorld {
    private String name;
    private Set<String> language;

//    public HelloWorld(){}
//    public HelloWorld(String name) {
//        this.name = name;
//    }


    public void setName(String name) {
        this.name = name;
    }
    public String hello() {
        return "Hello "+name.toUpperCase()+" !";
    }

    public Set<String> getLanguage() {
        return language;
    }

    public void setLanguage(Set<String> language) {
        this.language = language;
    }


}
