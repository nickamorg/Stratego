package Model.Pieces;

import javax.swing.Icon;
import javax.swing.ImageIcon;

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

    /**
    * <b>constructor</b>: Constructs a new Piece and sets the colour of its
    * <b>Postcondition:</b> The colour can be only R(Red) or B(Blue)
    * @param colour
    */
    public Piece(char colour) { 
        this.colour = colour;
    }
    
    /**
    * <b>constructor</b>: Constructs a new Piece
    * <b>Postcondition:</b> Default constractor for generating of forbidden pieces
    */
    public Piece() {}
    
    /**
    * <b>Accessor:</b> returns the colour of this piece
    * <b>Postcondition:</b> colour: R(Red) or B(Blue)
    * @return the colour of this piece
    */
    public char getColour() {
        return colour;
    }

    /**
    * <b>transformer(mutative)</b>: sets the icon of this piece
    * <b>Postcondition:</b> The icon depend on the name of this piece
    * @param icon
    */
    public void setIcon(String icon) { 
        this.icon = new ImageIcon("pieces\\" + icon + ".png");
    }
    
    /**
    * <b>transformer(mutative)</b>: seys the colour of this piece
    * <b>Postcondition:</b> colour: R(Red) or B(Blue)
    * @param colour
    */
    public void setColour(char colour) {
        this.colour = colour;
    }
    
    /**
    * <b>Accessor:</b> returns the level of this piece
    * <b>Postcondition:</b> level between 0 and 10
    * @return the level of this piece
    */
    public int getLevel() { return level; }
    
    /**
    * <b>Accessor:</b> returns the icon of this piece
    * <b>Postcondition:</b> The icon depend on the name of this piece
    * @return the icon of this piece
    */
    public Icon getIcon() { return icon; }
    
    /**
    * <b>Accessor:</b> returns the name of this piece
    * <b>Postcondition:</b> The name depend on the type of this piece
    * @return the name of this piece
    */
    public String getName() { return name; }

    /**
    * <b>transformer(mutative)</b>: sets the level of this piece
    * <b>Postcondition:</b> The level depend on the type of this piece
    * @param level
    */
    public void setLevel(int level) {
        this.level = level;
    }
    
    /**
    * <b>transformer(mutative)</b>: sets the name of this piece
    * <b>Postcondition:</b> The name depend on the type of this piece
    * @param name
    */
    public void setName(String name) { 
        this.name = name;
    }

}