package cg;

public class Calculator {
    public int calc(int a, int b){
        return a+b;
    }
    public boolean isPrime(int n){
        if(n<=1)
            return false;
        for(int i=2;i<n;i++){
            if (n%i==0)
                return false;}
        return true;
    }
}
