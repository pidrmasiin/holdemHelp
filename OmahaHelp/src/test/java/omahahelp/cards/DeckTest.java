/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pepa
 */
public class DeckTest {

    public DeckTest() {
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
    public void addDeckTest() {
        Deck cards = new Deck();
        Deck deck = new Deck();
        deck.addCards();
        cards.addDeck(deck);
        assertEquals(deck.size(), cards.size());
    }

    @Test
    public void addAndEraseTest() {
        Deck cards = new Deck();
        cards.addCards();
        cards.addAndErase(cards.getCard(1), 0);
        assertEquals(cards.size(), 52);
    }
    
     @Test
    public void eraseByStringTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card a = cards.getCard(1);
        cards.eraseByString(a.toString());
        assertEquals(cards.size(), 51);
    }
}
