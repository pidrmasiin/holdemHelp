/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import omahahelp.cards.Card;
import omahahelp.cards.Cards;
import omahahelp.deal.Draw;

/**
 *
 * @author petteri
 */
public class HandsValues implements Comparator<Card> {

    private int value;
    private int type;
    private Cards hand;

    public HandsValues() {
        this.hand = new Cards();
        this.value = 0;
    }

    public void setCardsToHand(Card a, Card b, Card c, Card d, Card e) {
        this.hand.getCards().clear();
        this.hand.getCards().add(a);
        this.hand.getCards().add(b);
        this.hand.getCards().add(c);
        this.hand.getCards().add(d);
        this.hand.getCards().add(e);
    }

    public void drawCardsToHand() {
        this.hand.getCards().clear();
        Cards cards = new Cards();
        cards.addCards();
        Draw draw = new Draw(cards);
        this.hand.getCards().addAll(draw.drawFlop());
        this.hand.getCards().add(draw.drawCard());
        this.hand.getCards().add(draw.drawCard());
    }

    public ArrayList getHand() {
        return hand.getCards();
    }

    public boolean checkFlush() {
        int suit = 0;
        int id = 0;
        for (int idx = 0; idx < this.hand.sum(); idx++) {
            suit = this.hand.getCard(idx).getSuit();
            if (suit != this.hand.getCard(0).getSuit()) {
                id = 1;
            }
        }
        if (id == 0) {
            return true;
        }
        return false;
    }

    public boolean checkStarightFlush() {
        if (this.checkFlush() && this.checkStraight()) {
            return true;
        }
        return false;
    }

    public boolean checkStraight() {
        this.organizeHand();
        if (hand.getCard(0).getNumber() == 1 && hand.getCard(4).getNumber() == 13) {
            return this.smallStraigth(1, 1);
        }
        return this.smallStraigth(0, 0);
    }

    public boolean smallStraigth(int x, int id) {
        this.organizeHand();
        int number = 0;
        while (x < this.hand.sum()) {
            number = this.hand.getCard(x).getNumber();
            number++;
            if (x < 4 && number == this.hand.getCard(x + 1).getNumber()) {
                id++;

            }
            if (id == 4) {
                return true;
            }
            x++;
        }
        return false;
    }

    public boolean sameOfKind(int many) {
        this.organizeHand();
        int check = 0;
        int number = this.hand.getCard(0).getNumber();
        int idx = 0;
        while (idx < this.hand.sum()) {
            if (number == this.hand.getCard(idx).getNumber()) {
                System.out.println("moi");
                check++;
            }
            number = this.hand.getCard(idx).getNumber();
            idx++;
        }
        if (check == many) {
            return true;
        }
        return false;
    }

    public void organizeHand() {
        Collections.sort(this.hand.getCards(), this);
    }

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber() - o2.getNumber();
    }

}
