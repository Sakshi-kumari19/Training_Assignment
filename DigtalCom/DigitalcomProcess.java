package DigtalCom;

import java.util.Scanner;

public class DigitalcomProcess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User obj = new User();
        String user,pass,author;
        GameService g = new GameService();

        int input;

        while(true){

            System.out.println("--------MAIN MENU-----------");
            System.out.println("1) RegisterUser");
            System.out.println("2) ViewGames");
            System.out.println("3) searchByName");
            System.out.println("4) Exit");

            System.out.println("Enter you choice : ");
            input = sc.nextInt();

            switch(input){
                case 1:
                    System.out.println("Enter user id : ");
                    user = sc.next();
                    System.out.println("Enter password : ");
                    pass = sc.next();

                    obj.addUser(user,pass);
                    System.out.println("Account created");
                    break;

                case 2:
                    System.out.println("Enter user id : ");
                    user = sc.next();
                    System.out.println("Enter password : ");
                    pass = sc.next();
                    if(obj.IsAuthenticated(user,pass)){
                        g.ViewAll().forEach(gs-> System.out.println(gs));
                    }
                    else{
                        System.out.println("Login failed");
                    }
                    break;
                case 3:
                    System.out.println("Enter user id : ");
                    user = sc.next();
                    System.out.println("Enter password : ");
                    pass = sc.next();
                    if(obj.IsAuthenticated(user,pass)){
                        System.out.println("Enter author name");
                        author = sc.next();
                        g.authorSearch(author);
                    }
                    else{
                        System.out.println("login failed");
                    }
                    break;
                case 4:
                    return;
            }
        }


    }
}
