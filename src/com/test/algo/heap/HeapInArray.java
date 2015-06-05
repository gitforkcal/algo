package com.test.algo.heap;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class HeapInArray {

    public static void createHeap(int[] data) {
        for(int i = (data.length-1)/2 ; i >= 0 ; i--) {
            heapify(data,i,data.length-1);
        }
    }

    public static void heapSort(int [] data) {
        createHeap(data);
        for(int i = data.length-1 ; i > 0 ; i--) {
            swap(data,0,i);
            heapify(data,0,i-1);
        }
    }

    private static void heapify(int [] data, int start,int end) {
        int current = start;
        int left = (2*current)+1;
        int right = (2*current)+2;

        if(left > end && right > end){
            return;
        }

        if(left <= end && right > end) {
            if(data[left] > data[current]){
                swap(data,left,current);
            }
            return;
        }

        if(data[current] > data[left] && data[current] > data[right]) {
            return;
        }

        int largest = -1;

        if(data[left] > data[right]) {
            swap(data,left,current);
            largest = left;
        } else {
            swap(data,right,current);
            largest = right;
        }
        heapify(data, largest, end);
    }

    public static void swap(int [] data , int i , int j) {
        int val = data[i];
        data[i] = data[j];
        data[j] = val;
    }

    public static void print(int [] data) {
        System.out.println("Array " + Arrays.toString(data));
    }

    public static void main(String [] argv) {
        int [] data = {5,2,8,1,3,9,7,6};
        createHeap(data);
        print(data);
        heapSort(data);
        print(data);
    }
}
