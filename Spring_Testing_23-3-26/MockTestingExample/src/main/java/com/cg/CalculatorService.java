package com.cg;

public class CalculatorService {
    private ICalculator cal;

    public CalculatorService(ICalculator cal) {
        this.cal = cal;
    }

//    public CalculatorService() {
//    }

    //this method is a business requirement method
    public int addService(int x,int y){
        return cal.calculate(x,y);
    }
}
