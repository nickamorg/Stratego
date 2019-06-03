package Model.Pieces;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
* Contains the methods signatures needed for creating a stratego immovable piece
* The level can take is the zero (0)
* None variable can be changed except x & y but only one time
*/
public abstract class ImmovablePiece extends Piece{
    boolean hasPlaced = false;
        
    /**
    * <b>constructor</b>: Constructs a new immovable piece
    * <b>Postcondition:</b> The only colour which can take are R(Red) and B(Blue)
    * @param colour
    */
    public ImmovablePiece(char colour) { /* ... code ... */ }
    
    /**
    * <b>constructor</b>: Constructs only a new piece type of forbidden
    */
    public ImmovablePiece() { /* ... code ... */ }
    
    /**
    * <b>transformer(mutative)</b>: sets the coords of this piece<br />
    * <b>Postcondition:</b> Only one time can be changed the coords.
    * @param x
    * @param y
    */
    @Override
    public void setXY(int x, int y) { /* ... code ... */  }
    
}