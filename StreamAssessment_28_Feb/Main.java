package com.labs.StreamAssessment_28_Feb;

import com.labs.StreamAssessment_28_Feb.EmployeeService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        System.out.println(es.totalSalPerDept());
        System.out.println(es.empWithMaxSalInEachDept());
        System.out.println(es.avgSalary());
        System.out.println(es.empAndSalary());
        System.out.println(es.salByDesc());
    }

}