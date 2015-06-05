package com.test.algo.misc;

/**
 * @author Rahul
 */
public class InsertionSort {

    public static void main(String [] argv) {
        int [] data = {3,6,1,2,5,7,9,8};
        print(data);
        insertionSort(data);
        print(data);
    }

    private static void insertionSort(int[] data) {
        for(int i = 0 ; i < data.length ; i++) {
            runCycle(data,i);
        }
    }

    private static void runCycle(int[] data, int index) {
        int val = data[index];
        int i = index-1;
        while(i>=0 && data[i] > val) {
            data[i+1] = data[i];
            i--;
        }
        data[i+1] = val;
    }

    public static void print(int[] data) {
        for(int i : data) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
