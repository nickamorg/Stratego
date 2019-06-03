package Controller;

import Model.Board.Board;
import Model.Pieces.*;
import Model.Player.Player;

/**
 * Controller is the master of the game and controls all 
 * of the operations executed
 */
public class Controller {
    int round;
    boolean turn;
    Player player1, player2;
    Board board;
    
    /**
    * <b>constructor</b>:Constructs a new Controller,with new 2 players,
    * new instances of TotalPieces Class and Graveyard class
    * @param name1
    * @param name2
    */
    public Controller(String name1, String name2) { /* ... code ... */ }
       
    /**
    * <b>transformer(mutative)</b>: Recover a defeated piece
    * <p><b>Postcondition:</b> Must be: x, y > 0 && x < 12 && y < 10
    * @param piece
    * @param x
    * @param y 
    */ 
    public void recover(Piece piece, int x, int y) { /* ... code ... */ }
     
    /**
    * <b>accessor</b>:Returns the score of the game <br />
    * @return how is the difference between the lost pieces of the players
    */
    public int getScore() { /* ... code ... */ }
    
    /**
    * <b>transformer(mutative)</b>: make changes after a turn started
    * <p><b>Postcondition:</b> Must be: prevX, prevY, nextX, nextY > 0 && prevX, nextX < 12 && prevY, nextY < 10
    * @param prevX
    * @param prevY
    * @param nextX
    * @param nextY
    */ 
    public void makeChanges(int prevX, int prevY, int nextX, int nextY) { /* ... code ... */ }
    
   /**
   * <b>Observer</b>:Return true if a game(one player lose it's flag or is'n able to do an move) has finished, false otherwise
   * @return true if a game(one player lose it's flag or is'n able to do an move) has finished, false otherwise
   */
    public boolean endOfGame() { /* ... code ... */  }
    
    /**
    * <b>transformer(mutative)</b>: Sets a new game
    */ 
    public void newGame() { /* ... code ... */ }
    
    /**
    * <b>accessor(selector)</b>:Returns a player
    * <b>Postcondition:</b> i == 1 || i == 2
    * @param i
    * @return the player i
    */
    public Player getPlayer(int i) { /* ... code ... */ }
    
    /**
    * <b>transformer(mutative)</b>: give the turn to the next player
    */ 
    public void changeTurn() { /* ... code ... */ }
    
    /**
    * <b>transformer(mutative)</b>: the game is rised 1 up turn
    * <p><b>Postcondition:</b> Must both of players to play
    */ 
    public void riseRound() { /* ... code ... */ }
    
    /**
    * <b>accessor(selector)</b>: Returns the number of the rounds which had been played
    * @return the number of rounds
    */
    public int getRound() { /* ... code ... */ }

    /**
    * <b>accessor(selector)</b>: Returns table of the game
    * @return the table of the game
    */
    public Board getBoard() { /* ... code ... */ }
    
    /**
    * <b>accessor(selector)</b>: Returns who player is playing now
    * <p><b>Postcondition:</b> True: First player turn, False: Second player turn
    * @return the turn of this round
    */
    public boolean getTurn() { /* ... code ... */ }
    
}




