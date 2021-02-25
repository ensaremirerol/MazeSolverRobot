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
    
    public int getBlock(int x, int y){
        return maze[y][x];
    }
}
