package Model.Collection;

import Model.Pieces.*;
import Model.Pieces.ImmovablePieces.*;
import Model.Pieces.MovablePieces.*;

/**
* Contains all the first pieces of a player
* Depenting on what colour we will give to it, 
* it will construct the respectively pieces
*/
public class Collection {
    private Piece[] Piece = new Piece[12];
    private int[] Quantity = new int[12];
    
    /**
    * <b>constructor</b>: Constructs a new collection of pieces
    * <b>Postcondition:</b> The only colour which can take is R(Red)) or B(Blue)
    * @param colour
    */
    public Collection(char colour) {
        
        Piece[1] = new Dragon(colour);
        Quantity[1] = 1;
        
        Piece[2] = new Mage(colour);
        Quantity[2] = 1;
        
        Piece[0] = new Slayer(colour);
        Quantity[0] = 1;
        
        Piece[11] = new Flag(colour);
        Quantity[11] = 1;
        
        Piece[3] = new Knight(colour);
        Quantity[3] = 2;
        
        Piece[5] = new Sorceress(colour);
        Quantity[5] = 2;
        
        Piece[7] = new Elf(colour);
        Quantity[7] = 2;
        
        Piece[4] = new BeastRider(colour);
        Quantity[4] = 3;
        
        Piece[9] = new Scout(colour);
        Quantity[9] = 4;
        
        Piece[8] = new Dwarf(colour);
        Quantity[8] = 5;
        
        Piece[10] = new Trap(colour);
        Quantity[10] = 6;
        
        if(colour == 'R') {
            Piece[6] = new LavaBeast(colour);
            Quantity[6] = 2;
        } else {
            Piece[6] = new Yeti(colour);
            Quantity[6] = 2;
        }
        
    }
    
    /**
    * <b>Observer:</b> Returns true if there isn't quantity, or false different
    * @return false for empty quantity, true different
    * @param i
    */
    public boolean isEmpty(int i) {
        return Quantity[i] == 0;
    }
    
    /**
    * <b>Observer:</b> Returns false if there is at least a piece, or true different
    * <b>Postcondition:</b> There is at least 1 quantity of piece i
    * @return true for empty collection, false different
    */
    public boolean isEmptyCollection() {
        for(int i = 0; i < 12; i++) {
            if(Quantity[i] != 0) return false;
        }
        return true;
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
    * <b>Postcondition:</b> i >= 0 && i < 12
    * @return the piece in position i
    * @param i
    */
    public Piece getPiece(int i) {
        Quantity[i]--;
        return Piece[i];
    }
    
    /**
    * <b>Transformer:</b> Rise the quantity of piece i
    * <b>Postcondition:</b> i >= 0 && i < 12
    * @param i
    */
    public void setPiece(int i) {
        Quantity[i]++;
    }
    
}
