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
import teamfighttacticstracker.datatype.PlayerLevel;
import testbed.MultiButtonTestbed;

/**
 *
 * @author Chris
 */
public class TeamFightTacticsTracker 
{
    public static ArrayList<OriginClass> allOriginClasses;
    public static ArrayList<Champion> allChamps;
    public static final int CHAMPLEVELS = 5;
    public static int[] champNums;
    public static final int PLAYERLEVELS = 9;
    public static PlayerLevel[] playerLevels;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        allOriginClasses = new ArrayList<>();
        allChamps = new ArrayList<>();
        champNums = new int[CHAMPLEVELS];
        playerLevels = new PlayerLevel[PLAYERLEVELS];
        
        try
        {
            BufferedReader in;
            String s;
            
            
            in = new BufferedReader(new FileReader("resources/champNums.txt"));
            for(int i = 0; i<CHAMPLEVELS; i++)
                champNums[i] = Integer.parseInt(in.readLine());
            in.close();
            
            in = new BufferedReader(new FileReader("resources/levelPercent.txt"));
            for(int i = 0; i<PLAYERLEVELS; i++)
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
        
        for(int i = 0; i<allChamps.size(); i++)
        {
            System.out.println(allChamps.get(i).getName());
        }
        

        new MultiButtonTestbed();
        // TODO code application logic here
    }
    
}
