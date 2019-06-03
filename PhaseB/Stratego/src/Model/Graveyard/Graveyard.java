package Model.Graveyard;

import Model.Pieces.*;
import Model.Pieces.ImmovablePieces.*;
import Model.Pieces.MovablePieces.*;

/**
 * This class contains the pieces of a player which have defeated    
 * Will be used when the player want to revive a piece
 */
public class Graveyard {
    private Piece[] Piece = new Piece[12];
    private int[] Quantity = new int[12];

    /**
    * <b>constructor</b>: Constructs a new graveyard of pieces
    * <b>Postcondition:</b> The only colour which can take is R(Red)) or B(Blue)
    * @param colour
    */
    public Graveyard(char colour) {
        Piece[1] = new Dragon(colour);
        
        Piece[2] = new Mage(colour);
        
        Piece[0] = new Slayer(colour);
        
        Piece[11] = new Flag(colour);
        
        Piece[3] = new Knight(colour);

        Piece[5] = new Sorceress(colour);
        
        Piece[7] = new Elf(colour);
        
        Piece[4] = new BeastRider(colour);
        
        Piece[9] = new Scout(colour);
        
        Piece[8] = new Dwarf(colour);
        
        Piece[10] = new Trap(colour);
        
        if(colour == 'R') {
            Piece[6] = new LavaBeast(colour);
        } else {
            Piece[6] = new Yeti(colour);
        }
        
    }
    
    /**
     * <b>Observer:</b> Returns true if this list contains no elements.
     * <b>Postcondition:</b> An Graveyard is empty when it's constructed
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        for(int i = 0; i < 12; i++) {
            if(Quantity[i] != 0) return false;
        }
        return true;
    }
    
    /**
     * <b>Observer:</b> Returns true if there is a defeated piece like as parameter i
     * <b>Postcondition:</b> Every piece has 0 defated crowd of every piece at the start
     * @return true if there is at least a defauted piece
     * @param i
     */
    public boolean isDefeated(int i) {
        if(Quantity[i] == 0) return true;
        return false;
    }
    
    /**
    * <b>Accessor:</b> returns the quantity of piece in position i
    * <b>Postcondition:</b> i >= 0 && i < 12
    * @return the quantity of piece i
    * @param i
    */
    public int getQuantity(int i) {
        return Quantity[i];
    }
    
    /**
     * <b>Accessor:</b> returns the piece in position i
     * <b>Postcondition:</b> There is at least 1 quantity of piece i
     * @return the piece in position i
     * @param i
     */
    public Piece getPiece(int i) {
        return Piece[i];
    }
    
    /**
    * <b>Transformer:</b> Rise the quantity of piece i
    * <b>Postcondition:</b> i >= 0 && i < 12
    * @param piece
    */
    public void setPiece(Piece piece) { 
        for(int i = 0; i < 12; i++) {
            if(piece.getLevel() == 0) {
                if(piece instanceof Trap) {
                    Quantity[10]++;
                } else {
                    Quantity[11]++;
                }
            } else {
                if((piece.getLevel() == Piece[i].getLevel())) {
                    Quantity[i]++;
                    return;
                }
            }
        }
    }
    
}
