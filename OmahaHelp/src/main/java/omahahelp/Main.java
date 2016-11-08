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
        System.out.println(values.getHand());
        values.setCardsToHand(cards.getCard(0), cards.getCard(11), cards.getCard(12), cards.getCard(10), cards.getCard(9));
        System.out.println(values.getHand());
        if(values.checkFlush()){
            System.out.println("väri");
        }
        
        
        if (values.checkStraight()){
            System.out.println("suora");
        }
        System.out.println(values.getHand());

    }

}
