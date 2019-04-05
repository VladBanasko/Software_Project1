package application;

public class Card {

	//Suit values
	static final String HEARTS = "Hearts";
	static final String SPADES = "Spades";
	static final String CLOVERS = "Clovers";
	static final String DIAMONDS = "Diamonds";

	//Field Variables
	private int _value;
	private String _suit;

	//Constructors
	public Card(String suit, int value){
		_suit = suit;
		_value = value;
	}

	//Getters and Setters
	public String getSuit(){
		return _suit;
	}

	public int getVal(){
		return _value;
	}

	//other Methods
	public String toString() {
		String name;
		switch(_value){
		case 14:
			name = "Ace";
			break;
		case 13:
			name = "King";
			break;
		case 12:
			name = "Queen";
			break;
		case 11:
			name= "Jack";
			break;
		default:
			name = "" + _value;
			break;
		}

		return "\n" + name + " of " + _suit ;
	}
}
