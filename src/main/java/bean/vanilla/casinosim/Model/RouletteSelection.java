package bean.vanilla.casinosim.Model;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Controller.CrapsGameController;
import bean.vanilla.casinosim.Controller.RouletteGameController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class RouletteSelection extends Pane {

    private final int[] chipValues = new int[] {1,5,10,20,50,100,500,1000,5000};
    private final String imageDirectoryPath = "src/main/resources/CasinoAssets/Overall UI/";
    private ImageView chipImage;
    private Label betLabel;

    private eRouletteBetSelection selection = eRouletteBetSelection.NONE;
    private int rouletteNumber = -1;
    private double betAmount = 0.0;


    public RouletteSelection(double x, double y, double width, double height) {
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
            size = (3.0 / 4.0) * width;
            chipImage.setFitWidth(size);
        } else {
            size = (3.0 / 4.0) * height;
            chipImage.setFitHeight(size);
        }
        //chipImage.setLayoutX((width / 2.0) - (chipImage.getFitWidth()));
        //chipImage.setLayoutY((height / 2.0) - (chipImage.getFitHeight() / 2.0));

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
            String bgColor = newValue ? "#26527a69" : "transparent";
            this.setStyle("-fx-background-color: "+bgColor+";");
        });

        //Increase bet on mouse click
        setOnMouseClicked(event -> {
            if (RouletteGameController.totalBet + RouletteGameController.GetBetAmount() <= CasinoApplication.player.GetBalance().GetBalance())
                AddToBetAmount(RouletteGameController.GetBetAmount());
        });
    }



    public eRouletteBetSelection Selection() {
        return selection;
    }
    public void SetRouletteSelection(eRouletteBetSelection selection) {
        this.selection = selection;
    }
    public int GetRouletteNumber() { return rouletteNumber; }
    public void SetRouletteNumber(int num) { rouletteNumber = num; }

    public double GetBetAmount() {
        return betAmount;
    }

    public void AddToBetAmount(double amount) {
        betAmount += amount;
        RouletteGameController.totalBet += amount;
        UpdateBetDisplay();
    }
    public void SubtractFromBetAmount(double amount) {
        betAmount -= amount;
        RouletteGameController.totalBet -= amount;
        UpdateBetDisplay();
    }

    public void ClearBet() {
        RouletteGameController.totalBet -= betAmount;
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

