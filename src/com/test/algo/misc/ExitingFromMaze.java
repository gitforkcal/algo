package com.test.algo.misc;

/**
 * @author Rahul Bhattacharjee
 */
public class ExitingFromMaze {

    int BLOCK = 0;
    int FREE = 1;
    int EXIT = 9;
    int VISITING = 2;

    // 1 1 1 0
    // 0 0 1 0
    // 0 1 1 0
    // 0 1 1 9

    int [] [] maze = {{1,1,1,0},
                      {0,0,1,0},
                      {0,1,1,0},
                      {0,1,1,9}};

    public void printMaze()  {
        System.out.println("=====");
        for(int i = 0 ; i < 4 ; i++) {
            for(int j = 0 ; j < 4 ; j++) {
                System.out.print(" " + maze[i][j]);
            }
            System.out.println("");
        }
    }

    public void findExit(int i , int j) {
        if(maze[i][j] == EXIT) {
            printMaze();
            return;
        }

        if(maze[i][j] == VISITING || maze[i][j] == BLOCK) {
            return;
        }

        maze[i][j] = VISITING;

        if(i+1 < 4 ) {
            findExit(i+1,j);
        }

        if(i-1 >= 0 ) {
            findExit(i-1,j);
        }

        if(j+1 < 4 ) {
            findExit(i,j+1);
        }

        if(j-1 >=0 ) {
            findExit(i,j-1);
        }

        maze[i][j] = FREE;
    }

    public static void main(String [] ar) {
        ExitingFromMaze maze = new ExitingFromMaze();
        maze.printMaze();

        System.out.println("=====");

        maze.findExit(0,0);
    }
}
