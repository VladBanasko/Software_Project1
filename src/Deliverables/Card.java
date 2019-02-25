package Deliverables;

/**
 * SYST 17796 Project Winter 2019 
 * Adrian Angara
 * Anmol Dang
 * Vladyslav Banasko
 * Avnish Singh Sekhon
 */



//A class to be used as the base Card class for the project. Must be general
public abstract class Card {
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    @Override
    public abstract String toString();
    
}
