
package games;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class highscore {

    String st, n, p, username;
    static int q;
    private ImageIcon icon, icons, iconm, icone, iconel, iconesc;

    public void namescore(int fscore) {
        q = 0;
        String x = Integer.toString(fscore);
        File file = new File("pappu.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException ex) {

        }
        try {
            while ((st = br.readLine()) != null) {
                String[] t = st.split(" ");
                n = t[0];
                p = t[1];

            }
        } catch (IOException ex) {

        }
        int w = Integer.parseInt(p);
        if (w < fscore) {
            q = 1;

            JFrame r = new JFrame();
            r.getContentPane().setBackground(Color.CYAN);
            r.setLocation(800, 300);
            r.setUndecorated(true);
            r.getRootPane().setWindowDecorationStyle(1);
            r.setVisible(true);
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r.setTitle("SetName");
            JButton inb = new JButton("OK");
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JLabel l = new JLabel("𝐏𝐥𝐞𝐚𝐬𝐞 𝐄𝐧𝐭𝐞𝐫 𝐲𝐨𝐮𝐫 𝐍𝐚𝐦𝐞: ");
            l.setFont(new Font("Helvetica", Font.BOLD, 20));
            JLabel lc = new JLabel("𝔠𝔬𝔫𝔤𝔬!𝔜𝔬𝔲 𝔥𝔞𝔳𝔢 𝔟𝔢𝔞𝔱𝔢𝔫 𝔜𝔬𝔲𝔯 𝔏𝔞𝔰𝔱 𝔯𝔢𝔠𝔬𝔯𝔡");
            lc.setFont(new Font("Helvetica", Font.BOLD, 20));
            lc.setForeground(Color.red);
            JTextField intx = new JTextField(20);
            panel1.add(l);
            panel1.setBounds(20, 65, 300, 50);

            panel1.setBackground(Color.CYAN);
            panel3.add(lc);
            panel3.setBounds(0, 20, 400, 50);
            panel3.setBackground(Color.CYAN);

            panel2.add(intx);
            panel2.setBounds(35, 110, 300, 40);
            panel2.setBackground(Color.CYAN);
            r.setLayout(null);

            r.add(panel1);
            r.add(panel2);
            r.add(panel3);
            inb.setSize(100, 50);
            inb.setLocation(150, 155);
            r.add(inb);
            r.setBackground(Color.cyan);
            r.setSize(400, 300);

            icon = new ImageIcon(getClass().getResource("image.png"));
            r.setIconImage(icon.getImage());

            inb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        MainMenu.sound();
                        Formatter f = new Formatter("pappu.txt");
                        username = intx.getText();
                        f.format("%s %s\n", username, fscore);
                        f.close();
                        r.setVisible(false);
                        new MainMenu();

                    } catch (IOException ex) {

                    }
                }
            });

        }

    }

}
