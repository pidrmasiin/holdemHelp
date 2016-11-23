/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import static omahahelp.cards.Card.Suit.CLUBS;
import static omahahelp.cards.Card.Suit.DIAMONDS;
import static omahahelp.cards.Card.Suit.HEARTS;

/**
 *
 * @author petteri
 */
public class Card {

    /**
     *Luodaan maat
     */
    public enum Suit {

        CLUBS, DIAMONDS, HEARTS, SPADES
    }
    
    private final Suit suit;
    private int number;

    public Card(int number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getNumber() {
        return this.number;
    }
    
    /**
     * Luodaan maille Integer-arvo
     * @return maiden Integer-arvo
     */
    public int getIntForSuit(){
        if(this.suit.equals(CLUBS)){
            return 0;
        }if(this.suit.equals(DIAMONDS)){
            return 100;
        }if(this.suit.equals(HEARTS)){
            return 1000;
        }return 10000;
    }
    
    /**
     * Luodaan jokaiselle kortille Integer-arvo
     * @return kortin Integer-arvo
     */
    public int getIdForCard(){
        return this.number + this.getIntForSuit();
    }

    @Override
    public String toString() {
        return number + " of " + suit;
    }
}
