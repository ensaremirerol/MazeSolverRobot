package com.ensar.mazesolverrobot;

import javax.swing.*;
import java.util.Iterator;

public class MazeSolverRobotMain {
    public static void main(String[] args) {
        int [][] m =
                {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        Maze maze = new Maze(m);
        Explorer explorer = new Explorer(maze, (short)1,(short)1);
        explorer.explore();
        JFrame window = new JFrame("Graph");
        window.setSize(640,480);
        GraphGraphics graphics = new GraphGraphics((explorer.graph.getHashMap()));
        window.add(graphics);
        window.setVisible(true);
    }
}
