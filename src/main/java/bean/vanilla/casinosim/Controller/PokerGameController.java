package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Deck;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class PokerGameController implements Initializable {

    @FXML
    private Text BetText;
    @FXML
    private Text BalText;


    private Deck deck;
    private double betAmount = 100.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new Deck(Color.RED);


    }



    public void Raise(MouseEvent event) {

    }
    public void Call(MouseEvent event) {

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
        betAmount -= 50;
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void IncreaseBet(MouseEvent event) {
        betAmount += 50;
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }
}
