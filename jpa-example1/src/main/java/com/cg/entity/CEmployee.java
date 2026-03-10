package com.cg.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

//@Entity
//@DiscriminatorValue("Contract_Employee")
public class CEmployee extends Employee{
    private double pay_per_hour;

    public double getPay_per_hour() {
        return pay_per_hour;
    }

    public void setPay_per_hour(double pay_per_hour) {
        this.pay_per_hour = pay_per_hour;
    }
}
