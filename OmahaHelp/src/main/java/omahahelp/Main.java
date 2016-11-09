/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp;

import omahahelp.cards.Cards;
import omahahelp.cards.PlayersCards;
import omahahelp.compare.HandsValues;
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

        Draw draw = new Draw(cards);

        HandsValues values = new HandsValues();
        values.drawCardsToHand();
        
       values.setCardsToHand(cards.getCard(8), cards.getCard(13), cards.getCard(1), cards.getCard(26), cards.getCard(39));
        System.out.println(values.getHand());
       
       if (values.sameOfKind(3)){
           System.out.println("neloset");
       }System.out.println(values.getHand());
    }

}
