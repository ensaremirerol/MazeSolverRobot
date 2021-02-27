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
    private int[][] maze;

    public Maze(int[][] maze) {
        this.maze = maze;
    }
    
    public int getBlock(int x, int y){
        return maze[y][x];
    }
}
