package bean.vanilla.casinosim.Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private ArrayList<Card> cards;


    public Deck() {
        cards = new ArrayList<>();
        FillDeck();
        Shuffle();
    }
    public Deck(double scale) {
        cards = new ArrayList<>();
        FillDeck(scale);
        Shuffle();
    }
    public Deck(Color cardBackColor) {
        cards = new ArrayList<>();
        FillDeck(cardBackColor);
        Shuffle();
    }
    public Deck(Color cardBackColor, double scale) {
        cards = new ArrayList<>();
        FillDeck(cardBackColor, scale);
        Shuffle();
    }

    public void FillDeck() {FillDeck(Color.RED, 1.0);}
    public void FillDeck(double scale) { FillDeck(Color.RED, scale); }
    public void FillDeck(Color backColor) { FillDeck(backColor, 1.0); }
    public void FillDeck(Color cardBackColor, double scale){
        Clear();

        String valueCharacter;
        Card.eSuit suitCharacter;
        for (int suit = 0; suit < 4; suit++) {
            suitCharacter = Card.eSuit.values()[suit];
            for (int value = 1; value < 14; value++) {
                if (value == 1) valueCharacter = "A";
                else if (value == 11) valueCharacter = "J";
                else if (value == 12) valueCharacter = "Q";
                else if (value == 13) valueCharacter = "K";
                else valueCharacter = (value + "");

                Card card = new Card(suitCharacter, valueCharacter+"", cardBackColor);
                card.Scale(scale);
                cards.add(card);
            }
        }
    }

    public void Clear(){
        cards.clear();
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }

    //public Card GetTopCard() { return cards.get(0); }

    public void DealCard(Player player) {
        if (cards == null || cards.size() == 0) return;
        player.playerHand.AddToHand(cards.get(0));
        cards.remove(0);
    }
    public void DealCard(Hand hand) {
        if (cards == null || cards.size() == 0) return;
        hand.AddToHand(cards.get(0));
        cards.remove(0);
    }

    public void DealCard(List<Card> listCards) {
        if (cards == null || cards.size() == 0) return;
        listCards.add(cards.get(0));
        cards.remove(0);
    }

    public void TakeCardFromPlayer(Player player, Card card) {
        if (cards == null) return;
        player.playerHand.removeOneFromHand(card);
        cards.add(card);
    }
}
