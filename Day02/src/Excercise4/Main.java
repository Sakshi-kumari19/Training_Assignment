package Excercise4;

public class Main {
    public static void main(String[] args) {
             IEmployee emp = new CreateObject()::create;
             Employee e = emp.createinstance();
             if(e!=null)
                 System.out.println("Employee Created using method reference");
             else
                 System.out.println("Employee not created");
    }
}
