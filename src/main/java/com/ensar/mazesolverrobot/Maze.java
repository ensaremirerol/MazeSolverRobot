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
public class Maze {
    private int maze [][];
    int x, y, direction;

    public Maze(int[][] maze, int startX, int startY) {
        this.maze = maze;
        this.x = startX;
        this.y = startY;
        direction = 0;
    }
    
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
                if (maze[y+1][x] == 0)y++;
                else return false;
                break;
            case 1:
                if (maze[y][x+1] == 0)x++;
                else return false;
                break;
            case 2:
                if (maze[y-1][x] == 0)y--;
                else return false;
                break;
            case 3:
                if (maze[y][x-1] == 0)x--;
                else return false;
                break;
            default:
                return false;
        }
        return true;
    }
}
