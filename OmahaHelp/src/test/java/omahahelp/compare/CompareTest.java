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
import omahahelp.cards.PlayersCards;
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
public class CompareTest {

    public CompareTest() {
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
    public void getCardsTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card cardA = new Card(13, SPADES);
        Card cardB = new Card(3, SPADES);
        Card cardC = new Card(2, SPADES);
        Card cardD = new Card(14, SPADES);
        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
        Compare compare = new Compare(cards);
        compare.setHands(handA, handB);
        assertEquals(compare.getCards(), cards);
    }

    @Test
    public void addFlopsToMapTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card cardA = new Card(13, CLUBS);
        Card cardB = new Card(3, SPADES);
        Card cardC = new Card(2, HEARTS);
        Card cardD = new Card(14, SPADES);
        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
        Compare compare = new Compare(cards);
        compare.setHands(handA, handB);
        compare.addCardsToFlopHashMap();

        assertEquals(compare.getMap().size(), 17296);
    }

    @Test
    public void calculateTurnTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card cardA = new Card(13, CLUBS);
        Card cardB = new Card(3, SPADES);
        Card cardC = new Card(2, HEARTS);
        Card cardD = new Card(14, SPADES);
        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
        Compare compare = new Compare(cards);
        compare.setHands(handA, handB);
        compare.addCardsToFlopHashMap();
        compare.addTurnsToMap();
        assertEquals(compare.getTurns().size(), 194580);
    }

    @Test
    public void setWinsAndTieZeroTest() {
        Deck cards = new Deck();
        cards.addCards();
      
        Compare compare = new Compare(cards);
        compare.setWinsAndTieZero();
        compare.setWinsAndTies(2);
        assertEquals(compare.getAwins(), 0);
        assertEquals(compare.getTies(), 0);
        assertEquals(compare.getBWins(), 1);
        compare.setWinsAndTies(0);
        assertEquals(compare.getTies(), 1);
        compare.setWinsAndTies(1);
        assertEquals(compare.getAwins(), 1);
        compare.setWinsAndTieZero();
        
        assertEquals(compare.getAwins(), 0);
        assertEquals(compare.getBWins(), 0);
        assertEquals(compare.getTies(), 0);

    }
    
    @Test
    public void setWinsAndTieTest() {
        Deck cards = new Deck();
        cards.addCards();
        Card cardA = new Card(13, CLUBS);
        Card cardB = new Card(3, SPADES);
        Card cardC = new Card(13, HEARTS);
        Card cardD = new Card(2, SPADES);
        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
        Compare compare = new Compare(cards);
        compare.setHands(handA, handB);
       
        
        Deck deck = new Deck();
        
        deck.addOneCard(new Card(3, CLUBS));
        deck.addOneCard(new Card(3, HEARTS));
        deck.addOneCard(new Card(3, DIAMONDS));
        deck.addOneCard(new Card(5, CLUBS));
        
        compare.setTurnWinsAndTies(deck);
        assertEquals(compare.getAwins(), 1);
        assertEquals(compare.getBWins(), 0);
        
        deck.erase();
        deck.addOneCard(new Card(2, CLUBS));
        deck.addOneCard(new Card(2, HEARTS));
        deck.addOneCard(new Card(2, DIAMONDS));
        deck.addOneCard(new Card(5, CLUBS));
        compare.setTurnWinsAndTies(deck);
        assertEquals(compare.getBWins(), 1);
        assertEquals(compare.getAwins(), 1);
        
        deck.erase();
        deck.addOneCard(new Card(12, CLUBS));
        deck.addOneCard(new Card(11, HEARTS));
        deck.addOneCard(new Card(10, DIAMONDS));
        deck.addOneCard(new Card(9, CLUBS));
        compare.setTurnWinsAndTies(deck);
        assertEquals(compare.getTies(), 1);

    }
    
    
    

//        @Test
//    public void compareTurnsCalculateTest(){
//    Deck cards = new Deck();
//        cards.addCards();
//        Card cardA = new Card(2, CLUBS);
//        Card cardB = new Card(2, SPADES);
//        Card cardC = new Card(2, HEARTS);
//        Card cardD = new Card(2, DIAMONDS);
//        PlayersCards handA = new PlayersCards(cards, cardA, cardB);
//        PlayersCards handB = new PlayersCards(cards, cardC, cardD);
//        Compare compare = new Compare(cards);
//        compare.setHands(handA, handB);
//        compare.addCardsToFlopHashMap();
//        
//        compare.addTurnsToMap();
//        compare.addWinsAndTiesAfterTurnWhenFlopBlind();
//        assertEquals(compare.getAwins(), 990);
//    }
    @Test
    public void CalculateAfterTurnTest() {
        Deck deck = new Deck();
        deck.addCards();
        String cardA = "2 of DIAMONDS";
        String cardB = "3 of SPADES";
        String cardC = "2 of CLUBS";
        String cardD = "2 of HEARTS";
        Card a = deck.getCardByString(cardA);
        Card b = deck.getCardByString(cardB);
        Card c = deck.getCardByString(cardC);
        Card d = deck.getCardByString(cardD);

        String cardQ = "13 of CLUBS";

        String cardW = "3 of CLUBS";
        String cardE = "3 of HEARTS";

        Card q = deck.getCardByString(cardQ);
        Card w = deck.getCardByString(cardW);
        Card e = deck.getCardByString(cardE);

        PlayersCards handA = new PlayersCards(deck, a, b);
        PlayersCards handB = new PlayersCards(deck, c, d);

        Value aa = new Value();
        Value bb = new Value();

        aa.setCardsToHand(a, b, q, w, e);
        bb.setCardsToHand(d, c, q, w, e);

        assertEquals(aa.getValue(), 430303132);
        assertEquals(bb.getValue(), 330302033);
    }

    public void compareTurnsTest() {
        Deck deck = new Deck();
        deck.addCards();
        String cardA = "3 of DIAMONDS";
        String cardB = "3 of SPADES";
        String cardC = "2 of CLUBS";
        String cardD = "2 of HEARTS";
        Card a = deck.getCardByString(cardA);
        Card b = deck.getCardByString(cardB);
        Card c = deck.getCardByString(cardC);
        Card d = deck.getCardByString(cardD);

        String cardQ = "14 of CLUBS";

        String cardW = "3 of CLUBS";
        String cardE = "3 of HEARTS";
        Deck turn = new Deck();
        
        Card q = deck.getCardByString(cardQ);
        Card w = deck.getCardByString(cardW);
        Card e = deck.getCardByString(cardE);
        turn.addOneCard(q);
        turn.addOneCard(w);
        turn.addOneCard(e);
        turn.addOneCard(c);

        PlayersCards handA = new PlayersCards(deck, a, b);
        PlayersCards handB = new PlayersCards(deck, c, d);
        Compare compare = new Compare(deck);
        compare.setHands(handA, handB);
        Value one = compare.compareTurns(deck, handB);
        assertEquals(one.getType(), 800000000);
        

    }

}
