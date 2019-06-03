package Model.Pieces.MovablePieces;

import Model.Pieces.MovablePiece;
import Model.Pieces.Piece;

public class Dwarf extends MovablePiece { 

    public Dwarf(char colour) { /* ... code ... */ }
    
    @Override
    public void move(int x, int y) { /* ... code ... */ }
        
    @Override
    public void attack(Piece opponent) { /* ... code ... */ }
    
    @Override
    public int[][] getMoves(Piece[] Table) { /* ... code ... */ return null; } 

    @Override
    public int isWinner(Piece opponent) { /* ... code ... */ }
    
}