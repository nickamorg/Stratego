package Model.Graveyard;

import Model.Pieces.*;
import Model.Player.Player;

/**
 * This class contains the pieces of a player which have defeated    
 * Will be used when the player want to revive a piece
 */
public class Graveyard {
    private Piece[] Piece = new Piece[12];
    private int[] Quantity = new int[12];

    /**
     * <b>Observer:</b> Returns true if this list contains no elements.
     * <b>Postcondition:</b> An Graveyard is empty when it's constructed
     * @return true if this list contains no elements
     */
    public boolean isEmpty() { /* ... code ... */ }
    
    /**
     * <b>Observer:</b> Returns true if there is a defeated piece like as parameter i
     * <b>Postcondition:</b> Every piece has 0 defated crowd of every piece at the start
     * @return true if there is at least a defauted piece
     * @param i
     */
    public boolean isDefeated(int i) { /* ... code ... */ }
    
    /**
     * <b>Accessor:</b> returns the piece in position i
     * <b>Postcondition:</b> There is at least 1 quantity of piece i
     * @return the piece in position i
     * @param i
     */
    public Piece getPiece(int i) { /* ... code ... */ }
    
    /**
     * <b>Transformer:</b> Rise the quantity of piece i
     * @param i
     */
    public void setPiece(int i) { /* ... code ... */ }
    
}
