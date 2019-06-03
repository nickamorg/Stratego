package Model.Pieces;

import javax.swing.Icon;

/**
* Contains the methods signatures needed for creating a stratego piece
* The level can be only from 0 to 10. 
* None variable can be changed except x & y
*/
public abstract class Piece {
    private int level;
    private char colour;
    private Icon icon;
    private String name;
    private int x;
    private int y;
    
    /**
    * <b>constructor</b>: Constructs a new Piece and sets the colour of its
    * <b>Postcondition:</b> The colour can be only R(Red) or B(Blue)
    * @param colour
    */
    public Piece(char colour) { /* ... code ... */ }
    
    /**
    * <b>constructor</b>: Constructs a new Piece and sets the colour of its
    * <b>Postcondition:</b> Default constractor for generate forbidden pieces
    */
    public Piece() { /* ... code ... */ }
    
   /**
    * <b>transformer(mutative)</b>: sets the icon of this piece
    * <b>Postcondition:</b> The icon depend on the name of every piece
    */
    public void setIcon() { /* ... code ... */ }
    
    /**
    * <b>Accessor:</b> returns the level of this piece
    * @return the level of this piece
    */
    public int getLevel() { /* ... code ... */ }
    
    /**
    * <b>Accessor:</b> returns the icon of this piece
    * @return the icon of this piece
    */
    public Icon getIcon() { /* ... code ... */ }
    
    /**
    * <b>Accessor:</b> returns the name of this piece
    * @return the name of this piece
    */
    public String getName() { /* ... code ... */ }

    /**
    * An abstract class which will be implemented from the subclasses
    * Taces as parameters the coordinates where the piece will be placed 
    * @param x
    * @param y
    */
    public abstract void setXY(int x, int y);
    
    public int getX() { /* ... code ... */ }

    public int getY() { /* ... code ... */ }
}