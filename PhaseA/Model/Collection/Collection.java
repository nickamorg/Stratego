package Model.Collection;

import Model.Pieces.*;

/**
* Contains all the first pieces of a player
* Depenting on what colour we will give to it, 
* it will construct the respectively pieces
*/
public class Collection {
    private Piece[] Piece;
    private int[] Quantity;
    
    /**
    * <b>constructor</b>: Constructs a new collection of pieces
    * <b>Postcondition:</b> The only colour which can take is R(Red)) or B(Blue)
    * @param colour
    */
    public Collection(char colour) { /* ... code ... */ }
    
    /**
    * <b>Observer:</b> Returns true if there is quantity, or false different
    * <b>Postcondition:</b> There is at least 1 quantity of piece i
    * @return true for empty quantity, false different
    * @param i
    */
    public boolean isEmpty(int i) { /* ... code ... */ }
    
    /**
    * <b>Accessor:</b> returns the piece in position i
    * <b>Postcondition:</b> i >= 0 && i < 12
    * @return the piece in position i
    * @param i
    */
    public Piece getPiece(int i) { /* ... code ... */ }
    
}
