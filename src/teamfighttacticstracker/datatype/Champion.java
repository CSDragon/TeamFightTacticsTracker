/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker.datatype;

import java.util.ArrayList;
import teamfighttacticstracker.TeamFightTacticsTracker;

/**
 *
 * @author Chris
 */
public class Champion
{
    public static final int CHAMPLEVELS = 5;
    public static final int LEVELSTOCK[] = {1,3,9};
    public static int[] champNums;

    private String name;
    private int cost;
    private int stock;
    
    private ArrayList<OriginClass> OriClassList;
    
    public Champion(String _name, ArrayList<OriginClass> _OriClassList)
    {
        name = _name;
        OriClassList = _OriClassList;
    }
    
    public Champion(String s)
    {
        String[] strings = s.split(",");
        OriClassList = new ArrayList<>();
        name = strings[0];
        cost = Integer.parseInt(strings[1]);
        for(int i = 2; i<strings.length;i++)
        {
            OriginClass oc = OriginClass.getOriginClassFromListByName(strings[i], TeamFightTacticsTracker.allOriginClasses);
            OriClassList.add(oc);
            oc.addChampion(this);
        }
        
        stock = champNums[cost-1];
    }
    
    
    public static Champion getChampionByName(String name)
    {
        //Yeah this could be done way differently but whatever
        for(int i = 0; i< TeamFightTacticsTracker.allChamps.size(); i++)
        {
            if(TeamFightTacticsTracker.allChamps.get(i).name.equals(name))
                return TeamFightTacticsTracker.allChamps.get(i);
        }
        return null;
    }
    
    /**
     * Returns all champions of a given cost, from a given array list
     * @param cost Cost of champions we want
     * @param champList The list of champs to search for
     * @return A list of all champions that meat the criteria 
     */
    public static ArrayList<Champion> getAllChampsByCost(int cost, ArrayList<Champion> champList)
    {
        //not the best way to do this, but whatever
        ArrayList<Champion> ret = new ArrayList<>();
        for(int i = 0; i< champList.size(); i++)
        {
            if(champList.get(i).getCost()==cost)
                ret.add(champList.get(i));
        }
        
        return ret;
    }
    
    /**
     * Returns all champions of a given cost, from the list of all champions.
     * @param cost Cost of the champions we want
     * @return The list of champions
     */
    public static ArrayList<Champion> getAllChampsByCost(int cost)
    {
        return getAllChampsByCost(cost, TeamFightTacticsTracker.allChamps);
    }
    
    public static ArrayList<Champion> getAllChampionsByOriginClass(OriginClass oriClass, ArrayList<Champion> champList)
    {
        ArrayList<Champion> ret = new ArrayList<>();
        for(int i = 0; i<champList.size(); i++)
        {
            if (champList.get(i).getOriClassList().contains(oriClass))
                ret.add(champList.get(i));
        }
        
        return ret;
    }
    
    public static ArrayList<Champion> getAllChampionsByOriginClass(OriginClass oriClass)
    {
        return getAllChampionsByOriginClass(oriClass, TeamFightTacticsTracker.allChamps);
    }

    
    
    public void consumeStock(int star)
    {
        stock -= LEVELSTOCK[star-1];
    }
    
    public void returnStock(int star)
    {
        stock += LEVELSTOCK[star-1];
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public int getCost() {
        return cost;
    }
    
    public int getStock() {
        return stock;
    }
    
    /**
     * @return the OriClassList
     */
    public ArrayList<OriginClass> getOriClassList() {
        return OriClassList;
    }

    /**
     * @param OriClassList the OriClassList to set
     */
    public void setOriClassList(ArrayList<OriginClass> OriClassList) {
        this.OriClassList = OriClassList;
    }
   
}
