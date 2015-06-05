package com.test.algo.misc;

import java.util.Arrays;

/**
 *
 * @author Rahul Bhattacharjee
 */
public class ProperBrackets {

    private static void printAllCombo(int left, int right, char[] data, int count) {
        if(left>right){
            return;
        }
        if(count == 4) {
            System.out.println("Print "+ Arrays.toString(data));
            return;
        }
        for(int i = 0 ; i < left ; i++) {
            data[count] = '(';
            printAllCombo(left-1, right, data, count+1);
        }
        for(int i = 0 ; i < right ; i++) {
            data[count] = ')';
            printAllCombo(left, right-1, data, count+1);
        }
    }

    /**
     *
     * @param argv
     */
    public static void main(String [] argv) {
        char [] data = new char[4];
        printAllCombo(2,2,data,0);
    }
}
