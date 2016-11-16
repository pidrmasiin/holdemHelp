/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import omahahelp.compare.Values;

/**
 *
 * @author petteri
 */
public class PlayersCards {

   
    private Card cardA;
    private Card cardB;

    public PlayersCards(Cards cards, Card a, Card b) {
        
        if (cards.getCardsContainsCardandEraseCard(a) && cards.getCardsContainsCardandEraseCard(b)) {
            this.cardA = a;
            this.cardB = b;
            System.out.println("hoid");
        } else {
            System.out.println("kortti pöydällä tai vastustajan kädessä");
        }
    }

    

}
