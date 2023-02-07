package bean.vanilla.casinosim.Model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Hand extends StackPane {

    //public ArrayList<Card> cards;


    public Hand() {
        /*cards = new ArrayList<>();*/
        //this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        this.setAlignment(Pos.TOP_CENTER);
    }
    public void removeOneFromHand(Card value){
        getChildren().remove(value);
        this.setLayoutY(0);
    };

    public void addToHand(Card card) {
        card.setPadding(new Insets(getChildren().size()*10, 0, 0, getChildren().size()*40));
        card.setLayoutY(0);
        getChildren().add(card);
    }

    public void resetHand(){
        getChildren().clear();
    }

    public int Points() {
        int totalValue = 0;
        int aceCount = 0;

        for (Node card : getChildren()) {
            if (card instanceof Card) {
                int value = 0;
                String cardCharacter = ((Card)card).GetCardCharacter();
                try {
                    value = Integer.valueOf(cardCharacter);
                } catch (NumberFormatException e) {
                    switch (cardCharacter) {
                        case "J", "Q", "K" -> value = 10;
                        case "A" -> {
                            value = 11;
                            aceCount++;
                        }
                    }
                }
                totalValue += value;
            }
        }

        if (totalValue > 21) {
            for (int i = 0; i < aceCount; i++) {
                totalValue -= 10;
                if (totalValue <= 21)
                    break;
            }
        }
        return totalValue;
    }




}
