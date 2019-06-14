package application;

import java.util.ArrayList;
import java.util.Random;

import application.Card;
import application.Card.Rank;
import application.Card.Suit;

public class Deck {

public static ArrayList<Card> cards = new ArrayList<Card>(52);


    /**
     * Default constructor makes a normal deck of playing cards
     */
	public Deck() {
		for (int suit = 1; suit <= 4; suit++) {
		    for (int rank = 1; rank <= 13; rank++) {
		        cards.add(new Card(Rank.values()[rank], Suit.values()[suit], (rank + "_of_"+ Suit.values()[suit])));
		        // ^^ The 3rd parameter is my way of making the address string match that of the enums 
		    }
		}
    }
	/**
	 * Shuffles the deck by swapping random cards
	 */
    public static void shuffle() {
		Random r = new Random();
		Card temp;
		for(int i=0; i<52; i++) {
			temp = cards.get(i);
			int tempInt = r.nextInt(52)+0;
			cards.set(i, cards.get(tempInt));
			cards.set(tempInt, temp);
		}
	}
	/**
	 * Method for drawing the next card in the deck
	 * @return the next card in the deck
	 */
	public static Card draw() {
		Card drawed = cards.get(0);
		cards.remove(0);
		System.err.println("Drew: " + drawed);
		return drawed;
	}
}
