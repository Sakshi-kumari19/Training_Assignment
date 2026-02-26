package InterestCalculator;

public class RDAccount extends Account{
    double interestRate;
    double amount;
    int noOfMonths;
    double monthlyAmount;
    int ageOfACHolder;

    public RDAccount(double monthlyAmount, int noOfMonths, int ageOfACHolder) {
        this.monthlyAmount = monthlyAmount;
        this.amount = monthlyAmount * noOfMonths;
        this.noOfMonths = noOfMonths;
        this.ageOfACHolder = ageOfACHolder;
    }

    @Override
    double calculateInterest(){
        boolean isSenior = ageOfACHolder >= 60;
        switch (noOfMonths) {

            case 6:
                interestRate = isSenior ? 8.00 : 7.50;
                break;

            case 9:
                interestRate = isSenior ? 8.25 : 7.75;
                break;

            case 12:
                interestRate = isSenior ? 8.50 : 8.00;
                break;

            case 15:
                interestRate = isSenior ? 8.75 : 8.25;
                break;

            case 18:
                interestRate = isSenior ? 9.00 : 8.50;
                break;

            case 21:
                interestRate = isSenior ? 9.25 : 8.75;
                break;

            default:
                System.out.println("Invalid number of months.");
                return 0;
        }

        return (amount * interestRate) / 100;
    }
}
