package application;
import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

	//Field Variables
	private ArrayList <Card> deck = new ArrayList <Card>();

	//Constructors
	public GroupOfCards(){
		//Intialize cards
		for(int i = 14; i >= 2; i--){
			deck.add(new Card(Card.HEARTS, i));
			deck.add(new Card(Card.SPADES, i));
			deck.add(new Card(Card.CLOVERS, i));
			deck.add(new Card(Card.DIAMONDS, i));
		}
	}

	//Other Methods
	public void shuffle(ArrayList <Card> list){
		Collections.shuffle(list);
	}

	public String toString(){
		return deck.toString() + "\n";
	}

	public void distribute(Player p1, Player p2){
		ArrayList <Card> deck1 = p1.getDeck();
		ArrayList <Card> deck2 = p2.getDeck();

		for(int i = 0; i <= deck.size() - 1; i++){
			if(i%2 == 0){
				deck1.add(deck.get(i));
			}else {
				deck2.add(deck.get(i));
			}
		}
	}

	//Getters
	public ArrayList <Card> getDeck(){
		return deck;
	}

	public Card getCard(int num){
		return deck.get(num);
	}


}
