
package testbed;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import teamfighttacticstracker.Statbot;
import teamfighttacticstracker.TeamFightTacticsTracker;
import teamfighttacticstracker.datatype.Champion;
import teamfighttacticstracker.datatype.OriginClass;
import teamfighttacticstracker.datatype.Player;


/**
 * MultiButtonTestbed
 * @author Chris Scott
 * This is a generic multi-button testbed.
 * It gives you a number of buttons you can press to test other programs.
 */
public class MultiButtonTestbed implements ActionListener
{
   
    private static JFrame gameFrame;
    
//list of buttons
    private static JButton but1;
    private static JButton but2;
    private static JButton but3;
    private static JButton but4;
    private static JButton but5;
    
        
    //Generic main
    public static void main(String[] args) 
    {
        new MultiButtonTestbed();
    }
    
    public MultiButtonTestbed()
    {
        //Set up window
        gameFrame = new JFrame("Multibuton Testbed");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setSize(400, 400);

        
        //create and add the buttons you've made
        but1 = new JButton("Test Get Dude");
        but1.addActionListener(this);
        gameFrame.add(but1, BorderLayout.NORTH);

        but2 = new JButton("Get a bunch of dudes");
        but2.addActionListener(this);
        gameFrame.add(but2, BorderLayout.EAST);

        but3 = new JButton("Stock totals");
        but3.addActionListener(this);
        gameFrame.add(but3, BorderLayout.WEST);

        but4 = new JButton("beatdown");
        but4.addActionListener(this);
        gameFrame.add(but4, BorderLayout.SOUTH);

        but5 = new JButton();
        but5.addActionListener(this);
        gameFrame.add(but5, BorderLayout.CENTER);
        
        
        //turn on the window
        gameFrame.setVisible(true);
        
        //System Under Test
        //set up the sound player
    }

    @Override
    /**
     * Action Listener implementation
     * Activates actions based on the button pressed.
     */
    public void actionPerformed(ActionEvent e) 
    {
        //Put the button actions here.
        if(e.getSource() == but1)
        {
            Champion test1 = Champion.getChampionByName("Vayne");
            System.out.println(test1.getName());
        }
        if(e.getSource() == but2)
        {
            ArrayList<Champion> test2 = Champion.getAllChampsByCost(2);
            for(int i = 0; i<test2.size();i++)
                System.out.println(test2.get(i).getName());
            
            System.out.println("");
            
            ArrayList<Champion> test3 = Champion.getAllChampionsByOriginClass(OriginClass.getOriginClassFromListByName("Ninja"));
            for(int i = 0; i<test3.size();i++)
                System.out.println(test3.get(i).getName());
            
        }
        if(e.getSource() == but3)
        {
            ArrayList<Champion> test3 = Champion.getAllChampionsByOriginClass(OriginClass.getOriginClassFromListByName("Ninja"));
            for(int i = 0; i<test3.size();i++)
                System.out.println(test3.get(i).getName());
            
            Champion zed = Champion.getChampionByName("Zed");
            zed.consumeStock(4);
            System.out.println(Statbot.getRemainingStock(test3) + "/" + Statbot.getTotalStock(test3));
        }
        if(e.getSource() == but4)
        {
            ArrayList<Champion> test3 = Champion.getAllChampionsByOriginClass(OriginClass.getOriginClassFromListByName("Glacial"));
            for(Champion champ: test3)
            {
                System.out.println(champ.getName() + champ.getCost());
            }
        }
        if(e.getSource() == but5)
        {
            Champion zed = Champion.getChampionByName("Zed");
            
            Player p = TeamFightTacticsTracker.allPlayers.get(0);
            
            p.setLevel(p.getLevel()+1);
            
            Statbot.chanceOfSeeingChamp(p, zed);
            zed.consumeStock(3);
            Statbot.chanceOfSeeingChamp(p, zed);
            zed.returnStock(3);
        }

    }
    
    
}
