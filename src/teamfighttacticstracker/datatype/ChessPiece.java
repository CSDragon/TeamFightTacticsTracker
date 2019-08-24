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
public class ChessPiece 
{
    private Champion champ;
    private int star;
    
    public ChessPiece(Champion c, int s)
    {
        champ = c;
        star = s;
        
        champ.consumeStock(star);
    }
    
    public void remove()
    {
        champ.returnStock(star);
    }
    
}
