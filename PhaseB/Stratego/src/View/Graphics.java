package View;

import Controller.Controller;
import Model.Collection.Collection;
import Model.Pieces.ImmovablePieces.*;
import Model.Pieces.MovablePieces.*;
import Model.Pieces.*;
import Model.Pieces.Piece;
import Model.Music.Music;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Graphics is a way to show the model of a game with graphical way.
* Let know the controller what about to do.
*/
public class Graphics extends JFrame{
    private JButton[][] Cell;
    private JPanel NJPanel;
    private JButton setGame, randomGame, mixGame;
    private SGBHandler setGameHand = new SGBHandler();
    private RGBHandler randGameHand = new RGBHandler();
    private MGBHandler mixGameHand = new MGBHandler();
    private ButtonHandler handler = new ButtonHandler();
    private Controller controller;
    private Random in = new Random();
    private int number = 0;
    private Piece piece;
    private Piece revP;
    private int moves = 0;
    private MixSorting mixSorting = new MixSorting();
    private SetSorting setSorting = new SetSorting();
    private JLabel jlabel;
    private Music mc = new Music();
    private JButton[] BGrave, RGrave;
    private int posX, posY;
    private ReviveHandler reviveHandler = new ReviveHandler();
    private Choice4ReviveHandler CFRHandler = new Choice4ReviveHandler();
    private int prevTurn = 2;
    
    /**
    * <b>constructor</b>: Constructs the first graphics of the game
    * */
    public Graphics() { 
        super("STRATEGO");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\myLogo.png"));
        newGame();
        
        JMenu optionMenu = new JMenu("Options");
        
        JMenuItem restartItem = new JMenuItem("Restart");
        optionMenu.add(restartItem);
        restartItem.addActionListener((ActionEvent event) -> {
            NJPanel.removeAll();
            if(Cell != null) {
               for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        NJPanel.remove(Cell[i][j]);
                    }
                }
           }
           remove(NJPanel);
           newGame();
           repaint();
           revalidate();
        });
        
        JMenuItem exitItem = new JMenuItem("Exit");
        optionMenu.add(exitItem);
        exitItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        JMenuBar gameBar = new JMenuBar();
        setJMenuBar(gameBar);
        gameBar.add(optionMenu);
    }
    
    /**
    * <b>transformer(mutative)</b>: Prepare a new game. Return the window to home page
    */
    public void newGame() {
        NJPanel = new JPanel(new BorderLayout());
        setGame = new JButton(new ImageIcon("images\\set.png"));
        setGame.addActionListener(setGameHand);
        setGame.setBackground(Color.white);
        randomGame = new JButton(new ImageIcon("images\\random.png"));
        randomGame.setBackground(Color.white);
        randomGame.addActionListener(randGameHand);
        mixGame = new JButton(new ImageIcon("images\\mix.png"));
        mixGame.setBackground(Color.white);
        mixGame.addActionListener(mixGameHand);
        jlabel = new JLabel(String.format("%120s", "Choose a form of game"));
        NJPanel.add(jlabel, BorderLayout.NORTH);
        NJPanel.add(setGame, BorderLayout.EAST);
        NJPanel.add(randomGame, BorderLayout.CENTER);
        NJPanel.add(mixGame, BorderLayout.WEST);        
        add(NJPanel);
    }
    
    /**
    * It's an action listener which is used when we want to set a game in our own.
    */
    private class SGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            Cell = new JButton[10][12];
            controller = new Controller("Nick", "HY252");
            NJPanel.removeAll();
            NJPanel.setLayout(new GridLayout(10, 12));
            Cell = new JButton[10][12];
            
            for(int i = 4; i < 6; i++) {
                for(int j = 1; j < 11; j++) {
                    Cell[i][j] = new JButton();
                    if(j == 3 || j == 4 || j == 7 || j == 8) {
                        Cell[i][j].setBackground(Color.yellow);
                        controller.getBoard().setPiece(new Forbidden(), i, j);
                    } else {
                        Cell[i][j].setBackground(Color.white);
                        controller.getBoard().setPiece(null, i, j);
                    }
                    Cell[i][j].setEnabled(false);
                }
            }
            
            int position = 1;
            for(int k = 0; k < 2; k++) {
                for(int i = position ; i < position + 3; i++) {
                    for(int j = 1; j < 11; j++) {
                        Cell[i][j] = new JButton();
                        Cell[i][j].addActionListener(setSorting);
                        Cell[i][j].setEnabled(false);
                    }
                }
                position = 6;
            }

            for(int i = 1 ; i < 10; i++) {
                Cell[i][11] = new JButton();
                Cell[i][11].setBackground(Color.black);
                Cell[i][11].setVisible(false);
                Cell[i][0] = new JButton();
                Cell[i][0].setBackground(Color.black);
                Cell[i][0].setVisible(false);
            }
            
            for(int j = 0; j < 12; j++) {
                Cell[0][j] = new JButton(controller.getPlayer(1).getMyCollection().getPiece(j).getIcon());
                controller.getPlayer(1).getMyCollection().setPiece(j);
                Cell[0][j].addActionListener(setSorting);
                
                Cell[9][j] = new JButton(controller.getPlayer(2).getMyCollection().getPiece(j).getIcon());
                controller.getPlayer(2).getMyCollection().setPiece(j);
                Cell[9][j].addActionListener(setSorting);
            }
            
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 12; j++) {
                    NJPanel.add(Cell[i][j]);
                }
            }
            add(NJPanel);
            repaint();
            revalidate();
        }
    }
    
    /**
    * <b>transformer(mutative)</b>: Make the hidden pieces of the game
    * <b>Postcondition:</b> There are 40 hidden pieces
    */
    public void setHiddenPiece() {
        for(int j = 0; j < 12; j++) {
            controller.getBoard().setPiece(new Forbidden(), 0, j);
            Cell[0][j] = new JButton();
        }
        for(int j = 0; j < 12; j++) {
            controller.getBoard().setPiece(new Forbidden(), 9, j);
            Cell[9][j] = new JButton();
        }
        for(int j = 0; j < 10; j++) {
            controller.getBoard().setPiece(new Forbidden(), j, 0);
            Cell[j][0] = new JButton();
        }
        for(int j = 0; j < 10; j++) {
            controller.getBoard().setPiece(new Forbidden(), j, 11);
            Cell[j][11] = new JButton();
        }
    }
    
    /**
    * <b>transformer(mutative)</b>: Prepare the game. Place the table and the graveyards into the panel
    * <p><b>Postcondition:</b> There is a window with 104 buttons
    */ 
    public void prepareTheTable() {
        setHiddenPiece();
            BGrave = new JButton[12];
            RGrave = new JButton[12];
            for(int i = 0; i < 12; i++) {
                RGrave[i] = new JButton(controller.getPlayer(2).getMyCollection().getPiece(i).getIcon());
                controller.getPlayer(2).getMyCollection().setPiece(i);
                RGrave[i].setToolTipText("0/" + (new Collection('R')).getQuantity(i));
                
                BGrave[i] = new JButton(controller.getPlayer(1).getMyCollection().getPiece(i).getIcon());
                controller.getPlayer(1).getMyCollection().setPiece(i);
                BGrave[i].setToolTipText("0/" + (new Collection('B')).getQuantity(i));
            }
            NJPanel.removeAll();
            NJPanel.setLayout(new GridLayout(10, 12));
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < 11; j++) {
                    if(controller.getBoard().getPiece(i, j) instanceof MovablePiece) {
                        MovablePiece tmp = (MovablePiece) controller.getBoard().getPiece(i, j);
                        if(tmp.isMoving(controller.getBoard().getTable(), i, j) == false) { 
                            Cell[i][j].setEnabled(false);
                        } else {
                            Cell[i][j].setEnabled(true);
                        }
                    }
                }
            }       
            for(int j = 0; j < 12; j++) {
                NJPanel.add(BGrave[j]);
            }
            JButton tmp;
            for(int i = 1; i < 9; i++) {
                tmp = new JButton();
                tmp.setVisible(false);
                NJPanel.add(tmp);
                for(int j = 1; j < 11; j++) {
                    if(i < 4) {
                        Cell[i][j].setIcon(new ImageIcon("pieces\\blueHidden.png"));
                        Cell[i][j].setEnabled(false);
                    }
                    if(!(controller.getBoard().getPiece(i, j) instanceof Trap) && !(controller.getBoard().getPiece(i, j) instanceof Flag)) {
                        Cell[i][j].removeActionListener(mixSorting);
                        Cell[i][j].removeActionListener(setSorting);
                        Cell[i][j].addActionListener(handler);
                    } else {
                        Cell[i][j].setEnabled(false);
                    }
                    NJPanel.add(Cell[i][j]);
                }
                tmp = new JButton();
                tmp.setVisible(false);
                NJPanel.add(tmp);
            }
            for(int j = 0; j < 12; j++) {
                NJPanel.add(RGrave[j]);
            }
            add(NJPanel);
    }
    
    /**
    * It's an action listener which is used when we want to set random game.
    */
    private class RGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            mc.playMusic("sounds\\sd.wav");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
            Cell = new JButton[10][12];
            controller = new Controller("Nick", "HY252");
            int s = 1;
            for(int p = 1; p < 3; p++) {
                if(p == 2) {
                    for(int i = 4; i < 6; i++) {
                        for(int j = 1; j < 11; j++) {
                            Cell[i][j] = new JButton();
                            if(j == 3 || j == 4 || j == 7 || j == 8) {
                                Cell[i][j].setBackground(Color.yellow);
                                controller.getBoard().setPiece(new Forbidden(), i, j);
                            } else {
                                Cell[i][j].setBackground(Color.white);
                                controller.getBoard().setPiece(null, i, j);
                            }
                            Cell[i][j].setEnabled(false);
                        }
                    }
                }
                for(int i = s; i < s + 3; i++) {
                    for(int j = 1; j < 11; j++) {
                        do {
                            number = in.nextInt(12);
                        } while(controller.getPlayer(p).getMyCollection().isEmpty(number) == true);
                        piece = controller.getPlayer(p).getMyCollection().getPiece(number);
                        piece = controller.makePiece(piece);
                        Cell[i][j] = new JButton();
                        Cell[i][j].setIcon(piece.getIcon());
                        controller.getBoard().setPiece(piece, i, j);
                    }
                }
                s = 6;
            }
            setHiddenPiece();
            prepareTheTable();
            add(NJPanel);
            repaint();
            revalidate();
            
        }
    }
    
    /**
    * <b>transformer(mutative)</b>: Take the result of the attack and change the table of the game 
    * <b>precondition:</b> x,xx > 0 && x,xx < 8 && y,yy > 0 && y,yy < 10
    * @param x
    * @param y
    * @param xx
    * @param yy
    */
    public void attack(int x, int y, int xx, int yy) {
        int result = ((MovablePiece)(controller.getBoard().getPiece(x, y))).attack(controller.getBoard().getPiece(xx,yy));
        int player;
        
        if(result < 4) {
            mc.playMusic("sounds\\Bomb.wav");
        }
        
        if(result == 1) {
            controller.getPlayer(controller.getTurn()).getMyGraveyard().setPiece(controller.getBoard().getPiece(xx, yy));
            controller.getBoard().setPiece(controller.getBoard().getPiece(x, y), xx, yy);
            controller.getBoard().deletePiece(x, y);
            Cell[xx][yy].setIcon(new ImageIcon("pieces\\" + this.getName()));
        } else if(result == 2) {
            controller.getPlayer(controller.getTurn()).getMyGraveyard().setPiece(controller.getBoard().getPiece(xx, yy));
            controller.getPlayer(prevTurn).getMyGraveyard().setPiece(controller.getBoard().getPiece(x, y));
            controller.getBoard().deletePiece(xx,yy);
            controller.getBoard().deletePiece(x, y);
            Cell[xx][yy].setIcon(null);
            Cell[xx][yy].setBackground(Color.white);
        } else if(result == 3){
            controller.getPlayer(prevTurn).getMyGraveyard().setPiece(controller.getBoard().getPiece(x, y));
            controller.getBoard().deletePiece(x, y);
        } else if(result == 5) {
            mc.playMusic("sounds\\Sorceress.wav");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
            }
            piece = controller.getBoard().getTable()[xx][yy];
            if(piece.getLevel()< controller.getBoard().getPiece(x, y).getLevel() && piece.getLevel() != 0 ) {
                if(piece.getColour() == 'R') {
                    piece.setColour('B');
                    piece.setName(piece.getName().replace("R", "B"));
                } else {
                    piece.setColour('R');
                    piece.setName(piece.getName().replace("B", "R"));
                }
                piece.setIcon(piece.getName());
            }
        } else {
            /* NOTHING IS CHARGED */
        }
        Cell[x][y].setIcon(null);
        Cell[x][y].setBackground(Color.white);
        for(int i = 0; i < 12; i++) {
            RGrave[i].setToolTipText(controller.getPlayer(2).getMyGraveyard().getQuantity(i) + "/" + (new Collection('R')).getQuantity(i));
            BGrave[i].setToolTipText(controller.getPlayer(1).getMyGraveyard().getQuantity(i) + "/" + (new Collection('B')).getQuantity(i));
        }
    }
    
    /**
    * <b>transformer(mutative)</b>: Change the icon of the pieces, the statement and the background.
    * <p><b>Postcondition:</b> Prepare the window so that the next player play.
    */ 
    public void makeChanges() {  
        for(int i = 1; i < 9; i++) {
            for(int j = 1; j < 11; j++) {
                if(!(controller.getBoard().getPiece(i, j) instanceof Forbidden)) {
                    Cell[i][j].setBackground(Color.white);
                    if(controller.getBoard().getPiece(i,j) != null) {
                        if(controller.getPlayer(controller.getTurn()).getColour() != controller.getBoard().getPiece(i,j).getColour()) {
                            if(controller.getTurn() == 1) {
                                Cell[i][j].setIcon(new ImageIcon("pieces\\redHidden.png"));
                                Cell[i][j].setEnabled(false);
                            } else {
                                Cell[i][j].setIcon(new ImageIcon("pieces\\blueHidden.png"));
                                Cell[i][j].setEnabled(false);
                            }
                        } else {
                            Cell[i][j].setIcon((controller.getBoard().getPiece(i, j).getIcon()));
                            Cell[i][j].setEnabled(true);
                        }
                        if(controller.getBoard().getPiece(i,j) instanceof Trap || controller.getBoard().getPiece(i,j) instanceof Flag) {
                            Cell[i][j].removeActionListener(handler);
                            Cell[i][j].setEnabled(false);
                        }
                    } else {
                        Cell[i][j].setBackground(Color.white);
                        Cell[i][j].setEnabled(false);
                    }
                }
            }
        }
        controller.setTurn();   
    }

    private class SetSorting implements ActionListener {
        int moves = 0, numOfPiece;
        JButton my;
        int position = 1;
        
        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(moves == 0) {
                moves++;
                my = (JButton)event.getSource();
                for(int j = 0; j < 12; j++) {
                    if(Cell[9][j] == my) {
                        position = 6;
                        numOfPiece = j;
                    }
                    
                    if(Cell[0][j] == my) {
                        position = 1;
                        numOfPiece = j;
                    }
                    Cell[9][j].setEnabled(false);
                    Cell[0][j].setEnabled(false);
                }
                
                for(int i = position; i < position + 3; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(controller.getBoard().getPiece(i, j) == null) {
                           Cell[i][j].setEnabled(true);
                        }
                    }
                }
            } else {
                my = (JButton)event.getSource();
                for(int i = position; i < position + 3; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(Cell[i][j] == my) {
                            if(position == 6) {
                                Piece piece = controller.getPlayer(2).getMyCollection().getPiece(numOfPiece);
                                piece = controller.makePiece(piece);
                                controller.getBoard().setPiece(piece, i, j);
                                Cell[i][j].setIcon(Cell[9][numOfPiece].getIcon());
                            } else {
                                Piece piece = controller.getPlayer(1).getMyCollection().getPiece(numOfPiece);
                                piece = controller.makePiece(piece);
                                controller.getBoard().setPiece(piece, i, j);
                                Cell[i][j].setIcon(Cell[0][numOfPiece].getIcon());
                            }
                        }
                    } 
                }
                for(int i = position ; i < position + 3; i++) {
                    for(int j = 1; j < 11; j++) {
                        Cell[i][j].setEnabled(false);
                    }
                }
                
                for(int j = 0; j < 12; j++) {
                    if(controller.getPlayer(2).getMyCollection().isEmpty(j) == false) {
                        Cell[9][j].setEnabled(true);
                    } else {
                        Cell[9][j].setEnabled(false);
                    }
                    if(controller.getPlayer(1).getMyCollection().isEmpty(j) == false) {
                        Cell[0][j].setEnabled(true);
                    } else {
                        Cell[0][j].setEnabled(false);
                    }
                }
                moves = 0;
                if(controller.getPlayer(2).getMyCollection().isEmptyCollection() == true
                && controller.getPlayer(1).getMyCollection().isEmptyCollection() == true) {
                    setHiddenPiece();
                    prepareTheTable();
                }
            }
        }
    }
    
    private class MixSorting implements ActionListener {
        int moves = 0, numOfPiece;
        JButton my;
        
        @Override
        public void actionPerformed(ActionEvent event) {
            if(moves == 0) {
                moves++;
                my = (JButton)event.getSource();
                for(int j = 0; j < 12; j++) {
                    if(Cell[9][j] == my) {
                        numOfPiece = j;
                    }
                    Cell[9][j].setEnabled(false);
                }
                for(int i = 6; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(controller.getBoard().getPiece(i, j) == null) {
                           Cell[i][j].setEnabled(true);
                        }
                    }
                }
            } else {
                my = (JButton)event.getSource();
                for(int i = 6; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(Cell[i][j] == my) {
                           controller.getBoard().setPiece(controller.getPlayer(2).getMyCollection().getPiece(numOfPiece), i, j);
                           Cell[i][j].setIcon(Cell[9][numOfPiece].getIcon());
                        }
                    } 
                }
                for(int i = 6 ; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        Cell[i][j].setEnabled(false);
                    }
                }
                
                for(int j = 0; j < 12; j++) {
                    if(controller.getPlayer(2).getMyCollection().isEmpty(j) == false) {
                        Cell[9][j].setEnabled(true);
                    } else {
                        Cell[9][j].setEnabled(false);
                    }
                }
                moves = 0;
                if(controller.getPlayer(2).getMyCollection().isEmptyCollection() == true) {
                    setHiddenPiece();
                    prepareTheTable();
                }
            }
        }
    }
    
    /**
    * It's an action listener which is used when we want to set a mix game
    */
    private class MGBHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            Cell = new JButton[10][12];
            controller = new Controller("Nick", "HY252");
            NJPanel.removeAll();
            NJPanel.setLayout(new GridLayout(9, 12));
            Cell = new JButton[10][12];
            
            for(int i = 1; i < 4; i++) {
                for(int j = 1; j < 11; j++) {
                    do {
                        number = in.nextInt(12);
                    } while(controller.getPlayer(1).getMyCollection().isEmpty(number) == true);
                    piece = controller.getPlayer(1).getMyCollection().getPiece(number);
                    piece = controller.makePiece(piece);
                    Cell[i][j] = new JButton();
                    Cell[i][j].setIcon(new ImageIcon("pieces\\blueHidden.png"));
                    controller.getBoard().setPiece(piece, i, j);
                    Cell[i][j].setEnabled(false);
                }
            }
     
            for(int i = 4; i < 6; i++) {
                for(int j = 1; j < 11; j++) {
                    Cell[i][j] = new JButton();
                    if(j == 3 || j == 4 || j == 7 || j == 8) {
                        Cell[i][j].setBackground(Color.yellow);
                        controller.getBoard().setPiece(new Forbidden(), i, j);
                    } else {
                        Cell[i][j].setBackground(Color.white);
                        controller.getBoard().setPiece(null, i, j);
                    }
                    Cell[i][j].setEnabled(false);
                }
            }
            
            for(int i = 6 ; i < 9; i++) {
                for(int j = 1; j < 11; j++) {
                    Cell[i][j] = new JButton();
                    Cell[i][j].addActionListener(mixSorting);
                    Cell[i][j].setEnabled(false);
                }
            }

            
            for(int i = 1 ; i < 10; i++) {
                Cell[i][11] = new JButton();
                Cell[i][11].setBackground(Color.black);
                Cell[i][11].setVisible(false);
                Cell[i][0] = new JButton();
                Cell[i][0].setBackground(Color.black);
                Cell[i][0].setVisible(false);
            }
            
            for(int j = 0; j < 12; j++) {
                Cell[9][j] = new JButton(controller.getPlayer(2).getMyCollection().getPiece(j).getIcon());
                controller.getPlayer(2).getMyCollection().setPiece(j);
                Cell[9][j].addActionListener(mixSorting);
            }
            
            for(int i = 1; i < 10; i++) {
                for(int j = 0; j < 12; j++) {
                    NJPanel.add(Cell[i][j]);
                }
            }
            add(NJPanel);
            repaint();
            revalidate();
        }
    }

    /**
    * <b>transformer(mutative)</b>: Places the piece which has revived.
    * <b>precondition:</b> x > 0 && x < 8 && y > 0 && y < 10
    * <p><b>Postcondition:</b> Set the window such as the game continue.
    * @param x
    * @param y
    */ 
    public void revive(int x, int y) {
        Piece p = controller.getBoard().getPiece(x, y);
        if(p.getColour() == 'B' && controller.getPlayer(1).revivals() < 2 && ((MovablePiece)p).hasRevive() == false && x == 8) {
            for(int i = 1; i < 4; i++) {
                for(int j = 1; j < 11; j++) {
                    if(controller.getBoard().getPiece(i, j) != null) {
                        Cell[i][j].setEnabled(false);
                        Cell[i][j].removeActionListener(handler);
                    } else {
                        Cell[i][j].setEnabled(true);
                        Cell[i][j].setBackground(Color.green);
                        Cell[i][j].removeActionListener(handler);
                        Cell[i][j].addActionListener(reviveHandler);
                    }
                }
            }
            for(int i = 4; i < 9; i++) {
                for(int j = 1; j < 11; j++) {
                    Cell[i][j].setEnabled(false);
                    Cell[i][j].removeActionListener(handler);
                }
            }
        }
        if(p.getColour() == 'R' && controller.getPlayer(2).revivals() < 2 && ((MovablePiece)p).hasRevive() == false && x == 1) {
            for(int i = 6; i < 9; i++) {
                for(int j = 1; j < 11; j++) {
                    if(controller.getBoard().getPiece(i, j) != null) {
                        Cell[i][j].setEnabled(false);
                        Cell[i][j].removeActionListener(handler);
                    } else {
                        Cell[i][j].setEnabled(true);
                        Cell[i][j].setBackground(Color.green);
                        Cell[i][j].removeActionListener(handler);
                        Cell[i][j].addActionListener(reviveHandler);
                    }
                }
            }
            for(int i = 1; i < 6; i++) {
                for(int j = 1; j < 11; j++) {
                    Cell[i][j].setEnabled(false);
                    Cell[i][j].removeActionListener(handler);
                }
            }
        }
        ((MovablePiece)p).setRevive();
    }
       
    private class ReviveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i = 0; i < 10; i++) {
                BGrave[i].removeActionListener(CFRHandler);
                RGrave[i].removeActionListener(CFRHandler);
                BGrave[i].setEnabled(true);
                RGrave[i].setEnabled(true);
            }
            RGrave[10].setEnabled(true);
            RGrave[11].setEnabled(true);
            BGrave[10].setEnabled(true);
            BGrave[11].setEnabled(true);
            for(int i = 1; i < 9; i++) {
                for(int j = 1; j < 11; j++) {
                    if(event.getSource() == Cell[i][j]) {
                        Cell[i][j].setIcon(revP.getIcon());
                        controller.getBoard().setPiece(revP, i, j);
                    }
                    Cell[i][j].removeActionListener(reviveHandler);
                    Cell[i][j].addActionListener(handler);
                }
            }
            makeChanges();
            for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(controller.getBoard().getPiece(i, j) instanceof MovablePiece) {
                            MovablePiece tmp = (MovablePiece) controller.getBoard().getPiece(i, j);
                            if(controller.getBoard().getPiece(i, j).getColour() != controller.getPlayer(prevTurn).getColour() || tmp.isMoving(controller.getBoard().getTable(), i, j) == false) { 
                                Cell[i][j].setEnabled(false);
                            } else {
                                Cell[i][j].setEnabled(true);
                            }
                        }
                    }
                } 
        }
    }
    
    /**
    * <b>accessor(selector)</b>: Returns a new piece
    * <b>precondition:</b>: colour: R or B, i: 0 - 13
    * <p><b>Postcondition:</b> Take the id of a piece, the colour, and make it.
    * @param i
    * @param colour
    * @return the made piece
    */
    public Piece makePiece(int i, char colour) {
        return (new Collection(colour)).getPiece(i);
    }
    
    private class Choice4ReviveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            for(int i = 0; i < 10; i++) {
                if(event.getSource() == RGrave[i]) {
                    revP = makePiece(i, 'R');
                }
                if(event.getSource() == BGrave[i]) {
                    revP = makePiece(i, 'B');
                }
            }
            revive(posX, posY);
        }
    }
    /**
    * It's an action listener which is used when a button is pressed and is ready to make a moving.
    */
    private class ButtonHandler implements ActionListener {
        JButton my, my2;
        int moves = 0;
        MovablePiece tmp;
        Piece piece;
        private int x, y, x2, y2;

        @Override
        public void actionPerformed(ActionEvent event) {
            
            if(moves == 0) {
                moves++;
                my = (JButton)event.getSource();
                for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(Cell[i][j] == my) {
                            x = i;
                            y = j;
                            if(controller.getBoard().getPiece(x, y) instanceof Scout) {
                                mc.playMusic("sounds\\dogs.wav");
                            }
                        }
                    }
                }
                tmp = (MovablePiece)controller.getBoard().getPiece(x, y);
                int[][] Moves = tmp.getMoves(controller.getBoard().getTable(), x, y);
                for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(Moves[i][j] == 0) {
                            Cell[i][j].setEnabled(false);
                        } else {
                            if(controller.getBoard().getPiece(i, j) instanceof Trap || controller.getBoard().getPiece(i, j) instanceof Flag)
                            Cell[i][j].addActionListener(this);
                            Cell[i][j].setEnabled(true);
                            Cell[i][j].setBackground(Color.green);
                        }
                    }
                }
            } else {
                
                controller.riseRound();
                my2 = (JButton)event.getSource();
                for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(Cell[i][j] == my2) {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
                
                if(controller.getBoard().getPiece(x2, y2) instanceof Flag) {
                    System.out.println("Player " + controller.getPlayer(controller.getTurn()).getName() + " WIN");
                    if(controller.getTurn() == 1) {
                        mc.playMusic("sounds\\Victory.wav");
                    } else {
                        mc.playMusic("sounds\\Lose.wav");
                    }
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }
                if(controller.getBoard().getTable()[x2][y2] == null) {
                    
                    mc.playMusic("sounds\\Steps.wav");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Cell[x2][y2].setIcon(tmp.getIcon());
                    Cell[x][y].setIcon(null);
                    Cell[x][y].setBackground(Color.white);
                    controller.getBoard().getTable()[x][y] = null;
                    controller.getBoard().getTable()[x2][y2] = tmp;
                } else {
                    piece = controller.getBoard().getTable()[x2][y2];
                    attack(x, y, x2, y2);
                }
                moves = 0;
                if(controller.getBoard().getPiece(x2, y2) != null && controller.getBoard().getPiece(x2, y2).getColour() == 
                   controller.getPlayer(prevTurn).getColour() &&
                   controller.getPlayer(prevTurn).revivals() < 2 && ((x2 == 8 && 
                   controller.getTurn() == 2) || ( x2== 1 && controller.getTurn() == 1)) && 
                   (((MovablePiece)controller.getBoard().getPiece(x2, y2))).hasRevive() == false &&
                   controller.getPlayer(prevTurn).getMyGraveyard().isEmpty() == false) {
                    posX = x2;
                    posY = y2;
                    for(int i = 1; i < 9; i++) {
                        for(int j = 1; j < 11; j++) {
                            Cell[i][j].setEnabled(false);
                            if(Cell[i][j].getBackground() == Color.green) {
                                Cell[i][j].setBackground(Color.white);
                            }
                        }
                    }
                    RGrave[10].setEnabled(false);
                    RGrave[11].setEnabled(false);
                    BGrave[10].setEnabled(false);
                    BGrave[11].setEnabled(false);
                    if(x2 == 1) {
                        for(int j = 0; j < 10; j++) {
                            if(controller.getPlayer(prevTurn).getMyGraveyard().isDefeated(j) == false) {
                                RGrave[j].addActionListener(CFRHandler);
                            } else {
                                RGrave[j].setEnabled(false);
                            }
                        }
                    } else {
                        for(int j = 0; j < 10; j++) {
                            if(controller.getPlayer(prevTurn).getMyGraveyard().isDefeated(j) == false) {
                                BGrave[j].addActionListener(CFRHandler);
                            } else {
                                BGrave[j].setEnabled(false);
                            }
                        }
                    }
                    controller.getPlayer(controller.getTurn()).riseRevives();
                    prevTurn = controller.getTurn();
                } else {
                prevTurn = controller.getTurn();
                makeChanges();
                for(int i = 1; i < 9; i++) {
                    for(int j = 1; j < 11; j++) {
                        if(controller.getBoard().getPiece(i, j) instanceof MovablePiece) {
                            MovablePiece tmp = (MovablePiece) controller.getBoard().getPiece(i, j);
                            if(controller.getBoard().getPiece(i, j).getColour() != controller.getPlayer(prevTurn).getColour() || tmp.isMoving(controller.getBoard().getTable(), i, j) == false) { 
                                Cell[i][j].setEnabled(false);
                            } else {
                                Cell[i][j].setEnabled(true);
                            }
                        }
                    }
                } 
                }

            } // End of Moving
        } // End of Button Action 
    } // End of Button Action Class 

} // End of Graphics Class