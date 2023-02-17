package bean.vanilla.casinosim.Model;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Controller.CrapsGameController;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BetSelection extends Pane {

    private final int[] chipValues = new int[] {1,5,10,20,50,100,500,1000,5000};
    private final String imageDirectoryPath = "src/main/resources/CasinoAssets/Overall UI/";
    private ImageView chipImage;
    private Label betLabel;

    private eCrapsBetSelection selection = eCrapsBetSelection.NONE;
    private double betAmount = 0.0;

    public BetSelection(double betAmount, eCrapsBetSelection selection, double x, double y, double width, double height) {
        this.betAmount = betAmount;
        this.selection = selection;

        //Setup position
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.setPrefWidth(width);
        this.setMaxWidth(width);
        this.setPrefHeight(height);
        this.setMaxHeight(height);
        this.setStyle("-fx-cursor: hand;");

        //Setup Imageview for chip
        chipImage = new ImageView();
        chipImage.setPreserveRatio(true);
        double size;
        if (width < height) {
            size = (1.0 / 4.0) * width;
            if (size < 40) size = 40;
            chipImage.setFitWidth(size);
        } else {
            size = (1.0 / 4.0) * height;
            if (size < 40) size = 40;
            chipImage.setFitHeight(size);
        }
        chipImage.setLayoutX((width / 2.0) - (chipImage.getFitWidth()));
        chipImage.setLayoutY((height / 2.0) - (chipImage.getFitHeight() / 2.0));

        //Setup bet label
        betLabel = new Label("$"+betAmount);
        betLabel.setTextFill(Color.BLACK);
        betLabel.setPrefWidth(80);
        betLabel.setPrefHeight(25);
        betLabel.setVisible(false);
        betLabel.setStyle("-fx-background-color: #e6a53e; -fx-border-color: #000; -fx-border-radius: 2px; -fx-background-radius: 2px;");
        betLabel.setLayoutX(width - 20);
        betLabel.setLayoutY(-20);

        //Update bet chip display
        UpdateBetDisplay();

        //add bet label and chip image to stack pane
        this.getChildren().addAll(chipImage, betLabel);

        //Display bet label on mouse hover
        hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (this.betAmount != 0.0) betLabel.setVisible(newValue);
            String bgColor = newValue ? "#00000069" : "transparent";
            this.setStyle("-fx-background-color: "+bgColor+";");
        });

        //Increase bet on mouse click
        setOnMouseClicked(event -> {
            AddToBetAmount(CrapsGameController.GetBetAmount());
        });
    }


    public eCrapsBetSelection Selection() {
        return selection;
    }
    public double GetBetAmount() {
        return betAmount;
    }

    public void AddToBetAmount(double amount) {
        betAmount += amount;
        UpdateBetDisplay();
    }
    public void SubtractFromBetAmount(double amount) {
        betAmount -= amount;
        UpdateBetDisplay();
    }

    public void ClearBet() {
        betAmount = 0.0;
        UpdateBetDisplay();
    }

    private void UpdateBetDisplay() {
        if (betAmount == 0.0) {
            betLabel.setText("$");
            if (betLabel.isVisible()) betLabel.setVisible(false);
            chipImage.setImage(null);
            return;
        }
        betLabel.setText("$"+betAmount);
        if (!betLabel.isVisible()) betLabel.setVisible(true);

        for (int i = chipValues.length-1; i >= 0; i--) {
            if (betAmount >= chipValues[i]) {
                String path = imageDirectoryPath+"Chip"+chipValues[i]+".png";
                try { chipImage.setImage(new Image(new FileInputStream(path)));
                } catch (FileNotFoundException e) { throw new RuntimeException(e); }
                return;
            }
        }
    }

}

