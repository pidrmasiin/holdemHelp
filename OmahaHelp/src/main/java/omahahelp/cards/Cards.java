/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import java.util.ArrayList;
import omahahelp.cards.Card;

/**
 *
 * @author petteri
 */
public class Cards {

    public ArrayList<Card> cards;

    public Cards() {
        this.cards = new ArrayList<Card>();

    }

    public void addCards() {
        int x = 1;
        int z = 1;
        int y = 0;
        while (cards.size() < 52) {
            if (x == 1) {
                y = 14;
            } else {
                y = x;
            }
            if (x < 14) {
                Card card = new Card(y, z);
                this.cards.add(card);
            } else {
                z += 1;
                x = 1;
                if (x == 1) {
                    y = 14;
                } else {
                    y = x;
                }
                Card card = new Card(y, z);
                this.cards.add(card);
            }
            x += 1;

        }
    }

    public ArrayList getCards() {
        return this.cards;
    }

    public int sum() {
        return cards.size();
    }

    public String getCardString(int x) {
        return cards.get(x).toString();
    }

    public Card getCard(int x) {
        return cards.get(x);
    }
    
    public boolean getCardsContainsCardandEraseCard(Card a){
        for(int x = 0; x<this.cards.size();x++){
            if(this.cards.get(x).getNumber()==a.getNumber() && this.cards.get(x).getSuit() == a.getSuit()){
                this.eraseCards(this.getCard(x));
                return true;
            }
        }return false;
    }

    public void eraseCards(Card x) {
        if (this.cards.contains(x)) {
            cards.remove(x);
        } else {
            System.out.println("Kortti ei ole pakassa");
        }
    }

}
