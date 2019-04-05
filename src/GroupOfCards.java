
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

	public Card checkLowerCard(Card card1, Card card2){
		Card temp = new Card();

		if(card1.getVal() > card2.getVal()){
			temp = card2;
		}else if(card1.getVal() < card2.getVal()){
			temp = card1;
		}

		return temp;
	}

	//Getters
	public ArrayList <Card> getDeck(){
		return deck;
	}

	public Card getCard(int num){
		return deck.get(num);
	}


}
