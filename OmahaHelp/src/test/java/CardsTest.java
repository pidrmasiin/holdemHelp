/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import omahahelp.omahahelp.Cards;
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
public class CardsTest {

    public CardsTest() {
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
    @Test
    public void sumRight() {
        Cards cards = new Cards();
        cards.addCards();
        assertEquals(cards.sum(), 52);
    }

    @Test
    public void rightCards() {
        Cards cards = new Cards();
        cards.addCards();
        assertEquals(cards.getCard(0), "1x1");
        assertEquals(cards.getCard(12), "13x1");
        assertEquals(cards.getCard(15), "3x2");
        assertEquals(cards.getCard(31), "6x3");
        assertEquals(cards.getCard(51), "13x4");
    }
}
