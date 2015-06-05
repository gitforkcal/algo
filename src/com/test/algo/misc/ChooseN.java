package com.test.algo.misc;

/**
 * @author Rahul
 */
public class ChooseN {

    public static void main(String [] argv) {
        char [] input = {'+','-','*','/'};
        int choose = 2;
        char [] out = new char[choose];
        choose(input,0,0,choose,out);
    }

    private static void choose(char[] input,int readIndex,int writeIndex, int choose, char[] out) {
        if(writeIndex == choose) {
            print(out);
            return;
        }

        if(readIndex == input.length){
            //print(out);
            return;
        }
        out[writeIndex] = input[readIndex];
        choose(input, readIndex +1, writeIndex+1,choose, out);
        choose(input, readIndex +1, writeIndex,choose, out);
    }

    private static void print(char[] out) {
        for(char c : out) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
