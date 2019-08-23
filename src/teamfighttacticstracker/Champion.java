/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamfighttacticstracker;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Champion
{

    private String name;
    private int cost;
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
