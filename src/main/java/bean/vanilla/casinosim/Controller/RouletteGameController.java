package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.BetSelection;
import bean.vanilla.casinosim.Model.RouletteSelection;
import bean.vanilla.casinosim.Model.RouletteWheel;
import bean.vanilla.casinosim.Model.eRouletteBetSelection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class RouletteGameController implements Initializable {

    @FXML
    public Pane pane;

    @FXML
    private ImageView IncreaseBet;
    @FXML
    private ImageView DecreaseBet;
    @FXML
    private Text BetText;
    @FXML
    private Text BalText;

    @FXML
    private Text WinningsLabel;


    @FXML
    private Text SpinNumber;


    public RouletteWheel wheel;

    private static double betAmount = 100.0;

    public static double totalBet = 0.0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wheel = new RouletteWheel();
        wheel.SetPosition(0.0, 120.0);
        wheel.Scale(0.5);
        wheel.rotator.setOnFinished(event -> {
            wheel.SetValue(CasinoApplication.rand.nextInt(37)); //0-36
            SpinNumber.setText(""+wheel.GetValue()+"!");
            SpinNumber.setFill(wheel.GetValueColor());
            DetermineResults();
        });

        pane.getChildren().add(wheel);

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());

        //Add all bet selections
        double cellSpacing = 2.333333333;
        int columnCount = 12;

        //Add selection for zero (0)
        RouletteSelection zeroBet = new RouletteSelection(400.0, 100.0, 52.0, 80.0);
        zeroBet.SetRouletteSelection(eRouletteBetSelection.ZERO);
        pane.getChildren().add(zeroBet);

        //Fill main grid
        double startX = 459.0, startY = 28.0;
        double cellWidth = 52.0, cellHeight = 73.0;
        for (int i = 0; i < 36; i++) {
            RouletteSelection bet = new RouletteSelection(startX + (cellWidth + cellSpacing) * (i % columnCount), startY + (cellHeight + cellSpacing) * (i / columnCount), cellWidth, cellHeight);
            bet.SetRouletteSelection(eRouletteBetSelection.NUMBER);
            bet.SetRouletteNumber(i + 1);
            pane.getChildren().add(bet);
        }

        //Fill the 3 "2 to 1" spaces on the right of the board
        startX = 1112.0;
        startY = 28.0;
        for (int i = 0; i < 3; i++) {
            RouletteSelection bet = new RouletteSelection(startX, startY + (cellHeight + cellSpacing) * i, cellWidth, cellHeight);
            switch (i) {
                case 0 -> bet.SetRouletteSelection(eRouletteBetSelection.ROW1);
                case 1 -> bet.SetRouletteSelection(eRouletteBetSelection.ROW2);
                case 2 -> bet.SetRouletteSelection(eRouletteBetSelection.ROW3);
            }
            pane.getChildren().add(bet);
        }

        //Fill the 3 "1st, 2nd, 3rd, 12" spaces
        startX = 459.0;
        startY = 255.0;
        cellWidth = 215.0;
        cellHeight = 52.0;
        for (int i = 0; i < 3; i++) {
            RouletteSelection bet = new RouletteSelection(startX + (cellWidth + cellSpacing) * i, startY, cellWidth, cellHeight);
            switch (i) {
                case 0 -> bet.SetRouletteSelection(eRouletteBetSelection._1ST_12);
                case 1 -> bet.SetRouletteSelection(eRouletteBetSelection._2ND_12);
                case 2 -> bet.SetRouletteSelection(eRouletteBetSelection._3RD_12);
            }
            pane.getChildren().add(bet);
        }

        //Fill the bottom 1 to 18, even, odd, red, black, etc. spaces
        startY = 312.0;
        cellWidth = 106.0;
        cellHeight = 54.0;
        cellSpacing = 3;
        for (int i = 0; i < 6; i++) {
            RouletteSelection bet = new RouletteSelection(startX + (cellWidth + cellSpacing) * i, startY, cellWidth, cellHeight);
            switch (i) {
                case 0 -> bet.SetRouletteSelection(eRouletteBetSelection._1TO18);
                case 1 -> bet.SetRouletteSelection(eRouletteBetSelection.EVEN);
                case 2 -> bet.SetRouletteSelection(eRouletteBetSelection.RED);
                case 3 -> bet.SetRouletteSelection(eRouletteBetSelection.BLACK);
                case 4 -> bet.SetRouletteSelection(eRouletteBetSelection.ODD);
                case 5 -> bet.SetRouletteSelection(eRouletteBetSelection._19TO36);
            }
            pane.getChildren().add(bet);
        }
    }

    private void DetermineResults() {
        int spinNum = wheel.GetValue();
        double winnings = 0.0;

        for (Node bet : pane.getChildren()) {
            if (bet instanceof RouletteSelection && ((RouletteSelection)bet).GetBetAmount() != 0) {
                switch (((RouletteSelection)bet).Selection()) {
                    case ZERO:
                        if (spinNum == 0) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case NUMBER:
                        if (spinNum == ((RouletteSelection)bet).GetRouletteNumber()) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case ROW1:
                        if (spinNum % 3 == 0) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case ROW2:
                        if (spinNum % 3 == 2) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case ROW3:
                        if (spinNum % 3 == 1) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case _1ST_12:
                        if (spinNum > 0 && spinNum <= 12) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case _2ND_12:
                        if (spinNum > 12 && spinNum <= 24) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case _3RD_12:
                        if (spinNum > 24 && spinNum <= 36) {
                            winnings += ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount() * 2.0;
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case _1TO18:
                        if (spinNum > 0 && spinNum <= 18) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case EVEN:
                        if (spinNum % 2 == 0) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case RED:
                        if (wheel.GetValueColor() == Color.RED) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case BLACK:
                        if (wheel.GetValueColor() == Color.BLACK) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case ODD:
                        if (spinNum % 2 == 1) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;
                    case _19TO36:
                        if (spinNum > 18 && spinNum <= 36) {
                            winnings += ((RouletteSelection)bet).GetBetAmount();
                        } else {
                            winnings -= ((RouletteSelection)bet).GetBetAmount();
                        }
                        ((RouletteSelection)bet).ClearBet();
                        break;

                    default:
                    case NONE:
                        break;
                }
            }
        }

        if (winnings > 0) {
            WinningsLabel.setText("You Won $"+winnings);
            CasinoApplication.player.AddToBalance(winnings);
        } else if (winnings < 0) {
            WinningsLabel.setText("You Lost $"+Math.abs(winnings));
            CasinoApplication.player.LostPartBalance(Math.abs(winnings));
        } else {
            WinningsLabel.setText("");
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());

        CasinoApplication.CheckForWithdraw();
    }


    public void Spin(MouseEvent mouseEvent) {
        if (wheel != null) wheel.SpinWheel();
    }


    @FXML
    private void Quit(MouseEvent e) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public static double GetBetAmount() { return betAmount; }

    @FXML
    public void DecreaseBet(MouseEvent event) {
        if (betAmount <= 0){
            DecreaseBet.setDisable(true);
            DecreaseBet.setOpacity(0.5);
            betAmount = 0;
        } else if (betAmount > 0){
            DecreaseBet.setDisable(false);
            betAmount -= 50;
            if (IncreaseBet.isDisable()){
                IncreaseBet.setDisable(false);
                IncreaseBet.setOpacity(1);
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    @FXML
    public void IncreaseBet(MouseEvent event) {
        if (betAmount >= CasinoApplication.player.GetBalance().GetBalance()){
            IncreaseBet.setDisable(true);
            IncreaseBet.setOpacity(0.5);
            betAmount = CasinoApplication.player.GetBalance().GetBalance();
        } else if (betAmount < CasinoApplication.player.GetBalance().GetBalance()){
            IncreaseBet.setDisable(false);
            betAmount += 50;
            if (DecreaseBet.isDisable()){
                DecreaseBet.setDisable(false);
                DecreaseBet.setOpacity(1);
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void updateBetsAndBalance(double bets, double playerBalance){
        BetText.setText("Bet: " + bets);
        BalText.setText("Balance: " + playerBalance);
    }
}
