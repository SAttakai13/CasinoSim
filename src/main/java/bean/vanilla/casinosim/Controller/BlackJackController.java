package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.lang.annotation.Inherited;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BlackJackController implements Initializable {

    @FXML
    private Pane GameScreenPane;
    @FXML
    private Button btnDoubleDown;
    @FXML
    private GridPane PlayerGrid;
    @FXML
    private Label DealerMoney;

    private double betAmount = 50;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SetupTable(4);

        NewRound();
    }

    int playerTurn;
    Player dealer;
    Deck deck = new Deck();
    ArrayList<Player> Players = new ArrayList<>();

    ArrayList<Label> PlayerLabels = new ArrayList<>();



    public void SetupTable(int numOfPlayers){
        playerTurn = 0;

        dealer = new Player(numOfPlayers);

        betAmount = PlayerScreenController.setBetAmount;

        dealer.PlayerHand.setMaxWidth(100);
        dealer.PlayerHand.setMaxHeight(100);

        PlayerLabels.clear();

        for (int i=0; i < numOfPlayers; i++){
            PlayerLabels.add(new Label());
            Player p = new Player(PlayerScreenController.playerNames[i], 1500.0, i);
            p.PlayerHand.setMaxWidth(100);
            p.PlayerHand.setMaxHeight(100);
            Players.add(p);
            PlayerGrid.add(PlayerLabels.get(i), i,0);

            if (i == 0)
                PlayerLabels.get(i).setTextFill(Color.RED);
            else
                PlayerLabels.get(i).setTextFill(Color.WHITE);

            PlayerLabels.get(i).setFont(new Font("Cambria", 24));
            PlayerLabels.get(i).setText(p.getName() + " $" + p.getMoney());
        }


        UpdateScreen();
    }

    public void DealCardsToHands(int numOfPlayers){
        for (int i=0; i<2; i++){
            for(int j=0; j<numOfPlayers; j++){
                deck.HitCard(Players.get(j));

            }
            deck.HitCard(dealer);
        }
    }

    public void UpdateScreen(){
        DealerMoney.setTextFill(Color.WHITE);
        DealerMoney.setFont(new Font("Cambria", 24));
        DealerMoney.setText("$" + dealer.getMoney());
        DealerMoney.setLayoutX(350);
        DealerMoney.setLayoutY(220);
        dealer.PlayerHand.setLayoutY(0);
        dealer.PlayerHand.setLayoutX(350);
        GameScreenPane.getChildren().add(dealer.PlayerHand);


        for (int i=0; i < Players.size(); i++) {
            PlayerGrid.add(Players.get(i).PlayerHand, i, 1);
        }
    }

    @FXML
    public void Hit(ActionEvent Hit)
    {
        deck.HitCard(Players.get(playerTurn));
        btnDoubleDown.setDisable(true);
        if (Players.get(playerTurn).PlayerHand.Points() > 21)
            IncrementPlayerTurn();
    }
    @FXML
    private void Stay(ActionEvent Stay)
    {
        IncrementPlayerTurn();
    }
    @FXML
    private void DoubleDown(ActionEvent DoubleDown)
    {
        Players.get(playerTurn).setMoney(Players.get(playerTurn).getMoney() - betAmount);
        dealer.setMoney(dealer.getMoney() + betAmount);

        deck.HitCard(Players.get(playerTurn));
        IncrementPlayerTurn();

        UpdateLabels();
    }


    public void IncrementPlayerTurn() {
        playerTurn = (playerTurn + 1) % (Players.size()+1);

        if (playerTurn == Players.size()) {
            HouseTurn();

            DetermineWinner();
        }

        btnDoubleDown.setDisable(false);


        PlayerLabels.get(playerTurn).setTextFill(Color.RED);
        for (int i = 0; i < PlayerLabels.size(); i++) {
            if (i != playerTurn)
                PlayerLabels.get(i).setTextFill(Color.WHITE);
        }
    }

    public void HouseTurn() {
        if (dealer.PlayerHand.Points() < 17)
            deck.HitCard(dealer);
        IncrementPlayerTurn();
    }

    public void NewRound(){
        dealer.PlayerHand.resetHand();
        for (Player player : Players) {
            player.PlayerHand.resetHand();
        }
        playerTurn = 0;
        deck.Clear();
        deck.FillDeck();
        deck.Shuffle();
        DealCardsToHands(Players.size());

        SetBets();


    }

    public void BackToTitle(ActionEvent actionEvent) {
        HelloApplication.setRoot("BlackJackTitleScreen");
    }

    public void SetBets() {
        dealer.setMoney(dealer.getMoney()+ betAmount);
        for (Player p : Players) {
            p.setMoney(p.getMoney() - betAmount);
        }
        UpdateLabels();
    }

    public void UpdateLabels() {
        for (int i = 0; i < Players.size(); i++) {
            if(PlayerGrid.getChildren().get(i) instanceof Label) {
                ((Label)PlayerGrid.getChildren().get(i)).setText(Players.get(i).getName() + " $" + Players.get(i).getMoney());
            }
        }
        DealerMoney.setText("$" + dealer.getMoney());
    }

    public void DetermineWinner() {
        int dealerPoints = dealer.PlayerHand.Points();

        //if dealer busts all players win
        if (dealerPoints > 21) {
            for (Player player : Players) {
                player.setMoney(player.getMoney() + betAmount * 2);
                dealer.setMoney(dealer.getMoney() - betAmount * 2);
            }
            NewRound();
        }
        else {
            for (Player player : Players) {
                int points = player.PlayerHand.Points();

                if (points == dealerPoints) {
                    //tied
                    System.out.println(player.getName() + " Tied with the Dealer!");

                    player.setMoney(player.getMoney() + betAmount);
                    dealer.setMoney(dealer.getMoney() - betAmount);

                    //Return bets
                }else if (points <= 21 && points > dealerPoints) {
                    //WIN
                    System.out.println(player.getName() + " : "+ points + " wins! Against Dealer: "+dealerPoints);

                    player.setMoney(player.getMoney() + betAmount * 2);
                    dealer.setMoney(dealer.getMoney() - betAmount * 2);

                    //Adjust balance
                } else {
                    //Lose
                    System.out.println(player.getName() + " Lost! Against Dealer: "+dealerPoints);
                }
            }
            NewRound();
        }
    }

}
