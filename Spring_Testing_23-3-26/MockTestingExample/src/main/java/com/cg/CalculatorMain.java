package com.cg;

public class CalculatorMain {
    public static void main(String[] args) {
//        CalculatorService cService = new CalculatorService();
//        //addService is return calculate method of interface, there is no implementation so it shows NullPointer exception
//        System.out.println(cService.addService(3,5));

          ICalculator c = (i,j)->i-j; //now the implementation is provided via Lambda expression.
          System.out.println(c.calculate(5,9));
    }
}
