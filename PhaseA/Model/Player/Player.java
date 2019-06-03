package Model.Player;

import Model.Pieces.*;
import Model.Collection.*;
import Model.Graveyard.Graveyard;

/**
* Contains the methods signatures needed for creating a stratego player
* The variable colour & name are final, so can't be changed
*/
public class Player {
    private boolean state = false;
    final private char colour;
    private Piece[] Pieces;
    final private Collection myColl;
    private Graveyard myGrave;
    final private String name;
    private int lostPieces = 0;
    
    /**
    * <b>constructor</b>: Constructs a new player and sets it's details
    * <b>Postcondition:</b>The colour can be only R(Red) or B(Blue)
    */
    public Player(char colour, String name) { /* ... code ... */ }

    /**
    * <b>transformer(mutative)</b>: sets the pieces of a player for a new game<br />
    * <b>Postcondition:</b> The variable - parameter ought to contains all the pieces
    */
    public void setPieces() { /* ... code ... */ }
    
    /**
    * <b>Observer:</b> Returns true if the player can make a moving else false
    * @return true if can move, else false 
    */
    public boolean isMovable() { /* ... code ... */ }
    
    /**
    * <b>Accessor:</b> returns name of the player
    * */
    public String getName() { /* ... code ... */ }
    
    /**
    * <b>Observer:</b> Returns true the player has lost all it's pieces
    * @return true if has lost all of them, or false different.
    */
    public boolean isDefeated() { /* ... code ... */ }

    /**
    * <b>transformer(mutative)</b>: sets the state of the player.<br />
    */
    public void setState() { /* ... code ... */ }

    /**
    * <b>Accessor:</b> returns the piece in position i
    * <b>Postcondition:</b> i >= 0 && i < 30
    * @return the piece in position i
    * @param i
    */
    public Piece getPiece(int i) { /* ... code ... */ }

    /**
    * <b>Accessor:</b> returns a collection with all the pieces of the player
    * @return a variable with all the pieces
    */
    public Collection getMyCollection() { /* ... code ... */ }

    /**
    * <b>Accessor:</b> returns a Graveyard with all the pieces of the player
    * @return a variable with all the defeated pieces
    */
    public Graveyard getMyGraveyard() { /* ... code ... */ }
    
    /**
    * <b>Observer:</b> Returns the number of the defeated pieces
    * @return the number of the defeated pieces
    */
    public int getLostPieces() { /* ... code ... */ }

    /**
    * <b>transformer(mutative)</b>: sets 1 plus lost piece<br />
    * <b>Postcondition:</b> lost pieces can't be over 30.
    */
    public void riseLostPieces() { /* ... code ... */ }
    
}