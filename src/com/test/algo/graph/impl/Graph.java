package com.test.algo.graph.impl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 1/19/14
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {

    private List<Node> nodes;
    public Graph(){}

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
