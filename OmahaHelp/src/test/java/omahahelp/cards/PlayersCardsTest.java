/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.cards;

import static omahahelp.cards.Card.Suit.CLUBS;
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
public class PlayersCardsTest {

    public PlayersCardsTest() {
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
    public void playersCardsTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card a = new Card(14, CLUBS);
        Card b = new Card(4, CLUBS);
        PlayersCards hand = new PlayersCards(cards, a);
        assertEquals(hand.getCardA().toString(), a.toString());
        hand.setCardB(cards, b);
        assertEquals(hand.getCardB().toString(), b.toString());
            
        
        }
    }
