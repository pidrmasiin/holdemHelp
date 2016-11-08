/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

/**
 *
 * @author petteri
 */
public class Card {

    private int number;
    private int suit;

    public Card(int number, int suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return number + "x" + suit;
    }
}
