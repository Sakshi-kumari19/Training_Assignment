package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class JKTyre implements ITyre{
    @Override
    public String getTyreDetail(){
        return "JK Tyre";
    }
}
