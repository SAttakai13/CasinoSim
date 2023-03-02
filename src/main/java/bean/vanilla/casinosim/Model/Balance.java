package bean.vanilla.casinosim.Model;

public class Balance {
    private double Balance;

    public Balance(double startingBalance) { this.Balance = startingBalance; }

    public double GetBalance() {
        return Balance;
    }

    public void SetBalance(double balance) {
        Balance = balance;
    }

    public double AddToBalance(double MoneyWon){
        return Balance += MoneyWon;
    }

    public double LostPartBalance(double MoneyLost) {
        Balance -= MoneyLost;
        if (Balance < 0.0) Balance = 0.0;
        return Balance;
    }

}
