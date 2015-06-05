package com.test.algo.heap;

/**
 * @author Rahul
 */
public class HeapSort {

    public static void main(String [] argv) {
        int data [] = {6,1,10,2,3,9,8,7,5,4};
        //int data [] = {1,2,3,4,5,6,7,8,9,10};

        print(data);

        heapsort(data);

        print(data);
    }

    private static void heapsort(int[] data) {
        int length = data.length-1;
        int lastRoot = (length-1)/2;

        for(int i = lastRoot ; i >= 0 ; i--) {
            heapify(data,i,length);
        }

        int last = length;
        for(int i = last ; i > 0 ; i--) {
            swap(data,0,i);
            heapify(data,0,i-1);
        }
    }

    private static int getProperMid(int n) {
        return (n-1)/2;
    }

    private static void heapify(int[] data, int index, int endRange) {
        int leftIndex = 2*index+1;
        int rightIndex = 2*index+2;

        int rootData = data[index];
        int leftData = -1;
        int rightData = -1;

        if(leftIndex <= endRange) {
            leftData = data[leftIndex];
        }
        if(rightIndex <= endRange) {
            rightData = data[rightIndex];
        }

        boolean isLeftLarge = leftData > rightData ? true : false;

        int swapIndex = index;

        if(isLeftLarge) {
            if(leftData != -1 && rootData < leftData) {
                swapIndex = leftIndex;
            }
        } else {
            if(rightData != -1 && rootData < rightData) {
                swapIndex = rightIndex;
            }
        }

        if(swapIndex != index) {
            swap(data,swapIndex,index);
            heapify(data, swapIndex,endRange);
        }

    }

    private static void print(int[] data) {
        for(int value : data) {
            System.out.print(" " + value);
        }
        System.out.println();
    }

    private static void swap(int [] data ,int a , int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
        return;
    }
}