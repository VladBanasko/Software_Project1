package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GameController {

	//FXML control handles
	@FXML private TextField txtCompDeck;
	@FXML private TextField txtPlayerDeck;
	@FXML private TextField txtCompWinnings;
	@FXML private TextField txtPlayerWinnings;

	@FXML private TextField txtCompDraw;
	@FXML private TextField txtPlayerDraw;

	@FXML private Button btnStart;
	@FXML private Button btnDraw;
	@FXML private Button btnNextRnd;

	@FXML private TextField txtPlayerScore;
	@FXML private TextField txtCompScore;
	@FXML private Button btnEndGame;
	@FXML private Label lblRound;

	//Create Player and GroupOfCards objects
	Player p1 = new Player("Player");
	Player p2 = new Player("Computer");
	GroupOfCards grp = new GroupOfCards();

	//Field Variables
	private int count = 0;
	private int numRounds = 1;
	private ArrayList <Card> deckMain = grp.getDeck();
	private ArrayList <Card> p1Deck = p1.getDeck();
	private ArrayList <Card> p2Deck = p2.getDeck();

	//Initialize method
	@FXML public void initialize(){

		btnStart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onStart();    // Always call a method in the outer class
            }
        });

		btnDraw.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onDrawClicked();    // Always call a method in the outer class
            }
        });

		btnNextRnd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onNextRndClicked();    // Always call a method in the outer class
            }
        });

		btnEndGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                endGame();    // Always call a method in the outer class
            }
        });

	}

	public void onStart(){

		//Shuffle deck 3 times
		grp.shuffle(deckMain);
		grp.shuffle(deckMain);
		grp.shuffle(deckMain);

		//Distribute cards between the 2 players
		grp.distribute(p1, p2);

		//Set the text on the GUI
		txtPlayerDeck.setText("" + p1Deck.size());//System.out.println(p1);
		txtCompDeck.setText("" + p2Deck.size());  //System.out.println(p2);

		//Manipulate buttons
		btnStart.setDisable(true); //Disables start button
		btnDraw.setDisable(false); //Enables Draw button
	}


	public void onDrawClicked(){
		//Deck counters initialized
		int countComp1 = Integer.parseInt(txtCompDeck.getText());       //Computer's Deck Counter
		int countComp2 = Integer.parseInt(txtCompWinnings.getText());  //Computer's Winnings Counter
		int countplyer1 = Integer.parseInt(txtPlayerDeck.getText());    //Player's Deck Counter
		int countplyer2 = Integer.parseInt(txtPlayerWinnings.getText());//Player's Winnings Counter

		//Pulls object from the decks and assign it to a Card variable
		Card p1Draw = p1Deck.get(count);
		Card p2Draw = p2Deck.get(count);

		//Sets the string for the draw text field
		txtPlayerDraw.setText(p1Draw.toString());
		txtCompDraw.setText(p2Draw.toString());

		//Compares the draws to determine who receives the earnings
		if(p1Draw.getVal() > p2Draw.getVal()){

			countComp1--;
			txtCompDeck.setText("" + countComp1);  //Decrease counter and set deck text

			countplyer1--;
			txtPlayerDeck.setText("" + countplyer1); //Increase counter and set deck text

			countplyer2+=2;
			txtPlayerWinnings.setText("" + countplyer2);//Decrease counter and set winnings text
		}else if(p1Draw.getVal() < p2Draw.getVal()){
			countComp1--;
			txtCompDeck.setText("" + countComp1); //Decrease counter and set deck text

			countplyer1--;
			txtPlayerDeck.setText("" + countplyer1);//Increase counter and set deck text

			countComp2 +=2;
			txtCompWinnings.setText("" + countComp2);//Decrease counter and set winnings text
		}

		//Disables button when no more cards can be drawn
		count++;//increases count every time draw is clicked
		int numClicks = p1.getDeck().size();
		if(count == numClicks & numRounds == 3){
			btnEndGame.setDisable(false);
			btnDraw.setDisable(true);

			//Determine who has the most cards and set increase win count for winner
			determineWinner();

		}else if(count == numClicks){
			btnDraw.setDisable(true);
			btnNextRnd.setDisable(false);

			//Determine who has the most cards and set increase win count for winner
			determineWinner();
		}

	}

	public void onNextRndClicked(){
		//increment rounds
		numRounds++;
		lblRound.setText("" + numRounds);

		//Reset round
		reset();

		//Reset button
		btnNextRnd.setDisable(true);

		//Call Start Method
		onStart();


	}

	public void determineWinner(){
		//Get the Winnings deck count
		int countComp2 = Integer.parseInt(txtCompWinnings.getText());  //Computer's Winnings Counter
		int countplyer2 = Integer.parseInt(txtPlayerWinnings.getText());//Player's Winnings Counter

		//Get the participants score count
		int compScore = Integer.parseInt(txtCompScore.getText());
		int playerScore = Integer.parseInt(txtPlayerScore.getText());

		//Update score
		if(countComp2 > countplyer2){
			compScore++;
			txtCompScore.setText("" + compScore);
		}else if(countComp2 < countplyer2){
			playerScore++;
			txtPlayerScore.setText("" + playerScore);
		}
	}

	public void endGame(){
		//Get the score count from both participants
		int compScore = Integer.parseInt(txtCompScore.getText());
		int playerScore = Integer.parseInt(txtPlayerScore.getText());

		//Determine winner by comparing scores
		if(compScore > playerScore){
			System.out.println("Computer wins");
		}else if(compScore < playerScore){
			System.out.println("Player wins");
		}else {
			System.out.println("Its a Draw!");
		}

		//Manipluate buttons
		btnStart.setDisable(false);
		btnEndGame.setDisable(true);

		//Reset game and all counters
		txtCompScore.setText("" + 0);
		txtPlayerScore.setText("" + 0);

		reset();
		numRounds = 1;
		lblRound.setText("" + numRounds);
	}

	public void reset(){
		//Reset values
		txtPlayerDeck.setText("" + 0);
		txtCompDeck.setText("" + 0);
		txtPlayerWinnings.setText("" + 0);
		txtCompWinnings.setText("" + 0);
		count = 0;

		//Clear both player's deck in the previous round
		p1Deck.clear();
		p2Deck.clear();
	}
}
