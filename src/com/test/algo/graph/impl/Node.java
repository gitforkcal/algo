package com.test.algo.graph.impl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 1/19/14
 * Time: 11:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class Node {

    private List<Node> nodes;
    private String name;
    private Color color = Color.NA;

    public String getNodeName() {
        return this.name;
    }

    public Node(String name) {
        this.name = name;
    }

    public List<Node> getConnectedNodes() {
        return null;
    }

    public void setConnectedNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
