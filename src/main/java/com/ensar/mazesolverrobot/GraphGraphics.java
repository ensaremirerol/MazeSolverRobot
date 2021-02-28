package com.ensar.mazesolverrobot;

import java.awt.*;

public class GraphGraphics extends Canvas {
    int MULTIPILER = 50;
    HashTable vertexes;
    public GraphGraphics(HashTable vertexes){
        this.vertexes = vertexes;
    }
    public void paint(Graphics g){
        setBackground(Color.white);
        int name = 0;
        for(Hashable data: vertexes){
            Vertex vertex = (Vertex) data;
            Vertex oVertex;
            g.setColor(Color.black);
            g.drawOval(vertex.vX*MULTIPILER, vertex.vY * MULTIPILER,  MULTIPILER, MULTIPILER);
            g.drawString(Integer.toString(name++), vertex.vX*MULTIPILER, vertex.vY*MULTIPILER);
            for (int i = 0; i <4; i++){
                if(vertex.edges[i] != null){
                    oVertex = vertex.getVertex(i);
                    int xMid = (Math.abs(vertex.vX - oVertex.vX)/2);
                    int yMid = (Math.abs(vertex.vY - oVertex.vY)/2);
                    g.drawLine(vertex.vX*MULTIPILER +MULTIPILER/2, vertex.vY*MULTIPILER+MULTIPILER/2,
                            oVertex.vX*MULTIPILER+MULTIPILER/2, oVertex.vY*MULTIPILER+MULTIPILER/2);
                }
            }
        }
    }
}
