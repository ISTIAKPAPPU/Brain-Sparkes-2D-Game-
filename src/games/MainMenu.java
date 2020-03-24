package games;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class MainMenu  {
    
    JFrame Menu = new JFrame("BARIN SPARKES");
    JButton Start=new JButton("Start");
    JButton selectlvl=new JButton("lvl");
    JButton Exit = new JButton("Exit");
    JButton score = new JButton("SCORE");
    JButton MapMaker = new JButton("Make Maker");
    ImageIcon picture=new ImageIcon(getClass().getResource("bgi2.gif"));//by me
    JLabel imageLabel = new JLabel(picture);
    ArrayList<String> mapList = new ArrayList<String>();
    JComboBox<String> lvlList;
    int menuWidth = 70; //Width of each button/item on display
    int menuHeight = 70;//Height of each button/item on display
    int WIDTH = 750;
    int HEIGHT = 770;
    private ImageIcon icon,icons,iconm,icone,iconel,iconesc;
    private Font font;
   
	public MainMenu() {
          
     //maze icon
           addicon();
           getMapList();
     
    	//Load map list
   	lvlList = new JComboBox(mapList.toArray(new String[mapList.size()]));
    	
        //Menu Variables
        Menu.setResizable(false);
        Menu.setSize(WIDTH, HEIGHT);
        Menu.setLayout(null);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set button icon me 
        icons=new ImageIcon(getClass().getResource("finalplay.gif"));
        iconm=new ImageIcon(getClass().getResource("map.gif"));  
        icone=new ImageIcon(getClass().getResource("exitf.gif"));
        iconel=new ImageIcon(getClass().getResource("lvl.jpg"));
        iconesc=new ImageIcon(getClass().getResource("score.jpg"));
        Start=new JButton(icons);
        MapMaker=new JButton(iconm);
        Exit=new JButton(icone);
        selectlvl=new JButton(iconel);
        score=new JButton(iconesc);
        //Start Button Variables
      
        Start.setSize(menuWidth,menuHeight);
        Start.setLocation(50,90);
        Menu.add(Start);
        Start.setToolTipText("Click to Play");
        Start.addActionListener(new ActionListener(){
                          

			@Override
			public void actionPerformed(ActionEvent arg0) {
                                sound();
                                 //JOptionPane.showMessageDialog(null, "still maintaning");\
                                 System.out.println((String) lvlList.getSelectedItem());
				new Maze((String) lvlList.getSelectedItem());                           
				Menu.setVisible(false);
			}
        	
        });	
        
        //Level Selector
        lvlList.setSize(100, 50);
        lvlList.setLocation(200, 200);
        selectlvl.setSize(menuWidth,menuHeight);
        selectlvl.setLocation(50, 190);
        Menu.add( selectlvl);
        selectlvl.setToolTipText("Select Level");
       // Menu.add( lvlList);
        selectlvl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
                             sound();
                            imageLabel .add(lvlList);
                          //  Menu.add(imageLabel);
                           //Menu.add( lvlList);
		            
			}
        	
        });
           //Map Maker Button Variables
        
        MapMaker.setSize(menuWidth,menuHeight);
        MapMaker.setLocation(50, 290);
        Menu.add(MapMaker);
        MapMaker.setToolTipText("Create a New Map");
        MapMaker.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
                                sound();
                                //JOptionPane.showMessageDialog(null, "still maintaning");
				new MazeMapMaker();
				Menu.setVisible(false);
			}
        	
        });
       
        //score
        score.setSize(menuWidth,menuHeight);
        score.setLocation(50,390);
        Menu.add(score);
        score.setToolTipText("Check High score");
        score.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
                                   sound();
                                  new addhscore();
                                  
                                  
			}
        });
        //Exit Button Variables
        
        Exit.setSize(menuWidth,menuHeight);
        Exit.setLocation(50,490);
        Menu.add(Exit);
        Exit.setToolTipText("Exit");
        Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
                        sound();
	            System.exit(0);
			}
        });
        
        //Display Picture
        
        imageLabel.setSize(WIDTH, HEIGHT);
       // imageLabel.setLayout(null);
       // imageLabel.setVisible(true);
        Menu.add(imageLabel);
        Menu.setUndecorated( true );
        Menu.setVisible(true);
        Menu.getRootPane().setWindowDecorationStyle(1);
       
    }
      public void addicon()
    {
        icon=new ImageIcon(getClass().getResource("image.png"));
        Menu.setIconImage(icon.getImage());
    }
     static public void sound()
      {
           try {
                File sound = new File("buttonsound.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
      }

   static boolean levelsExistAlready = false;
    
    public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
                   
    			mapList.add("LEVEL "+i+".map");
    			levelsExistAlready = true;
    		}
    	}
    }
   
}
