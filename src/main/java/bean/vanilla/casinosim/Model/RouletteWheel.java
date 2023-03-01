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

    private double trueSize = 864.0;

    private Color[] rouletteValueColors = new Color[] { Color.GREEN,
            Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK,
            Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.RED, Color.BLACK,
            Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.BLACK, Color.RED,
            Color.BLACK, Color.RED, Color.BLACK, Color.RED, Color.BLACK, Color.RED, };

    private int value = 0;
    private Color valueColor = Color.GREEN;
    public RotateTransition rotator;

    public RouletteWheel() {
        try {
            setImage(new Image(new FileInputStream("src/main/resources/CasinoAssets/Roulette/RouletteWheel_SingleZero.png")));
        } catch (FileNotFoundException e) {
            System.out.println("Roulette Wheel image not found.");
        }

        rotator = new RotateTransition(Duration.millis(CasinoApplication.rand.nextInt(1500, 3000)), this);
        rotator.setAxis(Rotate.Z_AXIS);
        rotator.setInterpolator(Interpolator.EASE_BOTH);
        rotator.setCycleCount(1);
    }


    public void SpinWheel() {
        rotator.setFromAngle(0);
        rotator.setToAngle(CasinoApplication.rand.nextInt(360 * 4, 360 * 9));
        rotator.playFromStart();
    }

    public void SetPosition(double x, double y) {
        setLayoutX(x);
        setLayoutY(y);
    }

    public void Scale(double scale) {
        setFitWidth(trueSize * scale);
        setFitHeight(trueSize * scale);
    }

    public int GetValue() { return value; }
    public Color GetValueColor() { return valueColor; }
    public void SetValue(int value) {
        this.value = value;
        valueColor = rouletteValueColors[value];
    }
}
