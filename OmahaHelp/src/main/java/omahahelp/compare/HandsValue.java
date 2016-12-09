/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import omahahelp.cards.Card;
import omahahelp.cards.PlayersCards;

/**
 * Luokassa käytetään Values luoka apuna. Luokan avulla muodostetaan käden arvo.
 *
 * @author petteri
 */
public class HandsValue {

    private int value;
    private int type;

    public HandsValue(int x, int y) {
        this.type = x;
        this.value = y;
    }

    public int getType() {
        return this.type;
    }
    
    
    
    public void addValueToValue(int x){
        this.value = this.value + x;
    }

    public int getValue() {
        return this.value;
    }

    public int getHandValue() {
        return this.value + this.type;
    }

    @Override
    public String toString() {
        return type + "x" + value;
    }
}
