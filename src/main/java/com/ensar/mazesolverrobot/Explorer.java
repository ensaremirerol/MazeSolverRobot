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
    private int currentWeight;
    private Maze maze;
    public TreeMaze graph = new TreeMaze();

    public Explorer(Maze maze, short startX, short startY){
        this.maze = maze;
        this.x = startX;
        this.y = startY;
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
    
    private short getSenorInfo(){
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

    private int decideDirection(){
        Vertex curr = graph.getCurr();
        short identifier = curr.identifier;

        if((identifier & Direction.NORTH) == Direction.NORTH && curr.edges[0] == null){
            return 0;
        }
        else if((identifier & Direction.EAST) == Direction.EAST && curr.edges[1] == null){
            return 1;
        }
        else if((identifier & Direction.SOUTH) == Direction.SOUTH && curr.edges[2] == null){
            return 2;
        }
        else if((identifier & Direction.WEST) == Direction.WEST && curr.edges[3] == null){
            return 3;
        }
        else return -1;
    }

    private boolean interrupt(){
        if (direction % 2 == 0) return maze.getBlock(x + 1, y) == 0 || maze.getBlock(x - 1, y) == 0;
        else return maze.getBlock(x, y + 1) == 0 || maze.getBlock(x, y - 1) == 0;
    }

    private void goBack(){
        Vertex curr = graph.getCurr();
        while (!((curr.identifier & Direction.NORTH) == Direction.NORTH && curr.edges[0] == null) ||
                ((curr.identifier & Direction.EAST) == Direction.EAST && curr.edges[1] == null) ||
                ((curr.identifier & Direction.SOUTH) == Direction.SOUTH && curr.edges[2] == null) ||
                ((curr.identifier & Direction.WEST) == Direction.WEST && curr.edges[3] == null)){
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < 4; i++){
                try{
                    if(minVal > graph.getOtherVertex(i).visitCounter){
                        minIndex = i;
                        minVal = graph.getOtherVertex(i).visitCounter;
                    }
                }
                catch(NullPointerException e){

                }
            }
            graph.changeVertex(minIndex);
            curr = graph.getCurr();
            curr.visitCounter++;
            x = curr.vX;
            y = curr.vY;

            System.out.println("x " + x);
            System.out.println("y " + y);
            System.out.println();
        }
    }



    public boolean explore(){
        graph.addVertex(direction, 0, getSenorInfo(), x, y);
        graph.getCurr().visitCounter++;
        while (graph.isThereNullEdge()){
            System.out.println("x " + x);
            System.out.println("y " + y);
            System.out.println();
            direction = decideDirection();
            if (direction == -1){
                goBack();
                continue;
            }
            goForward();
            while (!interrupt() && goForward()){
                currentWeight++;
            }
            graph.addVertex(direction, currentWeight, getSenorInfo(), x, y);
            graph.getCurr().visitCounter++;
            currentWeight = 0;
        }
        return true;
    }
}
