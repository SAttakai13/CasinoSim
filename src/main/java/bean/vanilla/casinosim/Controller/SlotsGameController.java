package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.SlotsWheels;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class SlotsGameController implements Initializable {

    @FXML
    private Pane pane;

    @FXML
    private Text BetText;
    @FXML
    private Text BalText;
    @FXML
    private ImageView IncreaseBet;
    @FXML
    private ImageView DecreaseBet;


    @FXML
    private ImageView Slot1;

    @FXML
    private ImageView Slot2;

    @FXML
    private ImageView Slot3;



    private double betAmount = 50.0;

    Random firstNum = new Random();
    Random secondNum = new Random();
    Random thirdNum = new Random();
    SlotsWheels wheels = new SlotsWheels();

    public int slot1 = 0;
    public int slot2 = 0;
    public int slot3 = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }


    public void SpinWheel() throws FileNotFoundException {
        wheels.fillWheel().clear();
        slot1 = firstNum.nextInt(0, 7);
        slot2 = secondNum.nextInt(0, 7);
        slot3 = thirdNum.nextInt(0, 7);
        Slot1.setImage(wheels.fillWheel().get(slot1));
        Slot2.setImage(wheels.fillWheel().get(slot2));
        Slot3.setImage(wheels.fillWheel().get(slot3));

        DetermineSlots(slot1, slot2, slot3);
    }

    public void DetermineSlots(int firstSlot, int secondSlot, int thirdSlot){
        String ConFirst = firstSlot + "";
        String ConSecond = secondSlot + "";
        String ConThird = thirdSlot + "";

        System.out.println(ConFirst);
        System.out.println(ConSecond);
        System.out.println(ConThird);

        int SlotMatches = 0;
        switch (SlotMatches){
            case 0:
                if ((ConFirst.equals(ConSecond.contains("7"))) && (ConFirst.equals(ConThird.contains("7"))) && (ConSecond.equals(ConThird.contains("7")))){
                    CasinoApplication.player.AddToBalance(betAmount * 10);
                } else {
                    SlotMatches++;
                }
            case 1: //this is 2
                if ((ConFirst.equals(ConSecond.contains("2"))) && (ConFirst.equals(ConThird.contains("2"))) && (ConSecond.equals(ConThird.contains("2")))){
                    CasinoApplication.player.AddToBalance(betAmount * 5);
                } else {
                    SlotMatches++;
                }
            case 2: //this is 1
                if ((ConFirst.equals(ConSecond.contains("1"))) && (ConFirst.equals(ConThird.contains("1"))) && (ConSecond.equals(ConThird.contains("1")))){
                    CasinoApplication.player.AddToBalance(betAmount * 3);
                } else {
                    SlotMatches++;
                }
            case 3: //this is 3
                if ((ConFirst.equals(ConSecond.contains("3"))) && (ConFirst.equals(ConThird.contains("3"))) && (ConSecond.equals(ConThird.contains("3")))){
                    CasinoApplication.player.AddToBalance(betAmount * 3);
                } else {
                    SlotMatches++;
                }
            case 4: //this is 4
                if ((ConFirst.equals(ConSecond.contains("4"))) && (ConFirst.equals(ConThird.contains("4"))) && (ConSecond.equals(ConThird.contains("4")))){
                    CasinoApplication.player.AddToBalance(betAmount + 75);
                } else {
                    SlotMatches++;
                }
            case 5: //this is 0
                if ((ConFirst.equals(ConSecond.contains("0"))) && (ConFirst.equals(ConThird.contains("0"))) && (ConSecond.equals(ConThird.contains("0")))){
                    CasinoApplication.player.AddToBalance(betAmount + 50);
                } else {
                    SlotMatches++;
                }
            case 6: //this is 5
                if ((ConFirst.equals(ConSecond.contains("5"))) && (ConFirst.equals(ConThird.contains("5"))) && (ConSecond.equals(ConThird.contains("5")))){
                    CasinoApplication.player.AddToBalance(betAmount + 25);
                } else {
                    SlotMatches++;
                }
            case 7: //this is 6
                if ((ConFirst.equals(ConSecond.contains("6"))) && (ConFirst.equals(ConThird.contains("6"))) && (ConSecond.equals(ConThird.contains("6")))){
                    CasinoApplication.player.AddToBalance(betAmount + 15);
                } else {
                    SlotMatches++;
                }
            case 8: //this is 7
                if ((ConFirst.equals(ConSecond)) || (ConFirst.equals(ConThird)) || (ConSecond.equals(ConThird))){
                    CasinoApplication.player.AddToBalance(betAmount + 50);
                } else {
                    SlotMatches++;
                }
            case 9:
                if ((!ConFirst.equals(ConSecond)) && (!ConFirst.equals(ConThird)) && (!ConSecond.equals(ConThird))){
                    CasinoApplication.player.LostPartBalance(betAmount);
                    break;
                }
        }


        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }





    public void Quit(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }

    public void Spin(MouseEvent event) throws FileNotFoundException {
        SpinWheel();
    }

    public void updateBetsAndBalance(double bets, double playerBalance){
        BetText.setLayoutX(857.0);
        BetText.setLayoutY(801.0);

        BalText.setLayoutX(784.0);
        BalText.setLayoutY(857.0);

        BetText.setText("Bet: $" + bets);
        BalText.setText("Balance: $" + playerBalance);
    }

    public void DecreaseBet(MouseEvent event) {
        if (betAmount <= 0){
            DecreaseBet.setDisable(true);
            DecreaseBet.setOpacity(0.5);
            betAmount = 0;
        } else if (betAmount > 0){
            DecreaseBet.setDisable(false);
            betAmount -= 50;
            if (IncreaseBet.isDisable() == true){
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
            if (DecreaseBet.isDisable() == true){
                DecreaseBet.setDisable(false);
                DecreaseBet.setOpacity(1);
            }
        }
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }
}
