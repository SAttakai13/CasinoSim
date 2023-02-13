package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Dice;
import bean.vanilla.casinosim.Model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleScreenController {
    @FXML
    public ImageView BlackJackScreen;

    public void NavToBlackJack(){
        CasinoApplication.setRoot("BlackJackGameScreen");
    }



}