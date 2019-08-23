/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker.datatype;

import teamfighttacticstracker.TeamFightTacticsTracker;

/**
 *
 * @author Chris
 */
public class PlayerLevel 
{
    private double[] percents;
    
    public PlayerLevel(String s)
    {
        String[] strings = s.split(",");
        percents = new double[TeamFightTacticsTracker.CHAMPLEVELS];
        for(int i = 0; i<TeamFightTacticsTracker.CHAMPLEVELS; i++)
            percents[i] = Double.parseDouble(strings[i]);
    }
}
