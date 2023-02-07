package bean.vanilla.casinosim.Model;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Dice extends ImageView {

    private final String imageDirectoryPath = "src/main/resources/CasinoAssets/Craps/";
    private final String defaultImagePath = imageDirectoryPath + "Dice1.png";
    private String imagePath;
    private Image diceImage = null;


    private final double trueSize = 100.0;

    private final Random rand;

    private int number = 1;
    private final int maxNumber = 6;

    public Dice() {
        rand = new Random();
        number = 1;

        setFitWidth(trueSize);
        setFitHeight(trueSize);

        SetDiceImage();
    }



    public void Roll() { RollToNumber(rand.nextInt(1, maxNumber+1)); }
    public void RollToNumber(int number) {
        if (number < 1 || number > maxNumber)
            return;
        this.number = number;


        RotateTransition rotator = new RotateTransition(Duration.millis(300), this);
        rotator.setAxis(Rotate.Z_AXIS);
        rotator.setFromAngle(0);
        rotator.setToAngle(360);
        rotator.setInterpolator(Interpolator.LINEAR);
        rotator.setCycleCount(1);
        rotator.playFromStart();

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        SetDiceImage();
                    }
                },
                150);
    }


    public int GetNumber() { return number; }


    public void SetPosition(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
    }

    private void SetDiceImage() {
        imagePath = imageDirectoryPath + "Dice"+number+".png";
        try {
            diceImage = new Image(new FileInputStream(imagePath));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: dice image not found for number: "+this);
            try {
                diceImage = new Image(new FileInputStream(defaultImagePath));
            } catch (FileNotFoundException ex) { }
        }
        if (diceImage != null) setImage(diceImage);
    }

    public void Scale(double scale) {
        setFitWidth(trueSize * scale);
        setFitHeight(trueSize * scale);
    }

    @Override
    public String toString() {
        return "| "+number+" |";
    }
}
