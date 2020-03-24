package games;

import java.awt.Color;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;

public class Player extends JPanel {

    int x, y;
    int ck=0;
    //add object icon
    ImageIcon objpicture = new ImageIcon(getClass().getResource("frog1.png"));
    JLabel objLabel = new JLabel(objpicture);

    public Player() {
        this.add(objLabel);
        this.setBackground(Color.CYAN);
        this.setSize(Maze.panelSize, Maze.panelSize);
        

    }

    public void moveLeft() {
        if (x > 0 && Maze.map[x - 1][y] == 1) {
            try {
                File sound = new File("buttonsound2.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.setLocation(this.getX() - 35, this.getY());
            x--;
        }
       
    }

    public  void moveRight() {
        if (x < Maze.columns - 1 && Maze.map[x + 1][y] == 1) {
            try {
                File sound = new File("buttonsound2.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setLocation(this.getX() + 35, this.getY());
            x++;
        }
       
    }

    public void moveUp() {
        if (y > 0 && Maze.map[x][y - 1] == 1) {
            try {
                File sound = new File("buttonsound2.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setLocation(this.getX(), this.getY() - 35);
            y--;
        }
      
    }

    public void  moveDown() {

        if (y < Maze.rows - 1 && Maze.map[x][y + 1] == 1) {
            try {
                File sound = new File("buttonsound2.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.setLocation(this.getX(), this.getY() + 35);
            y++;
        }
      
    }
    
}
