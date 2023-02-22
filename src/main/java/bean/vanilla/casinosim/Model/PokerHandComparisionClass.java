package bean.vanilla.casinosim.Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerHandComparisionClass {

    List<Card> handPlayer = new ArrayList<>();
    List<String> PlayerNumbers = new ArrayList<>();
    List<String> PlayerSuits = new ArrayList<>();

    public boolean ThreeOfKind = false;
    public boolean FourOfKind = false;
    public int Highcard = 0;
    public int NumOfPairs = 0;


    public boolean CheckRoyalFlush(Hand playerHand){
        boolean RoyalFlush = false;
        for (int i = 0; i < 5; i++){
            handPlayer.add(playerHand.GetCard(i));
        }

        if (handPlayer.contains(RoyalFlushOfHearts.get(0)) && handPlayer.contains(RoyalFlushOfHearts.get(1)) && handPlayer.contains(RoyalFlushOfHearts.get(2)) && handPlayer.contains(RoyalFlushOfHearts.get(3)) && handPlayer.contains(RoyalFlushOfHearts.get(4))) {
            RoyalFlush = true;
        } else if (handPlayer.contains(RoyalFlushOfDiamonds.get(0)) && handPlayer.contains(RoyalFlushOfDiamonds.get(1)) && handPlayer.contains(RoyalFlushOfDiamonds.get(2)) && handPlayer.contains(RoyalFlushOfDiamonds.get(3)) && handPlayer.contains(RoyalFlushOfDiamonds.get(4))){
            RoyalFlush = true;
        } else if (handPlayer.contains(RoyalFlushOfClubs.get(0)) && handPlayer.contains(RoyalFlushOfClubs.get(1)) && handPlayer.contains(RoyalFlushOfClubs.get(2)) && handPlayer.contains(RoyalFlushOfClubs.get(3)) && handPlayer.contains(RoyalFlushOfClubs.get(4))){
            RoyalFlush = true;
        } else if (handPlayer.contains(RoyalFlushOfSpades.get(0)) && handPlayer.contains(RoyalFlushOfSpades.get(1)) && handPlayer.contains(RoyalFlushOfSpades.get(2)) && handPlayer.contains(RoyalFlushOfSpades.get(3)) && handPlayer.contains(RoyalFlushOfSpades.get(4))){
            RoyalFlush = true;
        } else {
            RoyalFlush = false;
        }
        return RoyalFlush;
    }

    //Suits
    public boolean CheckFlush(Hand playerHand){
        boolean Flush = false;
        for (int i = 0; i < 5; i++){
            PlayerSuits.add(playerHand.GetCard(i).GetCardSuitName());
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
    public boolean CheckStraight(Hand playerHand){
        boolean Straight = false;
        for (int i = 0; i < 5; i++){
            PlayerNumbers.add(playerHand.GetCard(i).GetCardCharacter());
        }

        if (PlayerNumbers.contains(Straights2to6.get(0)) && PlayerNumbers.contains(Straights2to6.get(1)) && PlayerNumbers.contains(Straights2to6.get(2)) && PlayerNumbers.contains(Straights2to6.get(3)) && PlayerNumbers.contains(Straights2to6.get(4))) {
            Straight = true;
        } else if (PlayerNumbers.contains(Straights3to7.get(0)) && PlayerNumbers.contains(Straights3to7.get(1)) && PlayerNumbers.contains(Straights3to7.get(2)) && PlayerNumbers.contains(Straights3to7.get(3)) && PlayerNumbers.contains(Straights3to7.get(4))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights4to8.get(0)) && PlayerNumbers.contains(Straights4to8.get(1)) && PlayerNumbers.contains(Straights4to8.get(2)) && PlayerNumbers.contains(Straights4to8.get(3)) && PlayerNumbers.contains(Straights4to8.get(4))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights6to10.get(0)) && PlayerNumbers.contains(Straights6to10.get(1)) && PlayerNumbers.contains(Straights6to10.get(2)) && PlayerNumbers.contains(Straights6to10.get(3)) && PlayerNumbers.contains(Straights6to10.get(1))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights7toJ.get(0)) && PlayerNumbers.contains(Straights7toJ.get(1)) && PlayerNumbers.contains(Straights7toJ.get(2)) && PlayerNumbers.contains(Straights7toJ.get(3)) && PlayerNumbers.contains(Straights7toJ.get(1))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights8toQ.get(0)) && PlayerNumbers.contains(Straights8toQ.get(1)) && PlayerNumbers.contains(Straights8toQ.get(2)) && PlayerNumbers.contains(Straights8toQ.get(3)) && PlayerNumbers.contains(Straights8toQ.get(1))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights9toK.get(0)) && PlayerNumbers.contains(Straights9toK.get(1)) && PlayerNumbers.contains(Straights5to9.get(2)) && PlayerNumbers.contains(Straights9toK.get(3)) && PlayerNumbers.contains(Straights9toK.get(1))){
            Straight = true;
        } else if (PlayerNumbers.contains(Straights10toA.get(0)) && PlayerNumbers.contains(Straights10toA.get(1)) && PlayerNumbers.contains(Straights10toA.get(2)) && PlayerNumbers.contains(Straights10toA.get(3)) && PlayerNumbers.contains(Straights10toA.get(1))){
            Straight = true;
        }else {
            Straight = false;
        }
        return Straight;
    }

    public boolean CheckStraightFlush(Hand playerHand){
        boolean StraightFlush = false;
        for (int i = 0; i < 5; i++){
            handPlayer.add(playerHand.GetCard(i));
        }
        //this is diamonds
        if (handPlayer.contains(StraightOfDiamonds2to6.get(0)) && handPlayer.contains(StraightOfDiamonds2to6.get(1)) && handPlayer.contains(StraightOfDiamonds2to6.get(2)) && handPlayer.contains(StraightOfDiamonds2to6.get(3)) && handPlayer.contains(StraightOfDiamonds2to6.get(4))) {
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfDiamonds3to7.get(0)) && handPlayer.contains(StraightOfDiamonds3to7.get(1)) && handPlayer.contains(StraightOfDiamonds3to7.get(2)) && handPlayer.contains(StraightOfDiamonds3to7.get(3)) && handPlayer.contains(StraightOfDiamonds3to7.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfDiamonds4to8.get(0)) && handPlayer.contains(StraightOfDiamonds4to8.get(1)) && handPlayer.contains(StraightOfDiamonds4to8.get(2)) && handPlayer.contains(StraightOfDiamonds4to8.get(3)) && handPlayer.contains(StraightOfDiamonds4to8.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfDiamonds5to9.get(0)) && handPlayer.contains(StraightOfDiamonds5to9.get(1)) && handPlayer.contains(StraightOfDiamonds5to9.get(2)) && handPlayer.contains(StraightOfDiamonds5to9.get(3)) && handPlayer.contains(StraightOfDiamonds5to9.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfDiamonds6to10.get(0)) && handPlayer.contains(StraightOfHEARTS6to10.get(1)) && handPlayer.contains(StraightOfHEARTS6to10.get(2)) && handPlayer.contains(StraightOfHEARTS6to10.get(3)) && handPlayer.contains(StraightOfHEARTS6to10.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfDiamonds7toJ.get(0)) && handPlayer.contains(StraightOfDiamonds7toJ.get(1)) && handPlayer.contains(StraightOfDiamonds7toJ.get(2)) && handPlayer.contains(StraightOfDiamonds7toJ.get(3)) && handPlayer.contains(StraightOfDiamonds7toJ.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfDiamonds8toQ.get(0)) && handPlayer.contains(StraightOfDiamonds8toQ.get(1)) && handPlayer.contains(StraightOfDiamonds8toQ.get(2)) && handPlayer.contains(StraightOfDiamonds8toQ.get(3)) && handPlayer.contains(StraightOfDiamonds8toQ.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfDiamonds9toK.get(0)) && handPlayer.contains(StraightOfDiamonds9toK.get(1)) && handPlayer.contains(StraightOfDiamonds9toK.get(2)) && handPlayer.contains(StraightOfDiamonds9toK.get(3)) && handPlayer.contains(StraightOfDiamonds9toK.get(4))){
            StraightFlush = true;
        }
        //this is hearts
        else if (handPlayer.contains(StraightOfHEARTS2to6.get(0)) && handPlayer.contains(StraightOfHEARTS2to6.get(1)) && handPlayer.contains(StraightOfHEARTS2to6.get(2)) && handPlayer.contains(StraightOfHEARTS2to6.get(3)) && handPlayer.contains(StraightOfHEARTS2to6.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfHEARTS3to7.get(0)) && handPlayer.contains(StraightOfHEARTS3to7.get(1)) && handPlayer.contains(StraightOfHEARTS3to7.get(2)) && handPlayer.contains(StraightOfHEARTS3to7.get(3)) && handPlayer.contains(StraightOfHEARTS3to7.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfHEARTS4to8.get(0)) && handPlayer.contains(StraightOfHEARTS4to8.get(1)) && handPlayer.contains(StraightOfHEARTS4to8.get(2)) && handPlayer.contains(StraightOfHEARTS4to8.get(3)) && handPlayer.contains(StraightOfHEARTS4to8.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfHEARTS5to9.get(0)) && handPlayer.contains(StraightOfHEARTS5to9.get(1)) && handPlayer.contains(StraightOfHEARTS5to9.get(2)) && handPlayer.contains(StraightOfHEARTS5to9.get(3)) && handPlayer.contains(StraightOfHEARTS5to9.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfHEARTS6to10.get(0)) && handPlayer.contains(StraightOfHEARTS6to10.get(1)) && handPlayer.contains(StraightOfHEARTS6to10.get(2)) && handPlayer.contains(StraightOfHEARTS6to10.get(3)) && handPlayer.contains(StraightOfHEARTS6to10.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfHEARTS7toJ.get(0)) && handPlayer.contains(StraightOfHEARTS7toJ.get(1)) && handPlayer.contains(StraightOfHEARTS7toJ.get(2)) && handPlayer.contains(StraightOfHEARTS7toJ.get(3)) && handPlayer.contains(StraightOfHEARTS7toJ.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfHEARTS8toQ.get(0)) && handPlayer.contains(StraightOfHEARTS8toQ.get(1)) && handPlayer.contains(StraightOfHEARTS8toQ.get(2)) && handPlayer.contains(StraightOfHEARTS8toQ.get(3)) && handPlayer.contains(StraightOfHEARTS8toQ.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfHEARTS9toK.get(0)) && handPlayer.contains(StraightOfHEARTS9toK.get(1)) && handPlayer.contains(StraightOfHEARTS9toK.get(2)) && handPlayer.contains(StraightOfHEARTS9toK.get(3)) && handPlayer.contains(StraightOfHEARTS9toK.get(4))){
            StraightFlush = true;
        }
        //this is spades
        else if (handPlayer.contains(StraightOfSPADES2to6.get(0)) && handPlayer.contains(StraightOfSPADES2to6.get(1)) && handPlayer.contains(StraightOfSPADES2to6.get(2)) && handPlayer.contains(StraightOfSPADES2to6.get(3)) && handPlayer.contains(StraightOfSPADES2to6.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES3to7.get(0)) && handPlayer.contains(StraightOfSPADES3to7.get(1)) && handPlayer.contains(StraightOfSPADES3to7.get(2)) && handPlayer.contains(StraightOfSPADES3to7.get(3)) && handPlayer.contains(StraightOfSPADES3to7.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES4to8.get(0)) && handPlayer.contains(StraightOfSPADES4to8.get(1)) && handPlayer.contains(StraightOfSPADES4to8.get(2)) && handPlayer.contains(StraightOfSPADES4to8.get(3)) && handPlayer.contains(StraightOfSPADES4to8.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES5to9.get(0)) && handPlayer.contains(StraightOfSPADES5to9.get(1)) && handPlayer.contains(StraightOfSPADES5to9.get(2)) && handPlayer.contains(StraightOfSPADES5to9.get(3)) && handPlayer.contains(StraightOfSPADES5to9.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES6to10.get(0)) && handPlayer.contains(StraightOfSPADES6to10.get(1)) && handPlayer.contains(StraightOfSPADES6to10.get(2)) && handPlayer.contains(StraightOfSPADES6to10.get(3)) && handPlayer.contains(StraightOfSPADES6to10.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES7toJ.get(0)) && handPlayer.contains(StraightOfSPADES7toJ.get(1)) && handPlayer.contains(StraightOfSPADES7toJ.get(2)) && handPlayer.contains(StraightOfSPADES7toJ.get(3)) && handPlayer.contains(StraightOfSPADES7toJ.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES8toQ.get(0)) && handPlayer.contains(StraightOfSPADES8toQ.get(1)) && handPlayer.contains(StraightOfSPADES8toQ.get(2)) && handPlayer.contains(StraightOfSPADES8toQ.get(3)) && handPlayer.contains(StraightOfSPADES8toQ.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfSPADES9toK.get(0)) && handPlayer.contains(StraightOfSPADES9toK.get(1)) && handPlayer.contains(StraightOfSPADES9toK.get(2)) && handPlayer.contains(StraightOfSPADES9toK.get(3)) && handPlayer.contains(StraightOfSPADES9toK.get(4))){
            StraightFlush = true;
        }
        //this is clubs
        else if (handPlayer.contains(StraightOfCLUBS2to6.get(0)) && handPlayer.contains(StraightOfCLUBS2to6.get(1)) && handPlayer.contains(StraightOfCLUBS2to6.get(2)) && handPlayer.contains(StraightOfCLUBS2to6.get(3)) && handPlayer.contains(StraightOfCLUBS2to6.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfCLUBS3to7.get(0)) && handPlayer.contains(StraightOfCLUBS3to7.get(1)) && handPlayer.contains(StraightOfCLUBS3to7.get(2)) && handPlayer.contains(StraightOfCLUBS3to7.get(3)) && handPlayer.contains(StraightOfCLUBS3to7.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfCLUBS4to8.get(0)) && handPlayer.contains(StraightOfCLUBS4to8.get(1)) && handPlayer.contains(StraightOfCLUBS4to8.get(2)) && handPlayer.contains(StraightOfCLUBS4to8.get(3)) && handPlayer.contains(StraightOfCLUBS4to8.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfCLUBS5to9.get(0)) && handPlayer.contains(StraightOfCLUBS5to9.get(1)) && handPlayer.contains(StraightOfCLUBS5to9.get(2)) && handPlayer.contains(StraightOfCLUBS5to9.get(3)) && handPlayer.contains(StraightOfCLUBS5to9.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfCLUBS6to10.get(0)) && handPlayer.contains(StraightOfCLUBS6to10.get(1)) && handPlayer.contains(StraightOfCLUBS6to10.get(2)) && handPlayer.contains(StraightOfCLUBS6to10.get(3)) && handPlayer.contains(StraightOfCLUBS6to10.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfCLUBS7toJ.get(0)) && handPlayer.contains(StraightOfCLUBS7toJ.get(1)) && handPlayer.contains(StraightOfCLUBS7toJ.get(2)) && handPlayer.contains(StraightOfCLUBS7toJ.get(3)) && handPlayer.contains(StraightOfCLUBS7toJ.get(4))){
            StraightFlush = true;
        }else if (handPlayer.contains(StraightOfCLUBS8toQ.get(0)) && handPlayer.contains(StraightOfCLUBS8toQ.get(1)) && handPlayer.contains(StraightOfCLUBS8toQ.get(2)) && handPlayer.contains(StraightOfCLUBS8toQ.get(3)) && handPlayer.contains(StraightOfCLUBS8toQ.get(4))){
            StraightFlush = true;
        } else if (handPlayer.contains(StraightOfCLUBS9toK.get(0)) && handPlayer.contains(StraightOfCLUBS9toK.get(1)) && handPlayer.contains(StraightOfCLUBS9toK.get(2)) && handPlayer.contains(StraightOfCLUBS9toK.get(3)) && handPlayer.contains(StraightOfCLUBS9toK.get(4))){
            StraightFlush = true;
        } else {
            StraightFlush = false;
        }
        return StraightFlush;
    }

    public void CheckGroupsAndPairs(){
        int GroupTypes = 0;
        long count;
        switch (GroupTypes){
            case 0:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("2")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 1:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("3")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 2:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("4")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 3:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("5")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 4:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("6")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 5:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("7")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 6:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("8")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 7:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("9")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 8:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("10")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 9:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("J")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 10:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("Q")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 11:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("K")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                    GroupTypes++;
                }
                break;
            case 12:
                count = handPlayer.stream().filter(handPlayer -> handPlayer.GetCardCharacter().equals("A")).count();
                if (count == 2){
                    NumOfPairs++;
                } else if(count == 3){
                    ThreeOfKind = true;
                } else if(count == 4){
                    FourOfKind = true;
                } else if (count == 1){
                    Highcard++;
                }
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
