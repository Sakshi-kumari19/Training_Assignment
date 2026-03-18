package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
    private int empid;
    private String name;
    private Address address;

    public Employee(){}
    public Employee(Address address) {
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

    public void printEmployeeDetails(){
        System.out.println("Employee Id: "+empid);
        System.out.println("Name: "+name);
        System.out.println("---------address--------");
        System.out.println("city: "+address.getCity());
        System.out.println("country: "+address.getCountry());
        System.out.println("zip: "+address.getZip());
    }
}