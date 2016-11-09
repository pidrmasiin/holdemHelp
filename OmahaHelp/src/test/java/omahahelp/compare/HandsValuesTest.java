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
public class HandsValuesTest {

    private Object cards;

    public HandsValuesTest() {
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
        HandsValues values = new HandsValues();
        values.setCardsToHand(cards.getCard(9), cards.getCard(1), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), true);
        values.setCardsToHand(cards.getCard(9), cards.getCard(35), cards.getCard(2), cards.getCard(3), cards.getCard(4));
        assertEquals(values.checkFlush(), false);
    }

    @Test
    public void StraightCheckTest() {
        Cards cards = new Cards();
        cards.addCards();
        HandsValues values = new HandsValues();
        values.setCardsToHand(cards.getCard(1), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkStraight(), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.checkStraight(), false);
        values.setCardsToHand(cards.getCard(12), cards.getCard(11), cards.getCard(0), cards.getCard(10), cards.getCard(9));
        assertEquals(values.checkStraight(), true);
    }
    
    @Test
    public void sameOfKindTest() {
        Cards cards = new Cards();
        cards.addCards();
        HandsValues values = new HandsValues();
        values.setCardsToHand(cards.getCard(18), cards.getCard(5), cards.getCard(44), cards.getCard(34), cards.getCard(31));
        assertEquals(values.sameOfKind(4), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.sameOfKind(4), false);
        values.setCardsToHand(cards.getCard(0), cards.getCard(13), cards.getCard(1), cards.getCard(26), cards.getCard(39));
        assertEquals(values.sameOfKind(4), true);
        values.setCardsToHand(cards.getCard(19), cards.getCard(5), cards.getCard(44), cards.getCard(34), cards.getCard(31));
        assertEquals(values.sameOfKind(3), true);
        values.setCardsToHand(cards.getCard(46), cards.getCard(3), cards.getCard(5), cards.getCard(2), cards.getCard(4));
        assertEquals(values.sameOfKind(3), false);
        
    }
    
    
}
