/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import testbed.MultiButtonTestbed;

/**
 *
 * @author Chris
 */
public class TeamFightTacticsTracker 
{
    public static ArrayList<OriginClass> allOriginClasses;
    public static ArrayList<Champion> allChamps;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        allOriginClasses = new ArrayList<>();
        allChamps = new ArrayList<>();
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("resources/originsAndClasses.txt"));
            String s = in.readLine();
            while(s!= null && !s.equals(""))
            {
                allOriginClasses.add(new OriginClass(s));
                
                s = in.readLine();
            }
            
            in = new BufferedReader(new FileReader("resources/champions.txt"));
            s = in.readLine();
            while(s!= null && !s.equals(""))
            {
                Champion c = new Champion(s);
                allChamps.add(c);
                s = in.readLine();
            }
            System.out.println("asdf");
            
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
