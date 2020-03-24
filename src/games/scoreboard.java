package games;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class scoreboard extends JFrame {

    private Container c;
    private JPanel bpanel1 = new JPanel();
    private JPanel bpanel2 = new JPanel();
    private JPanel bpanel3 = new JPanel();
    private JPanel bpanel4 = new JPanel();

    private JLabel finalscore;
    private JLabel totalscore;
    private JLabel scoren1;
    private JLabel scoren2;
    private JLabel cong;
    private JLabel scoretitle;
    int semiscore;
    static int fscore;
    JButton mainmenu = new JButton("MAINMENU");
    JButton tryagain = new JButton("TRY AGAIN");
    JButton next = new JButton("PLAY NEXT LEVEL");
    String str, username;
    String st, p, n, pass;
    int ex = 0;
    private ImageIcon icon, icons, iconm, icone, iconel, iconesc;

    scoreboard(int k, int l, int count, String s) {

        semiscore = 10000 - (k * 100 + l) - (count * 5);
        if (semiscore < 0) {
            semiscore = 0;
        } else if ((k * 100 + l) - (count * 5) == 0) {
            semiscore = 0;

        }

        fscore = fscore + semiscore;

        str = s;
        System.out.println("" + semiscore + " total= " + fscore);
        init();
    }

    public void init() {
        addicon();
        String score, totalpoint;
        finalscore = new JLabel();
        totalscore = new JLabel();
        scoren1 = new JLabel();
        scoren2 = new JLabel();
        cong = new JLabel();
        scoretitle = new JLabel();
        if (semiscore == 0) {
            score = "OO";
        } else {
            score = String.valueOf(semiscore);
        }
        if (fscore == 0) {
            totalpoint = "OO";
        } else {
            totalpoint = String.valueOf(fscore);
        }
        this.setUndecorated(true);

        this.setTitle("BRAIN SPARKS(scoreboard)");
        this.setVisible(true);
        this.getRootPane().setWindowDecorationStyle(1);
        this.getContentPane().setBackground(Color.CYAN);
        finalscore.setFont(new Font("Helvetica", Font.BOLD, 30));
        totalscore.setFont(new Font("Helvetica", Font.BOLD, 30));
        scoren1.setFont(new Font("Helvetica", Font.BOLD, 30));
        scoren2.setFont(new Font("Helvetica", Font.BOLD, 30));
        cong.setFont(new Font("Helvetica", Font.BOLD, 40));
        scoretitle.setFont(new Font("Helvetica", Font.BOLD, 30));
        //System.out.println("lvl="+score+" total="+totalpoint);
        finalscore.setText(score);
        totalscore.setText(totalpoint);
        scoren1.setText("𝕷𝖊𝖛𝖊𝖑 𝖘𝖈𝖔𝖗𝖊➦");

        scoren2.setText("𝕿𝖔𝖙𝖆𝖑 𝖘𝖈𝖔𝖗𝖊➥");
        cong.setText("𝕮𝖔𝖓𝖌𝖗𝖆𝖙𝖚𝖑𝖆𝖙𝖎𝖔𝖓𝖘!");
        //scoretitle.setText("▀▄▀▄ 𝕱𝖎𝖓𝖆𝖑𝕾𝖈𝖔𝖗𝖊🎈 ▄▀▄▀");
        scoretitle.setText("▀▄▀▄ 🎈𝖄𝖔𝖚𝖗𝕾𝖈𝖔𝖗𝖊🎈 ▄▀▄▀");
        //scoretitle.setText("▀▄▀▄▀▄ 𝕱𝖎𝖓𝖆𝖑 𝕾𝖈𝖔𝖗𝖊🎈 ▄▀▄▀▄▀");

        finalscore.setForeground(Color.BLUE);
        totalscore.setForeground(Color.GRAY);
        scoren1.setForeground(Color.blue);
        scoren2.setForeground(Color.gray);
        cong.setForeground(Color.red);
        scoretitle.setForeground(Color.BLACK);

        //congratulation
        bpanel3.add(cong);
        bpanel3.setBounds(80, 20, 350, 70);
        bpanel3.setBackground(Color.CYAN);
        //scoretitle
        bpanel4.add(scoretitle);
        bpanel4.setBounds(1, 110, 492, 70);
        bpanel4.setBackground(Color.CYAN);
        //score
        bpanel1.add(finalscore);
        bpanel1.add(totalscore);
        bpanel1.setBounds(300, 170, 100, 100);
        bpanel1.setBackground(Color.CYAN);
        bpanel2.add(scoren1);
        bpanel2.add(scoren2);
        bpanel2.setBounds(50, 170, 300, 100);
        bpanel2.setBackground(Color.CYAN);

        c = this.getContentPane();
        c.setLayout(null);
        this.setResizable(false);
        this.setSize(500, 550);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.add(bpanel1);
        c.add(bpanel2);
        c.add(bpanel3);
        c.add(bpanel4);
        tryagain.setSize(100, 70);
        tryagain.setLocation(300, 400);
        c.add(tryagain);
        tryagain.setToolTipText("Try Again");
        tryagain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainMenu.sound();
                fscore = fscore - (semiscore + 500);
                dispose();
                new Maze(str);
            }

        });

        mainmenu.setSize(100, 70);
        mainmenu.setLocation(80, 400);
        c.add(mainmenu);
        mainmenu.setToolTipText("Go to Mainmenu");
        mainmenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                MainMenu.sound();

                highscore h = new highscore();
                h.namescore(fscore);
                dispose();
                fscore = 0;
                if (highscore.q == 0) {
                    new MainMenu();
                }
            }

        });

        next.setSize(400, 30);
        next.setLocation(50, 300);
        c.add(next);
         next.setToolTipText("Play Next Level");
        next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nxt = getnext(str);
                new Maze(nxt);
                dispose();
            }

        });

    }

//    public static void main(String[] args) {
//        new scoreboard(4, 5, 10, "papppuuuu");
//    }

    public void addicon() {
        icon = new ImageIcon(getClass().getResource("image.png"));
        this.setIconImage(icon.getImage());
    }

    public String getnext(String x) {

        String s = x;
        String s2 = "";
        int l = s.length();
        for (int i = 6; i < l; i++) {
            if (s.charAt(i) == '.') {
                break;
            }
            Character z = s.charAt(i);
            s2 = s2.concat(z.toString());
        }

        s = s.replace(s2, "");
        int w = Integer.parseInt(s2);

        w = w + 1;

        String ws = Integer.toString(w);
        ws = ws.concat(".");
        s = s.replace(".", ws);

        System.out.println("old lvl   " + s2);
        System.out.println("new lvl   " + w);
        System.out.println("after=" + s);

        return s;
    }
}
