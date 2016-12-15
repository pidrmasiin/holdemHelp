/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import omahahelp.cards.Card;
import static omahahelp.cards.Card.Suit.CLUBS;
import static omahahelp.cards.Card.Suit.DIAMONDS;
import static omahahelp.cards.Card.Suit.HEARTS;
import static omahahelp.cards.Card.Suit.SPADES;
import omahahelp.cards.Deck;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petteri
 */
public class ValuesTest {

    private Object cards;

    public ValuesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void flushCheckTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(9), cards.getCard(1), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), true);
        values.setCardsToHand(cards.getCard(9), cards.getCard(35), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), false);
    }

    @Test
    public void straightCheckTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(1), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkStraight(), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkStraight(), false);
        values.setCardsToHand(cards.getCard(12), cards.getCard(11), cards.getCard(0), cards.getCard(10), cards.getCard(9));
        assertEquals(values.checkStraight(), true);
        values.setCardsToHand(cards.getCard(14), cards.getCard(2), cards.getCard(13), cards.getCard(16), cards.getCard(30));
        assertEquals(values.checkStraight(), true);
        
    }

    @Test
    public void fourOfKindCheckTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(1), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkFourofKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkFourofKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkFourofKind(), true);

    }

    @Test
    public void threeOfKindCheckTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(46), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), true);
        values.setCardsToHand(cards.getCard(13), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), false);

    }

    @Test
    public void twoPairsTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(2), cards.getCard(18), cards.getCard(5), cards.getCard(15), cards.getCard(9));
        assertEquals(values.checkTwoPairs(), true);
        values.setCardsToHand(cards.getCard(13), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkTwoPairs(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkTwoPairs(), false);

    }

    @Test
    public void pairTest() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        values.setCardsToHand(cards.getCard(2), cards.getCard(18), cards.getCard(5), cards.getCard(15), cards.getCard(9));
        assertEquals(values.checkPair(), false);
        values.setCardsToHand(cards.getCard(13), cards.getCard(45), cards.getCard(0), cards.getCard(1), cards.getCard(2));
        assertEquals(values.checkPair(), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkPair(), false);

    }

    @Test
    public void setCardstoHand() {
        Deck cards = new Deck();
        cards.addCards();
        Value values = new Value();
        Card a = cards.getCard(0);
        values.setCardsToHand(a, a, a, a, a);
        assertEquals(values.getHandSum(), 5);

    }

    @Test
    public void setFiveCardstoHandTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card a = cards.getCard(0);
        Deck deck = new Deck();
        deck.addOneCard(a);
        deck.addOneCard(a);
        deck.addOneCard(a);
        deck.addOneCard(a);
        deck.addOneCard(a);

        Value values = new Value();

        values.setFiveCardsDeckToHand(deck);
        assertEquals(values.getHandSum(), 5);

    }

    @Test
    public void getStraigtFlushTest() {
        Card a = new Card(14, CLUBS);
        Card b = new Card(3, CLUBS);
        Card c = new Card(4, CLUBS);
        Card d = new Card(5, CLUBS);
        Card e = new Card(2, CLUBS);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 900000000);
        assertEquals(values.checkStarightFlush(), true);
    }

    @Test
    public void getFourofKindTest() {
        Card a = new Card(14, CLUBS);
        Card b = new Card(14, DIAMONDS);
        Card c = new Card(14, HEARTS);
        Card d = new Card(14, SPADES);
        Card e = new Card(6, CLUBS);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 800000000);
    }

    @Test
    public void getFullHouseTest() {
        Card a = new Card(14, CLUBS);
        Card b = new Card(14, DIAMONDS);
        Card c = new Card(14, HEARTS);
        Card d = new Card(6, SPADES);
        Card e = new Card(6, CLUBS);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 700000000);
        assertEquals(values.checkFullHouse(), true);
    }

    @Test
    public void getFlushTest() {
        Card a = new Card(7, CLUBS);
        Card b = new Card(3, CLUBS);
        Card c = new Card(4, CLUBS);
        Card d = new Card(5, CLUBS);
        Card e = new Card(2, CLUBS);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 600000000);
        
    }

    @Test
    public void getStraightTest() {
        Card a = new Card(7, CLUBS);
        Card b = new Card(3, CLUBS);
        Card c = new Card(4, CLUBS);
        Card d = new Card(5, CLUBS);
        Card e = new Card(6, SPADES);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 500000000);
    }

    @Test
    public void getPairTest() {
        Card a = new Card(7, CLUBS);
        Card b = new Card(3, CLUBS);
        Card c = new Card(4, CLUBS);
        Card d = new Card(5, CLUBS);
        Card e = new Card(7, SPADES);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 200000000);
    }

    @Test
    public void getNothingTest() {
        Card a = new Card(7, CLUBS);
        Card b = new Card(3, CLUBS);
        Card c = new Card(4, CLUBS);
        Card d = new Card(5, CLUBS);
        Card e = new Card(9, SPADES);
        Value values = new Value();
        values.setCardsToHand(a, b, c, d, e);
        assertEquals(values.getType(), 0);
    }

}
