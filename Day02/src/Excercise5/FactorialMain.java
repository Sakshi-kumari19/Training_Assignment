package Excercise5;

public class FactorialMain {
    public static void main(String[] args) {
        IFactorial fact = new FactorialCalc()::calFactorial;
        System.out.println("Factorial of 6 is: "+fact.factorial(6));
    }
}
