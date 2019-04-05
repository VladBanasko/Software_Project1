import java.util.ArrayList;

public class Game {

	/*Initialize the GroupOfCards object and get the
	 *main playing deck of 52 cards and print them
	 */
	private static GroupOfCards goc = new GroupOfCards();
	private static ArrayList<Card> mainDeck = goc.getDeck();//System.out.println(mainDeck); // print mainDeck

	/*Initialize 2 player objects
	 */
	private static Player playerOne = new Player("Adrian");
	private static Player playerTwo = new Player("Computer");

	/*Retrieve both decks and winnings from the player objects
	 * */
	private static ArrayList<Card> p1Deck = playerOne.getDeck();
	private static ArrayList<Card> p2Deck = playerTwo.getDeck();
	private static ArrayList<Card> p1Winnings = new ArrayList<Card>();
	private static ArrayList<Card> p2Winnings = new ArrayList<Card>();

	/*Main Method
	 * */
	public static void main(String arg[]){

		/*Shuffle the main deck , and distribute
		 *cards among the 2 players and then print
		 *player's info
		 */
		goc.shuffle(mainDeck);
		goc.shuffle(mainDeck);
		goc.distribute(playerOne, playerTwo);//System.out.println(playerOne); //System.out.println(playerTwo);

		/*Add the lower card into the round winner's winnings deck;
		 * */
		for(int i = 0; i < 26; i++){
			Card lowerCard = goc.checkLowerCard(p1Deck.get(i), p2Deck.get(i));
			if(lowerCard.equals(p1Deck.get(i))){
				p2Winnings.add(lowerCard);
			}else if(lowerCard.equals(p2Deck.get(i))){
				p1Winnings.add(lowerCard);
			}
		}

		System.out.println("\np1: "+ p1Winnings + " \np2: " + p2Winnings);

	}

}
