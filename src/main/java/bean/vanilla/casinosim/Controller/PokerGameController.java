package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.Model.Deck;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class PokerGameController implements Initializable {


    private Deck deck;
    private double betAmount = 100.0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deck = new Deck(Color.RED);

    }


}
