package Model.Pieces;

/**
* Contains the methods signatures needed for creating a stratego movable piece
* The level can be only from 1 to 10. 
* None variable can be changed except x & y
*/

public abstract class MovablePiece extends Piece {
    private boolean hasRecovered;
    
    /**
    * <b>constructor</b>: Constructs a new movable piece
    * <b>Postcondition:</b> The only colour which can take are R(Red) and B(Blue)
    * @param colour
    */
    public MovablePiece(char colour) { /* ... code ... */ }
    
    /**
    * <b>Observer:</b> Returns true if has recovered a piece before.
    * @return true if has recoverd, else false 
    */
    public boolean hasRecovered() { return true; /* ... code ... */ }
    
    /**
    * <b>transformer(mutative)</b>: set that the piece has recovered
    */
    public void setRecovering() { /* ... code ... */ } 

    /**
    * Abstract class which will be implemented different for every piece
    * <b>transformer(mutative)</b>: This piece is moving to somewhere else
    * <b>Postcondition:</b> None piece can move to places which aren't in it's score,
    * are forbidden or are caught from other pieces.
     * @param x
     * @param y
    */
    abstract public void move(int x, int y);
    
    /**
    * Abstract class which will be implemented different for every piece
    * <b>transformer(mutative)</b>: This piece attacks to another piece
    * <b>Postcondition:</b> None piece can attack to pieces which aren't 
    * in it's scope and has the same colour
    * @param opponent
    */
    abstract public void attack(Piece opponent);
    
    /**
    * Abstract method which will be implemented different for every piece
    * <b>Observer:</b> Returns true if there is at least one moving
    * @param Table
    * @return true if there is a possible moving
    */
    abstract public int[][] getMoves(Piece[] Table);
    
    /**
    * It's a  class which will be implemented different for some pieces
    * <b>Observer:</b> In general case returns 1 if this piece's level is higher than the opponent's,
    * 2 if both are equal and 3 differend.
    * @return 1 for win, 2 for tie or 3 for lose
    * @param opponent
    */
    abstract public int isWinner(Piece opponent);
    
    @Override
    public void setXY(int x, int y) { /* ... code ... */  }
}