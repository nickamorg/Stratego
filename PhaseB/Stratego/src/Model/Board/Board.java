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
    public Board() { 
        Table = new Piece[10][12];
    }

    /**
    * <b>Accessor:</b> returns the table of the game
    * @return a Table 10 X 12
    */
    public Piece[][] getTable() {
        return Table;
    }
    
    /**
    * <b>Accessor:</b> returns the piece in position x, y
    * <b>Postcondition:</b> x, y > 0 && x < 12 && y < 10
    * @return the piece in position i
    * @param x
    * @param y
    */
    public Piece getPiece(int x, int y) {
        return Table[x][y];
    }

    /**
    * <b>transformer(mutative)</b>: set a piece of a player on the table
    * <b>Postcondition:</b> x, y > 0 && x < 12 && y < 10
    * @param piece
    * @param x
    * @param y
    */
    public void setPiece(Piece piece, int x, int y) { 
        Table[x][y] = piece;
    }
   
    /**
    * <b>transformer(mutative)</b>: delete the piece of a player on the table from x, y coords
    * <b>Postcondition:</b> x, y > 0 && x < 12 && y < 10
    * @param x
    * @param y
    */
    public void deletePiece(int x, int y) { 
        Table[x][y] = null;
    }
}
