package Model.Pieces.MovablePieces;

import Model.Pieces.ImmovablePieces.Forbidden;
import Model.Pieces.ImmovablePieces.Trap;
import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;

public class Elf extends MovablePiece { 

    public Elf(char colour) {
        super(colour);
        super.setName("elf" + colour);
        super.setIcon(super.getName());
        super.setLevel(4);
    }
    
    @Override
    public int attack(Piece opponent) {
        
        if(getLevel() > opponent.getLevel()) {
            return 1;
        } else {
            return 4;
        }
        
    }
    
    @Override
    public int[][] getMoves(Piece[][] Table, int x, int y) {
        int[][] Moves = new int[10][12];
        int fromX = x - 2, toX = x + 3, fromY = y - 2, toY = y + 3; 
        
        if( x < 3) {
            fromX = 1;
            toX = x + 3;
        }
        
        if( x > 6) {
            fromX = x - 2;
            toX = 9;
        }
        
        if( y < 3) {
            fromY = 1;
            toY = y + 3;
        }
        
        if( y > 8) {
            fromY = y - 2;
            toY = 9;
        }
        
        for(int i = fromX; i < toX; i++) {
            for(int j = fromY; j < toY; j++) {
                 if((Table[i][j] == null || (!(Table[i][j] instanceof Forbidden) && Table[i][j].getColour() != getColour()))) {
                     Moves[i][j] = 1;
                 }
            }
        }
        return Moves;
    }
    
    @Override
    public boolean isMoving(Piece[][] Table, int x, int y) {
        int[][] Moves = getMoves(Table, x, y);
        for(int i = 1; i < 9; i++) {
           for(int j = 1; j < 11; j++) {
               if(Moves[i][j] == 1) return true;
           }
        }
        return false;
        
    }
        
}