package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Hand;
import bean.vanilla.casinosim.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGameController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private ImageView SplitButton;

    private Player dealer;
    private Deck deck;
    private Color deckColor = Color.BLUE;

    private Hand playerSplitHand = null;

    @FXML
    private Pane bannerPane;
    @FXML
    private Text bannerText;

    private boolean buttonsDisabled = false;

    private boolean isPlayersTurn;
    private double truePlayerXPosition = 570;

    private double betAmount = 100.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dealer = new Player("Dealer", 10000.0);
        dealer.playerHand.resetHand();
        dealer.playerHand.SetPosition(truePlayerXPosition, 40);
        dealer.playerHand.Scale(1.0/3.0);

        CasinoApplication.player.playerHand.resetHand();
        CasinoApplication.player.playerHand.SetPosition(truePlayerXPosition, 492);
        CasinoApplication.player.playerHand.Scale(1.0/3.0);
        pane.getChildren().addAll(dealer.playerHand, CasinoApplication.player.playerHand);
        deck = new Deck(deckColor);
        DealCards();

        dealer.playerHand.FlipCard(0);

        isPlayersTurn = true;
    }

    private void HitCard(){
        deck.DealCard(CasinoApplication.player);

        SplitButton.setDisable(true);
        SplitButton.setOpacity(0.5);

        if (CasinoApplication.player.playerHand.BlackJackPoints() > 21 || CasinoApplication.player.playerHand.getChildren().size() >= 5)
            EndPlayerTurn();
    }

    private void DoubleDown(){
        deck.DealCard(CasinoApplication.player);
        betAmount *= 2;
        EndPlayerTurn();
    }

    private void Stand(){
        EndPlayerTurn();
    }

    private void Split() {
        SplitButton.setDisable(true);
        SplitButton.setOpacity(0.5);

        playerSplitHand = new Hand();
        playerSplitHand.Scale(1.0/3.0);
        playerSplitHand.AddToHand(CasinoApplication.player.playerHand.GetCard(1));
        CasinoApplication.player.playerHand.RemoveCard(1);

        //Set Positions
        pane.getChildren().add(playerSplitHand);
        CasinoApplication.player.playerHand.SetPosition(truePlayerXPosition - 50, 492);
        playerSplitHand.SetPosition(truePlayerXPosition + 50, 492);

        //Deal new cards
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(playerSplitHand);

        EndPlayerTurn();
    }


    private void DealCards() {
        if (deck == null || dealer == null) return;
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);

        //Check if split is available
        if (CasinoApplication.player.playerHand.HasMatchingValues()) {
            SplitButton.setDisable(false);
            SplitButton.setOpacity(1.0);
        } else {
            SplitButton.setDisable(true);
            SplitButton.setOpacity(0.5);
        }
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
        buttonsDisabled = false;

        //Reset split
        if (playerSplitHand != null) {
            pane.getChildren().remove(playerSplitHand);
            playerSplitHand = null;
            CasinoApplication.player.playerHand.SetPosition(truePlayerXPosition, 492);
        }

        dealer.playerHand.resetHand();
        CasinoApplication.player.playerHand.resetHand();

        deck = new Deck(deckColor);
        DealCards();

        dealer.playerHand.FlipCard(0);

        isPlayersTurn = true;
    }


    private void DetermineWinner() {
        String bannerMessage = "";

        int dealerPoints = dealer.playerHand.BlackJackPoints();

        //if dealer busts all players win
        if (dealerPoints > 21) {
            ExchangeBet(dealer, CasinoApplication.player, 2.0);
            bannerMessage = CasinoApplication.player.GetName() + " wins! Against Dealer: "+dealerPoints;
        }
        else {
            int points = CasinoApplication.player.playerHand.BlackJackPoints();

            //Check for split hand points
            if (playerSplitHand != null) {
                int splitPoints = playerSplitHand.BlackJackPoints();
                if ((points > 21 || splitPoints > points) && splitPoints <= 21) {
                    points = splitPoints;
                }
            }


            if (points == dealerPoints) {
                //tied
                bannerMessage = CasinoApplication.player.GetName() + " Tied with the Dealer!";

                //Return bets
                ExchangeBet(dealer, CasinoApplication.player);

            } else if (points <= 21 && points > dealerPoints) {
                //WIN
                bannerMessage = CasinoApplication.player.GetName() + " : "+ points + " wins! Against Dealer: "+dealerPoints;


                //Adjust balance
                if (CasinoApplication.player.playerHand.getChildren().size() == 5) {
                    ExchangeBet(dealer, CasinoApplication.player, 4.0);
                    bannerMessage = CasinoApplication.player.GetName() + " 5-Card Charlie!";
                } else if (points == 21) {
                    ExchangeBet(dealer, CasinoApplication.player, 3.0);
                    bannerMessage = CasinoApplication.player.GetName() + " BlackJack!";
                } else {
                    ExchangeBet(dealer, CasinoApplication.player, 2.0);
                }
            } else {
                //Lose
                bannerMessage = CasinoApplication.player.GetName() + " : "+ points + " Lost! Against Dealer: "+dealerPoints;
            }
        }

        dealer.playerHand.FlipCard(0, 500);

        bannerText.setText(bannerMessage);
        bannerPane.setVisible(true);
        buttonsDisabled = true;
    }

    public void Hit(MouseEvent event) {
        if (!buttonsDisabled) HitCard();
    }

    public void DoubleDwn(MouseEvent event) { if (!buttonsDisabled) DoubleDown(); }

    public void Split(MouseEvent event)  { if (!buttonsDisabled) Split(); }

    public void Stand(MouseEvent event) { if (!buttonsDisabled) Stand(); }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void DecreaseBet(MouseEvent event) {

    }

    public void IncreaseBet(MouseEvent event) {

    }

    public void NewGameBtnPressed(ActionEvent actionEvent) {
        bannerPane.setVisible(false);
        NewRound();
    }

}
