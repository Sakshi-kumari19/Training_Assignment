package Excercise3;

public class Validate {
    public static void main(String[] args) {
        IAuthenticate check = (u,p)->{
            String user = "sakshi";
            String pass = "1234";

            if(u.equals(user) && p.equals(pass))
                return true;
            else
                return false;
        };
        System.out.println(check.login("sakshi","1234"));
    }
}
