package com.cg.cfg;

import com.cg.bean.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
    @Bean("h")
    @Scope("prototype")
    public HelloWorld getBean(){
        HelloWorld hello=new HelloWorld();
        hello.setName("Sakshi");
        return hello;
    }
}