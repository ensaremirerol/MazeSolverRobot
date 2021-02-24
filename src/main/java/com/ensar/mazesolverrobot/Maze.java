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
    private int maze [];
    int x, y, direction, mazeSide;

    public Maze(int[] maze, int startX, int startY) {
        this.maze = maze;
        mazeSide = (int) Math.sqrt(maze.length);
        this.x = startX;
        this.y = startY;
        direction = 0;
    }
    
    public boolean goForward(){
        
    }
    
    
    private int getIndex(int x, int y){
        return y * mazeSide + x;
    }
}
