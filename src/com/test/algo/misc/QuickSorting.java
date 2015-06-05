package com.test.algo.misc;

/**
 * @author Rahul
 */
public class QuickSorting {

    public static void main(String [] argv) {
        int data [] = {6,1,9,2,3,9,8,7,5,4};
        print(data);
        quickSort(data,0,data.length-1);
        print(data);
    }

    private static void quickSort(int[] data, int start, int end) {
        if(start > end) {
            return;
        }
        int pivotVal = data[end];
        int pivotIndex = start;

        for(int i = start ; i < end ; i++) {
            if(data[i] < pivotVal) {
                swap(data,pivotIndex,i);
                pivotIndex++;
            }
        }

        swap(data,end,pivotIndex);

        quickSort(data, start,pivotIndex-1);
        quickSort(data, pivotIndex+1, end);
    }

    private static void swap(int [] data , int one , int two) {
        int temp = data[one];
        data[one] = data[two];
        data[two] = temp;
        return;
    }

    private static void print(int [] data) {
        for(int a : data) {
            System.out.print(" " + a);
        }
        System.out.println();
    }
}
