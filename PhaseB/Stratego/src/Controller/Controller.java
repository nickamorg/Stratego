package Controller;

import Model.Board.Board;
import Model.Pieces.*;
import Model.Pieces.ImmovablePieces.*;
import Model.Pieces.MovablePieces.*;
import Model.Player.Player;

/**
 * Controller is the master of the game and controls all 
 * of the operations executed
 */
public class Controller {
    private int round = 0;
    private int turn = 1;
    private Player player1, player2;
    private Board board;
    
    /**
    * <b>constructor</b>:Constructs a new Controller,with new 2 players,
    * new instances of TotalPieces Class and Graveyard class
    * @param name1
    * @param name2
    */
    public Controller(String name1, String name2) {
        player1 = new Player('B', name1);
        player2 = new Player('R', name2);
        board = new Board();
    }
    
    
    /**
    * <b>transformer(mutative)</b>: sets the turn
    * <b>Postcondition:</b> Turn: 1 -> 2 or 2 -> 1
    */
    public void setTurn() {
        if(turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }
    
    
    /**
    * <b>accessor(selector)</b>:Returns a player
    * <b>Postcondition:</b> i == 1 || i == 2
    * @param i
    * @return the player i
    */
    public Player getPlayer(int i) { 
        if(i == 1) {
            return player1;
        } else {
            return player2;
        }
    }
    
    /**
    * <b>transformer(mutative)</b>: the game is rised 1 up turn
    * <p><b>Postcondition:</b> Must both of players to play
    */ 
    public void riseRound() { round++; }
    
    /**
    * <b>accessor(selector)</b>: Returns the number of the rounds which had been played
    * @return the number of rounds
    */
    public int getRound() {
        return round;
    }

    /**
    * <b>accessor(selector)</b>: Returns table of the game
    * @return the table of the game
    */
    public Board getBoard() {
        return board;
    }
    
    /**
    * <b>accessor(selector)</b>: Returns who player is playing now
    * <p><b>Postcondition:</b> True: First player turn, False: Second player turn
    * @return the turn of this round
    */
    public int getTurn() {
        return turn;
    }
    
    
    /**
    * <b>transformer(mutative)</b>: make a clone piece
    * <b>Postcondition:</b> piece' type is one of the 13 of the game
     * @param p
     * @return a new piece
    */
    public Piece makePiece(Piece p) {
        Piece newP = null;
        
        if(p instanceof Dragon) {
            newP = new Dragon(p.getColour());
            
        } else if(p instanceof BeastRider) {
            newP = new BeastRider(p.getColour());
            
        } else if(p instanceof Dwarf) {
            newP = new Dwarf(p.getColour());
            
        } else if(p instanceof Elf) {
            newP = new Elf(p.getColour());
            
        } else if(p instanceof Knight) {
            newP = new Knight(p.getColour());
            
        } else if(p instanceof LavaBeast) {
            newP = new LavaBeast(p.getColour());
            
        } else if(p instanceof Mage) {
            newP = new Mage(p.getColour());
            
        } else if(p instanceof Scout) {
            newP = new Scout(p.getColour());
            
        } else if(p instanceof Slayer) {
            newP = new Slayer(p.getColour());
            
        } else if(p instanceof Sorceress) {
            newP = new Sorceress(p.getColour());
            
        } else if(p instanceof Yeti) {
            newP = new Yeti(p.getColour());
            
        } else if(p instanceof Trap) {
            newP = new Trap(p.getColour());
            
        } else if(p instanceof Flag) {
            newP = new Flag(p.getColour());
        }
        
        newP.setName(p.getName());
        newP.setLevel(p.getLevel());
        newP.setIcon(p.getName());
        return newP;
    }
}
