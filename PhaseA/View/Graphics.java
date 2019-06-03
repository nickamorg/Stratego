package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* Graphics is a way to show the model of a game with graphical way.
* Let know the controller what about to do.
*/
public class Graphics extends JFrame{
    private MJButton[][] Cell;
    private JPanel NJPanel;
    private JButton setGame, randomGame, mixGame, ready;
    private SGBHandler setGameHand;
    private RGBHandler randGameHand;
    private MGBHandler mixGameHand;
    private ButtonHandler handler;
    private Controller stratego;
    
    public class MJButton extends JButton{
        private int x;
        private int y;

        public MJButton(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public MJButton(int x, int y, Icon icon) {
            super(icon);
            this.x = x;
            this.y = y;
        }

        public MJButton(int x, int y, String string) {
            super(string);
            this.x = x;
            this.y = y;
        }

        public MJButton(int x, int y, Action action) {
            super(action);
            this.x = x;
            this.y = y;
        }

        public MJButton(int x, int y, String string, Icon icon) {
            super(string, icon);
            this.x = x;
            this.y = y;
        }

        @Override
        public int getX() {
            return x;
        }
        
        @Override
        public int getY() {
            return y;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public void setY(int y) {
            this.y = y;
        }
    }
    
    /**
    * <b>constructor</b>: Constructs the first graphics of the game
    * */
    public Graphics() { /* ... code ... */ }
    
    /**
    * It's an action listener which is used when we want to set a game on our own.
    */
    private class SGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            /* ... code ... */ 
        }
    }
    
    /**
    * It's an action listener which is used when we want to set random game.
    */
    private class RGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            /* ... code ... */ 
        }
    }
    
    /**
    * It's an action listener which is used when we want to set a mix game
    */
    private class MGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            /* ... code ... */ 
        }
    }
    
    /**
    * It's an action listener which is used when a button is pressed and is ready to make a moving.
    */
    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            /* ... code ... */ 
        }
    }
    
}