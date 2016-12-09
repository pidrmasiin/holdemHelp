/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import omahahelp.cards.Card;
import omahahelp.cards.Deck;
import omahahelp.cards.PlayersCards;

/**
 * Luokan avulla lasketaan kumpi pelaajista johtaa kunkin pelin osa-alueen
 * jälkeen.
 *
 * @author petteri
 */
public class Compare {

    private int ties;
    private int aWins;
    private int bWins;
    private HashMap<String, Integer> all5CardsCombos;
    private HashMap<String, Deck> flops;
    private HashMap<String, Deck> turns;
    private HashMap<Integer, Deck> rivers;
    private Deck cards;
    private PlayersCards handA;
    private PlayersCards handB;

    /**
     * Asetetaam omat ja vastustajan kortit ja pakka.
     *
     * @param handA omat kortit
     * @param handB vastustajan kortit
     * @param cards pakka
     */
    public Compare(Deck cards) {

        this.cards = cards;
        this.all5CardsCombos = new HashMap<String, Integer>();
        this.flops = new HashMap<String, Deck>();
        this.turns = new HashMap<String, Deck>();
        this.rivers = new HashMap<Integer, Deck>();
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;

    }

    public void setHands(PlayersCards handA, PlayersCards handB) {
        this.handA = handA;
        this.handB = handB;
    }

    public Deck getCards() {
        return this.cards;
    }

    public HashMap<String, Integer> getAll5Combos() {
        return this.all5CardsCombos;
    }

    /**
     * Muodostetaan pakasta pakkoja ja asetaan niitä flops-Hashmappiin siten,
     * että key:nä toimii pakan string-muota ja valuena pakka Deck-muodossa.
     *
     * @param flop true, jos asetetaan floppia
     * @param turn true, jos asetetaan turnia
     */
    public void addCardsToFlopHashMap() {

        for (int w = 0; w < cards.size(); w++) {
            for (int x = 1; x < cards.size(); x++) {

                for (int z = 2; z < cards.size(); z++) {
                    Deck deck = new Deck();
                    Card a = cards.getCard(x);
                    Card b = cards.getCard(z);
                    Card c = cards.getCard(w);
                    deck.addOneCard(a);
                    if (!deck.getContainsByString(b.toString())) {
                        deck.addOneCard(b);
                    }
                    if (!deck.getContainsByString(c.toString())) {
                        deck.addOneCard(c);

                        if (deck.size() == 3) {
                            String key = deck.getString();
                            if (!flops.containsKey(key)) {
                                flops.put(key, deck);

//                                this.setWinsAndTies(this.compareFlop(a, b, c, handA, handB));
                            }
                        }
                    }

                }

            }

        }

    }

    public void addTurnsToMap() {

        for (int x = 3; x < cards.size(); x++) {

            for (Deck deck : flops.values()) {

                Deck copy = new Deck();
                copy.addOneCard(deck.getCard(0));
                copy.addOneCard(deck.getCard(1));
                copy.addOneCard(deck.getCard(2));

                if (!deck.getContainsByString(cards.getCardString(x))) {

                    copy.addOneCard(cards.getCard(x));
                    turns.put(copy.getString(), copy);

                }

            }

        }

    }

    public void compareTurns() {
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;

        for (Deck deck : turns.values()) {
            Value one = this.helpToCompare(handA, deck);
            Value two = this.helpToCompare(handB, deck);

            this.setWinsAndTies(this.compareValues(one, two));

        }

    }

    public Value helpToCompare(PlayersCards choose, Deck turn) {
        Value one = new Value();
        Value compare = new Value();

        Deck a = new Deck();
        a.addDeck(turn);
        a.addOneCard(choose.getCardA());

        one.setFiveCardsDeckToHand(a);
        a.eraseCards(choose.getCardA());

        a.addOneCard(choose.getCardB());
        compare.setFiveCardsDeckToHand(a);

        if (this.compareValues(one, compare) == 2) {
            one = compare;
        }
        a.addOneCard(choose.getCardA());
        for (int x = 0; x < turn.size(); x++) {
            a.eraseCards(turn.getCard(x));
            compare.setFiveCardsDeckToHand(a);
            if (this.compareValues(one, compare) == 2) {
                one = compare;
            }
            a.addOneCard(turn.getCard(x));
        }
        return one;

    }

    public void addRiversToMap() {
        Value val = new Value();

        int y = 0;
        for (int x = 5; x < cards.size(); x++) {

            for (Deck deck : turns.values()) {

                Deck copy = new Deck();
                copy.addOneCard(deck.getCard(0));
                copy.addOneCard(deck.getCard(1));
                copy.addOneCard(deck.getCard(2));
                copy.addOneCard(deck.getCard(3));

                if (!copy.getContainsByString(cards.getCardString(x))) {

                    copy.addOneCard(cards.getCard(x));
                    val.setFiveCardsDeckToHand(copy);
                    val.setType();
                    val.setValue();
                    int key = val.getHandsValue().getHandValue();
                    if (!rivers.containsKey(key)) {
                        rivers.put(key, copy);
                    }

                }

            }

            System.out.println(x);
        }
    }

    public HashMap<Integer, Deck> getRiversMap() {
        return this.rivers;
    }

    public void setWinsAndTies(int x) {
        if (x == 0) {
            this.ties++;
        }
        if (x == 1) {
            this.aWins++;
        }
        if (x == 2) {
            this.bWins++;
        }
    }

    public HashMap<String, Deck> getTurns() {
        return this.turns;
    }

    public void reOrganize() {
        this.cards.sort();
    }

    public HashMap getMap() {
        return this.flops;
    }

//
    public Deck getThisCards() {
        return this.cards;
    }

    public int getTies() {
        return ties;
    }

    public int getAwins() {
        return aWins;
    }

    public int getbWins() {
        return bWins;
    }

    public String getOddsForAwins() {
        DecimalFormat x = new DecimalFormat("#.##");
        return (x.format((double) this.aWins / (double) this.flops.size() * 100));
    }

    /**
     * Vertaillaan käsiä Values-luokan avulla suhteessa kolmen kortin
     * flop-pakkaan.
     *
     * @param a 1. flop-pakan kortti
     * @param b 2. flop-pakan kortti
     * @param c 3. flop-pakan kortti
     * @param d 1. pelaajan käsi
     * @param e 2. pelaajan käsi
     */
    public Integer compareFlop(Card a, Card b, Card c, PlayersCards d, PlayersCards e) {

        Value valuesA = new Value();
        Value valuesB = new Value();
        valuesA.setCardsToHand(a, b, c, d.getCardA(), d.getCardB());
        valuesB.setCardsToHand(a, b, c, e.getCardA(), e.getCardB());

        return this.compareValues(valuesA, valuesB);

    }

    public Integer compareValues(Value a, Value b) {
        a.setType();
        b.setType();
        int va = a.getHandsValue().getType();
        int vb = b.getHandsValue().getType();
        if (va == vb) {
            for (int x = 0; x < a.checkSames().size(); x++) {
                if (a.checkSames().get(x).getValue() != b.checkSames().get(x).getValue()) {
                    va = a.checkSames().get(x).getValue();
                    vb = b.checkSames().get(x).getValue();
                    break;
                }

            }
        }
        if (va == vb) {
            return 0;
        }
        if (va > vb) {
            return 1;
        }
        return 2;
    }

}
