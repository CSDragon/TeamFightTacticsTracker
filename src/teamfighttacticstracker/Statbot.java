/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker;

import java.util.ArrayList;
import teamfighttacticstracker.datatype.Champion;
import teamfighttacticstracker.datatype.Player;

/**
 *
 * @author Chris
 */
public class Statbot 
{
    public static int getRemainingStock(ArrayList<Champion> champs)
    {
        int totalStock = 0;
        for(Champion ch: champs)
            totalStock += ch.getStock();
        
        return totalStock;
    }
    
    public static int getTotalStock(ArrayList<Champion> champs)
    {
        int totalStock = 0;
        for(Champion ch: champs)
            totalStock += Champion.champNums[ch.getCost()-1];
    
        return totalStock;
    }
    
    public static double percentCleanup(double d)
    {
        d *= 10000;
        
        int i = (int)d;
        
        d = (double)i/100;
        return d;
    }
    
    public static double chanceOfSeeingChamp(Player pl, Champion champ)
    {
        ArrayList<Champion> sameCost = Champion.getAllChampsByCost(champ.getCost());
        int totalStock = getRemainingStock(sameCost);
        
        //chance of rolling on a level
        double chance = (double)champ.getStock()/totalStock;
        
        System.out.println(chance);
        
        chance  = chance * (TeamFightTacticsTracker.playerLevels[pl.getLevel()-1].getPercent(champ.getCost())/100); 
        
        System.out.println(chance);

        chance = 1- (Math.pow(1-chance, 5));

        System.out.println(chance +"\n");
        
        return chance;
        
    }
}
