/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.deal;

import java.util.ArrayList;
import java.util.Random;
import omahahelp.cards.Card;
import static omahahelp.cards.Card.Suit.SPADES;
import omahahelp.cards.Deck;

/**
 *
 * @author petteri
 */
public class Draw {

    public Deck cards;

    public Draw(Deck cards) {
        this.cards = cards;
    }

    public Card drawCard() {
        Card a = new Card(15, SPADES);
        Random randomGenerator = new Random();
        if (this.cards.getCards().isEmpty()) {
            System.out.println("Pakka tyhjä");
            return a;
        } else {
            int randomInt = randomGenerator.nextInt(this.cards.getCards().size());

            a = cards.getCard(randomInt);
            cards.eraseCards(a);

            return a;
        }
    }

    public ArrayList<Card> drawFlop() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(this.drawCard());
        flop.add(this.drawCard());
        flop.add(this.drawCard());

        return flop;
    }

}
