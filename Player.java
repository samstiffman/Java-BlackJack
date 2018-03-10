package application;

import java.util.ArrayList;

import application.Card;
import application.Card.Rank;


public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	int soft;
	
	int total = 0;
	
	public Player() {
		Card first = Deck.draw();
		Card second = Deck.draw();
		System.err.println(first + ", " + second);
		hand.add(first);
		hand.add(second);
		System.err.println();
		if((first.rank == Rank.ACE && first.rank.getRank()<10) || (second.rank == Rank.ACE && first.rank.getRank()<10)) {
			soft++;
		}
		setTotal();
	}
	public void AITurn() {
		setTotal();
		
		while(total<17) {
			 Card newCard = Deck.draw();
             if(newCard.rank.getRank()== 1) {
             	soft++;
             }
             hand.add(newCard);
             setTotal();
             System.err.println("AI hit, new Total: " + total);
		}
		if(total>21) {
			System.err.println("AI busts");
			Main.AIBust();
		}	
		else if(total==21) {
			if(Main.player.total==21) {
				System.err.println("Tie");
				Main.tie();
			}
			else {
				System.err.println("Dealer wins");
				Main.playerBust();
			}
		}
		else if(Main.player.total==21) {
			System.err.println("Blackjack");
			Main.blackJack();
		}
		else if(total == Main.player.total) {
			//if equal push
			Main.tie();
		}
		else if(total > Main.player.total && total<21) {
			//computer wins
			Main.playerBust();
		}
		else {
			//player wins
			Main.AIBust();
		}
	}
	public void setTotal() {
		int aces =0;
		for(Card i: hand) {
			if(i.rank == Rank.ACE) {
				aces++;
			}
		}
		int sum = 0;
		for(Card value: hand) {
			switch(value.rank) {
			case ACE: sum += 11;
				soft++;
				break;
			case KING: sum += 10;
				break;
			case QUEEN: sum += 10;
				break;
			case JACK: sum += 10;
				break;
			default:
				sum += value.rank.getRank();
			}
		}
		while(sum>21 && aces>0) {
			aces--;
			sum-=10;
		}
		total = sum;
	}

}
