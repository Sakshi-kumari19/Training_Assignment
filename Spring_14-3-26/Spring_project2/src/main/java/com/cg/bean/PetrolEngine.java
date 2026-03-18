package com.cg.bean;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements IEngine{
    @Override
    public String getBHP(){
        return "Petrol Engine with 150 BHP";
    }
}
