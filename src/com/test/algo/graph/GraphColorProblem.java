package com.test.algo.graph;

import com.test.algo.graph.impl.Color;
import com.test.algo.graph.impl.Graph;
import com.test.algo.graph.impl.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul
 */
public class GraphColorProblem {

    public Graph getGraph() {
        Graph graph = new Graph();
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        List<Node> adA  = new ArrayList<Node>();
        adA.add(nodeB);
        adA.add(nodeC);

        List<Node> adB = new ArrayList<Node>();
        adB.add(nodeD);
        adB.add(nodeE);

        List<Node> adC = new ArrayList<Node>();
        adC.add(nodeE);

        List<Node> adD = new ArrayList<Node>();

        nodeA.setConnectedNodes(adA);
        nodeB.setConnectedNodes(adB);
        nodeC.setConnectedNodes(adC);
        nodeA.setConnectedNodes(adD);

        List<Node> allNodes = new ArrayList<Node>();
        allNodes.add(nodeA);
        allNodes.add(nodeB);
        allNodes.add(nodeC);
        allNodes.add(nodeD);
        allNodes.add(nodeE);

        graph.setNodes(allNodes);

        return graph;
    }

    public Graph getGraph1() {
        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        List<Node> aList = new LinkedList<Node>();
        aList.add(nodeB);
        aList.add(nodeC);
        aList.add(nodeD);
        aList.add(nodeE);
        nodeA.setConnectedNodes(aList);

        List<Node> bList = new LinkedList<Node>();
        bList.add(nodeA);
        bList.add(nodeC);
        bList.add(nodeD);
        nodeB.setConnectedNodes(bList);

        List<Node> cList = new LinkedList<Node>();
        cList.add(nodeA);
        cList.add(nodeB);
        cList.add(nodeE);
        nodeC.setConnectedNodes(cList);

        List<Node> dList = new LinkedList<Node>();
        dList.add(nodeB);
        dList.add(nodeA);
        dList.add(nodeE);
        nodeD.setConnectedNodes(dList);

        List<Node> eList = new LinkedList<Node>();
        eList.add(nodeD);
        eList.add(nodeA);
        eList.add(nodeC);
        nodeE.setConnectedNodes(eList);

        List<Node> allNodes = new ArrayList<Node>();
        allNodes.add(nodeA);
        allNodes.add(nodeB);
        allNodes.add(nodeC);
        allNodes.add(nodeD);
        allNodes.add(nodeE);

        graph.setNodes(allNodes);
        return graph;
    }

    public static Color getColor(Node node) {
        List<Node> childs = node.getConnectedNodes();
        Color color = null;
        Color [] availableColors = Color.values();

        for(Color currentColor : availableColors) {
            if(currentColor == Color.NA){
                continue;
            }
            color = currentColor;
            for(Node current : childs) {
                if(current.getColor() == currentColor) {
                    color = Color.NA;
                    break;
                }
            }
        }

        return color;
    }

    public static boolean isValidColor(Node node,Color color) {
        List<Node> childs = node.getConnectedNodes();
        if(color == Color.NA){
            return false;
        }
        for(Node current : childs) {
            if(current.getColor() == color) {
                return false;
            }
        }
        return true;
    }

    public static void colorGraph(Graph graph) {
        List<Node> nodeList = graph.getNodes();
        int size = nodeList.size()-1;
        for(int i = 0 ; i < size ; i++) {
            //colorNode(nodeList.get(i),i,size);
        }
    }

    public static void colorNode(Node node , int id , int size,List<NodeColorPair> pairs) {
        Color color = getColor(node);
        if(color != Color.NA) {
            node.setColor(color);
        }
        if(id == size) {

        }
    }


    // Note: This is the core to the problem.
    // retry using different colors and check if the adjecent nodes
    // should not be of the same color.

    static int SIZE = 4;
    static int [] nodeColor = null;

    public static void colorNode(int index ) {
        do {
            Color color = getColor(getNodeForIndex(index));
            if(color == null) {
                return;
            } else {
                if(index == SIZE) {
                    printColors();
                } else {
                    colorNode(index+1);
                }
            }
        } while (true);
    }

    private static void printColors() {

    }

    private static Node getNodeForIndex(int index) {
        return null;
    }

    public static class NodeColorPair {
        private Node node;
        private Color color;

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

}
