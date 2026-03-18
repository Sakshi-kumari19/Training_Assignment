package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class MrfTyre implements ITyre{
    @Override
    public String getTyreDetail(){
        return "MRF Tyre";
    }
}
