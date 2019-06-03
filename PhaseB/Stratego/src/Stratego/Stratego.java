
package Stratego;

import View.*;
import java.io.IOException;
import javax.swing.JFrame;

public class Stratego {
        public static void main(String[] args) throws IOException {
            Graphics newStratego = new Graphics();
            newStratego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            newStratego.setSize(800, 700);
            newStratego.setVisible(true); 
       }
}
