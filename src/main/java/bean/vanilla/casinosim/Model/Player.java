package bean.vanilla.casinosim.Model;

public class Player {
    private String Name;
    //public boolean isPlayerTurn;
    private double money;
    public int PlayerPos;
    public Hand PlayerHand;



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Player(int playerPos) {
        PlayerHand = new Hand();
        this.PlayerPos = playerPos;
        Name = "Player " + (playerPos+1);
        money = 1500.0;
    }

    public Player(String name, double money, int playerPos) {
        Name = name;
        //this.isPlayerTurn = isPlayerTurn;
        this.money = money;
        PlayerPos = playerPos;
        PlayerHand = new Hand();
    }

    public void AddToHand(Card card) {
        PlayerHand.addToHand(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "Name='" + Name + '\'' +
                ", money=" + money +
                ", PlayerPos=" + PlayerPos +
                ", PlayerHand=" + PlayerHand +
                '}';
    }
}
