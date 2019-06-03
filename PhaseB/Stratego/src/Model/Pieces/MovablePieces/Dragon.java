package Model.Pieces.MovablePieces;

import Model.Pieces.ImmovablePieces.Forbidden;
import Model.Pieces.ImmovablePieces.Trap;
import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;

public class Dragon extends MovablePiece { 

    public Dragon(char colour) {
        super(colour);
        super.setName("dragon" + colour);
        super.setIcon(super.getName());
        super.setLevel(10);
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
    
    /**
    * Observer: Check for more attack's moves
    * @param Table
    * @param Moves
    * @param i
    * @param j
    */
    public void check4Attack(Piece[][] Table, int[][] Moves, int i, int j) {
        if( j > 1 && (!(Table[i][j - 1] instanceof Forbidden) && Table[i][j - 1] != null && Table[i][j - 1].getColour() != getColour())) {
            Moves[i][j - 1] = 1;
        }
        if( i > 1 && (!(Table[i - 1][j] instanceof Forbidden) && Table[i - 1][j] != null && Table[i - 1][j].getColour() != getColour())) {
            Moves[i - 1][j] = 1;
        }
        if( j < 10 && (!(Table[i][j + 1] instanceof Forbidden) && Table[i][j + 1] != null && Table[i][j + 1].getColour() != getColour())) {
            Moves[i][j + 1] = 1;
        }
        if( i < 8 && (!(Table[i + 1][j] instanceof Forbidden) && Table[i + 1][j] != null && Table[i + 1][j].getColour() != getColour())) {
            Moves[i + 1][j] = 1;
        }
    }
    
    @Override
    public int[][] getMoves(Piece[][] Table, int x, int y) {
        int[][] Moves = new int[10][12];
        int i = x, j = y;
        
        while(i > 1) {
            if(Table[i - 1][j] == null || (!(Table[i - 1][j] instanceof Forbidden) && Table[i - 1][j].getColour() != getColour()) ) {
                Moves[i - 1][j] = 1;
                if(Table[i - 1][j] == null) {
                    check4Attack(Table, Moves, i - 1, j);
                }
                break;
            } 
            if(Table[i - 1][j] != null && !(Table[i - 1][j] instanceof Forbidden) && Table[i][j] == null && Table[i - 1][j].getColour() != getColour()) {
                Moves[i - 1][j] = 1;
            }
            i--;
        }
        
        i = x;
        while(i < 8) {
            if(Table[i + 1][j] == null || (!(Table[i + 1][j] instanceof Forbidden) && Table[i + 1][j].getColour() != getColour())) {
                Moves[i + 1][j] = 1;
                if(Table[i + 1][j] == null) {
                    check4Attack(Table, Moves, i + 1, j);
                }
                break;
            } 
            if(Table[i + 1][j] != null && !(Table[i + 1][j] instanceof Forbidden) && Table[i][j] == null && Table[i + 1][j].getColour() != getColour()) {
                Moves[i + 1][j] = 1;
            }
            i++;
        }
        
        i = x;
        while(j > 1) {
            if(Table[i][j - 1] == null || (!(Table[i][j - 1] instanceof Forbidden) && Table[i][j - 1].getColour() != getColour())) {
                Moves[i][j - 1] = 1;
                if(Table[i][j - 1] == null) {
                    check4Attack(Table, Moves, i, j - 1);
                }
                break;
            } 
            if(Table[i][j - 1] != null && !(Table[i][j] instanceof Forbidden) && Table[i][j] == null && Table[i][j - 1].getColour() != getColour()) {
                Moves[i][j - 1] = 1;
            }
            j--;
        }
        j = y;
        while(j < 10) {
            if(Table[i][j + 1] == null || (!(Table[i][j + 1] instanceof Forbidden) && Table[i][j + 1].getColour() != getColour())) {
                Moves[i][j + 1] = 1;
                if(Table[i][j + 1] == null) {
                    check4Attack(Table, Moves, i, j + 1);
                }
                break;
            } 
            if(Table[i][j + 1] != null && !(Table[i][j] instanceof Forbidden) && Table[i][j] == null && Table[i][j + 1].getColour() != getColour()) {
                Moves[i][j + 1] = 1;
            }
            j++;
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