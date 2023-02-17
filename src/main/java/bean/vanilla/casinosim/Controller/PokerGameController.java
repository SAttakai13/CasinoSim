package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Hand;
import bean.vanilla.casinosim.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PokerGameController implements Initializable {
    @FXML
    private Pane pane;

    @FXML
    private Text BetText;
    @FXML
    private Text BalText;

    private Color deckColor = Color.GREEN;

    private double initialBet;
    private Deck deck;
    private Card card;

    private Player Dealer;
    private double betAmount = 50.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new Deck(Color.RED);

        CasinoApplication.player.playerHand.resetHand();
        CasinoApplication.player.playerHand.SetPosition(497, 416);
        CasinoApplication.player.playerHand.Scale(1.0/3.0);

        pane.getChildren().addAll(CasinoApplication.player.playerHand);
        deck = new Deck(deckColor);
        DealCards();

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    private void NewRound(){

    }

    public void cardExchange(int CardIndex){
        CasinoApplication.player.playerHand.RemoveCard(CardIndex);
        deck.DealCard(CasinoApplication.player);

    }


    private void DealCards(){
        if (deck == null || Dealer == null ) return;
        for (int i = 0; i < 5; i++) {
            deck.DealCard(CasinoApplication.player);
        }
    }

    public void Raise(MouseEvent event) {
        betAmount += 50 * 2;
    }
    public void Call(MouseEvent event) {
        betAmount += 50;
    }
    public void Fold(MouseEvent event) {

    }

    public void DetermineWinner() {
        String bannerMessage = "";

        
    }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void updateBetsAndBalance(double bets, double playerBalance){
        BetText.setLayoutX(914.0);
        BetText.setLayoutY(794.0);

        BalText.setLayoutX(860.0);
        BalText.setLayoutY(836.0);

        BetText.setText("Bet: " + bets);
        BalText.setText("Balance: " + playerBalance);
    }


    public void DecreaseBet(MouseEvent event) {
        betAmount -= 50;
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void IncreaseBet(MouseEvent event) {
        betAmount += 50;
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }
}
