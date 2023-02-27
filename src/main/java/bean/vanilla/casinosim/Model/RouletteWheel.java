package bean.vanilla.casinosim.Model;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

public class RouletteWheel extends ImageView {

    private Color[] rouletteValueColors = new Color[] { Color.GREEN,
            Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK,
            Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK,
            Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED,
            Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, };

    private int value = 0;
    private Color valueColor = Color.GREEN;

    public RouletteWheel() {
        try {
            setImage(new Image(new FileInputStream("src/main/resources/CasinoAssets/Roulette/RouletteWheel_SingleZero.png")));
        } catch (FileNotFoundException e) {
            System.out.println("Roulette Wheel image not found.");
        }
    }

    public void SpinWheel() {
        RotateTransition rotator = new RotateTransition(Duration.millis(CasinoApplication.rand.nextInt(800, 1400)), this);
        rotator.setAxis(Rotate.Z_AXIS);
        rotator.setToAngle(CasinoApplication.rand.nextInt(360, 780));
        rotator.setInterpolator(Interpolator.EASE_IN);
        rotator.setCycleCount(1);
        rotator.playFromStart();

        rotator.setOnFinished(event -> {
            SetValue(CasinoApplication.rand.nextInt(37)); //0-36
        });
    }


    public int GetValue() { return value; }
    public Color GetValueColor() { return valueColor; }
    private void SetValue(int value) {
        this.value = value;
        valueColor = rouletteValueColors[value];
    }
}
