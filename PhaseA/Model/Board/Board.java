package Model.Board;

import Model.Pieces.*;

/**
* Contains the methods signatures needed for creating a stratego table
*/
public class Board {
    Piece[][] Table;
    
    /**
    * <b>constructor</b>: Constructs a new table and sets the dead zones
    */
    public Board() { /* ... code ... */ }

    
    /**
    * <b>Accessor:</b> returns the piece in position x, y
    * <b>Postcondition:</b> x, y > 0 && x < 11 && y < 9
    * @return the piece in position i
    * @param x
    * @param y
    */
    public Piece getPiece(int x, int y) { /* ... code ... */  }

    /**
    * <b>transformer(mutative)</b>: set a piece of a player on the table
    * <b>Postcondition:</b> x, y > 0 && x < 12 && y < 10
     * @param piece
     * @param x
     * @param y
    */
    public void setPiece(Piece piece, int x, int y) { /* ... code ... */ }
   
}
