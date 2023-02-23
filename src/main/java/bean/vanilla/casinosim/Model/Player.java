package bean.vanilla.casinosim.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Balance balance;
    public Hand playerHand;

    public List<Card> Pokerhand;

    public Player(String name, double startingBalance) {
        this.name = name;
        this.balance = new Balance(startingBalance);
        playerHand = new Hand();
        Pokerhand = new ArrayList<>();
    }

    public String GetName() { return name; }
    public Balance GetBalance() { return balance; }

    public void AddToBalance(double amount) {
        balance.AddToBalance(amount);
    }
    public void LostPartBalance(double amount) {
        balance.LostPartBalance(amount);
    }

}
