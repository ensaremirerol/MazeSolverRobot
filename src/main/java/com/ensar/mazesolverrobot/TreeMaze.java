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

    public TreeMaze(Vertex start) {
        this.start = start;
        this.curr = start;
    }  
    
    public void addVertex(int currDirection, int weight, short identifer, short x, short y){
        Vertex nVertex = new Vertex(identifer, x, y);
        Edge nEdge = new Edge(weight, curr, nVertex);
        if(!hashMap.add(nVertex)){
            nVertex = (Vertex)hashMap.getCachedData();
        }
        curr.setEdge(nEdge, currDirection);
        nVertex.setEdge(nEdge, Direction.reverseDirection(currDirection));
        curr = nVertex;
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
