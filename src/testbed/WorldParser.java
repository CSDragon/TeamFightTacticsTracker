/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbed;

import java.io.BufferedReader;
import java.io.FileReader;
import teamfighttacticstracker.TeamFightTacticsTracker;
import teamfighttacticstracker.datatype.Champion;
import teamfighttacticstracker.datatype.Player;

/**
 *
 * @author Chris
 */
public class WorldParser 
{
    
    public static void readFile()
    {
        
        try
        {
            BufferedReader in;
            String s;


            in = new BufferedReader(new FileReader("resources/testWorld.txt"));
            
            s = in.readLine(); //get rid of the first Player
            for(int i = 0; i<9; i++)
            {
                //get player level
                TeamFightTacticsTracker.allPlayers.get(i).setLevel(Integer.parseInt(in.readLine()));
                
                int boardNum = 0;
                s = in.readLine();//get rid of the "Board"
                s = in.readLine();
                while(!s.equals("Bench"))
                {
                    String name = s;
                    int star = Integer.parseInt(in.readLine());
                    
                    TeamFightTacticsTracker.allPlayers.get(i).addPiece(Champion.getChampionByName(name), star, Player.BOARD, boardNum);
                    
                    s = in.readLine();
                    boardNum++;
                }
                
                boardNum = 0;
                s = in.readLine();
                while(!s.equals("Player"))
                {
                    String name = s;
                    int star = Integer.parseInt(in.readLine());
                    
                    TeamFightTacticsTracker.allPlayers.get(i).addPiece(Champion.getChampionByName(name), star, Player.BENCH, boardNum);
                    
                    s = in.readLine();
                    boardNum++;
                }
                
            }
            
            
            
            in.close();
        }
        catch(Exception e)
        {

        }
    }
}
