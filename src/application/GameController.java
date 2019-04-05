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

	//Create Player and GroupOfCards objects
	Player p1 = new Player("Player");
	Player p2 = new Player("Computer");
	GroupOfCards grp = new GroupOfCards();

	//Field Variables
	private int count = 0;
	private ArrayList <Card> deckMain = grp.getDeck();
	private ArrayList <Card> p1Deck = p1.getDeck();
	private ArrayList <Card> p2Deck = p2.getDeck();
	private ArrayList <Card> p1Winnings = p1.getWinnings();
	private ArrayList <Card> p2Winnings = p2.getWinnings();

	//Initialize method
	@FXML public void initialize(){

		btnStart.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                onStartClicked();    // Always call a method in the outer class
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
	}

	public void onStartClicked(){
		grp.shuffle(deckMain);
		grp.shuffle(deckMain);
		grp.shuffle(deckMain);

		grp.distribute(p1, p2);


		txtPlayerDeck.setText("" + p1Deck.size());
		txtCompDeck.setText("" + p2Deck.size());

		//System.out.println(p1);
		//System.out.println(p2);

		btnStart.setDisable(true); //Disables start button
		btnDraw.setDisable(false); //Enables Draw button
	}


	public void onDrawClicked(){
		Card p1Draw = p1Deck.get(count);
		Card p2Draw = p2Deck.get(count);

		txtPlayerDraw.setText(p1Draw.toString());
		txtCompDraw.setText(p2Draw.toString());

		//Removes one card from each of the decks every time draw is clicked
	/*	int temp = Integer.parseInt(txtCompDeck.getText());
		temp--;
		txtCompDeck.setText("" + temp);
		int temp2 = Integer.parseInt(txtPlayerDeck.getText());
		temp2--;
		txtPlayerDeck.setText("" + temp2);*/

		//Compares the draws to determine who receives the earnings then pushes the earnings into
		  // their respective winnings array
		if(p1Draw.getVal() > p2Draw.getVal()){
			//remove after
			int temp = Integer.parseInt(txtCompDeck.getText());
			temp--;
			txtCompDeck.setText("" + temp);
			int temp2 = Integer.parseInt(txtPlayerDeck.getText());
			temp2--;
			txtPlayerDeck.setText("" + temp2);
			//remove after

			int temp3 = Integer.parseInt(txtPlayerWinnings.getText());
			temp3+=2;
			txtPlayerWinnings.setText("" + temp3);

			p1Winnings.add(p2Draw);
			p1Winnings.add(p1Draw);

		}else if(p1Draw.getVal() < p2Draw.getVal()){
			//remove after
			int temp = Integer.parseInt(txtCompDeck.getText());
			temp--;
			txtCompDeck.setText("" + temp);
			int temp2 = Integer.parseInt(txtPlayerDeck.getText());
			temp2--;
			txtPlayerDeck.setText("" + temp2);
			//remove after

			int temp3 = Integer.parseInt(txtCompWinnings.getText());
			temp3+=2;
			txtCompWinnings.setText("" + temp3);

			p2Winnings.add(p1Draw);
			p2Winnings.add(p2Draw);
		}

		count++;//increases count every time draw is clicked

		//Disables button when no more cards can be drawn
		int numClicks;
		if(p1Deck.size() > p2Deck.size()){
			numClicks = p2Deck.size();
		}else {
			numClicks = p1Deck.size();
		}

		if(count == numClicks){
			btnDraw.setDisable(true);
			btnNextRnd.setDisable(false);
			System.out.println("Computer: \n" + p2Winnings + "\n");
			System.out.println("Player: \n" + p1Winnings);

		}
	}

	public void onNextRndClicked(){
		//Clear the decks
		p1Deck.clear();
		p2Deck.clear();

		//Replace contents of deck with the winnings
		p1Deck.addAll(p1Winnings);
		p2Deck.addAll(p2Winnings);

		//Clear contents of winnings
		p1Winnings.clear();
		p2Winnings.clear();

		//Reset values
		txtPlayerDeck.setText("" + p1Deck.size());
		txtCompDeck.setText("" + p2Deck.size());
		txtPlayerWinnings.setText("" + 0);
		txtCompWinnings.setText("" + 0);

		count = 0;
		btnNextRnd.setDisable(true);
		btnDraw.setDisable(false);

		System.out.println("Computer: \n" + p2Deck + "\n");
		System.out.println("Player: \n" + p1Deck);
	}
}
