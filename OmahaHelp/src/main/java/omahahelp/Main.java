/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import omahahelp.cards.Card;
import static omahahelp.cards.Card.Suit.SPADES;
import omahahelp.cards.Deck;
import omahahelp.cards.PlayersCards;
import omahahelp.compare.Compare;
import omahahelp.compare.HandsValues;
import omahahelp.compare.Values;
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
        Deck deck = new Deck();
        deck.addCards();
        String cardA = "2 of CLUBS";
        String cardB = "14 of CLUBS";
        String cardC = "3 of CLUBS";
        String cardD = "4 of CLUBS";
        Card a = deck.getCardByString(cardA);
        Card b = deck.getCardByString(cardB);
        Card c = deck.getCardByString(cardC);
        Card d = deck.getCardByString(cardD);
        System.out.println(a.toString());
        PlayersCards handA = new PlayersCards(deck, a, b);
        PlayersCards handB = new PlayersCards(deck, c, d);
        Compare compare = new Compare(handA, handB, deck);
        compare.addWinsAndCardsToHashMaps(false, true);
        System.out.println(compare.getAwins());

    }
}
