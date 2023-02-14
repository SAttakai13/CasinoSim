package bean.vanilla.casinosim.Model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Hand extends StackPane {

    private double trueWidth = 300.0;
    private double trueHeight = 350.0;

    private boolean isHidden = false;
    private double cardScale = 1.0;

    public Hand() {
        setMaxWidth(trueWidth * cardScale);
        setMaxHeight(trueHeight * cardScale);
        this.setAlignment(Pos.TOP_CENTER);
        SetIsHidden(false);
        this.setPadding(new Insets(0, 0, 0, 20));
    }
    public void removeOneFromHand(Card value){
        getChildren().remove(value);
    };

    public void AddToHand(Card card) {
        card.Scale(cardScale);
        if (isHidden) card.FlipCard(0);

        this.setPadding(new Insets(0, 0, 0, this.getPadding().getLeft() - 20));
        StackPane cardPane = new StackPane();
        cardPane.setPadding(new Insets(getChildren().size()*8, 0, 0, getChildren().size()*40));
        cardPane.setMaxWidth(10);
        cardPane.setMaxHeight(10);
        cardPane.getChildren().add(card);
        getChildren().add(cardPane);
    }

    public void resetHand(){
        this.setPadding(new Insets(0, 0, 0, 0));
        getChildren().clear();
    }

    public int BlackJackPoints() {
        int totalValue = 0;
        int aceCount = 0;

        for (Node pane : getChildren()) {
            if (pane instanceof StackPane) {
                if (((StackPane) pane).getChildren().size() >= 1) {
                    Node card = ((StackPane) pane).getChildren().get(0);
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


    public boolean IsHidden() { return isHidden; }
    public void SetIsHidden(boolean isHidden) { SetIsHidden(isHidden, 0); }
    public void SetIsHidden(boolean isHidden, double duration) {
        if (this.isHidden == isHidden) return;
        this.isHidden = isHidden;

        for (Node pane : getChildren()) {
            if (pane instanceof StackPane) {
                if (((StackPane) pane).getChildren().size() >= 1) {
                    Node card = ((StackPane) pane).getChildren().get(0);
                    if (card instanceof Card) {
                        if (this.isHidden != ((Card) card).IsCardFlipped())
                            ((Card)card).FlipCard(duration);
                    }
                }
            }
        }
    }
    public void ToggleIsHidden() { ToggleIsHidden(0); }
    public void ToggleIsHidden(double duration) {
        SetIsHidden(!isHidden, duration);
    }

    public void FlipCard(int index) { FlipCard(index, 0); }
    public void FlipCard(int index, double duration) {
        if (index < 0 || index >= getChildren().size())
            return;

        Node pane = getChildren().get(index);
        if (pane instanceof StackPane) {
            if (((StackPane) pane).getChildren().size() >= 1) {
                Node card = ((StackPane) pane).getChildren().get(0);
                if (card instanceof Card) {
                    ((Card) card).FlipCard(duration);
                }
            }
        }
    }


    public Card GetCard(int index) {
        if (index < 0 || index >= getChildren().size())
            return null;

        Node pane = getChildren().get(index);
        if (pane instanceof StackPane) {
            if (((StackPane) pane).getChildren().size() >= 1) {
                Node card = ((StackPane) pane).getChildren().get(0);
                if (card instanceof Card) {
                    return (Card)card;
                }
            }
        }
        return null;
    }

    public void RemoveCard(int index) {
        getChildren().remove(index);
    }


    public boolean HasMatchingValues() {
        String value = null;
        for (int i = 0; i < getChildren().size(); i++) {
            Node pane = getChildren().get(i);
            if (pane instanceof StackPane) {
                if (((StackPane) pane).getChildren().size() >= 1) {
                    Node card = ((StackPane) pane).getChildren().get(0);
                    if (card instanceof Card) {
                        if (value == null) {
                            value = ((Card) card).GetCardCharacter();
                            continue;
                        }
                        if (!((Card) card).GetCardCharacter().equals(value)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public void SetPosition(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
    }
    public void Scale(double scale) {
        cardScale = scale;
        setMaxWidth(trueWidth * cardScale);
        setMaxHeight(trueHeight * cardScale);
        for (Node card : getChildren()) {
            if (card instanceof Card)
                ((Card)card).Scale(cardScale);
        }
    }


}
