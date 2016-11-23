package omahahelp.cards;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Deck cards = new Deck();
        cards.addCards();
        assertEquals(cards.sum(), 52);
    }

    @Test
    public void rightCards() {
        Deck cards = new Deck();
        cards.addCards();
        assertEquals(cards.getCard(0).toString(), "2 of CLUBS");
        assertEquals(cards.getCard(12).toString(), "14 of CLUBS");
        assertEquals(cards.getCard(15).toString(), "4 of DIAMONDS");
        assertEquals(cards.getCard(31).toString(), "7 of HEARTS");
        assertEquals(cards.getCard(51).toString(), "14 of SPADES");
    }

    @Test
    public void sumRightAfterCreatingPlayersCards() {
        Deck cards = new Deck();
        cards.addCards();
        PlayersCards pCards = new PlayersCards(cards, cards.getCard(1), cards.getCard(3));
        assertEquals(cards.sum(), 50);
    }

    @Test
    public void getCardsContainsCardandEraseCardTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card a = new Card(14, CLUBS);
        Card d = new Card(4, CLUBS);
        assertEquals(cards.getCardsContainsCardandEraseCard(a), true);
        assertEquals(cards.getCardsContainsCardandEraseCard(a), false);
        assertEquals(cards.getCardsContainsCardandEraseCard(d), true);
        assertEquals(cards.getCardsContainsCardandEraseCard(d), false);
    }
    
    @Test
    public void getIntForSuitTestAndGetIntForCardTests() {
        Card a = new Card(14, CLUBS);
        Card b = new Card(14, DIAMONDS);
        Card c = new Card(14, SPADES);
        Card d = new Card(14, HEARTS);
        assertEquals(a.getIdForCard(), 14);
        assertEquals(b.getIdForCard(), 114);
        assertEquals(c.getIdForCard(), 10014);
        assertEquals(d.getIdForCard(), 1014);
        assertEquals(a.getIntForSuit(), 0);
        assertEquals(b.getIntForSuit(), 100);
        assertEquals(c.getIntForSuit(), 10000);
        assertEquals(d.getIntForSuit(), 1000);
    }
    
     @Test
    public void addOneAndGetStringTests(){
        Deck deck = new Deck();
        Card a = new Card(4, CLUBS);
        Card b = new Card(14, DIAMONDS);
        Card c = new Card(14, SPADES);
        Card d = new Card(2, HEARTS);
        deck.addOneCard(a);
        deck.addOneCard(b);
        deck.addOneCard(c);
        deck.addOneCard(d);
        assertEquals(deck.sum(), 4);
        assertEquals(deck.getString(), "14 of SPADES;2 of HEARTS;14 of DIAMONDS;4 of CLUBS;");
    }
    
    
    @Test
    public void getCardByStringTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card a = new Card(14, CLUBS);
        Card b = new Card(7, DIAMONDS);
        Card c = new Card(3, SPADES);
        assertEquals(a.toString(), cards.getCardByString(a.toString()).toString());
        assertEquals(b.toString(), cards.getCardByString(b.toString()).toString());
        assertEquals(c.toString(), cards.getCardByString(c.toString()).toString());
        assertEquals(cards.getCardsContainsCardandEraseCard(a), true);
        assertEquals(c.toString(), cards.getCardByString(c.toString()).toString());
        
        
    }
    
    
    
    
    
}
