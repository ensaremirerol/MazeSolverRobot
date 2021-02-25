/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensar.mazesolverrobot;

/**
 *
 * @author ensar
 */
public class Explorer {
    private short x,y;
    private int direction = 0;
    private Maze maze;
    private TreeMaze graph = new TreeMaze();
    
    public boolean turnRight(){
        direction = (direction + 1) % 4;
        return true;
    }
    
    public boolean turnLeft(){
        direction = (direction - 1) % 4;
        return true;
    }
     
    public boolean goForward(){
        switch(direction){
            case 0:
                if (maze.getBlock(x, y+1) == 0)y++;
                else return false;
                break;
            case 1:
                if (maze.getBlock(x+1, y) == 0)x++;
                else return false;
                break;
            case 2:
                if (maze.getBlock(x, y-1) == 0)y--;
                else return false;
                break;
            case 3:
                if (maze.getBlock(x-1, y) == 0)x--;
                else return false;
                break;
            default:
                return false;
        }
        return true;
    }
    
    public short getSenorInfo(){
        short retVal = 0;
        if(maze.getBlock(x, y + 1) == 0){
            retVal |= Direction.NORTH;
        }
        if(maze.getBlock(x + 1, y) == 0){
            retVal |= Direction.EAST;
        }
        if(maze.getBlock(x, y - 1) == 0){
            retVal |= Direction.SOUTH;
        }
        if(maze.getBlock(x - 1, y) == 0){
            retVal |= Direction.WEST;
        }
        return retVal;
    }
    
    public boolean explore(){
        graph.addVertex(direction, 0, getSenorInfo(), x, y);
        return true;
    }
    
    public int decideDirection(){
        Vertex curr = graph.getCurr();
        short identifer = curr.identifer;
        
        if((identifer & Direction.NORTH) == 1 && curr.edges == null){
            return 0;
        }
        
        return -1;
    }
    
    
}
