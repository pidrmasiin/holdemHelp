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
import static omahahelp.cards.Card.Suit.DIAMONDS;
import static omahahelp.cards.Card.Suit.SPADES;
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

    /**
     * Asetataan kädet, joita vertaillaan.
     *
     * @param handA 1. käsi.
     * @param handB 2. käsi.
     */
    public void setHands(PlayersCards handA, PlayersCards handB) {
        this.handA = handA;
        this.handB = handB;
    }

    public Deck getCards() {
        return this.cards;
    }

    /**
     * Muodostetaan pakasta pakkoja ja asetaan niitä flops-Hashmappiin siten,
     * että key:nä toimii pakan string-muota ja valuena flop-pakka
     * Deck-muodossa.
     *
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

                                this.setWinsAndTies(this.compareFlop(a, b, c, handA, handB));
                            }
                        }
                    }

                }

            }

        }

    }

    /**
     * Lisätään turnit mappiin siten, että keyna toimii pakan String-muoto ja
     * valuena 4-kortin pakka Deckinä.
     */
    public void addTurnsToMap() {

        int y = 0;
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

    /**
     * Käydään läpi kaikki mahdolliset turnit ja tarkastetaan aina pelin
     * tilanne.
     *
     * @param a flopin 1. kortti.
     * @param b flopin 2. kortti.
     * @param c flopin 3. kortti.
     */
    public void calculateAfterTurn(Card a, Card b, Card c) {
        this.setWinsAndTieZero();

        Deck deck = new Deck();
        deck.addOneCard(a);
        deck.addOneCard(b);
        deck.addOneCard(c);
        for (Card x : (ArrayList<Card>) this.cards.getCards()) {
            deck.addOneCard(x);

            this.setTurnWinsAndTies(deck);
            deck.eraseByString(x.toString());

        }

    }

    /**
     * Käydään läpi kaikki mahdolliset turnMappiin asetetut pakat ja
     * tarkastetaan pelin tilanne.
     */
    public void addWinsAndTiesAfterTurnWhenFlopBlind() {
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;
   

        for (Deck deck : this.turns.values()) {

            this.setTurnWinsAndTies(deck);

        }
    }

    /**
     * Verrataan kahta kättä ja asetaan voittoja ja tasapelejä käsien vahvuuden
     * mukaan.
     *
     * @param deck pöydällä olevat kortit.
     */
    public void setTurnWinsAndTies(Deck deck) {

        Value one = this.compareTurns(deck, handA);
        Value two = this.compareTurns(deck, handB);

        if (one.getValue() > two.getValue()) {
            this.aWins++;
        }
        if (one.getValue() < two.getValue()) {
            this.bWins++;
        }
        if (one.getValue() == two.getValue()) {
            this.ties++;
        }

    }

    /**
     * Asetetaan voitot ja tasurit nolliksi.
     */
    public void setWinsAndTieZero() {
        this.aWins = 0;
        this.bWins = 0;
        this.ties = 0;
    }

    /**
     * Etsitään vahvin viiden kortin yhdistelmä pöydällä ja kädessä olevista
     * korteista.
     *
     * @param deck pöydällä olevat kortit.
     * @param hand käsi
     * @return palautetaan Value, joka sisältää suurimman arvon saaneet kortit.
     */
    public Value compareTurns(Deck deck, PlayersCards hand) {

        Value out = new Value();
        out.setCardsToHand(deck.getCard(0), deck.getCard(1), deck.getCard(2), deck.getCard(3), hand.getCardA());

        Value comp = new Value();
        comp.setCardsToHand(deck.getCard(0), deck.getCard(1), deck.getCard(2), deck.getCard(3), hand.getCardB());

        if (this.compareValues(out, comp) == 2) {
            out.setFiveCardsDeckToHand(comp.getDeck());

        }

        comp.setCardsToHand(deck.getCard(0), deck.getCard(1), deck.getCard(2), hand.getCardB(), hand.getCardA());
        if (this.compareValues(out, comp) == 2) {
            out.setFiveCardsDeckToHand(comp.getDeck());
        }

        comp.setCardsToHand(deck.getCard(0), deck.getCard(1), hand.getCardB(), deck.getCard(3), hand.getCardA());
        if (this.compareValues(out, comp) == 2) {
            out.setFiveCardsDeckToHand(comp.getDeck());
        }

        comp.setCardsToHand(deck.getCard(0), hand.getCardB(), deck.getCard(2), deck.getCard(3), hand.getCardA());
        if (this.compareValues(out, comp) == 2) {
            out.setFiveCardsDeckToHand(comp.getDeck());
        }

        comp.setCardsToHand(hand.getCardB(), deck.getCard(1), deck.getCard(2), deck.getCard(3), hand.getCardA());
        if (this.compareValues(out, comp) == 2) {
            out.setFiveCardsDeckToHand(comp.getDeck());
        }

        return out;
    }

    /**
     * Käytetään apumetodina laskettaessa käsien suhteita.
     *
     * @param x riippuen x:n arvosta lisätään voittoja tai tasapeli.
     */
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

    /**
     * Järjestää pakan.
     */
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


    public int getBWins() {
        return bWins;
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
     * @return palautetaan 1, jos käsi 1 voittaa, ja 2, jos käsi 2. Nolla jos kädet
     * yhtä vahvat.
     */
    public Integer compareFlop(Card a, Card b, Card c, PlayersCards d, PlayersCards e) {

        Value valuesA = new Value();
        Value valuesB = new Value();
        valuesA.setCardsToHand(a, b, c, d.getCardA(), d.getCardB());
        valuesB.setCardsToHand(a, b, c, e.getCardA(), e.getCardB());

        return this.compareValues(valuesA, valuesB);

    }

    /**
     * Vertaillaan kahta Value-luokkaa.
     *
     * @param a ensimmäinen value
     * @param b toinen value
     * @return palautetaan 1, jos a vahvempi, palautetaan 2, jos b vahvempi.
     * palautetaan 0, jos a & b yhtä vahvat.
     */
    public Integer compareValues(Value a, Value b) {

        if (a.getValue() == b.getValue()) {
            return 0;
        }
        if (a.getValue() > b.getValue()) {
            return 1;
        }
        return 2;
    }

}
