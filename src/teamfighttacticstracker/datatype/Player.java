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
public class Player 
{
    public static final int BOARD = 0;
    public static final int BENCH = 10;
    public static final int PLAYERLEVELS = 9;
    
    
    private int playerID;
    private int level;
    private ChessPiece[] board;
    
    public Player(int id)
    {
        playerID = id;
        board = new ChessPiece[20];
        level = 1;
    }
    
    public void addPiece(ChessPiece cp, int boardOrBench, int num)
    {
        if(board[num+boardOrBench] != null)
        {
            board[num+boardOrBench].remove();
            board[num+boardOrBench] = null;
        }
        
        board[num+boardOrBench] = cp;
    }
    
    public void addPiece(Champion champ, int star, int boardOrBench, int num)
    {
        ChessPiece cp = new ChessPiece(champ, star);
        addPiece(cp, boardOrBench,num);
    }
    
    public void clearnBoard(int boardOrBench)
    {
        for(int i = 0; i<10; i++)
        {
            if(board[i+boardOrBench] != null)
            {
                board[i+boardOrBench].remove();
                board[i+boardOrBench] = null;
            }
        }
    }    
    
    public void setLevel(int _level)
    {
        level = _level;
    }
}
