package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private int empid;
    private String name;
    @Autowired
    @Qualifier("address")
    private Address address;

    public Employee(){}

    public Employee(int empid, String name, Address address) {
        this.empid = empid;
        this.name = name;
        this.address = address;
    }


    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void printdetails(){
        System.out.println("Emp id: "+empid);
        System.out.println("Emp name : "+name);
        System.out.println("Emp Address");
        System.out.println("city: "+address.getCity());
        System.out.println("country: "+address.getCountry());
        System.out.println("zip: "+address.getZip());
    }
}
