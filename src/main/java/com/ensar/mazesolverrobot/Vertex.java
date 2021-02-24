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
public class Vertex{
    Edge edges [] = new Edge[4];
    boolean start, end;
    public short identifer;

    public Vertex(short identifer) {
        this.identifer = identifer;
    }
    
    public Vertex getVertex(int direction){
        Edge edge = edges[direction];
        return edge.v1 != this? edge.v1:edge.v2;
    }
    
    public void setEdge(Edge edge, int direction){
        edges[direction] = edge;
    }
}

