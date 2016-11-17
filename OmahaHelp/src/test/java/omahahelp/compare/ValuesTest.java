/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.compare;

import omahahelp.cards.Cards;
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
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        values.setCardsToHand(cards.getCard(9), cards.getCard(1), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), true);
        values.setCardsToHand(cards.getCard(9), cards.getCard(35), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), false);
    }

    @Test
    public void straightCheckTest() {
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
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
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        values.setCardsToHand(cards.getCard(1), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkFourofKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkFourofKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkFourofKind(), true);

    }

    @Test
    public void threeOfKindCheckTest() {
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        values.setCardsToHand(cards.getCard(46), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), true);
        values.setCardsToHand(cards.getCard(13), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkThreeOfKind(), false);

    }

    @Test
    public void twoPairsTest() {
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        values.setCardsToHand(cards.getCard(2), cards.getCard(18), cards.getCard(5), cards.getCard(15), cards.getCard(9));
        assertEquals(values.checkTwoPairs(), true);
        values.setCardsToHand(cards.getCard(13), cards.getCard(0), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkTwoPairs(), false);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkTwoPairs(), false);

    }

    @Test
    public void pairTest() {
        Cards cards = new Cards();
        cards.addCards();
        Values values = new Values();
        values.setCardsToHand(cards.getCard(2), cards.getCard(18), cards.getCard(5), cards.getCard(15), cards.getCard(9));
        assertEquals(values.checkPair(), false);
        values.setCardsToHand(cards.getCard(13), cards.getCard(45), cards.getCard(0), cards.getCard(1), cards.getCard(2));
        assertEquals(values.checkPair(), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(51), cards.getCard(12), cards.getCard(25), cards.getCard(38));
        assertEquals(values.checkPair(), false);

    }

}
