package Model.Pieces.MovablePieces;

import Model.Pieces.ImmovablePieces.Forbidden;
import Model.Pieces.ImmovablePieces.Trap;
import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;

public class Yeti extends MovablePiece { 

    public Yeti(char colour) {
        super(colour);
        super.setName("yeti");
        super.setIcon(super.getName());
        super.setLevel(5);
        
    }
    
    @Override
    public int attack(Piece opponent) {
        
        if(opponent instanceof Trap) {
            return 3;
        }
        if(super.getLevel() > opponent.getLevel()) {
            return 1;
        } else if(super.getLevel() < opponent.getLevel()) {
            return 3;
        } else {
            return 2;
        }
    }
    
    @Override
    public int[][] getMoves(Piece[][] Table, int x, int y) {
        int[][] Moves = new int[10][12];
        if((Table[x][y - 1] == null || (!(Table[x][y - 1] instanceof Forbidden) && Table[x][y - 1].getColour() != getColour()))) {
            Moves[x][y - 1] = 1;
        }
        if((Table[x - 1][y] == null || (!(Table[x - 1][y] instanceof Forbidden) && Table[x - 1][y].getColour() != getColour()))) {
            Moves[x - 1][y] = 1;
        }
        if( (Table[x][y + 1] == null || (!(Table[x][y + 1] instanceof Forbidden) && Table[x][y + 1].getColour() != getColour()))) {
            Moves[x][y + 1] = 1;
        }
        if((Table[x + 1][y] == null || (!(Table[x + 1][y] instanceof Forbidden) && Table[x + 1][y].getColour() != getColour()))) {
            Moves[x + 1][y] = 1;
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