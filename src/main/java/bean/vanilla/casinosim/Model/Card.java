package bean.vanilla.casinosim.Model;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class Card extends ImageView {
    public enum eSuit { DIAMONDS, CLUBS, HEARTS, SPADES }
    public static char[] suitChars = new char[] {
            '♦','♣','♥','♠'
    };

    private final double trueWidth = 250.0;

    private String cardCharacter = "";
    private eSuit suit;
    private char suitChar;
    private Color cardColor;
    private Color cardBackColor;
    private boolean cardFlipped = false;

    private final String imageDirectoryPath = "src/main/resources/CasinoAssets/BlackJack/Cards/";
    private final String defaultImagePath = imageDirectoryPath + "cardJoker.png";
    private final String defaultBackImagePath = imageDirectoryPath + "cardBack_red5.png";
    private String imagePath;
    private String backImagePath;

    private Image cardImage = null;
    private Image cardBackImage = null;


    public Card(eSuit suit, String character, Color cardBackColor) {
        this.suit = suit;
        if (!character.matches("[0-9]{1,2}")) {
            this.cardCharacter = character.toUpperCase();
        } else {
            this.cardCharacter = character;
        }
        String suitName = GetCardSuitName();
        imagePath = imageDirectoryPath + "card" + suitName + cardCharacter + ".png";


        this.cardBackColor = cardBackColor;
        String cardBackColorName = "red";
        if (cardBackColor.equals(Color.RED)) {
            cardBackColorName = "red";
        } else if (cardBackColor.equals(Color.BLUE)) {
            cardBackColorName = "blue";
        } else if (cardBackColor.equals(Color.GREEN)) {
            cardBackColorName = "green";
        }
        backImagePath = imageDirectoryPath + "cardBack_"+cardBackColorName+"5.png";

        BuildCard();
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

        this.setPreserveRatio(true);
        this.setFitWidth(trueWidth);

        //Set Card Image
        try {
            cardImage = new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: card image not found for card: "+this);

            //Set Default Image (Joker Card)
            try {
                cardImage = new Image(new FileInputStream(defaultImagePath));
            } catch (FileNotFoundException ex) { }
        }

        //Set Card Back Image
        try {
            cardBackImage = new Image(new FileInputStream(backImagePath));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: card back image not found for card color: "+cardBackColor.toString().toLowerCase());

            //Set Default Image (Red Back Card)
            try {
                cardBackImage = new Image(new FileInputStream(defaultBackImagePath));
            } catch (FileNotFoundException ex) { }
        }

        //Set Card Image
        if (cardImage != null) setImage(cardImage);
    }


    private RotateTransition rotator = new RotateTransition(Duration.millis(500), this);
    public void FlipCard(double duration) {
        rotator.setDuration(Duration.millis(duration));
        rotator.setAxis(Rotate.Y_AXIS);
        rotator.setToAngle(cardFlipped ? 0 : 180);
        rotator.setInterpolator(Interpolator.LINEAR);
        rotator.setCycleCount(1);
        rotator.playFromStart();

        new Timer().schedule(
            new TimerTask() {
                @Override
                public void run() {
                    if (cardFlipped) {
                        setImage(cardImage);
                    } else {
                        setImage(cardBackImage);
                    }
                    cardFlipped = !cardFlipped;
                }
            },
            (long) (duration / 2.0));
    }




    public char GetCardSuitCharacter() { return suitChar; }
    public String GetCardCharacter() {
        return cardCharacter;
    }
    public String GetCardSuitName() { return suit.toString().toUpperCase().substring(0,1) + suit.toString().toLowerCase().substring(1); }


    public void Scale(double scale) {
        this.setFitWidth(trueWidth * scale);
    }

    @Override
    public String toString() {
        return "| "+cardCharacter+" "+suitChar+" |";
    }
}
