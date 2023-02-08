package bean.vanilla.casinosim.Model;

public class Balance {
    private double StartingBalance;

    public Balance(double startingBalance) {
        this.StartingBalance = startingBalance;
    }

    public double getStartingBalance() {
        return StartingBalance;
    }

    public void setStartingBalance(double startingBalance) {
        StartingBalance = startingBalance;
    }

    public double addToBalance(double MoneyWon){
        return StartingBalance += MoneyWon;
    }

    public double LostPartBalance(double MoneyLost) {
        return StartingBalance -= MoneyLost;
    }

}
