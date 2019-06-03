package Model.Pieces.ImmovablePieces;

import Model.Pieces.ImmovablePiece;

public class Flag extends ImmovablePiece {

    public Flag(char colour) { 
        super(colour); 
        super.setName("flag" + colour);
        super.setIcon(this.getName());
        super.setLevel(0);
    }
    
}
