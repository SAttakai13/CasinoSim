package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Dice;
import bean.vanilla.casinosim.Model.Player;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleScreenController {

    public void NavToBlackjack(MouseEvent event) {
        CasinoApplication.setRoot("BlackJackGameScreen");
    }

    public void NavToPoker(MouseEvent event) {
        CasinoApplication.setRoot("PokerGameScreen");
    }

    public void NavToRoulette(MouseEvent event) {
        CasinoApplication.setRoot("RouletteGameScreen");
    }

    public void NavToSlots(MouseEvent event) {
        CasinoApplication.setRoot("SlotsGameScreen");
    }

    public void NavToCraps(MouseEvent event) {
        CasinoApplication.setRoot("CrapsGameScreen");
    }

    public void NavToCredit(MouseEvent event) {
        CasinoApplication.setRoot("CreditScreen");
    }

    public void Quit(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

}