package Model.Music;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music {
    InputStream in; 
    InputStream audioStream;
    
    public void playMusic(String gongFile) {
        try {
            in = new FileInputStream(gongFile);
            try {
                // create an audiostream from the inputstream
                audioStream = new AudioStream(in);
                AudioPlayer.player.start(audioStream);
            } catch (IOException ex) {
                Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}