package bean.vanilla.casinosim.Controller;

import bean.vanilla.casinosim.CasinoApplication;
import bean.vanilla.casinosim.Model.SlotsWheels;
import javafx.event.ActionEvent;
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
    private Pane bannerPane;
    @FXML
    private Text bannerText;

    @FXML
    private ImageView Spin;

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

    private boolean buttonsDisabled = false;



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
        SlotButtons(buttonsDisabled);
        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
    }

    public void GoBackToMain(MouseEvent event) {
        CasinoApplication.setRoot("TitleScreen");
    }


    public void SpinWheel() throws FileNotFoundException {
        buttonsDisabled = false;
        SlotButtons(buttonsDisabled);
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
        String bannerMessage = "";
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
                    Double Jackpot = betAmount * 10;
                    CasinoApplication.player.AddToBalance(Jackpot);
                    bannerMessage = CasinoApplication.player.GetName() + " JACKPOT!\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Jackpot;
                } else {
                    SlotMatches++;
                }
            case 1: //this is 2
                if ((ConFirst.equals(ConSecond.contains("2"))) && (ConFirst.equals(ConThird.contains("2"))) && (ConSecond.equals(ConThird.contains("2")))){
                    Double cherry = betAmount * 5;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + cherry;
                    CasinoApplication.player.AddToBalance(cherry);
                } else {
                    SlotMatches++;
                }
            case 2: //this is 1
                if ((ConFirst.equals(ConSecond.contains("1"))) && (ConFirst.equals(ConThird.contains("1"))) && (ConSecond.equals(ConThird.contains("1")))){
                    Double Bell = betAmount * 3;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Bell;
                    CasinoApplication.player.AddToBalance(Bell);
                } else {
                    SlotMatches++;
                }
            case 3: //this is 3
                if ((ConFirst.equals(ConSecond.contains("3"))) && (ConFirst.equals(ConThird.contains("3"))) && (ConSecond.equals(ConThird.contains("3")))){
                    Double lemon = betAmount * 3;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + lemon;
                    CasinoApplication.player.AddToBalance(lemon);
                } else {
                    SlotMatches++;
                }
            case 4: //this is 4
                if ((ConFirst.equals(ConSecond.contains("4"))) && (ConFirst.equals(ConThird.contains("4"))) && (ConSecond.equals(ConThird.contains("4")))){
                    Double Melon = betAmount + 75;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Melon;
                    CasinoApplication.player.AddToBalance(Melon);
                } else {
                    SlotMatches++;
                }
            case 5: //this is 0
                if ((ConFirst.equals(ConSecond.contains("0"))) && (ConFirst.equals(ConThird.contains("0"))) && (ConSecond.equals(ConThird.contains("0")))){
                    Double Banana = betAmount + 50;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Banana;
                    CasinoApplication.player.AddToBalance(Banana);
                } else {
                    SlotMatches++;
                }
            case 6: //this is 5
                if ((ConFirst.equals(ConSecond.contains("5"))) && (ConFirst.equals(ConThird.contains("5"))) && (ConSecond.equals(ConThird.contains("5")))){
                    Double Orange = betAmount + 25;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Orange;
                    CasinoApplication.player.AddToBalance(Orange);
                } else {
                    SlotMatches++;
                }
            case 7: //this is 6
                if ((ConFirst.equals(ConSecond.contains("6"))) && (ConFirst.equals(ConThird.contains("6"))) && (ConSecond.equals(ConThird.contains("6")))){
                    Double Plum = betAmount + 15;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Plum;
                    CasinoApplication.player.AddToBalance(Plum);
                } else {
                    SlotMatches++;
                }
            case 8: //this is 7
                if ((ConFirst.equals(ConSecond)) || (ConFirst.equals(ConThird)) || (ConSecond.equals(ConThird))){
                    Double Pairs = betAmount + 50;
                    bannerMessage = CasinoApplication.player.GetName() + " won.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney earned: " + Pairs;
                    CasinoApplication.player.AddToBalance(Pairs);
                } else {
                    SlotMatches++;
                }
            case 9:
                if ((!ConFirst.equals(ConSecond)) && (!ConFirst.equals(ConThird)) && (!ConSecond.equals(ConThird))){
                    Double nothing = betAmount;
                    bannerMessage = CasinoApplication.player.GetName() + " lost.\nBalance: " +  CasinoApplication.player.GetBalance().GetBalance() + "\nMoney lost: " + nothing;
                    CasinoApplication.player.LostPartBalance(nothing);
                    break;
                }
        }


        updateBetsAndBalance(betAmount, CasinoApplication.player.GetBalance().GetBalance());
        bannerText.setText(bannerMessage);
        bannerPane.setVisible(true);
        buttonsDisabled = true;
        SlotButtons(buttonsDisabled);
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

    public void SlotButtons(boolean tool){
        IncreaseBet.setDisable(tool);
        DecreaseBet.setDisable(tool);
        Spin.setDisable(tool);
        if (tool) {
            IncreaseBet.setOpacity(0.5);
            DecreaseBet.setOpacity(0.5);
            Spin.setOpacity(0.5);
        } else if (!tool) {
            IncreaseBet.setOpacity(1);
            DecreaseBet.setOpacity(1);
            Spin.setOpacity(1);
        }

    }

    public void SpinAgainBtnPressed(ActionEvent event) throws FileNotFoundException {
        bannerPane.setVisible(false);
        SlotButtons(false);
    }
}
