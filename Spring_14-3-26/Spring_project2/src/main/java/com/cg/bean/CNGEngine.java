package com.cg.bean;

import org.springframework.stereotype.Component;

@Component("cng")
public class CNGEngine implements IEngine {
    @Override
    public String getBHP(){
                 return "CNG Engine with 110 BHP";
             }
}
