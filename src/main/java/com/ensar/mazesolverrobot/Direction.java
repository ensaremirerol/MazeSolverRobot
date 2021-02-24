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
class NotDirection extends Exception{

    public NotDirection() {
        super("Direction value must be in between 0 and 3");
    }
    
}

public class Direction {
    public static short NORTH = 1;
    public static short EAST = 1 << 1;
    public static short SOUTH = 1 << 2;
    public static short WEST = 1 << 3;
    
    public static short direction2Indetifer(int direction) throws NotDirection{
        switch(direction){
            case 0:
                return NORTH;
            case 1:
                return EAST;
            case 2:
                return SOUTH;
            case 3:
                return WEST;
            default:
                throw new NotDirection();
        }
    }
    
    public static int reverseDirection(int direction){
        return (direction + 2) % 4;
    }
}
