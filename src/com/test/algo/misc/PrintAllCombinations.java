package com.test.algo.misc;

/**
 * @author Rahul Bhattacharjee
 */
public class PrintAllCombinations {

    public static void printAllCombo(int left , int right , char[] data) {
        if(left == 0 && right == 0) {
            System.out.println(new String(data));
            return;
        }

        if(left > 0) {
            data[left] = '(';
            printAllCombo(left-1,right,data);
        }
        if(right > 0) {
            data[right] = ')';
            printAllCombo(left , right-1,data);
        }
    }

    /**
     *
     * @param argv
     */
    public static void main(String [] argv) {
        char [] data = new char[8];
        printAllCombo(2,2,data);
    }
}
