/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import static games.Maze.flag;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MAIN {
      public static void main(String args[]) {
        
       Thread thread = new Thread() {
            
            @Override
            public void run() {
                
                    FirstPage ob = new FirstPage();
                    try {
                        sleep(4500);
                       ob.Menu.setVisible(false);
                        new MainMenu();
                    } catch (InterruptedException ex) {
                      
                       ex.printStackTrace();
                   }
                }
            
     };

     thread.start();
    //  new MainMenu();
     
      

    }

    
}
