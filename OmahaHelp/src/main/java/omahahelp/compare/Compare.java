/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private HashMap<String, Deck> flops;
    private HashMap<String, Deck> turns;
    private Deck cards;
    private PlayersCards handA;
    private PlayersCards handB;

    /**
     * Asetetaam omat ja vastustajan kortit ja pakka.
     * @param handA omat kortit
     * @param handB vastustajan kortit
     * @param cards pakka
     */
    public Compare(PlayersCards handA, PlayersCards handB, Deck cards) {
        this.handA = handA;
        this.handB = handB;
        this.cards = cards;
        this.flops = new HashMap<String, Deck>();
        this.turns = new HashMap<String, Deck>();
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;

    }

    public Deck getCards() {
        return this.cards;
    }

    /**
     * Muodostetaan pakasta  pakkoja ja asetaan niitä
     * flops-Hashmappiin siten, että key:nä toimii pakan string-muota ja valuena
     * pakka Deck-muodossa. 
     * @param flop true, jos asetetaan floppia
     * @param turn true, jos asetetaan turnia
     */
    public void addWinsAndCardsToHashMaps(boolean flop, boolean turn) {
        this.getMap().clear();
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;
        for (int w = 0; w < cards.sum(); w++) {
            for (int x = 1; x < cards.sum(); x++) {

                for (int z = 2; z < cards.sum(); z++) {

                    if (flop) {
                        this.addWins(x, z, w, turn, flop, 0, 0);
                    }
                    if (turn) {
                        for (int q = 3; q < cards.sum(); q++) {

                            if (!flop) {
                                this.addWins(x, z, w, turn, flop, q, 0);
                            }
//                            if (turn && flop) {
//
//                                for (int k = 4; k < all.sum(); k++) {
//                                    Deck copy = all;
//                                    copy.getCardsContainsCardandEraseCard(all.getCard(w));
//                                    copy.getCardsContainsCardandEraseCard(all.getCard(x));
//                                    copy.getCardsContainsCardandEraseCard(all.getCard(q));
//                                    this.addWins(copy, x, z, w, turn, flop, q, k);
//                                }
//                            }

                        }

                    }

                }
            }
        }
    }

    /**
     * Apu korttien lisäämiseksi mappiin. Katsotaan sisältääkö mappi jo turnin 
     * tai riverin, jos ei asetetaan se mappiin. Flopin yhteydessä myös verrataan
     * korttien arvoja.
     * @param x tämän mukaan haetaan 1. kortti pakasta
     * @param z tämän mukaan haetaan 2. kortti pakasta
     * @param w tämän mukaan haetaan 3. kortti pakasta
     * @param turn true, jos asetetaan turnia
     * @param flop true, jos asetetaan floppia.
     * @param t tämän mukaan haetaan 4. kortti pakasta, jos turnista kyse
     * @param k tämän mukaan haetaan 5. kortti pakasta, jos riveristä kyse
     */
    public void addWins(int x, int z, int w, boolean turn, boolean flop, int t, int k) {
        Deck deck = new Deck();
        Card a = cards.getCard(x);
        Card b = cards.getCard(z);
        Card c = cards.getCard(w);
        Card d = cards.getCard(t);
        Card e = cards.getCard(k);

        deck.addOneCard(a);
        if (!deck.getContainsByString(b.toString())) {
            deck.addOneCard(b);
        }
        if (!deck.getContainsByString(c.toString())) {
            deck.addOneCard(c);
        }

//        if (!a.toString().equals(b.toString())) {
//            deck.addOneCard(b);
//        }
//        if (!a.toString().equals(c.toString()) && !b.toString().equals(c.toString())) {
//            deck.addOneCard(c);
//        }
        if (deck.sum() == 3 && !turn) {
            String key = deck.getString();
            if (!this.flops.containsKey(key)) {
                this.flops.put(key, deck);
                this.compareFlop(a, b, c, handA, handB);

            }
        }
        if ((!a.toString().equals(d.toString()) && !b.toString().equals(d.toString())) && !c.toString().equals(d.toString()) && turn) {
            deck.addOneCard(d);

        }
        if (deck.sum() == 4) {

            String key = deck.getString();
            if (!this.turns.containsKey(key)) {
                this.turns.put(key, deck);

            }
        }
    }

    /**
     * Käydään kaikki mahdolliset viiden kortin kombinaatiot läpi ja katsotaan
     * kumpi käsistä voittaa.
     */
    public void calculateTurn() {

        Values values = new Values();
        int valA = 0;
        int valB = 0;
        for (Deck deck : this.turns.values()) {

            Card a = deck.getCard(0);
            Card b = deck.getCard(1);
            Card c = deck.getCard(2);
            Card d = deck.getCard(3);
            values.setCardsToHand(a, b, c, d, this.handA.getCardA());
            valA = values.getHandValue();
            values.setCardsToHand(a, b, c, d, this.handA.getCardB());
            valA = this.helpCompare(valA, values.getHandValue());

            values.setCardsToHand(a, b, c, this.handA.getCardA(), this.handA.getCardB());
            valA = this.helpCompare(valA, values.getHandValue());
            values.setCardsToHand(a, b, this.handA.getCardA(), d, this.handA.getCardB());
            valA = this.helpCompare(valA, values.getHandValue());
            values.setCardsToHand(a, this.handA.getCardA(), c, d, this.handA.getCardB());
            valA = this.helpCompare(valA, values.getHandValue());
            values.setCardsToHand(this.handA.getCardA(), b, c, d, this.handA.getCardB());
            valA = this.helpCompare(valA, values.getHandValue());
            values.setCardsToHand(a, b, c, d, this.handB.getCardA());
            valB = values.getHandValue();
            values.setCardsToHand(a, b, c, d, this.handB.getCardB());
            valB = this.helpCompare(valB, values.getHandValue());
            values.setCardsToHand(a, b, c, this.handB.getCardA(), this.handB.getCardB());
            valB = this.helpCompare(valB, values.getHandValue());
            values.setCardsToHand(a, b, this.handB.getCardA(), d, this.handB.getCardB());
            valB = this.helpCompare(valB, values.getHandValue());
            values.setCardsToHand(a, this.handB.getCardA(), c, d, this.handB.getCardB());
            valB = this.helpCompare(valB, values.getHandValue());
            valB = this.helpCompare(valB, values.getHandValue());
            this.setWinsAndTie(valA, valB);

        }
    }

    /**
     * Loin tällasen, että oisin saanu testien rivikattavuutta lisättyä, mutta
     * ei se oikein auttanu.
     * @param a
     * @param b
     * @return
     */
    public Integer helpCompare(int a, int b) {
        if (a < b) {
            return b;
        }
        return a;
    }

    public HashMap<String, Deck> getTurns() {
        return this.turns;
    }
//
//    public void compareHands(Card a, Card b, Card c, Card d, Card e, boolean river) {
//        Deck deck = new Deck();
//
//        int valueA = 0;
//        int valueB = 0;
//        deck.addOneCard(a);
//        deck.addOneCard(b);
//        deck.addOneCard(c);
//        deck.addOneCard(d);
//        if (river) {
//            deck.addOneCard(e);
//        }
//        Deck copy = deck;
//
//        copy.addOneCard(this.handA.getCardA());
//        copy.addOneCard(this.handA.getCardB());
//
//        valueA = this.helpCompareCardsTwo(copy);
//
//        deck.addOneCard(this.handB.getCardA());
//        deck.addOneCard(this.handB.getCardB());
//
//        valueB = this.helpCompareCardsTwo(copy);
//
//        this.setWinsAndTie(valueA, valueB);
//
//    }
//
//    public int helpCompareCardsTwo(Deck copy) {
//        int valueA = 0;
//        Values values = new Values();
//
//        for (Deck help : this.helpCompareCards(copy)) {
//
//            values.setCardsToHand(help.getCard(0), help.getCard(1), help.getCard(2), help.getCard(3), help.getCard(4));
//            if (valueA < values.getHandValue()) {
//                valueA = values.getHandValue();
//            }
//        }
//        return valueA;
//    }
//
//    public ArrayList<Deck> helpCompareCards(Deck deck) {
//
//        ArrayList<Deck> map = new ArrayList<Deck>();
//        for (int w = 0; w < deck.sum(); w++) {
//            Card a = deck.getCard(w);
//            for (int x = 1; x < deck.sum(); x++) {
//                Card b = deck.getCard(x);
//                for (int z = 2; z < deck.sum(); z++) {
//                    Card c = deck.getCard(z);
//                    for (int h = 3; h < deck.sum(); h++) {
//                        Card d = deck.getCard(h);
//                        for (int f = 4; f < deck.sum(); f++) {
//                            Card e = deck.getCard(f);
//                            Deck help = new Deck();
//                            help.addOneCard(a);
//                            help.addOneCard(b);
//                            help.addOneCard(c);
//                            help.addOneCard(d);
//                            help.addOneCard(e);
//                            map.add(help);
//
//                        }
//                    }
//                }
//            }
//        }
//        return map;
//    }

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
    public void compareFlop(Card a, Card b, Card c, PlayersCards d, PlayersCards e) {

        Values values = new Values();
        values.setCardsToHand(a, b, c, d.getCardA(), d.getCardB());
        int x = values.getHandValue();
        values.setCardsToHand(a, b, c, e.getCardA(), e.getCardB());
        int y = values.getHandValue();
        this.setWinsAndTie(x, y);
    }

    public void setWinsAndTie(int a, int b) {

        if (a > b) {
            this.aWins++;
        }
        if (b > a) {
            this.bWins++;
        }
        if (a == b) {
            this.ties++;
        }
    }

}
