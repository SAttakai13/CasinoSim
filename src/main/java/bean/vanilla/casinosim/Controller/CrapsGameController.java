package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.BetSelection;
import bean.vanilla.casinosim.Model.Dice;
import bean.vanilla.casinosim.Model.eCrapsBetSelection;
import bean.vanilla.casinosim.Model.eCrapsPhase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class CrapsGameController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private GridPane DiceGrid;
    @FXML
    private ImageView PointMarker;
    private final double[] pointerPositions = new double[] { 85, 210, 340, 410, 540, 710 };


    private final String indicatorImagePath = "src/main/resources/CasinoAssets/Craps/";
    private final String offIndicatorImagePath = indicatorImagePath + "CrapsOffIndicator.png";
    private final String onIndicatorImagePath = indicatorImagePath + "CrapsOnIndicator.png";


    @FXML
    private ImageView IncreaseBet;
    @FXML
    private ImageView DecreaseBet;
    @FXML
    private Text BetText;
    @FXML
    private Text BalText;


    private static double betAmount = 100.0;

    public static double totalBet = 0.0;
    private Dice d1, d2;

    private boolean isFirstRoll = true;

    private List<BetSelection> betSelections = new ArrayList<>();
    public static eCrapsPhase phase = eCrapsPhase.NONE;

    private int crapsPoint = -1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        d1 = new Dice();
        DiceGrid.add(d1, 0, 0);
        d2 = new Dice();
        DiceGrid.add(d2, 1, 0);

        isFirstRoll = true;
        phase = eCrapsPhase.COME_OUT;

        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.PASS, 89, 587, 711, 69));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.NOT_PASS, 89, 528, 711, 56));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.FIELD, 89, 396, 711, 129));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_4, 831, 59, 140, 58));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_6, 831, 120, 140, 58));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_8, 974, 120, 140, 58));
        betSelections.add(new BetSelection(0.0, eCrapsBetSelection.HARDWAY_10, 974, 59, 140, 58));

        pane.getChildren().addAll(betSelections);

        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
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

                                SetPoint(-1);
                                continue;
                            } else if (total == 2 || total == 3 || total == 12) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            } else {
                                SetPoint(total);
                            }
                            break;
                        case POINT:
                            if (total == 7 || total == 11) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            } else if (total == crapsPoint) {
                                CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            }
                            break;
                        default:
                        case NONE: break;
                    }

                    break;
                case NOT_PASS:
                    switch (phase) {
                        case COME_OUT:
                            if (total == 7 || total == 11) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            } else if (total == 2 || total == 3 || total == 12) {
                                CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            } else {
                                SetPoint(total);
                            }
                            break;
                        case POINT:
                            if (total == 7 || total == 11) {
                                CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            } else if (total == crapsPoint) {
                                CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                                selection.ClearBet();

                                SetPoint(-1);
                                continue;
                            }
                            break;
                        default:
                        case NONE: break;
                    }

                    break;
                case FIELD:
                    if (total == 3 || total == 4 || total == 9 || total == 10 || total == 11) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount());
                    } else if (total == 2) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 2.0);
                    } else if (total == 12) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 3.0);
                    } else {
                        CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                    }
                    SetPoint(total);
                    selection.ClearBet();
                    continue;

                case HARDWAY_4:
                    if (total == 4 && d1.GetNumber() == d2.GetNumber()) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 7.0);
                    } else {
                        CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                    }
                    selection.ClearBet();
                    continue;
                case HARDWAY_6:
                    if (total == 6 && d1.GetNumber() == d2.GetNumber()) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 9.0);
                    } else {
                        CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                    }
                    selection.ClearBet();
                    continue;
                case HARDWAY_8:
                    if (total == 8 && d1.GetNumber() == d2.GetNumber()) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 9.0);
                    } else {
                        CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                    }
                    selection.ClearBet();
                    continue;
                case HARDWAY_10:
                    if (total == 10 && d1.GetNumber() == d2.GetNumber()) {
                        CasinoApplication.player.AddToBalance(selection.GetBetAmount() * 7.0);
                    } else {
                        CasinoApplication.player.LostPartBalance(selection.GetBetAmount());
                    }
                    selection.ClearBet();
                    continue;

                default:
                case NONE: break;
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }


    private void SetPoint(int point) {
        if (point != -1 && point != 4 && point != 5 && point != 6 && point != 8 && point != 9 && point != 10)
            return;
        crapsPoint = point;

        if (point == -1)
            phase = eCrapsPhase.COME_OUT;
        else phase = eCrapsPhase.POINT;

        //Set position of point indicator
        SetPointerPosition(crapsPoint);
    }
    private void SetPointerPosition(int pos) {
        if (pos == -1) {
            PointMarker.setLayoutX(710);
            PointMarker.setLayoutY(256);
        }
        else {
            PointMarker.setLayoutY(50);
            switch (pos) {
                case 4 -> PointMarker.setLayoutX(pointerPositions[0]);
                case 5 -> PointMarker.setLayoutX(pointerPositions[1]);
                case 6 -> PointMarker.setLayoutX(pointerPositions[2]);
                case 8 -> PointMarker.setLayoutX(pointerPositions[3]);
                case 9 -> PointMarker.setLayoutX(pointerPositions[4]);
                case 10 -> PointMarker.setLayoutX(pointerPositions[5]);
            }
        }

        //Set image
        try {
            PointMarker.setImage(new Image(new FileInputStream(phase == eCrapsPhase.POINT ? onIndicatorImagePath : offIndicatorImagePath)));
        } catch (FileNotFoundException e) {
            System.out.println("Point Marker "+(phase == eCrapsPhase.POINT ? "ON" : "OFF")+" Indicator image not found");
        }
    }


    @FXML
    private void Quit(MouseEvent e) {
        CasinoApplication.setRoot("TitleScreen");
    }


    public static double GetBetAmount() { return betAmount; }


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
