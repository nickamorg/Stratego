package Model.Pieces;

import Model.Board.Board;
import javax.swing.JButton;

/**
* Contains the methods signatures needed for creating a stratego movable piece
* The level can be only from 1 to 10. 
* None variable can be changed except x & y
*/
public abstract class MovablePiece extends Piece {
    private boolean hasRevive = false;
    
    /**
    * <b>constructor</b>: Constructs a new movable piece
    * <b>Precondition:</b> The only colour which can take are R(Red) and B(Blue)
    * @param colour
    */
    public MovablePiece(char colour) {
        super(colour);
    }
    
    /**
    * <b>Observer:</b> Returns true if has recovered a piece before.
    * @return true if has recoverd, else false 
    */
    public boolean hasRevive() { 
        return hasRevive; 
    }
    
    /**
    * <b>transformer(mutative)</b>: set that the piece has recovered
    * <b>Postcondition:</b> Make variable hasRecovered equal to true
    */
    public void setRevive() { 
        hasRevive = true;
    } 
    
    /**
    * Abstract class which will be implemented different for every piece
    * Observer: This piece attacks to another piece
    * <b>Postcondition:</b> None piece can attack to pieces which aren't 
    * in it's scope and has the same colour. Attack Type: 1-5
    * @param opponent
    * @return the type of the attack
    */
    abstract public int attack(Piece opponent);
    
    /**
    * Abstract method which will be implemented different for every piece
    * <b>Observer:</b> Returns true if there is at least one moving
    * <b>precondition:</b> x > 0 && x < 8 && y > 0 && y < 10
    * @param Table
    * @param x
    * @param y
    * @return true if there is a possible moving
    */
    abstract public int[][] getMoves(Piece[][] Table, int x, int y);
    
    /**
    * Abstract method which will be implemented different for every piece
    * <b>Observer:</b> Returns true if it can move or false different
    * <b>precondition:</b> x > 0 && x < 8 && y > 0 && y < 10
    * @param Table
    * @param x
    * @param y
    * @return true if there is a possible moving
    */
    abstract public boolean isMoving(Piece[][] Table, int x, int y);
    
}