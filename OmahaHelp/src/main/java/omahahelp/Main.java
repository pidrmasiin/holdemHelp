/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp;

import omahahelp.gui.GUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import omahahelp.cards.Card;
import static omahahelp.cards.Card.Suit.SPADES;
import omahahelp.cards.Deck;
import omahahelp.cards.PlayersCards;
import omahahelp.compare.Compare;
import omahahelp.compare.HandsValue;
import omahahelp.compare.Value;
import omahahelp.deal.Draw;

/**
 *
 * @author petteri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


//        Deck deck = new Deck();
//        deck.addCards();
//        String cardA = "2 of DIAMONDS";
//        String cardB = "2 of SPADES";
//        String cardC = "2 of CLUBS";
//        String cardD = "2 of HEARTS";
//        Card a = deck.getCardByString(cardA);
//        Card b = deck.getCardByString(cardB);
//        Card c = deck.getCardByString(cardC);
//        Card d = deck.getCardByString(cardD);
//        System.out.println(a.toString());
//        PlayersCards handA = new PlayersCards(deck, a, b);
//        PlayersCards handB = new PlayersCards(deck, c, d);
//        Compare compare = new Compare(deck);
//        compare.setHands(handA, handB);
//        compare.addCardsToFlopHashMap();
//        compare.addTurnsToMap();
//        System.out.println(compare.getTurns().size() + "moo");
//        
////        compare.compareTurns();
////        System.out.println("");
////        System.out.println(compare.getAwins() + "/" + compare.getTurns().size());
////        System.out.println(compare.getbWins() + "/" + compare.getTurns().size());
////        System.out.println(compare.getTies() + "/" + compare.getTurns().size());
////      so
//     
//        compare.addCardsToFlopHashMap();
//        System.out.println(compare.getRiversMap().size());
//        
////        compare.makeMapOfAll5CardsCombinations();
//        

    }
}
