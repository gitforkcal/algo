package com.test.algo.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1. bfs
 * 2.dfs
 * 3.dfs - stack
 * 4.cycle detection.
 * 5.path from node a to b
 */
public class BFS {

    public static void main(String[] argv) {
        Graph g = getGraph();
        //bfs(g);
        //dfs(g);
        //g = getGraph();
        //System.out.println();
        //dfsWithoutRecursion(g);

        cycleDetection(g);
    }

    private static void cycleDetection(Graph g) {

    }

    private static void dfsWithoutRecursion(Graph g) {
        Stack<Vertex> stack = new Stack<Vertex>();
        stack.add(g.getFirstNode());

        while(!stack.isEmpty()) {
            Vertex v = stack.pop();
            if(v.isVisited()) {
                continue;
            }
            System.out.print(v.getData() + " ");
            v.setVisited(true);
            stack.addAll(v.getVirtexs());
        }
    }

    private static void dfs(Graph g) {
        dfsNode(g.getFirstNode());
    }

    private static void dfsNode(Vertex firstNode) {
        if(firstNode.isVisited()) {
            return;
        }
        System.out.print(firstNode.getData()+ " ");
        firstNode.setVisited(true);
        for(Vertex v : firstNode.getVirtexs()) {
            dfsNode(v);
        }
    }

    private static void bfs(Graph g) {
        Vertex v = g.getFirstNode();
        Queue queue = new LinkedList();
        queue.add(v);

        while(!queue.isEmpty()) {
            Vertex current = (Vertex) queue.poll();
            if(current.isVisited()) {
                return;
            }
            System.out.print(current.getData()+ " ");
            current.setVisited(true);
            queue.addAll(current.getVirtexs());
        }
    }

    public static Graph getGraph() {
        Graph g = new Graph();
        Vertex one = new Vertex();
        Vertex two = new Vertex();
        Vertex three = new Vertex();
        Vertex four = new Vertex();
        Vertex five = new Vertex();
        Vertex six = new Vertex();

        one.setData(1);
        one.setVirtexs(two);
        one.setVirtexs(five);
        g.addVirtex(one);

        two.setData(2);
        two.setVirtexs(three);
        two.setVirtexs(six);
        g.addVirtex(two);

        three.setData(3);
        g.addVirtex(three);

        four.setData(4);
        four.setVirtexs(one);
        g.addVirtex(four);

        five.setData(5);
        five.setVirtexs(four);
        five.setVirtexs(six);
        g.addVirtex(five);

        six.setData(6);
        g.addVirtex(six);
        return g;
    }
}
