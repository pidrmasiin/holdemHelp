/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import java.util.ArrayList;
import java.util.Collections;
import omahahelp.cards.Card;
import omahahelp.cards.Card.Suit;
import static omahahelp.cards.Card.Suit.SPADES;

/**
 * Luokan avulla muodostetaan pakkoja.
 *
 * @author petteri
 */
public class Deck {

    public ArrayList<Card> cards;

    /**
     * Luodaan pakka.
     */
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    /**
     * Lisätään pakkaan kaikki 52 korttia.
     */
    public void addCards() {
        for (Suit suit : Suit.values()) {
            for (int x = 2; x < 15; x++) {
                Card card = new Card(x, suit);
                this.cards.add(card);

            }
        }

    }

    /**
     * Lisätään joki Deck-pakka tähän Deck-pakkaan. 
     * @param deck pakka, joka lisätään.
     */
    public void addDeck(Deck deck) {
        for (Card card : deck.cards) {
            this.addOneCard(card);
        }
    }

    public ArrayList getCards() {
        return this.cards;
    }

    public int size() {
        return cards.size();
    }

    /**
     * Etsitään pakasta kortti Stringin mukaan.
     *
     * @param x halutun kortin String
     * @return haluttu kortti
     */
    public Card getCardByString(String x) {
        Card b = new Card(15, SPADES);
        for (Card a : this.cards) {
            if (a.toString().equals(x)) {
                b = a;
            }
        }
        return b;
    }

    /**
     * Haetaan tietystä kohtaa pakkaa olevan kortin String-muoto.
     *
     * @param x määritetään, mistä kohtaa kortti haetaan
     * @return palautetaan kortin String
     */
    public String getCardString(int x) {
        return cards.get(x).toString();
    }

    public Card getCard(int x) {
        return cards.get(x);
    }

    /**
     * Lisätään pakkaan haluttu kortti.
     *
     * @param a haluttu kortti
     */
    public void addOneCard(Card a) {
        this.cards.add(a);
    }


    public void addAndErase(Card a, int x) {
        this.cards.remove(x);
        this.cards.add(a);
    }

    public void eraseByString(String x) {
        Card a = this.getCardByString(x);
        this.eraseCards(a);
    }

    public void erase() {
        this.cards.clear();
    }

    /**
     * Katsotaan sisältääkö pakka tietyn kortin, jos sisältää poistetaan
     * kyseinen kortti.
     *
     * @param a poistettava kortti
     * @return true, jos kortti löytyi ja poistettiin
     */
    public boolean getCardsContainsCardandEraseCard(Card a) {
        for (int x = 0; x < this.cards.size(); x++) {
            if (this.cards.get(x).getNumber() == a.getNumber() && this.cards.get(x).getSuit() == a.getSuit()) {
                this.eraseCards(this.getCard(x));
                return true;
            }
        }
        return false;
    }

    public boolean getContainsByString(String s) {
        for (Card c : this.cards) {
            if (c.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Poistetaan haluttu kortti pakasta.
     *
     * @param x poistettava kortti
     */
    public void eraseCards(Card x) {
        if (this.cards.contains(x)) {
            cards.remove(x);
        } else {
            System.out.println("Kortti ei ole pakassa");
        }
    }

    public void sort() {
        Collections.sort(cards, (Card o1, Card o2) -> o2.getIdForCard() - o1.getIdForCard());
    }

    public String getString() {
        this.sort();
        String out = "";
        for (Card card : cards) {
            out += card.toString() + ";";
        }
        return out;
    }

}
