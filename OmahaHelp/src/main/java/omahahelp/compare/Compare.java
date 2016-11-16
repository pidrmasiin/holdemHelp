/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import omahahelp.cards.Cards;
import omahahelp.cards.PlayersCards;

/**
 *
 * @author petteri
 */
public class Compare {
    private Cards cards;
    private PlayersCards handA;
    private PlayersCards handB;

    public Compare(PlayersCards handA, PlayersCards handB) {
        
        
        this.handA = handA;
        this.handB = handB;
        this.cards = cards;
    }
    
    public Cards getCards(){
        return this.cards;
    }
    
    public void compareBeforeFlop(){
        
    }
}
