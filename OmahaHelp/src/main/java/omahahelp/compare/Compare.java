/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import omahahelp.cards.Card;
import omahahelp.cards.Deck;
import omahahelp.cards.PlayersCards;

/**
 *
 * @author petteri
 */
public class Compare {

    private int ties;
    private int aWins;
    private int bWins;
    private HashMap<String, Deck> flops;
    private Deck cards;
    private PlayersCards handA;
    private PlayersCards handB;

    public Compare(PlayersCards handA, PlayersCards handB, Deck cards) {
        this.handA = handA;
        this.handB = handB;
        this.cards = cards;
        this.flops = new HashMap<String, Deck>();
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;

    }

    public Deck getCards() {
        return this.cards;
    }

    /**
     * Muodostetaan pakasta kolmen kortin pakkoja ja asetaan niitä
     * flops-Hashmappiin siten, että key:nä toimii pakan string-muota ja valuena
     * pakka Deck-muodossa. Lisäksi jokaisen pakan muodostuksen yhteydessä
     * verrataan compareHands-metodin avulla pelaajien käsien arvoja toisiinsa
     * ja kasvatetaan vertailun mukaisesti joko ties tai aWins tai bWins
     * Integeria.
     */
    public void helpToAddFlopsToHashMaps() {

        int winsForA = 0;
        int winsForB = 0;
        int ties = 0;
        Values values = new Values();
        for (int w = 0; w < this.cards.sum(); w++) {
            for (int x = 0; x < this.cards.sum(); x++) {
                for (int z = 0; z < this.cards.sum(); z++) {
                    Deck deck = new Deck();
                    Card a = this.cards.getCard(x);
                    Card b = this.cards.getCard(z);
                    Card c = this.cards.getCard(w);
                    deck.addOneCard(a);
                    if (!a.toString().equals(b.toString())) {
                        deck.addOneCard(b);
                    }
                    if (!a.toString().equals(c.toString()) && !b.toString().equals(c.toString())) {
                        deck.addOneCard(c);
                    }
                    if (deck.sum() == 3) {
                        String key = deck.getString();
                        if (!this.flops.containsKey(key)) {
                            this.flops.put(key, deck);
                            this.compareHands(a, b, c, handA, handB);

                        }
                    }
                }
            }
        }
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
    public void compareHands(Card a, Card b, Card c, PlayersCards d, PlayersCards e) {

        Values values = new Values();
        values.setCardsToHand(a, b, c, d.getCardA(), d.getCardB());
        int x = values.getHandValue();
        values.setCardsToHand(a, b, c, e.getCardA(), e.getCardB());
        int y = values.getHandValue();

        if (x > y) {
            this.aWins++;
        }
        if (y > x) {
            this.bWins++;
        }
        if (x == y) {
            this.ties++;
        }
    }
}

//    public HashMap<String, Integer> countCardsInMap() {
//        HashMap out = new HashMap<String, Integer>();
//        for (int x = 0; x < this.flops.size(); x++) {
//
//            Deck deck = help.get(x);
//
//            for (int y = 0; y < deck.cards.size(); y++) {
//
//                if (out.containsKey(deck.getCardString(y))) {
//
//                    if (out.get(deck.getCardString(y)) != null) {
//
//                        int put = (int) out.get(deck.getCardString(y));
//
//                        put++;
//
//                        out.replace(deck.getCardString(y), put);
//                        put = 0;
//
//                    }
//                }
//                if (out.get(deck.getCardString(y)) == null) {
//                    out.put(deck.getCardString(y), 1);
//                }
//
//            }
//
//        }
//        return out;
//    }
//
//    public Deck getThoseThatHaventFullyCounted() {
//        Deck help = new Deck();
//        for (int x = 0; x < this.countCardsInMap().size(); x++) {
//
//            if (this.countCardsInMap().get(this.cards.getCard(x).toString()) == 900) {
//                help.addOneCard(cards.getCardByString(this.cards.getCard(x).toString()));
//
//            }
//        }
//        return help;
//    }
