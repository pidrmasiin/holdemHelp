/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp;

import omahahelp.cards.Card;
import omahahelp.cards.Cards;
import omahahelp.cards.PlayersCards;
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
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        
               values.setCardsToHand(cards.getCard(14), cards.getCard(2), cards.getCard(13), cards.getCard(17), cards.getCard(30));
        System.out.println(values.checkSames());

    }
}
