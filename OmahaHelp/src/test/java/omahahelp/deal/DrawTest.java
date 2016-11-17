/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omahahelp.deal;

import omahahelp.cards.Card;
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
public class DrawTest {

    public DrawTest() {
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
    public void sumRightAfterDraw() {
        Cards cards = new Cards();
        cards.addCards();
        Draw draw = new Draw(cards);
        draw.drawCard();
        assertEquals(cards.sum(), 51);
    }

    @Test
    public void sumRightAfterDrawFlop() {
        Cards cards = new Cards();
        cards.addCards();
        Draw draw = new Draw(cards);
        draw.drawFlop();
        assertEquals(cards.sum(), 49);
    }

    @Test
    public void rightStringAfterAllDrawed() {
        Cards cards = new Cards();
        cards.addCards();
        Draw draw = new Draw(cards);
        for (int idx = 1; idx <= 52; ++idx) {
            draw.drawCard();
        }

        assertEquals(draw.drawCard().toString(), "13x13");
    }
}
