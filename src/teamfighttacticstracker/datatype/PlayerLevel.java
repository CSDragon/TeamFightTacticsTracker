/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker.datatype;

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
        percents = new double[Champion.CHAMPLEVELS];
        for(int i = 0; i<Champion.CHAMPLEVELS; i++)
            percents[i] = Double.parseDouble(strings[i]);
    }
}
