package Model.Pieces.ImmovablePieces;

import Model.Pieces.ImmovablePiece;

public class Trap extends ImmovablePiece {
    
    public Trap(char colour) {  
        super(colour); 
        super.setName("trap" + colour);
        super.setIcon(this.getName());
        super.setLevel(0);
    }
}