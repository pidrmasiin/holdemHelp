/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.omahahelp;

import java.util.ArrayList;
import omahahelp.omahahelp.Card;

/**
 *
 * @author petteri
 */
public class Cards {

    private ArrayList cards;

    public Cards() {
        this.cards = new ArrayList<Card>();
    }

    public void addCards() {
        int x = 1;
        int z = 1;
        while (cards.size() < 52) {
            if (x < 14) {
                Card card = new Card(x, z);
                this.cards.add(card);
            }else{
                z += 1;
                x = 1;
                Card card = new Card(x, z);
                this.cards.add(card);
            }
            x += 1;
            
        }
    }
    
    public ArrayList printCards(){
        return this.cards;
    }
    
    public int sum(){
        return cards.size();
    }
    
    public String getCard(int x){
        return cards.get(x).toString();
    }
}
