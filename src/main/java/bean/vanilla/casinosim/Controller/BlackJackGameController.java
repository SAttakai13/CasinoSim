package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class BlackJackGameController implements Initializable {
    @FXML
    private AnchorPane pane;

    private Player dealer;
    private Deck deck;

    private boolean isPlayersTurn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dealer = new Player("Dealer", 10000.0);
        dealer.playerHand.SetPosition(200, 20);
        dealer.playerHand.Scale(1.0/3.0);

        CasinoApplication.player.playerHand.resetHand();
        CasinoApplication.player.playerHand.SetPosition(200, 300);
        CasinoApplication.player.playerHand.Scale(1.0/3.0);
        pane.getChildren().addAll(dealer.playerHand, CasinoApplication.player.playerHand);
        deck = new Deck(Color.BLUE);
        DealCards();

        dealer.playerHand.FlipCard(0);

        isPlayersTurn = true;
    }


    private void DealCards() {
        if (deck == null || dealer == null) return;
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);
        deck.DealCard(CasinoApplication.player);
        deck.DealCard(dealer);
    }
}
