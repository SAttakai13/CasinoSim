package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Dice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleScreenController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private VBox pane;
    private Card card;
    private Dice die;

    @FXML
    protected void onHelloButtonClick() {
        card.FlipCard(300);
        die.Roll();
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        card = new Card(Card.eSuit.SPADES, "4", Color.BLUE);
        card.Scale(0.4);
        pane.getChildren().add(card);

        die = new Dice();
        die.Scale(0.6);
        pane.getChildren().add(die);
    }
}