package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGameController implements Initializable {

    @FXML
    private AnchorPane pane;

    private Player dealer;
    private Deck deck;
    private Color deckColor = Color.BLUE;

    private boolean isPlayersTurn;

    private double betAmount = 100.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dealer = new Player("Dealer", 10000.0);
        dealer.playerHand.SetPosition(200, 20);
        dealer.playerHand.Scale(1.0/3.0);

        CasinoApplication.player.playerHand.resetHand();
        CasinoApplication.player.playerHand.SetPosition(200, 300);
        CasinoApplication.player.playerHand.Scale(1.0/3.0);
        pane.getChildren().addAll(dealer.playerHand, CasinoApplication.player.playerHand);
        deck = new Deck(deckColor);
        DealCards();

        dealer.playerHand.FlipCard(0);

        isPlayersTurn = true;
    }

    private void HitCard(){
        deck.DealCard(CasinoApplication.player);
        EndPlayerTurn();
    }

    private void DoubleDown(){
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(CasinoApplication.player);
        EndPlayerTurn();
    }

    private void Stand(){
        EndPlayerTurn();
    }


    private void DealCards() {
        if (deck == null || dealer == null) return;
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);
    }

    private void ExchangeBet(Player sender, Player receiver) { ExchangeBet(sender, receiver, 1.0); }
    private void ExchangeBet(Player sender, Player receiver, double multiplier) {
        receiver.GetBalance().AddToBalance(betAmount * multiplier);
        sender.GetBalance().LostPartBalance(betAmount * multiplier);
    }


    private void EndPlayerTurn() {
        //Dealer AI
        int dealerPoints = dealer.playerHand.BlackJackPoints();
        if (dealerPoints < 17) deck.DealCard(dealer);

        DetermineWinner();
    }




    private void NewRound() {
        dealer.playerHand.resetHand();
        CasinoApplication.player.playerHand.resetHand();

        deck = new Deck(deckColor);
        DealCards();
        isPlayersTurn = true;
    }


    private void DetermineWinner() {
        int dealerPoints = dealer.playerHand.BlackJackPoints();

        //if dealer busts all players win
        if (dealerPoints > 21) {
            ExchangeBet(dealer, CasinoApplication.player, 2.0);
        }
        else {
            int points = CasinoApplication.player.playerHand.BlackJackPoints();

            if (points == dealerPoints) {
                //tied
                System.out.println(CasinoApplication.player.GetName() + " Tied with the Dealer!");

                //Return bets
                ExchangeBet(dealer, CasinoApplication.player);

            } else if (points <= 21 && points > dealerPoints) {
                //WIN
                System.out.println(CasinoApplication.player.GetName() + " : "+ points + " wins! Against Dealer: "+dealerPoints);


                //Adjust balance
                if (points == 21) {
                    ExchangeBet(dealer, CasinoApplication.player, 3.0);
                    System.out.println(CasinoApplication.player.GetName() + " BlackJack!");
                } else {
                    ExchangeBet(dealer, CasinoApplication.player, 2.0);
                }
            } else {
                //Lose
                System.out.println(CasinoApplication.player.GetName() + " Lost! Against Dealer: "+dealerPoints);
            }
        }

        //Start new Round
        NewRound();
    }

    public void Hit(MouseEvent event) {
        HitCard();
    }

    public void DoubleDwn(MouseEvent event) {
        DoubleDown();
    }

    public void Split(MouseEvent event) {

    }

    public void Stand(MouseEvent event) {
        Stand();
    }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void DecreaseBet(MouseEvent event) {

    }

    public void IncreaseBet(MouseEvent event) {

    }
}
