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
public class PlayersCards {

    private Cards cards;
    private Card cardA;
    private Card cardB;

    public PlayersCards(Cards cards, Card a, Card b) {
        this.cards = cards;
        if (this.cards.getCards().contains(b) & this.cards.getCards().contains(a)) {
            this.cardB = b;
            cards.eraseCards(b);
            this.cardA = a;
            cards.eraseCards(a);
        } else {
            System.out.println("kortti pöydällä tai vastustajan kädessä");
        }
    }

}
