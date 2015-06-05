package com.test.algo.misc;

import java.util.Arrays;

public class PermutationOfSyombols {

    public static void main(String [] argv) {
        char [] symbols = {'+','-'};
        permutations(symbols);
    }

    private static void permutations(char[] symbols) {
        char [] output = new char[symbols.length];
        getPermutations(symbols,0,output);
    }

    private static void getPermutations(char[] symbols,int index, char[] output) {
        int length = symbols.length;
        if(index == length) {
            print(output);
            return;
        }

        for(char symbol : symbols) {
            output[index] = symbol;
            getPermutations(symbols,index+1, output);
        }
    }

    private static void print(char [] array) {
        for(char c : array) {
            System.out.print(c +" ");
        }
        System.out.println();
    }
}
