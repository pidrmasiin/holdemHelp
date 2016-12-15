/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import omahahelp.compare.Value;

/**
 * Luokan avulla asetetaan pelaajille kortit.
 *
 * @author petteri
 */
public class PlayersCards {

    private Card cardA;
    private Card cardB;

    /**
     * Asetetaan pakasta pelaajalle kortit, jos pakassa kyseiset kortit.
     *
     * @param cards valitaan pakka, josta vedetään
     * @param a pakasta otettu kortti
     * @param b pakasta otettu kortti
     */
    public PlayersCards(Deck cards, Card a, Card b) {

        if (cards.getCardsContainsCardandEraseCard(a) && cards.getCardsContainsCardandEraseCard(b)) {
            this.cardA = a;
            this.cardB = b;

        }
    }

    /**
     * Luodaan käsi yhdellä kortilla.
     * @param cards pakka, josta käsi luodaan.
     * @param a kortti, joka asetetaan käteen, jos löytyy pakasta.
     */
    public PlayersCards(Deck cards, Card a) {
        if (cards.getCardsContainsCardandEraseCard(a)) {
            this.cardA = a;
        }
    }

    /**
     * Asetetaan käteen toinen kortti pakasta.
     * @param cards pakka, josta kortti asetetaan.
     * @param b kortti, joka asetetaan, jos löytyy pakasta.
     */
    public void setCardB(Deck cards, Card b) {
        if (cards.getCardsContainsCardandEraseCard(b)) {
            this.cardB = b;
        }

    }

    public Card getCardA() {
        return this.cardA;
    }

    public Card getCardB() {
        return this.cardB;
    }

    @Override
    public String toString() {
        return this.cardA.toString() + " & " + this.cardB.toString();
    }

}
