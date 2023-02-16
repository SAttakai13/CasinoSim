package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.Dice;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class CrapsGameController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private GridPane DiceGrid;


    private double betAmount = 100.0;
    private Dice d1, d2;

    private boolean isFirstRoll = true;

    private int crapsPoint = -1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        d1 = new Dice();
        d1.Scale(0.5);
        DiceGrid.add(d1, 0, 0);
        d2 = new Dice();
        d2.Scale(0.5);
        DiceGrid.add(d2, 1, 0);

        isFirstRoll = true;
    }


    public int GetDiceValue() {
        return d1.GetNumber() + d2.GetNumber();
    }
    public Dice GetDie(int i) {
        return i == 1 ? d1 : i == 2 ? d2 : null;
    }

    @FXML
    private void Roll(MouseEvent e) {
        d1.Roll();
        d2.Roll();
        DetermineResults();
    }


    private void DetermineResults() {
        int total = GetDiceValue();
        if (isFirstRoll) {
            if (total == 7 || total == 11 ||
                    ((total == 4 || total == 6 || total == 8 || total == 10) && d1.GetNumber() == d2.GetNumber())) {
                PlayerWin(); //Player Wins
            } else if (total == 2 || total == 3 || total == 12) {
                PlayerLose(); //Player Loses
            } else {
                SetPoint(total);
                isFirstRoll = false;
            }
        } else {
            if (total == crapsPoint) {
                PlayerWin(); //Player Wins
            } else if (total == 7) {
                PlayerLose(); //Player Loses
            }
        }
    }


    private void PlayerWin() {
        System.out.println("Player wins");
        int total = GetDiceValue();

        if (isFirstRoll) {

            //Determine Hardway points
            if (d1.GetNumber() == d2.GetNumber()) {
                if (total == 4 || total == 10) CasinoApplication.player.AddToBalance(betAmount * 7);
                if (total == 6 || total == 8) CasinoApplication.player.AddToBalance(betAmount * 9);
            } else {

            }
        } else {

        }
    }

    private void PlayerLose() {
        System.out.println("Player Loses");
        CasinoApplication.player.LostPartBalance(betAmount);
        //Update Labels
    }

    private void NewRound() {

        isFirstRoll = true;
        SetPoint(-1);
    }

    private void SetPoint(int point) {
        if (point != -1 && point != 4 && point != 5 && point != 6 && point != 8 && point != 9 && point != 10)
            return;
        crapsPoint = point;

        //Set position of point indicator

    }

    @FXML
    private void Quit(MouseEvent e) {
        CasinoApplication.setRoot("TitleScreen");
    }
}
