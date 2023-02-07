package bean.vanilla.casinosim.Model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Card extends StackPane {

    public static char[] suitChars = new char[] {
            '♦','♣','♥','♠'
    };

    private String cardCharacter = "";
    private eSuit suit;
    private char suitChar;
    private Color cardColor;

    private double trueWidth = 250.0;
    private double trueHeight = 350.0;
    private double trueArcWidth = 25.0;
    private double trueArcHeight = 25.0;
    private int trueFontSize = 60;
    private int trueSmallFontSize = 52;
    private double truePadding = 10.0;

    private Rectangle rectangle;

    public Card(eSuit suit, String character) {
        this.suit = suit;
        if (!character.matches("[0-9]{1,2}")) {
            this.cardCharacter = character.toUpperCase();
        } else {
            this.cardCharacter = character;
        }


        BuildCard();


        Scale(0.6);

        //this.setAlignment(Pos.CENTER_LEFT);
    }

    private void BuildCard() {
        switch (suit) {
            case DIAMONDS -> {
                suitChar = suitChars[0];
                cardColor = Color.RED;
            }
            case HEARTS -> {
                suitChar = suitChars[2];
                cardColor = Color.RED;
            }
            case CLUBS -> {
                suitChar = suitChars[1];
                cardColor = Color.BLACK;
            }
            case SPADES -> {
                suitChar = suitChars[3];
                cardColor = Color.BLACK;
            }
        }

        this.setWidth(250.0);
        this.setHeight(350.0);
        this.setAlignment(Pos.TOP_LEFT);

        rectangle = new Rectangle(250.0, 350.0, Color.WHITE);

        rectangle.setArcWidth(25);
        rectangle.setArcHeight(25);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2.0);
        rectangle.setFill(Color.WHITE);

        this.getChildren().add(rectangle);


        Label cardNumber = new Label(cardCharacter+"\n"+suitChar);
        cardNumber.setTextFill(cardColor);
        cardNumber.setFont(new Font("Segoe UI Black", 60));
        cardNumber.setPrefWidth(250.0);
        cardNumber.setPrefHeight(350.0);
        cardNumber.setAlignment(Pos.CENTER);

        this.getChildren().add(cardNumber);


        Label cardSuit_TL = new Label(suitChar+"\n"+cardCharacter);
        cardSuit_TL.setTextFill(cardColor);
        cardSuit_TL.setFont(new Font("Segoe UI Black", 52));
        cardSuit_TL.setPadding(new Insets(0, 10, 0, 10));
        cardSuit_TL.setPrefWidth(250.0);
        cardSuit_TL.setPrefHeight(350.0);
        cardSuit_TL.setAlignment(Pos.TOP_LEFT);

        this.getChildren().add(cardSuit_TL);

        Label cardSuit_BR = new Label(suitChar+"");
        cardSuit_BR.setTextFill(cardColor);
        cardSuit_BR.setFont(new Font("Segoe UI Black", 52));
        cardSuit_BR.setPadding(new Insets(0, 10, 0, 10));
        cardSuit_BR.setPrefWidth(250.0);
        cardSuit_BR.setPrefHeight(350.0);
        cardSuit_BR.setAlignment(Pos.BOTTOM_RIGHT);

        //Change to addall later
        this.getChildren().add(cardSuit_BR);
    }

    public String GetCardCharacter() {
        return cardCharacter;
    }
    public void Scale(double scale) {
        this.setScaleX(scale);
        this.setScaleY(scale);
        this.setScaleZ(scale);

        this.setWidth(trueWidth * scale);
        this.setHeight(trueHeight * scale);
        this.rectangle.setWidth(trueWidth * scale);
        this.rectangle.setHeight(trueHeight * scale);

        for (Node c : getChildren()) {
            if (c instanceof Label) {
                ((Label)c).setPrefWidth(trueWidth * scale);
                ((Label)c).setPrefHeight(trueHeight * scale);

                if (((Label)c).getAlignment() == Pos.CENTER)
                    ((Label)c).setFont(new Font("Segoe UI Black", trueSmallFontSize * scale));
                else {
                    ((Label) c).setFont(new Font("Segoe UI Black", trueSmallFontSize * scale));
                    ((Label)c).setPadding(new Insets(0, truePadding * scale, 0, truePadding * scale));
                }

            }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardCharacter='" + cardCharacter + '\'' +
                ", suit=" + suit +
                ", suitChar=" + suitChar +
                ", cardColor=" + cardColor +
                '}';
    }
}
