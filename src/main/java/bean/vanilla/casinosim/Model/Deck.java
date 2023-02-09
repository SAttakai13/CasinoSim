package bean.vanilla.casinosim.Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        FillDeck();
        Shuffle();
    }
    public Deck(Color cardBackColor) {
        cards = new ArrayList<>();
        FillDeck(cardBackColor);
        Shuffle();
    }

    public void FillDeck() { FillDeck(Color.RED); }
    public void FillDeck(Color cardBackColor){
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

                cards.add(new Card(suitCharacter, valueCharacter+"", cardBackColor));
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

    public void TakeCardFromPlayer(Player player, Card card) {
        if (cards == null) return;
        player.playerHand.removeOneFromHand(card);
        cards.add(card);
    }
}
