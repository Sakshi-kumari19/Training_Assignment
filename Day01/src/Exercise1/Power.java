package Exercise1;
//Q1. Lambda expression which accepts x and y numbers and return x^y.
public class Power {
    public static void main(String[] args) {
    IPower p = (x,y)->{
            return (int)Math.pow(x,y);
        };
        System.out.println(p.calc(2,4));

    }
}
