package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.Model.Card;
import bean.vanilla.casinosim.Model.Deck;
import bean.vanilla.casinosim.Model.Dice;
import bean.vanilla.casinosim.Model.Player;
import javafx.event.ActionEvent;
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
    private Player p;
    private Deck deck;

    @FXML
    protected void onHelloButtonClick() {
        card.FlipCard(300);
        die.Roll();

        deck.DealCard(p);
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onOtherButtonClick(ActionEvent actionEvent) {
        p.playerHand.ToggleIsHidden(100);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        card = new Card(Card.eSuit.SPADES, "4", Color.BLUE);
        card.Scale(0.4);
        pane.getChildren().add(card);

        die = new Dice();
        die.Scale(0.6);
        pane.getChildren().add(die);

        deck = new Deck();
        p = new Player("Jake", 1000.0);
        p.playerHand.Scale(0.4);
        pane.getChildren().add(p.playerHand);
    }

}