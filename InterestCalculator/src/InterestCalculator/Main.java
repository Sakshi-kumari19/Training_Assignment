package InterestCalculator;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvalidValueException {
        Scanner sc = new Scanner(System.in);
        int choice;
        double avgAmount,fdAmount,rdAmount,fdInterest;
        int days,age;
        String type;
        FDAccount fd;
        RDAccount rd;
        SBAccount sb;

        while(true){
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");

            System.out.println("Enter your choice");
            choice = sc.nextInt();


            switch (choice) {

                case 1:

                    System.out.println("Enter the Average amount in your account:");
                    avgAmount = sc.nextDouble();
                    System.out.println("Enter type of acc : ");
                    type = sc.next();

                    if (avgAmount < 0) {
                        throw new InvalidValueException("Amount Cannot be negative");
                    }

                    sb = new SBAccount(avgAmount,type);
                    double sbInterest = sb.calculateInterest();

                    System.out.println("Interest gained: Rs. " + sbInterest);
                    break;

                case 2:

                    System.out.println("Enter the FD amount:");
                    fdAmount = sc.nextDouble();

                    if (fdAmount < 0) {
                        throw new InvalidValueException("Amount Cannot be negative");
                    }
                    System.out.println("Enter the number of days:");
                    days = sc.nextInt();

                    if (days <= 0) {
                        throw new InvalidValueException("Days Cannot be negative");

                    }

                    if(fdAmount>=10000000){

                    System.out.println("Enter your age:");
                    age = sc.nextInt();

                        if (age < 0) {
                            throw new InvalidValueException("Age Cannot be negative");
                        }

                    fd = new FDAccount(fdAmount,days,age);
                    fdInterest = fd.calculateInterest();
                    }
                    else{
                        fd = new FDAccount(fdAmount,days);
                        fdInterest = fd.calculateInterest();

                    }

                    System.out.println("Interest gained is: " + fdInterest);
                    break;

                case 3:

                    System.out.println("Enter the RD monthly amount:");
                    rdAmount = sc.nextDouble();

                    System.out.println("Enter the number of months:");
                    int months = sc.nextInt();


                    System.out.println("Enter age : ");
                    age = sc.nextInt();

                    if (rdAmount < 0 || months <= 0) {
                        throw new InvalidValueException("Age Cannot be negative");
                    }

                    rd = new RDAccount(rdAmount,months,age);
                    double rdInterest = rd.calculateInterest();

                    System.out.println("Interest gained is: " + rdInterest);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Option");
            }

        }
    }
}