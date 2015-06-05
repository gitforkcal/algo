package com.test.algo.misc;


/**
 * @author Rahul Bhattacharjee
 */
public class GraphColoringProblem {

    public static void main(String [] arguments) {
        int [][] graph = {{1,0,0,1},{1,1,1,0},{0,0,1,1},{1,0,0,1}};

        int [] colors = new int[4];
        for(int c = 0 ; c < colors.length ; c++) {
            colors[c] = -1;
        }

        colorGraph(graph,colors,0,5);

        System.out.println("Color of node A " + colors[0]);
        System.out.println("Color of node B " + colors[1]);
        System.out.println("Color of node C " + colors[2]);
        System.out.println("Color of node D " + colors[3]);
    }

    private static void colorGraph(int[][] graph, int [] colors,int nodeIndex,int noOfColors) {
        int length = colors.length;
        int color = getNextAvailableColor(graph,nodeIndex,colors,noOfColors);
        if(color == -1) {
            return;
        } else {
            colors[nodeIndex] = color;
            if(nodeIndex == (length-1)) {
                print(colors);
                System.exit(0);
            } else {
                colorGraph(graph, colors, nodeIndex+1,noOfColors);
            }
        }
    }

    private static void print(int [] vals) {
        for(int val : vals) {
            System.out.print(" " + val);
        }
    }

    private static int getNextAvailableColor(int[][] graph,int nodeIndex,int[] colors,int noOfColors) {
        int [] edges = graph[nodeIndex];
        for(int color = 0 ; color < noOfColors ; color++) {
            boolean found = true;
            for(int node = 0 ; node < edges.length ; node++) {
                if(node == nodeIndex){
                    continue;
                }
                if(edges[node] == 1) {
                    if(colors[node] == color) {
                        found = false;
                        break;
                    }
                }
            }
            if(found == true){
                return color;
            }
        }
        return -1;
    }
}
