package com.test.algo.misc;

public class Solutions {

    // Some constants for the Class.
    public static final int BLOCK = 0;
    public static final int FREE = 1;
    public static final int VISITING = 2;


    static int numberOfPaths(int [][]a,int M,int N) {
        ResultHolder resultHolder = new ResultHolder();
        findExit(a,0,0,M,N,resultHolder);
        return resultHolder.getTotalPaths();
    }


    /**
     * This function navigates through the maze and increments result holder with 1 , each time it reached cell
     * row-1,col-1. This method uses backtracking algorithms to find the exit to the maze.
     *
     */
    public static void findExit(int [] [] maze ,int x , int y, int row, int col ,ResultHolder holder) {
        if(x >= col || y >= row) {
            return;
        }
        if(x == col-1 && y == row-1) {
            holder.incrementPath();
            return;
        }

        if(maze[x][y] == VISITING || maze[x][y] == BLOCK) {
            return;
        }

        maze[x][y] = VISITING;

        // visit left in the maze.
        if(x+1 < row ) {
            findExit(maze,x+1,y,row,col,holder);
        }

        // vist down in the maze.
        if(y+1 < col) {
            findExit(maze,x,y+1,row,col,holder);
        }
        maze[x][y] = FREE;
    }

    /**
     * Class to keep track of number of exit paths possible.
     */
    private static class ResultHolder {
        private int paths;

        public void incrementPath(){
            paths +=1;
        }

        public int getTotalPaths() {
            return paths;
        }
    }

    public static void main(String [] argv) {

        int [] [] maze = {{1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}};

        System.out.println(numberOfPaths(maze, 3, 4));
    }

}
