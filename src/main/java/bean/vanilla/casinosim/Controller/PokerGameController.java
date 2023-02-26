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

    private Deck deck;
    private double betAmount = 50.0;

    private double PlayerPosY = 436.0;

    private ArrayList<Double> PlayerPosX = new ArrayList<>();

    private int CardIndexToExchange = 0;

    //Array of set position x values;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BetText.setText("Bet: " + betAmount);
        BalText.setText("Balance: " + CasinoApplication.player.GetBalance().GetBalance());

        PlayerPosX.add(88.0);
        PlayerPosX.add(318.0);
        PlayerPosX.add(547.0);
        PlayerPosX.add(775.0);
        PlayerPosX.add(1005.0);


        CasinoApplication.player.Pokerhand.clear();
        deck = new Deck(deckColor, 0.4);
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

        CasinoApplication.player.Pokerhand.get(0).SetPosition(PlayerPosX.get(0), PlayerPosY);
        CasinoApplication.player.Pokerhand.get(1).SetPosition(PlayerPosX.get(1), PlayerPosY);
        CasinoApplication.player.Pokerhand.get(2).SetPosition(PlayerPosX.get(2), PlayerPosY);
        CasinoApplication.player.Pokerhand.get(3).SetPosition(PlayerPosX.get(3), PlayerPosY);
        CasinoApplication.player.Pokerhand.get(4).SetPosition(PlayerPosX.get(4), PlayerPosY);

        pane.getChildren().addAll(CasinoApplication.player.Pokerhand);

    }

    private void NewRound(){
        buttonsDisabled = false;
        for (int i = 0; i < CasinoApplication.player.Pokerhand.size(); i++){
            pane.getChildren().remove(CasinoApplication.player.Pokerhand.get(i));
        }
        CasinoApplication.player.Pokerhand.clear();
        deck = new Deck(deckColor, 0.4);
        DealCards();
    }

    public void ExchangeCard() {
        pane.getChildren().remove(CasinoApplication.player.Pokerhand.get(CardIndexToExchange));
        Card card = deck.TakeTopCard();
        card.SetPosition(PlayerPosX.get(CardIndexToExchange), PlayerPosY);
        CasinoApplication.player.Pokerhand.set(CardIndexToExchange, card);
        pane.getChildren().add(card);
    }



    public void DetermineWinner() {
        String bannerMessage = "";
        PokerHandComparisionClass hands = new PokerHandComparisionClass();
        hands.CheckGroupsAndPairs(CasinoApplication.player.Pokerhand);
        System.out.println(hands.Highcard);
        System.out.println(hands.NumOfPairs);

        if ((hands.CheckRoyalFlush(CasinoApplication.player.Pokerhand)) == true) {
            CasinoApplication.player.AddToBalance(betAmount * 5);
            bannerMessage = CasinoApplication.player.GetName() + " won by a royal flush!";
        } else if ((hands.CheckStraightFlush(CasinoApplication.player.Pokerhand)) == true) {
            CasinoApplication.player.AddToBalance(betAmount * 4);
            bannerMessage = CasinoApplication.player.GetName() + " won by a straight flush!";
        } else if ((hands.FourOfKind == true)) {
            CasinoApplication.player.AddToBalance(betAmount * 2);
            bannerMessage = CasinoApplication.player.GetName() + " won by four of a kind!";
        } else if (hands.ThreeOfKind == true && hands.NumOfPairs == 1) {
            CasinoApplication.player.AddToBalance(betAmount * 2);
            bannerMessage = CasinoApplication.player.GetName() + " won by a full house!";
        } else if (hands.CheckFlush((CasinoApplication.player.Pokerhand)) == true) {
            CasinoApplication.player.AddToBalance(betAmount + 100);
            bannerMessage = CasinoApplication.player.GetName() + " won by a flush!";
        } else if ((hands.CheckStraight(CasinoApplication.player.Pokerhand)) == true) {
            CasinoApplication.player.AddToBalance(betAmount + 100);
            bannerMessage = CasinoApplication.player.GetName() + " won by a Straight!";
        } else if (hands.ThreeOfKind == true) {
            CasinoApplication.player.AddToBalance(betAmount + 75);
            bannerMessage = CasinoApplication.player.GetName() + " won by three of a kind!";
        } else if (hands.NumOfPairs == 2) {
            CasinoApplication.player.AddToBalance(betAmount + 50);
            bannerMessage = CasinoApplication.player.GetName() + " won by two pairs!";
        } else if (hands.NumOfPairs == 1){
            CasinoApplication.player.AddToBalance(betAmount + 25);
            bannerMessage = CasinoApplication.player.GetName() + " won by one pair!";
        } else if (hands.Highcard == 5){
            CasinoApplication.player.LostPartBalance(betAmount);
            bannerMessage = "You lose by high card";
        }

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());

        bannerText.setText(bannerMessage);
        bannerPane.setVisible(true);
        buttonsDisabled = true;
    }



    public void Raise(MouseEvent event) {
        if (!buttonsDisabled) {
            betAmount += betAmount * 2;
            DetermineWinner();
        }

    }
    public void Call(MouseEvent event) {
        if (!buttonsDisabled) {
            DetermineWinner();
        }
    }

    public void Fold(MouseEvent event) {
        if (!buttonsDisabled) {
            CasinoApplication.player.LostPartBalance(betAmount);
            bannerText.setText("You lose, play again?");
            bannerPane.setVisible(true);
            buttonsDisabled = true;
        }
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


    public void ExchangeCard3(MouseEvent event) {
        CardIndexToExchange = 2;
        ExchangeCard();
    }

    public void ExchangeCard1(MouseEvent event) {
        CardIndexToExchange = 0;
        ExchangeCard();
    }

    public void ExchangeCard2(MouseEvent event) {
        CardIndexToExchange = 1;
        ExchangeCard();
    }

    public void ExchangeCard4(MouseEvent event) {
        CardIndexToExchange = 3;
        ExchangeCard();
    }

    public void ExchangeCard5(MouseEvent event) {
        CardIndexToExchange = 4;
        ExchangeCard();
    }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void NewGameBtnPressed(ActionEvent actionEvent) {
        bannerPane.setVisible(false);
        NewRound();
    }
}
