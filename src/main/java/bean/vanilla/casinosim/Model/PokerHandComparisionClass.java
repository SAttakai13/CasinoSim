package bean.vanilla.casinosim.Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHandComparisionClass {

    List<Card> handPlayer = new ArrayList<>();
    List<String> PlayerNumbers = new ArrayList<>();
    List<String> PlayerSuits = new ArrayList<>();

    public boolean ThreeOfKind = false;
    public boolean FourOfKind = false;
    public int Highcard = 0;
    public int NumOfPairs = 0;


    public boolean CheckRoyalFlush(List<Card> handPlayer){
        boolean RoyalFlush = false;

        if (handPlayer.containsAll(RoyalFlushOfHearts)) {
            RoyalFlush = true;
        } else if (handPlayer.containsAll(RoyalFlushOfDiamonds)){
            RoyalFlush = true;
        } else if (handPlayer.containsAll(RoyalFlushOfClubs)){
            RoyalFlush = true;
        } else if (handPlayer.containsAll(RoyalFlushOfSpades)){
            RoyalFlush = true;
        } else {
            RoyalFlush = false;
        }
        return RoyalFlush;
    }

    //Suits
    public boolean CheckFlush(List<Card> playerHand){
        boolean Flush = false;
        for (int i = 0; i < 5; i++){
            PlayerSuits.add(playerHand.get(i).GetCardSuitName());
        }
        if (PlayerSuits.get(0).equals("Diamonds") && PlayerSuits.get(1).equals("Diamonds") && PlayerSuits.get(2).equals("Diamonds") && PlayerSuits.get(3).equals("Diamonds") && PlayerSuits.get(4).equals("Diamonds")){
            Flush = true;
        } else if (PlayerSuits.get(0).equals("Clubs") && PlayerSuits.get(1).equals("Clubs") && PlayerSuits.get(2).equals("Clubs") && PlayerSuits.get(3).equals("Clubs") && PlayerSuits.get(4).equals("Clubs")) {
            Flush = true;
        } else if (PlayerSuits.get(0).equals("Hearts") && PlayerSuits.get(1).equals("Hearts") && PlayerSuits.get(2).equals("Hearts") && PlayerSuits.get(3).equals("Hearts") && PlayerSuits.get(4).equals("Hearts")) {
            Flush = true;
        } else if (PlayerSuits.get(0).equals("Spades") && PlayerSuits.get(1).equals("Spades") && PlayerSuits.get(2).equals("Spades") && PlayerSuits.get(3).equals("Spades") && PlayerSuits.get(4).equals("Spades")) {
            Flush = true;
        } else {
            Flush = false;
        }
        return Flush;
    }

    //Numbers and Characters
    public boolean CheckStraight(List<Card> playerHand){
        boolean Straight = false;
        for (int i = 0; i < 5; i++){
            PlayerNumbers.add(playerHand.get(i).GetCardCharacter());
        }

        if (PlayerNumbers.containsAll(Straights2to6)) {
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights3to7)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights4to8)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights6to10)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights7toJ)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights8toQ)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights9toK)){
            Straight = true;
        } else if (PlayerNumbers.containsAll(Straights10toA)){
            Straight = true;
        }else {
            Straight = false;
        }
        return Straight;
    }

    public boolean CheckStraightFlush(List<Card> playerHand){
        boolean StraightFlush = false;
        for (int i = 0; i < 5; i++){
            handPlayer.add(playerHand.get(i));
        }
        //this is diamonds
        if (handPlayer.containsAll(StraightOfDiamonds2to6)) {
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds3to7)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds4to8)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds5to9)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds6to10)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds7toJ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds8toQ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfDiamonds9toK)){
            StraightFlush = true;
        }
        //this is hearts
        else if (handPlayer.containsAll(StraightOfHEARTS2to6)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS3to7)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS4to8)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS5to9)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS6to10)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS7toJ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS8toQ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfHEARTS9toK)){
            StraightFlush = true;
        }
        //this is spades
        else if (handPlayer.containsAll(StraightOfSPADES2to6)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES3to7)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES4to8)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES5to9)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES6to10)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES7toJ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES8toQ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfSPADES9toK)){
            StraightFlush = true;
        }
        //this is clubs
        else if (handPlayer.containsAll(StraightOfCLUBS2to6)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS3to7)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS4to8)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS5to9)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS6to10)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS7toJ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS8toQ)){
            StraightFlush = true;
        } else if (handPlayer.containsAll(StraightOfCLUBS9toK)){
            StraightFlush = true;
        } else {
            StraightFlush = false;
        }
        return StraightFlush;
    }

    public void CheckGroupsAndPairs(List<Card> playerHand){
        for (int i = 0; i < 5; i++){
            PlayerNumbers.add(playerHand.get(i).GetCardCharacter());
        }
        int GroupTypes = 0;
        int count;
        switch (GroupTypes){
            case 0:
                count = Collections.frequency(PlayerNumbers, "2");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }

            case 1:
                count = Collections.frequency(PlayerNumbers, "3");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }

            case 2:
                count = Collections.frequency(PlayerNumbers, "4");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }

            case 3:
                count = Collections.frequency(PlayerNumbers, "5");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }

            case 4:
                count = Collections.frequency(PlayerNumbers, "6");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 5:
                count = Collections.frequency(PlayerNumbers, "7");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 6:
                count = Collections.frequency(PlayerNumbers, "8");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 7:
                count = Collections.frequency(PlayerNumbers, "9");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 8:
                count = Collections.frequency(PlayerNumbers, "10");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 9:
                count = Collections.frequency(PlayerNumbers, "J");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 10:
                count = Collections.frequency(PlayerNumbers, "Q");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 11:
                count = Collections.frequency(PlayerNumbers, "K");
                if (count == 2){
                    NumOfPairs++;
                    GroupTypes++;
                } else if(count == 3){
                    ThreeOfKind = true;
                    GroupTypes++;
                } else if(count == 4){
                    FourOfKind = true;
                    GroupTypes++;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                } else {
                    GroupTypes++;
                }
            case 12:
                count = Collections.frequency(PlayerNumbers, "A");
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                }
                break;
        }
    }




    //Below are the lists for the straights, flushes, and royal flushes
    //ROYALFLUSHES
    public static List<Card> RoyalFlushOfDiamonds = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "10", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "J", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "Q", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "K", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "A", Color.GREEN));

    public static List<Card> RoyalFlushOfSpades = Arrays.asList(new Card(Card.eSuit.SPADES, "10", Color.GREEN),
            new Card(Card.eSuit.SPADES, "J", Color.GREEN),
            new Card(Card.eSuit.SPADES, "Q", Color.GREEN),
            new Card(Card.eSuit.SPADES, "K", Color.GREEN),
            new Card(Card.eSuit.SPADES, "A", Color.GREEN));

    public static List<Card> RoyalFlushOfHearts = Arrays.asList(new Card(Card.eSuit.HEARTS, "10", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "J", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "Q", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "K", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "A", Color.GREEN));

    public static List<Card> RoyalFlushOfClubs = Arrays.asList(new Card(Card.eSuit.CLUBS, "10", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "J", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "Q", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "K", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "A", Color.GREEN));


    //Straight flushes DIAMONDS
    public static List<Card> StraightOfDiamonds2to6 = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "2", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "3", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "4", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "5", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "6", Color.GREEN));

    public static List<Card> StraightOfDiamonds3to7 = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "3", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "4", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "5", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "6", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "7", Color.GREEN));
    public static List<Card> StraightOfDiamonds4to8 = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "4", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "5", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "6", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "7", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "8", Color.GREEN));
    public static List<Card> StraightOfDiamonds5to9 = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "5", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "6", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "7", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "8", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "9", Color.GREEN));

    public static List<Card> StraightOfDiamonds6to10 = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "6", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "7", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "8", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "9", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "10", Color.GREEN));

    public static List<Card> StraightOfDiamonds7toJ = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "7", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "8", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "9", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "10", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "J", Color.GREEN));

    public static List<Card> StraightOfDiamonds8toQ = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "8", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "9", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "10", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "J", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "Q", Color.GREEN));

    public static List<Card> StraightOfDiamonds9toK = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "9", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "10", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "J", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "Q", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "K", Color.GREEN));



    //STRAIGHTS HEARTS
    public static List<Card> StraightOfHEARTS2to6 = Arrays.asList(new Card(Card.eSuit.HEARTS, "2", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "3", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "4", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN));

    public static List<Card> StraightOfHEARTS3to7 = Arrays.asList(new Card(Card.eSuit.HEARTS, "3", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "4", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN));
    public static List<Card> StraightOfHEARTS4to8 = Arrays.asList(new Card(Card.eSuit.HEARTS, "4", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN));
    public static List<Card> StraightOfHEARTS5to9 = Arrays.asList(new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "9", Color.GREEN));


    public static List<Card> StraightOfHEARTS6to10 = Arrays.asList(new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "9", Color.GREEN));

    public static List<Card> StraightOfHEARTS7toJ = Arrays.asList(new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "9", Color.GREEN));

    public static List<Card> StraightOfHEARTS8toQ = Arrays.asList(new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "9", Color.GREEN));

    public static List<Card> StraightOfHEARTS9toK = Arrays.asList(new Card(Card.eSuit.HEARTS, "5", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "6", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "7", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "8", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "9", Color.GREEN));


    //STRAIGHTS SPADES

    public static List<Card> StraightOfSPADES2to6 = Arrays.asList(new Card(Card.eSuit.SPADES, "2", Color.GREEN),
            new Card(Card.eSuit.SPADES, "3", Color.GREEN),
            new Card(Card.eSuit.SPADES, "4", Color.GREEN),
            new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN));

    public static List<Card> StraightOfSPADES3to7 = Arrays.asList(new Card(Card.eSuit.SPADES, "3", Color.GREEN),
            new Card(Card.eSuit.SPADES, "4", Color.GREEN),
            new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN));
    public static List<Card> StraightOfSPADES4to8 = Arrays.asList(new Card(Card.eSuit.SPADES, "4", Color.GREEN),
            new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN));
    public static List<Card> StraightOfSPADES5to9 = Arrays.asList(new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN),
            new Card(Card.eSuit.SPADES, "9", Color.GREEN));

    public static List<Card> StraightOfSPADES6to10 = Arrays.asList(new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN),
            new Card(Card.eSuit.SPADES, "9", Color.GREEN));

    public static List<Card> StraightOfSPADES7toJ = Arrays.asList(new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN),
            new Card(Card.eSuit.SPADES, "9", Color.GREEN));

    public static List<Card> StraightOfSPADES8toQ = Arrays.asList(new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN),
            new Card(Card.eSuit.SPADES, "9", Color.GREEN));

    public static List<Card> StraightOfSPADES9toK = Arrays.asList(new Card(Card.eSuit.SPADES, "5", Color.GREEN),
            new Card(Card.eSuit.SPADES, "6", Color.GREEN),
            new Card(Card.eSuit.SPADES, "7", Color.GREEN),
            new Card(Card.eSuit.SPADES, "8", Color.GREEN),
            new Card(Card.eSuit.SPADES, "9", Color.GREEN));


    //STRAIGHTS CLUBS
    public static List<Card> StraightOfCLUBS2to6 = Arrays.asList(new Card(Card.eSuit.CLUBS, "2", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "3", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "4", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN));

    public static List<Card> StraightOfCLUBS3to7 = Arrays.asList(new Card(Card.eSuit.CLUBS, "3", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "4", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN));
    public static List<Card> StraightOfCLUBS4to8 = Arrays.asList(new Card(Card.eSuit.CLUBS, "4", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN));
    public static List<Card> StraightOfCLUBS5to9 = Arrays.asList(new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "9", Color.GREEN));

    public static List<Card> StraightOfCLUBS6to10 = Arrays.asList(new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "9", Color.GREEN));

    public static List<Card> StraightOfCLUBS7toJ = Arrays.asList(new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "9", Color.GREEN));

    public static List<Card> StraightOfCLUBS8toQ = Arrays.asList(new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "9", Color.GREEN));

    public static List<Card> StraightOfCLUBS9toK = Arrays.asList(new Card(Card.eSuit.CLUBS, "5", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "6", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "7", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "8", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "9", Color.GREEN));



    public static List<String> Straights2to6 = Arrays.asList("2","3","4", "5", "6");
    public static List<String> Straights3to7 = Arrays.asList("3", "4", "5", "6", "7");
    public static List<String> Straights4to8 = Arrays.asList("4", "5", "6", "7", "8");
    public static List<String> Straights5to9 = Arrays.asList("5", "6", "7", "8", "9");
    public static List<String> Straights6to10 = Arrays.asList("6", "7", "8", "9", "10");
    public static List<String> Straights7toJ = Arrays.asList("7", "8", "9", "10", "J");
    public static List<String> Straights8toQ = Arrays.asList("8", "9", "10", "J", "Q");
    public static List<String> Straights9toK = Arrays.asList("9", "10", "J", "Q", "K");
    public static List<String> Straights10toA = Arrays.asList("10", "J", "Q", "K", "A");

}
