package com.cg.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

//@Entity
//@DiscriminatorValue("Permanent_Employee")
public class PEmployee extends Employee {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
