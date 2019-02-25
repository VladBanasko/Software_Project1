package Deliverables;

/**
 * SYST 17796 Project Winter 2019 
 * Adrian Angara
 * Anmol Dang
 * Vladyslav Banasko
 * Avnish Singh Sekhon
 */


//class that models each Player in the game. Players have an identifier, which should be unique.
public abstract class Player {
    
    //Field Variables
    private String playerID; //the unique ID for this player
    
    //Constructors
    public Player(String name) {
        playerID = name;
    }
    
    //Getters
    public String getPlayerID() {
        return playerID;
    }

    //Setters
    public void setPlayerID(String givenID) {
        playerID = givenID;
    }
    
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    public abstract void play();
    
}
