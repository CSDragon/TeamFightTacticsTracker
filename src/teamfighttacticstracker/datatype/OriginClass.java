/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker.datatype;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class OriginClass 
{

    private String name;
    private ArrayList<Integer> levels;
    private ArrayList<Champion> champList;
    
    public OriginClass(String _name, ArrayList<Integer> _levels)
    {
        name = _name;
        levels = _levels;
        champList = new ArrayList<>();
    }
    
    public OriginClass(String s)
    {
        String[] strings = s.split(",");
        ArrayList<Integer> _levels = new ArrayList<>();
        champList = new ArrayList<>();
        for(int i = 1; i<strings.length; i++)
            _levels.add(Integer.parseInt(strings[i]));
        
        name = strings[0];
        levels = _levels;
    }
    
    public void addChampion(Champion c)
    {
        champList.add(c);
    }
    
    
    /**
     * Returns the Origin or Class with the given name
     */
    public static OriginClass getOriginClassFromListByName(String name, ArrayList<OriginClass> list)
    {
        //brute force, but given the size of the objects involved, this is not a big deal.
        for(int i = 0; i<list.size(); i++)
        {
            if (list.get(i).getName().equals(name))
                return list.get(i);
        }
        
        return null;
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

    /**
     * @return the levels
     */
    public ArrayList<Integer> getLevels() {
        return levels;
    }

    /**
     * @param levels the levels to set
     */
    public void setLevels(ArrayList<Integer> levels) {
        this.levels = levels;
    }

    /**
     * @return the champList
     */
    public ArrayList<Champion> getChampList() {
        return champList;
    }

    /**
     * @param champList the champList to set
     */
    public void setChampList(ArrayList<Champion> champList) {
        this.champList = champList;
    }
    
    
    
}
