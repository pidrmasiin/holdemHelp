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
 * Luokan avulla arvotaan pakasta kortteja.
 *
 * @author petteri
 */
public class Draw {

    /**
     *Alustus.
     */
    public Deck cards;

    /**
     * Alustus.
     * @param cards lisätään pakka.
     */
    public Draw(Deck cards) {
        this.cards = cards;
    }

    /**
     *Arvotaan kortti pakasta.
     * @return palauttaa arvotun kortin.
     */
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

    /**
     * Arpoo flopin
     * @return palauttaa arvotun flopin.
     */
    public ArrayList<Card> drawFlop() {
        ArrayList<Card> flop = new ArrayList<>();
        flop.add(this.drawCard());
        flop.add(this.drawCard());
        flop.add(this.drawCard());

        return flop;
    }

}
