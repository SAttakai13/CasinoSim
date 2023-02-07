package bean.vanilla.casinosim.Model;

public class Player {

    private String name;
    //private Balance balance;
    //public Hand playerHand;

    public Player(String name, double startingBalance) {
        this.name = name;
        //balance = new Balance(startingBalance);
        //playerHand = new Hand();
    }

    public String GetName() { return name; }
    //public Balance GetBalance() { return balance; }

}
