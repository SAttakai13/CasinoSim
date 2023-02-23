package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PokerGameController implements Initializable {
    @FXML
    private Pane pane;

    @FXML
    private Text BetText;
    @FXML
    private Text BalText;

    @FXML
    private ImageView IncreaseBet;

    @FXML
    private ImageView DecreaseBet;

    @FXML
    private Pane bannerPane;
    @FXML
    private Text bannerText;

    private Color deckColor = Color.GREEN;

    private boolean buttonsDisabled = false;

    private double initialBet;
    private Deck deck;
    private double betAmount = 50.0;

    private double PlayerPosY = 416.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CasinoApplication.player.Pokerhand.get(0).SetPosition(197, PlayerPosY);
        CasinoApplication.player.Pokerhand.get(1).SetPosition(327, PlayerPosY);
        CasinoApplication.player.Pokerhand.get(2).SetPosition(497, PlayerPosY);
        CasinoApplication.player.Pokerhand.get(3).SetPosition(587, PlayerPosY);
        CasinoApplication.player.Pokerhand.get(4).SetPosition(657, PlayerPosY);



        pane.getChildren().addAll(CasinoApplication.player.Pokerhand);
        deck = new Deck(deckColor);
        DealCards();

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    private void DealCards(){
        if (deck == null) return;
        deck.DealCard(CasinoApplication.player.Pokerhand);
        deck.DealCard(CasinoApplication.player.Pokerhand);
        deck.DealCard(CasinoApplication.player.Pokerhand);
        deck.DealCard(CasinoApplication.player.Pokerhand);
        deck.DealCard(CasinoApplication.player.Pokerhand);
    }

    private void NewRound(){
        //buttonsDisabled = false;
        CasinoApplication.player.Pokerhand.clear();

        deck = new Deck(deckColor);
        DealCards();
    }

    private void EndRound(){
        DetermineWinner();
    }

    public void NewGameBtnPressed(ActionEvent actionEvent) {
        bannerPane.setVisible(false);
        NewRound();
    }

    public void DetermineWinner() {
        String bannerMessage = "";
        boolean GameWon = false;
        PokerHandComparisionClass hands = new PokerHandComparisionClass();
        hands.CheckGroupsAndPairs();
        int HandTypes = 0;
        switch (HandTypes){
            case 0:
                if ((hands.CheckRoyalFlush(CasinoApplication.player.Pokerhand)) == false){
                    HandTypes++;
                    break;
                } else {
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by a royal flush!";
                }
                break;
            case 1:
                //Straight flush (share same suit and in order.)
                if ((hands.CheckStraightFlush(CasinoApplication.player.Pokerhand)) == false){
                    HandTypes++;
                    break;
                } else {
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by a straight flush!";
                }
                break;
            case 2:
                //Four of a kind
                if (hands.FourOfKind == false){
                    HandTypes++;
                } else if (hands.FourOfKind == true){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by four of a kind!";
                }
                break;
            case 3:
                //Full house (three of a kind and a pair)
                if (hands.ThreeOfKind == false && hands.NumOfPairs != 1)  {
                    HandTypes++;
                } else if(hands.ThreeOfKind == true && hands.NumOfPairs == 1){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by a full house!";
                }
            case 4:
                //flush (This is to match all cards in hand have same suits)
                if (hands.CheckFlush((CasinoApplication.player.Pokerhand)) == false){
                    HandTypes++;
                    break;
                } else if (hands.CheckFlush((CasinoApplication.player.Pokerhand)) == true){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won!";
                }
            case 5:
                //Straight (to have the numbers in the hand in order)
                if ((hands.CheckStraight(CasinoApplication.player.Pokerhand)) == false){
                    HandTypes++;
                    break;
                } else if ((hands.CheckStraight(CasinoApplication.player.Pokerhand)) == true) {
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by a Straight!";
                }
            case 6:
                //three of a kind
                if (hands.ThreeOfKind == false){
                    HandTypes++;
                    break;
                } else if (hands.ThreeOfKind == true){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by three of a kind!";
                }
            case 7:
                //Pairs two and one
                if (hands.NumOfPairs == 2){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by two pairs!";
                } else if (hands.NumOfPairs == 1){
                    GameWon = true;
                    bannerMessage = CasinoApplication.player.GetName() + " won by one pair!";
                }else if (hands.NumOfPairs == 0){
                    HandTypes++;
                    break;
                }
            case 8:
                if (hands.Highcard == 5)
                    GameWon = false;

                break;

        }
        bannerText.setText(bannerMessage);
        bannerPane.setVisible(true);
        //buttonsDisabled = true;
    }

    public void ExchangeCard(MouseEvent event) {
        String CardIndexToRemove = event.getSource().toString();
        if (CardIndexToRemove.equals("btnPokerExchange1")) {
            CasinoApplication.player.Pokerhand.remove(0);
            deck.DealCard(CasinoApplication.player.Pokerhand);

        } else if (CardIndexToRemove.equals("btnPokerExchange2")) {
            CasinoApplication.player.Pokerhand.remove(1);
            deck.DealCard(CasinoApplication.player.Pokerhand);
        } else if (CardIndexToRemove.equals("btnPokerExchange3")) {
            CasinoApplication.player.Pokerhand.remove(2);
            deck.DealCard(CasinoApplication.player.Pokerhand);
        } else if (CardIndexToRemove.equals("btnPokerExchange4")) {
            CasinoApplication.player.Pokerhand.remove(3);
            deck.DealCard(CasinoApplication.player.Pokerhand);
        } else if (CardIndexToRemove.equals("btnPokerExchange5")) {
            CasinoApplication.player.Pokerhand.remove(4);
            deck.DealCard(CasinoApplication.player);
        }
    }

    public void Raise(MouseEvent event) {
        betAmount += betAmount * 2;
        DetermineWinner();
    }
    public void Call(MouseEvent event) {
        betAmount = betAmount;
        DetermineWinner();
    }

    public void Fold(MouseEvent event) {

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
        if (betAmount <= 0){
            DecreaseBet.setDisable(true);
            DecreaseBet.setOpacity(0.5);
            betAmount = 0;
        } else if (betAmount > 0){
            DecreaseBet.setDisable(false);
            betAmount -= 50;
            if (IncreaseBet.isDisable() == true){
                IncreaseBet.setDisable(false);
                IncreaseBet.setOpacity(1);
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void IncreaseBet(MouseEvent event) {
        if (betAmount >= CasinoApplication.player.GetBalance().GetBalance()){
            IncreaseBet.setDisable(true);
            IncreaseBet.setOpacity(0.5);
            betAmount = CasinoApplication.player.GetBalance().GetBalance();
        } else if (betAmount < CasinoApplication.player.GetBalance().GetBalance()){
            IncreaseBet.setDisable(false);
            betAmount += 50;
            if (DecreaseBet.isDisable() == true){
                DecreaseBet.setDisable(false);
                DecreaseBet.setOpacity(1);
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }



}
