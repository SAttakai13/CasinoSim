package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.BetSelection;
import bean.vanilla.casinosim.Model.Dice;
import bean.vanilla.casinosim.Model.eCrapsBetSelection;
import bean.vanilla.casinosim.Model.eCrapsPhase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CrapsGameController implements Initializable {

    //@FXML
    @FXML
    private Pane pane;
    //@FXML
    private GridPane DiceGrid;


    private static double betAmount = 100.0;
    private Dice d1, d2;

    private boolean isFirstRoll = true;

    private List<BetSelection> betSelections = new ArrayList<>();
    private eCrapsPhase phase = eCrapsPhase.NONE;

    private int crapsPoint = -1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        d1 = new Dice();
        d1.Scale(0.5);
        //DiceGrid.add(d1, 0, 0);
        d2 = new Dice();
        d2.Scale(0.5);
        //DiceGrid.add(d2, 1, 0);

        isFirstRoll = true;
        phase = eCrapsPhase.COME_OUT;

        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.PASS, 150, 600, 600, 100));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.NOT_PASS, 150, 450, 600, 100));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.FIELD, 100, 200, 700, 200));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_4, 850, 250, 25, 25));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_6, 900, 250, 25, 25));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_8, 850, 300, 25, 25));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_10, 900, 300, 25, 25));

        pane.getChildren().addAll(betSelections);
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

        for (BetSelection selection : betSelections) {
            if (selection.GetBetAmount() == 0.0) continue;

            switch (selection.Selection()) {
                case PASS:
                    switch (phase) {
                        case COME_OUT:
                            if (total == 7 || total == 11) {
                                CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                                selection.ClearBet();
                                continue;
                            } else if (total == 2 || total == 3 || total == 12) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();
                                continue;
                            } else {
                                crapsPoint = total;
                                //SET POSITION OF POINT TILE HERE ********
                            }
                            break;
                        case POINT:
                            if (total == 7 || total == 11) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                crapsPoint = total;
                                //SET POSITION OF POINT TILE HERE ********
                                continue;
                            } else if (total == crapsPoint) {
                                CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                crapsPoint = total;
                                //SET POSITION OF POINT TILE HERE ********
                                continue;
                            }
                            break;
                        default:
                        case NONE: break;
                    }
                    if (crapsPoint == -1) phase = eCrapsPhase.COME_OUT;
                    else phase = eCrapsPhase.POINT;

                    break;
                case NOT_PASS:


                    break;
                case FIELD:


                    break;
                case HARDWAY_4:


                    break;
                case HARDWAY_6:


                    break;
                case HARDWAY_8:


                    break;
                case HARDWAY_10:


                    break;

                default:
                case NONE: break;
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


    public static double GetBetAmount() { return betAmount; }
}
