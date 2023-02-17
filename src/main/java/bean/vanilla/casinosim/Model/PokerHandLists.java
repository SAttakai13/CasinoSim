package bean.vanilla.casinosim.Model;

import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.List;

public class PokerHandLists {
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


    public static List<Card> StraightOfDiamonds = Arrays.asList(new Card(Card.eSuit.DIAMONDS, "A", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "2", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "3", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "4", Color.GREEN),
            new Card(Card.eSuit.DIAMONDS, "5", Color.GREEN));

    public static List<Card> StraightOfHearts = Arrays.asList(new Card(Card.eSuit.HEARTS, "A", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "2", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "3", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "4", Color.GREEN),
            new Card(Card.eSuit.HEARTS, "5", Color.GREEN));


    public static List<Card> StraightOfSpades = Arrays.asList(new Card(Card.eSuit.SPADES, "A", Color.GREEN),
            new Card(Card.eSuit.SPADES, "2", Color.GREEN),
            new Card(Card.eSuit.SPADES, "3", Color.GREEN),
            new Card(Card.eSuit.SPADES, "4", Color.GREEN),
            new Card(Card.eSuit.SPADES, "5", Color.GREEN));

    public static List<Card> StraightOfClubs = Arrays.asList(new Card(Card.eSuit.CLUBS, "A", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "2", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "3", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "4", Color.GREEN),
            new Card(Card.eSuit.CLUBS, "5", Color.GREEN));


    public static List<String> StraightTwotoSix = Arrays.asList("2", "3", "4", "5", "6");
    public static List<String> StraightThreetoSeven = Arrays.asList("3", "4", "5", "6", "7");
    public static List<String> StraightFourtoEight = Arrays.asList("4", "5", "6", "7", "8");
    public static List<String> StraightFivetoNine = Arrays.asList("5", "6", "7", "8", "9");
    public static List<String> StraightSixtoTen = Arrays.asList("6", "7", "8", "9", "10");
    public static List<String> StraightSeventoJ = Arrays.asList("7", "8", "9", "10", "J");
    public static List<String> StraightEighttoQ = Arrays.asList("8", "9", "10", "J", "Q");
    public static List<String> StraightNinetoK = Arrays.asList("9", "10", "J", "Q", "K");
    public static List<String> StraightTentoA = Arrays.asList("10", "J", "Q", "K", "A");



}
