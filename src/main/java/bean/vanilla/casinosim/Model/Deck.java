package bean.vanilla.casinosim.Model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        FillDeck();
        Shuffle();
    }

    public void FillDeck(){
        cards = new ArrayList<>();

        String valueCharacter;
        eSuit suitCharacter;
        for (int suit = 0; suit < 4; suit++) {
            suitCharacter = eSuit.values()[suit];
            for (int value = 1; value < 14; value++) {
                if (value == 1) valueCharacter = "A";
                else if (value == 11) valueCharacter = "J";
                else if (value == 12) valueCharacter = "Q";
                else if (value == 13) valueCharacter = "K";
                else valueCharacter = (value + "");

                cards.add(new Card(suitCharacter, valueCharacter+""));
            }
        }
    }

    public void Clear(){
        cards.clear();
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }


    public void HitCard(Player player){
        player.AddToHand(cards.get(0));
        cards.remove(0);
    }
}
