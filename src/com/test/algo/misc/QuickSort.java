package com.test.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rahul Bhattacharjee
 */
public class QuickSort {

    private static int data [] = {6,1,9,2,3,9,8,7,5,4};

    private static void quickSort(int [] data , int left , int right) {
        if(right-left < 0) {
            return;
        }

        int pivot = data[right];
        int p = left;

        for(int i = left ; i < right ; i++) {
            if(data[i] <= pivot) {
                swap(data,i,p++);
            }
        }
        swap(data,p,right);

        //System.out.print("partition index " + p + " value is " + data[p]);

        quickSort(data, left, p-1);
        quickSort(data, p+1, right);

    }

    public static int [] mergeSort(int [] data, int start , int end) {
        //System.out.println("Invoked with end " + end + " start " + start);
        //if(end-start==0) {
        //    return new int[0];
        //}

        if(start == end) {
            int a [] = new int[1];
            a[0] = data[start];
            return a;
        }

        if((end-start) ==1) {
            int [] r = new int[2];
            if(data[start] < data[end]) {
                r[0] = data[start];
                r[1] = data[end];
            } else {
                r[0] = data[end];
                r[1] = data[start];
            }
            return r;
        }

        int mid = (end+start)/2;

        System.out.println("start " + start + " end " + end + " mid => " + mid);

        int[] a = mergeSort(data, start, mid);
        int[] b = mergeSort(data, mid+1, end);

        return merge(a,b);
    }

    public static int[] merge(int [] a1 , int [] a2)  {
        int [] temp = new int[a1.length+a2.length];
        int i =0;
        int j =0;

        int f =0;
        while(i< a1.length && j < a2.length) {
            if(a1[i] < a2[j]) {
                temp[f++] = a1[i++];
            } else {
                temp[f++] = a2[j++];
            }
        }
        while(i < a1.length) {
            temp[f++] = a1[i++];
        }
        while(j < a2.length) {
            temp[f++] = a2[j++];
        }
        return temp;
    }

    private static void swap(int [] data , int a , int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;
    }

    public static void print(int [] data) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i : data){
            list.add(i);
        }
        System.out.println(list);
    }

    public static void main(String [] argv) {
        print(data);

        quickSort(data,0,data.length-1);
        //data = mergeSort(data,0,data.length-1);

        print(data);
    }

    public static void main1(String []a ) {
        int x [] = {1,2,5,8,9};
        int y [] = {3,4,7,10};

        print(merge(x,y));
    }
}
