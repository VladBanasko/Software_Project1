
import java.util.ArrayList;

public class Player {

	//Field Variables
	private String _name;
	private ArrayList <Card> _playerDeck = new ArrayList <Card>();
	private ArrayList <Card> _winnings = new ArrayList <Card>();

	//Constructor
	public Player(String name){
		_name = name;
	}

	//Getters
	public ArrayList <Card> getDeck(){
		return _playerDeck;
	}

	public ArrayList <Card> getWinnings(){
		return _winnings;
	}

	//Other Methods
	public String toString(){
		return "\n" + _name + "'s deck: " + "\n" + _playerDeck;
	}

}
