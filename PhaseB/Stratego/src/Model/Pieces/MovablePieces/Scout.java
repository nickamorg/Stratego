package Model.Pieces.MovablePieces;

import Model.Pieces.ImmovablePieces.Forbidden;
import Model.Pieces.ImmovablePieces.Trap;
import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;

public class Scout extends MovablePiece { 

    public Scout(char colour) {
        super(colour);
        super.setName("scout" + colour);
        super.setIcon(super.getName());
        super.setLevel(2);
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
    public boolean isMoving(Piece[][] Table, int x, int y) {
        int[][] Moves = getMoves(Table, x, y);
        for(int i = 1; i < 9; i++) {
           for(int j = 1; j < 11; j++) {
               if(Moves[i][j] == 1) return true;
           }
        }
        return false;
        
    }
    
    @Override
    public int[][] getMoves(Piece[][] Table, int x, int y) {
        int[][] Moves = new int[10][12];
        int i = 1;
        
        while((y - i) > 0 && Table[x][y - i] == null ) {
            Moves[x][y - i] = 1;
            i++;
        }
        if((y - i) > 0 && !(Table[x][y - i] instanceof Forbidden) && Table[x][y - i].getColour() != getColour()) {
            Moves[x][y - i] = 1;
        }
            
        i = 1;
        while((x - i) > 0 && Table[x - i][y] == null ) {
            Moves[x - i][y] = 1;
            i++;
        }
        if((x - i) > 0 && !(Table[x - i][y] instanceof Forbidden) && Table[x - i][y].getColour() != getColour()) {
            Moves[x - i][y] = 1;
        }
        
        i = 1;
        while((y + i) < 11 && Table[x][y + i] == null ) {
            Moves[x][y + i] = 1;
            i++;
        }
        if((y + i) < 11 && !(Table[x][y + i] instanceof Forbidden) && Table[x][y + i].getColour() != getColour()) {
            Moves[x][y + i] = 1;
        }
        
        i = 1;
        while((x + i) < 9 && Table[x + i][y] == null ) {
            Moves[x + i][y] = 1;
            i++;
        }
        if((x + i) < 9 && !(Table[x + i][y] instanceof Forbidden) && Table[x + i][y].getColour() != getColour()) {
            Moves[x + i][y] = 1;
        }
        return Moves;
    } 

}