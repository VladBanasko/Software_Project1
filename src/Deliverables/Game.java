package Deliverables;

/**
 * SYST 17796 Project Winter 2019 
 * Adrian Angara
 * Anmol Dang
 * Vladyslav Banasko
 * Avnish Singh Sekhon
 */


import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 */
public abstract class Game {
    
    //Fields
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    
    //Constructors
    public Game(String givenName){
        gameName = givenName;
        players = new ArrayList();
    }

    //Getters
    public String getGameName() {
        return gameName;
    }
    
    public ArrayList <Player> getPlayers() {
        return players;
    }

    //Setters
    public void setPlayers(ArrayList <Player> players) {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();
}//end class
