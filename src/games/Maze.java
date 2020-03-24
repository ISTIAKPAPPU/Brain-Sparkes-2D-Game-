package games;

import static games.MainMenu.sound;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maze extends JFrame implements Runnable {

    public static int rows = 20;
    public static int columns = 20;
    public static int panelSize = 35;
    public static int map[][] = new int[columns][rows];
    public static int endLevelLoc;
    Player p;
    private ImageIcon icon;
    private JPanel timepanel = new JPanel();
    private JPanel countpanel = new JPanel();
    private JPanel scorepanel = new JPanel();

    private Container c;
    private JLabel timer, time, cnt, counter, score, inis, sname;
    private JButton back = new JButton("back");
    ;
    boolean stop = false;
    boolean start = true;
    boolean scorefinal = false;
    int count = 0;
    int k, l;
    Thread t = new Thread(this);
    Thread ok = new Thread(this);
    NumberFormat nf = new DecimalFormat("00");
    int check = 0;
    String str1;
    boolean ex = true;
    int ck ,cl;
    public void sidecomponent() {

        timer = new JLabel();
        time = new JLabel();
        cnt = new JLabel();
        score = new JLabel();
        inis = new JLabel();
        counter = new JLabel();
        sname = new JLabel();
        time.setText("00:00");
        time.setFont(new Font("Helvetica", Font.PLAIN, 20));
        timer.setFont(new Font("Helvetica", Font.BOLD, 20));
        cnt.setFont(new Font("Helvetica", Font.BOLD, 20));
        score.setFont(new Font("Helvetica", Font.BOLD, 20));
        inis.setFont(new Font("Helvetica", Font.BOLD, 20));
        counter.setFont(new Font("Helvetica", Font.BOLD, 20));
        sname.setFont(new Font("Helvetica", Font.BOLD, 20));

        cnt.setText(nf.format(count));

        timer.setText("𝕿𝖎𝖒𝖊𝖗");
        counter.setText(" 𝕊𝖙𝖊𝖕𝖟  ");
        score.setText("𝟐𝟗.𝟗𝟗𝐬");
        inis.setText("𝕷𝖎𝖒𝖎𝖙");
        sname.setText("𝕿𝖎𝖒𝖊");

        time.setForeground(Color.cyan);
        cnt.setForeground(Color.cyan);
        timer.setForeground(Color.WHITE);
        score.setForeground(Color.CYAN);
        inis.setForeground(Color.white);
        counter.setForeground(Color.white);
        sname.setForeground(Color.white);

        c = this.getContentPane();
        c.setLayout(new BorderLayout());
        timepanel.add(timer);
        timepanel.add(time);
        countpanel.add(counter);
        countpanel.add(cnt);
        scorepanel.add(sname);
        scorepanel.add(inis);
        scorepanel.add(score);

        back.setBounds(730, 200, 100, 50);
        timepanel.setBounds(730, 50, 100, 100);
        countpanel.setBounds(730, 280, 100, 100);
        scorepanel.setBounds(730, 500, 100, 120);
        back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
                     
			}
        });
        timepanel.setBackground(Color.GRAY);
        countpanel.setBackground(Color.GRAY);

        scorepanel.setBackground(Color.GRAY);
        c.add(timepanel);
        c.add(countpanel);
        c.add(scorepanel);
     
    }

    public Maze(String str) {

        //setstr(String p);
        str1 = str;
        
        loadMap(str);
        sidecomponent();
        if(ex){
             t.start();
        }
        this.setResizable(false);
        this.setSize((columns * panelSize) + 150, (rows * panelSize) + 70);
        this.setTitle("BRAIN SPARKS(playground)");
        this.setLayout(null); 
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(1);
        this.getContentPane().setBackground(Color.GRAY);
        addicon();
       
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();


         //t.start();
                //Player movement
                if (key == KeyEvent.VK_W) {
                    count++;
//                    if (start) {
//                        t.start();
//                        start = false;
//
//                    }
                    cnt.setText(nf.format(count));
                    System.out.println(".keyPressed()");
                    p.moveUp();
                }
                if (key == KeyEvent.VK_A) {
                    count++;
//                    if (start) {
//                        t.start();
//                        start = false;
//                    }
                    cnt.setText(nf.format(count));
                    p.moveLeft();
                    System.out.println(".keyPressed()");
                }
                if (key == KeyEvent.VK_S) {
                    count++;
//                    if (start) {
//                        t.start();
//                        start = false;
//                    }
                    cnt.setText(nf.format(count));
                    p.moveDown();
                    System.out.println(".keyPressed()");
                }
                if (key == KeyEvent.VK_D) {
                    count++;
//                    if (start) {
//                        t.start();
//                        start = false;
//                    }
                    cnt.setText(nf.format(count));
                    p.moveRight();
                    System.out.println(".keyPressed()");
                }
                int ck = 0, cl = 0;
                int x = 0;
                if (p.x == columns - 1 && p.y == endLevelLoc) {

                    stop = true;
                    scorefinal = true;

                    ck = k;
                    cl = l;
                    JOptionPane.showMessageDialog(null, "level completed", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    new scoreboard(ck, cl, count, str);
                    dispose();
                    //new MainMenu();
                }
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub

            }

        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //System.out.println((columns*panelSize)+50+"-"+((rows*panelSize)+70));
                System.exit(0);
            }
        });

        this.setLocationRelativeTo(null);

        //Create player
        p = new Player();
        p.setVisible(true);
        this.add(p);

        //Color map
        for (int y = 0; y < columns; y++) {
            for (int x = 0; x < rows; x++) {
                Tile tile = new Tile(x, y);
                tile.setSize(panelSize, panelSize);
                tile.setLocation((x * panelSize) + 23, (y * panelSize) + 25);
                if (map[x][y] == 0) {
                    tile.setBackground(Color.BLACK);
                } else {
                    tile.setBackground(Color.cyan);
                    tile.setWall(false);
                    if (x == 0) {
                        p.setLocation((x * panelSize) + 23, (y * panelSize) + 25);
                        p.y = y;
                    }
                    if (x == columns - 1) {
                        endLevelLoc = y;
                    }
                }

                tile.setVisible(true);
                this.add(tile);
            }
        }
 
        if (ex) {
           this.setVisible(true);
        } else {
            this.setVisible(false);
            new scoreboard(ck, cl, count, str);
            //scoreboard.fscore = 0;
          //  new MainMenu();

        }

       
    }

    public void addicon() {
        icon = new ImageIcon(getClass().getResource("image.png"));
        this.setIconImage(icon.getImage());
    }
    static boolean flag = true;

    public void loadMap(String str) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(str));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String mapStr = sb.toString();

            int counter = 0;
            for (int y = 0; y < columns; y++) {
                for (int x = 0; x < rows; x++) {
                    String mapChar = mapStr.substring(counter, counter + 1);
                    if (!mapChar.equals("\r\n") && !mapChar.equals("\n") && !mapChar.equals("\r")) {//If it's a number
                        //System.out.print(mapChar);
                        map[x][y] = Integer.parseInt(mapChar);
                    } else {//If it is a line break
                        x--;
                        System.out.print(mapChar);
                    }
                    counter++;
                }
            }
        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "create new level", "level not found", JOptionPane.INFORMATION_MESSAGE);
            ex = false;
        
        }

    }

    @Override
    public void run() {
        for (k = 0; k < 40; k++) {
            int g = 0;
            if (!stop) {
                if (k == 30) {
                    JOptionPane.showMessageDialog(null, "time Out", "Oops", JOptionPane.INFORMATION_MESSAGE);

                    new scoreboard(0, 0, 0, str1);
                    dispose();
                    g = 1;
                    break;

                }
            }
            for (l = 0; l < 100; l++) {
                if (stop || g == 1) {
                    break;
                }
                NumberFormat nf = new DecimalFormat("00");
                time.setText(nf.format(k) + ":" + nf.format(l));
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
        }

    }

}
