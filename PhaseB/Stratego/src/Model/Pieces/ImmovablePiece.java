package Model.Pieces;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
* Contains the methods signatures needed for creating a stratego immovable piece
* The level can take is the zero (0)
* None variable can be changed except x & y but only one time
*/
public abstract class ImmovablePiece extends Piece{
        
    /**
    * <b>constructor</b>: Constructs a new immovable piece
    * <b>Postcondition:</b> The only colour which can take are R(Red) and B(Blue)
    * @param colour
    */
    public ImmovablePiece(char colour) { super(colour); }
    
    /**
    * <b>constructor</b>: Constructs only a new piece type of forbidden
    */
    public ImmovablePiece() { super(); }
    
}