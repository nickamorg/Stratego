package Model.Player;

import Model.Pieces.*;
import Model.Collection.*;
import Model.Graveyard.Graveyard;

/**
* Contains the methods signatures needed for creating a stratego player
* The variable colour & name are final, so can't be changed
*/
public class Player {
    final private char colour;
    final private Collection myColl;
    private Graveyard myGrave;
    final private String name;
    private int revivals = 0;
    
    /**
    * <b>constructor</b>: Constructs a new player and sets it's details
    * <b>Postcondition:</b>The colour can be only R(Red) or B(Blue)
    */
    public Player(char colour, String name) {
        this.colour = colour;
        this.name = name;
        myColl = new Collection(colour);
        myGrave = new Graveyard(colour);
    }

    /**
    * Observer: Return the number of the revivals
    * <b>Postcondition:</b> Revivals: 0-2
    * @return Return the number of the revivals
    */
    public int revivals() {
        return revivals;
    }
    
    /**
    * <b>transformer(mutative)</b>: Rise the number of the revivals
    * <b>Postcondition:</b> Revivals: 1 or 2
    */
    public void riseRevives() {
        revivals++;
    }
    
    /**
    * <b>Accessor:</b> returns name of the player
    * @return the name of the player
    */
    public String getName() {
        return name;
    }
    
    /**
    * <b>Accessor:</b> returns colour of the player
    * <b>Postcondition:</b> The colour can be only R(Red) or B(Blue)
    * @return the colour of the player
    */
    public char getColour() {
        return colour;
    }

    /**
    * <b>Accessor:</b> returns a collection with all the pieces of the player
    * @return a collection with all the pieces
    */
    public Collection getMyCollection() {
        return myColl;
    }

    /**
    * <b>Accessor:</b> returns a Graveyard with all the pieces of the player
    * @return a graveyard with all the defeated pieces
    */
    public Graveyard getMyGraveyard() {
        return myGrave;
    }
    
}