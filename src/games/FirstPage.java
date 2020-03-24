/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author student
 */
public class FirstPage  {
    JFrame Menu = new JFrame("BRAIN SPARKES(Loading)");
    ImageIcon picture=new ImageIcon(getClass().getResource("l.gif"));//by me
    JLabel imageLabel = new JLabel(picture);
    int WIDTH = 750;
    int HEIGHT =770;
    
     private ImageIcon icon,icons,iconm,icone;//by me

	public FirstPage() { 
            addicon();
        //Menu Variables
        try{
            File sound =new File("Sound Effect.wav");
            AudioInputStream ais=AudioSystem.getAudioInputStream(sound);
            Clip clip=AudioSystem.getClip();
            clip.open(ais);
            clip.start();  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        //Display Picture
        imageLabel.setSize(WIDTH, HEIGHT);
        imageLabel.setLayout(null);
       
        imageLabel.setVisible(true);
        Menu.setUndecorated( true );
        Menu.add(imageLabel);
        Menu.setVisible(true);
        Menu.getRootPane().setWindowDecorationStyle(1);
       
    }
      public void addicon()
    {
        icon=new ImageIcon(getClass().getResource("image.png"));
        Menu.setIconImage(icon.getImage());
    }
 
      
}
