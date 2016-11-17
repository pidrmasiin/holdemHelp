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

public class Values implements Comparator<Card> {

    private HandsValues value;
    private Cards hand;

    public Values() {
        this.hand = new Cards();
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
        if (hand.getCard(0).getNumber() == 2 && hand.getCard(4).getNumber() == 14) {
            return this.highStraigth(this.hand.sum() - 1, 1);
        }
        return this.highStraigth(this.hand.sum(), 0);
    }

    public boolean highStraigth(int y, int id) {
        int x = 0;
        this.organizeHand();
        int number = 0;
        while (x < y) {
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

    public ArrayList<Integer> helpToCheckSames() {

        this.organizeHand();
        ArrayList help = new ArrayList<>();
        int idx = 0;
        while (idx < this.hand.sum()) {
            help.add(this.hand.getCard(idx).getNumber());
            idx++;
        }
        return help;
    }

    public ArrayList<HandsValues> checkSames() {
        int sames = 0;
        this.organizeHand();
        ArrayList help = new ArrayList<>();
        help = this.helpToCheckSames();
        ArrayList out = new ArrayList<HandsValues>();
        int x = 0;
        int y = 4;
        while (x < 5) {
            int check = (int) help.get(y);
            for (int idx = 0; idx < help.size(); idx++) {
                if ((int) help.get(idx) == check) {
                    sames++;
                }
            }
            HandsValues hand = new HandsValues(sames, check);
            if (out.isEmpty()) {
                out.add(hand);
            }
            if (!out.get(out.size() - 1).toString().equals(hand.toString())) {
                out.add(hand);
            }
            sames = 0;
            y--;
            x++;
        }
        Collections.sort(out, (HandsValues o1, HandsValues o2) -> o2.getType() - o1.getType());
        return out;
    }

    public boolean checkFourofKind() {
        return this.checkSames().get(0).getType() == 4;
    }

    public boolean checkThreeOfKind() {
        return this.checkSames().get(0).getType() == 3 && this.checkSames().get(1).getType() != 2;
    }

    public boolean checkFullHouse() {
        return this.checkSames().get(0).getType() == 3 && this.checkSames().get(1).getType() == 2;
    }

    public boolean checkTwoPairs() {
        return this.checkSames().get(0).getType() == 2 && this.checkSames().get(1).getType() == 2;
    }

    public boolean checkPair() {
        return this.checkSames().get(0).getType() == 2 && 2 != this.checkSames().get(1).getType();
    }

    public void organizeHand() {
        Collections.sort(this.hand.getCards(), this);
    }

    public Integer getType() {
        if (this.checkStarightFlush()) {
            return 800;
        }
        if (this.checkFourofKind()) {
            return 700;
        }
        if (this.checkFullHouse()) {
            return 600;
        }
        if (this.checkFlush()) {
            return 500;
        }
        if (this.checkStraight()) {
            return 400;
        }
        if (this.checkThreeOfKind()) {
            return 300;
        }
        if (this.checkTwoPairs()) {
            return 200;
        }
        if (this.checkPair()) {
            return 100;
        }
        return 0;
    }

    public void setHandsValues() {
        this.value = new HandsValues(this.getType(), this.checkSames().get(0).getValue());
    }

    public int getHandValue() {
        return this.value.getHandValue();
    }

    @Override
    public int compare(Card o1, Card o2) {
        return o1.getNumber() - o2.getNumber();
    }
}
