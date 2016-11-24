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
        Deck cards = new Deck();
        cards.addCards();
        Card cardA = new Card(13, SPADES);
        Card cardB = new Card(3, SPADES);
        Card cardC = new Card(2, SPADES);
        Card cardD = new Card(14, SPADES);
        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
        Compare compare = new Compare(handA, handB, cards);
        System.out.println(cards.sum());
        compare.helpToAddFlopsToHashMaps();

        System.out.println(compare.getMap().keySet().size());
        System.out.println(compare.getCards().sum());
        System.out.println("");
        System.out.println("");

        System.out.println(handA.toString() + ":" + compare.getAwins());
        System.out.println(handB.toString() + ":" + compare.getbWins());
        System.out.println("Ties:" + compare.getTies());
        int yhteensa = +compare.getTies() + compare.getbWins() + compare.getAwins();
        System.out.println("Yhteensä: " + yhteensa);

        System.out.println(handA.toString() + ": " + compare.getOddsForAwins() + " % ");

    }
}
