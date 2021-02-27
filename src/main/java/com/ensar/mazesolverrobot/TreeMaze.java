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

public class TreeMaze {
     
    private Vertex start, curr, end;
    
    private HashMap hashMap = new HashMap();

    private int nullEdges = 0;

    public TreeMaze() {
    }  
    
    public void addVertex(int currDirection, int weight, short identifier, short x, short y){
        Vertex nVertex = new Vertex(identifier, x, y);
        if(start == null){
            start = nVertex;
            curr = nVertex;
            hashMap.add(nVertex);
            incrementNullEdge(identifier);
            return;
        }
        else if(!hashMap.add(nVertex)){
            nVertex = (Vertex)hashMap.getCachedData();
        }
        Edge nEdge = new Edge(weight, curr, nVertex);
        curr.setEdge(nEdge, currDirection);
        nVertex.setEdge(nEdge, Direction.reverseDirection(currDirection));
        curr = nVertex;
        incrementNullEdge(identifier);
        nullEdges--;
    }

    private void incrementNullEdge(short identifier){
        if((identifier & Direction.NORTH) == 1){
            nullEdges++;
        }
            if((identifier & Direction.EAST) == Direction.EAST){
            nullEdges++;
        }
        if((identifier & Direction.SOUTH) == Direction.SOUTH){
            nullEdges++;
        }
        if((identifier & Direction.WEST) == Direction.WEST){
            nullEdges++;
        }
    }

    public Vertex getOtherVertex(int index){
        return curr.edges[index].v1 == curr? curr.edges[index].v2:curr.edges[index].v1;
    }

    public boolean changeVertex(int index){
        curr = getOtherVertex(index);
        return true;
    }

    public boolean isThereNullEdge(){
        return nullEdges != 0;
    }
    
    public Vertex getCurr(){
        return curr;
    }
    
    public Vertex getStart(){
        return start;
    }
    
    public Vertex getEnd(){
        return end;
    }
    
    public void markAsEnd(){
        end = curr;
    }
    
}
