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

    @FXML
    private ImageView IncreaseBet;

    @FXML
    private ImageView DecreaseBet;



    @FXML
    private Text BetText;

    @FXML
    private Text BalText;


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

    private boolean betIsDoubled = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BetText.setText("Bet: " + betAmount);
        BalText.setText("Balance: " + CasinoApplication.player.GetBalance().GetBalance());

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

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void updateBetsAndBalance(double bets, double playerBalance){
        BetText.setLayoutX(914.0);
        BetText.setLayoutY(794.0);

        BalText.setLayoutX(860.0);
        BalText.setLayoutY(836.0);

        BetText.setText("Bet: " + bets);
        BalText.setText("Balance: " + playerBalance);
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
        betIsDoubled = true;
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
        receiver.AddToBalance(betAmount * multiplier);
        sender.LostPartBalance(betAmount * multiplier);
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
        betIsDoubled = false;

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
        int points = CasinoApplication.player.playerHand.BlackJackPoints();

        //Check for split hand points
        //Calculate bet return amount based off points of player's 2nd split hand and dealer hand
        if (playerSplitHand != null) {
            int splitPoints = playerSplitHand.BlackJackPoints();

            if (splitPoints <= 21 && splitPoints > dealerPoints) {
                //Split Hand Adjust balance
                if (splitPoints == 21) {
                    ExchangeBet(dealer, CasinoApplication.player, 2.0);
                } else {
                    ExchangeBet(dealer, CasinoApplication.player);
                }
            } else {
                //Split Hand Lose
                ExchangeBet(CasinoApplication.player, dealer, (betIsDoubled ? 2.0 : 1.0));
            }
        }

        //if dealer busts all players win
        if (dealerPoints > 21) {
            if (points > 21) {
                //Lose
                bannerMessage = CasinoApplication.player.GetName() + " : "+ points + " Lost! Against Dealer: "+dealerPoints;
                ExchangeBet(CasinoApplication.player, dealer, (betIsDoubled ? 2.0 : 1.0));

            } else {
                ExchangeBet(dealer, CasinoApplication.player, (betIsDoubled ? 2.0 : 1.0));
                bannerMessage = CasinoApplication.player.GetName() + " wins! Against Dealer: " + dealerPoints;
            }
        } else {


            //Calculate bet return amount based off points of player and dealer hand
            if (points == dealerPoints) {
                //tied
                bannerMessage = CasinoApplication.player.GetName() + " Tied with the Dealer!";


            } else if (points <= 21 && points > dealerPoints) {
                //WIN
                bannerMessage = CasinoApplication.player.GetName() + " : "+ points + " wins! Against Dealer: "+dealerPoints;


                //Adjust balance
                if (CasinoApplication.player.playerHand.getChildren().size() == 5) {
                    ExchangeBet(dealer, CasinoApplication.player, 3.0 * (betIsDoubled ? 2.0 : 1.0));
                    bannerMessage = CasinoApplication.player.GetName() + " 5-Card Charlie!";
                } else if (points == 21) {
                    ExchangeBet(dealer, CasinoApplication.player, 2.0 * (betIsDoubled ? 2.0 : 1.0));
                    bannerMessage = CasinoApplication.player.GetName() + " BlackJack!";
                } else {
                    ExchangeBet(dealer, CasinoApplication.player, (betIsDoubled ? 2.0 : 1.0));
                }
            } else {
                //Lose
                bannerMessage = CasinoApplication.player.GetName() + " : "+ points + " Lost! Against Dealer: "+dealerPoints;
                ExchangeBet(CasinoApplication.player, dealer, (betIsDoubled ? 2.0 : 1.0));
            }
        }

        //Reveal hidden dealer card
        dealer.playerHand.FlipCard(0, 500);

        //Update balance and bet text
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());

        //Check if player is out of money
        CasinoApplication.CheckForWithdraw();

        //Reveal Winner Banner
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

    public void NewGameBtnPressed(ActionEvent actionEvent) {
        bannerPane.setVisible(false);
        NewRound();
    }

}
