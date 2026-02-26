package InterestCalculator;

public class SBAccount extends Account{
    double interestRate;
    double amount;
    String type;
    SBAccount(){
    }
    public SBAccount(double amount, String type) {

        this.amount = amount;
        this.type = type;
    }
    @Override
    double calculateInterest(){
        if((type).equals("NRI")){
            return (this.amount*6)/100;
        }
        else{
            return (this.amount*4)/100;
        }
    }
}
