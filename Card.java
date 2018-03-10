package application;


public class Card{

	 Rank rank;
	 Suit suit;
	 String address;
	
	public Card(Rank rank, Suit suit, String address) {
       this.rank = rank;
       this.suit = suit;
       this.address = address;
   }
	public Card() {
		rank = Rank.values()[0];
		suit = Suit.values()[0];
	}
	public String toString() {
		return rank + " of " + suit;
	}
	enum Suit {
		EXTRA(0),
		CLUB(1),
		DIAMOND(2),
		HEART(3),
		SPADE(4);
		
		private int cardSuit;
		
		private Suit(int value) {
			cardSuit = value;
		}
		
		public int getSuit() {
			return cardSuit;
		}
	}
	enum Rank{
		EXTRA(0),
		ACE(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(11),
		QUEEN(12),
		KING(13);
		
		
		private int rank;
		
		private Rank(int value) {
			rank = value;
		}
		
		public int getRank() {
			return rank;
		}
	}
}
