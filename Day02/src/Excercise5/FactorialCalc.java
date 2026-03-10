package Excercise5;

public class FactorialCalc {
    int n;
    public int calFactorial(int num){
        int result =1;
        for(int i=2;i<=num;i++){
            result*=i;
        }
        return result;
    }
}
