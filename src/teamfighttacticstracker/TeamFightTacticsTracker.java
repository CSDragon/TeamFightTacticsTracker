/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker;

import teamfighttacticstracker.datatype.Champion;
import teamfighttacticstracker.datatype.OriginClass;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import teamfighttacticstracker.datatype.Player;
import teamfighttacticstracker.datatype.PlayerLevel;
import testbed.MultiButtonTestbed;
import testbed.WorldParser;

/**
 *
 * @author Chris
 */
public class TeamFightTacticsTracker 
{
    public static ArrayList<OriginClass> allOriginClasses;
    public static ArrayList<Champion> allChamps;
    public static ArrayList<Player> allPlayers;
    
    
    public static PlayerLevel[] playerLevels;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        allOriginClasses = new ArrayList<>();
        allChamps = new ArrayList<>();
        Champion.champNums = new int[Champion.CHAMPLEVELS];
        playerLevels = new PlayerLevel[Player.PLAYERLEVELS];
        
        try
        {
            BufferedReader in;
            String s;
            
            
            in = new BufferedReader(new FileReader("resources/champNums.txt"));
            for(int i = 0; i<Champion.CHAMPLEVELS; i++)
                Champion.champNums[i] = Integer.parseInt(in.readLine());
            in.close();
            
            in = new BufferedReader(new FileReader("resources/levelPercent.txt"));
            for(int i = 0; i<Player.PLAYERLEVELS; i++)
                playerLevels[i] = new PlayerLevel(in.readLine());
            in.close();
            
            
            
            in = new BufferedReader(new FileReader("resources/originsAndClasses.txt"));
            s = in.readLine();
            while(s!= null && !s.equals(""))
            {
                allOriginClasses.add(new OriginClass(s));
                
                s = in.readLine();
            }
            in.close();
            
            in = new BufferedReader(new FileReader("resources/champions.txt"));
            s = in.readLine();
            while(s!= null && !s.equals(""))
            {
                Champion c = new Champion(s);
                allChamps.add(c);
                s = in.readLine();
            }
            in.close();
            
        }
        catch(Exception E)
        {
            System.exit(0);
        }
        
        allPlayers = new ArrayList<>();
        for(int i = 0; i<8; i++)
            allPlayers.add(new Player(i));

        
        WorldParser.readFile();
        
        new MultiButtonTestbed();
        // TODO code application logic here
        
    }
    
    
    
}
