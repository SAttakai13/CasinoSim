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
        CasinoApplication.setRoot("BlackJackInstructionScreen");
    }

    public void NavToPoker(MouseEvent event) {
        CasinoApplication.setRoot("PokerInstructionScreen");
    }

    public void NavToRoulette(MouseEvent event) {
        CasinoApplication.setRoot("RouletteInstructionScreen");
    }

    public void NavToSlots(MouseEvent event) {
        CasinoApplication.setRoot("SlotsInstructionScreen");
    }

    public void NavToCraps(MouseEvent event) {
        CasinoApplication.setRoot("CrapsInstructionScreen");
    }

    public void NavToCredit(MouseEvent event) {
        CasinoApplication.setRoot("CreditScreen");
    }

    public void Quit(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

}