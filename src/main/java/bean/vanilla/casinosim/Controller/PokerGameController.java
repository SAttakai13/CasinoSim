package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.*;
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
        boolean GameWon = false;
        PokerHandComparisionClass hands = new PokerHandComparisionClass();
        hands.CheckGroupsAndPairs();
        int HandTypes = 0;
        switch (HandTypes){
            case 0:
                if ((hands.CheckRoyalFlush(CasinoApplication.player.playerHand)) == false){
                    HandTypes++;
                    break;
                } else {
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won!";
                }
                break;
            case 1:
                //Straight flush
                if ((hands.CheckStraightFlush(CasinoApplication.player.playerHand)) == false){
                    HandTypes++;
                    break;
                } else {
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won!";
                }
                break;
            case 2:
                //Four of a kind
                if (hands.FourOfKind == false){
                    HandTypes++;
                } else if (hands.FourOfKind == true){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won!";
                }
                break;
            case 3:
                //Full house
                if (hands.ThreeOfKind == false && hands.NumOfPairs != 1)  {
                    HandTypes++;
                } else if(hands.ThreeOfKind == true && hands.NumOfPairs == 1){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won!";
                }
            case 4:
//                if () {
//
//                } else if() {
//
//                }
            case 5:
//                if () {
//
//                } else if () {
//
//                }
            case 6:
//                if () {
//
//                } else if(){
//
//                }
            case 7:
//                if () {
//
//                } else if() {
//
//                }
            case 8:
//                if () {
//
//                } else if() {
//
//                }
            case 9:
//                if () {
//
//                } else if() {
//
//                }
        }
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
