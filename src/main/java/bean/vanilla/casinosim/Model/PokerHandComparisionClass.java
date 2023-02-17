package bean.vanilla.casinosim.Model;

import bean.vanilla.casinosim.CasinoApplication;

import java.util.ArrayList;
import java.util.List;

public class PokerHandComparisionClass {
    private Hand playerHand;
    public int numMatches;

    PokerHandLists HandComparison = new PokerHandLists();


    public void CheckRoyalFlush(Hand playerHand){
        boolean RoyalFlush = false;
        ArrayList<String> handPlayer = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            handPlayer.add(playerHand.GetCard(i).GetCardCharacter());
        }

//        if () {
//
//        } else if(){
//
//        } else if(){
//
//        } else if(){
//
//        }
    }

    //Not for certain about this
    public void StraightFlush(Hand playerHand){

    }


    public void FourOfAKind(Hand playerHand){


    }





}
