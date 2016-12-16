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
import static omahahelp.cards.Card.Suit.HEARTS;
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

        Deck deck = new Deck();
        deck.addCards();
        String cardA = "2 of DIAMONDS";
        String cardB = "14 of SPADES";
        String cardC = "2 of CLUBS";
        String cardD = "2 of HEARTS";
        Card a = deck.getCardByString(cardA);
        Card b = deck.getCardByString(cardB);
        Card c = deck.getCardByString(cardC);
        Card d = deck.getCardByString(cardD);

        String cardQ = "5 of CLUBS";

        String cardW = "3 of CLUBS";
        String cardE = "6 of HEARTS";
        Card t = new Card(4, HEARTS);

        Card q = deck.getCardByString(cardQ);
        Card w = deck.getCardByString(cardW);
        Card e = deck.getCardByString(cardE);

        Deck turn = new Deck();
        turn.addOneCard(q);
        turn.addOneCard(t);
        turn.addOneCard(w);
        turn.addOneCard(e);

        PlayersCards handA = new PlayersCards(deck, a, b);
        PlayersCards handB = new PlayersCards(deck, c, d);

        Value aa = new Value();
        Value bb = new Value();

        Compare compare = new Compare(deck);
        compare.setHands(handA, handB);
        aa = compare.compareTurns(turn, handA);
        bb = compare.compareTurns(turn, handB);

        System.out.println(aa.getValue());
        System.out.println(bb.getValue());

    }
}
