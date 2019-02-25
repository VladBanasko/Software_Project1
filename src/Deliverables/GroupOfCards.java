package Deliverables;

/**
 * SYST 17796 Project Winter 2019 
 * Adrian Angara
 * Anmol Dang
 * Vladyslav Banasko
 * Avnish Singh Sekhon
 */


import java.util.ArrayList;
import java.util.Collections;

/*
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 */
public class GroupOfCards {
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    //Constructors
    public GroupOfCards(int givenSize) {
        size = givenSize;
    }
    
    
    // A method that will get the group of cards as an ArrayList
    public ArrayList<Card> showCards() {
        return cards;
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //Getters
    public int getSize() {
        return size;
    }

    //Setters
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
