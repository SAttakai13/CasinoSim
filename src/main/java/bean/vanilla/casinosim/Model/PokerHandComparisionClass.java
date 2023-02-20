package bean.vanilla.casinosim.Model;

import bean.vanilla.casinosim.CasinoApplication;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerHandComparisionClass {
    private Hand playerHand;

    List<Card> handPlayer = new ArrayList<>();
    public int numMatches;


    public void CheckRoyalFlush(Hand playerHand){
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
    }

    //Not for certain about this (Found A solution?)
    public void StraightFlush(Hand playerHand){
        boolean StraightFlush = false;
        for (int i = 0; i < 5; i++){
            handPlayer.add(playerHand.GetCard(i));
        }


    }


    //Below are the lists for the straights, flushes, and royal flushes
    //ROYAL FLUSHES
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

}
