package com.test.algo.misc;

/**
 * @author Rahul
 */
public class RotatedArray {

    public static void printElementInRotated(int [] data , int val) {
        findElementInRotated(data,0,data.length-1,val);
    }

    public static void findElementInRotated(int data[] , int low , int high, int val) {
        if(low < high) {
            int mid = (low+high)/2;
            if(data[mid] == val) {
                System.out.println("Index is " + mid);
            }
            if(data[low] < data[mid]) { //  left sorted
                if(data[low] <= val && data[mid] > val) {
                    findElementInRotated(data, low, mid-1, val);
                }else{
                    findElementInRotated(data, mid+1, high, val);
                }
            } else {
                if(val > data[mid] && val <= data[high]) {
                    findElementInRotated(data, mid+1, high, val);
                } else {
                    findElementInRotated(data, low, mid-1, val);
                }
            }
        }
    }

    public static int findMinimum(int [] data, int low , int high) {
        if(high < low){
            return data[0];
        }
        if(high == low){
            return data[0];
        }

        int mid = (low+high)/2;

        // mid is min.
        if(data[mid] < data[mid-1] && data[mid] < data[mid+1])
            return data[mid];

        if(data[mid] > data[mid+1])
            return data[mid+1];

        if(data[low] < data[mid]) {
            return findMinimum(data,mid+1,high);
        } else {
            return findMinimum(data, low, mid-1);
        }

    }

    public static void main(String [] argv) {
        int [] data = {6,7,8,9,1,2,3,4,5};
        //printElementInRotated(data,7);

        System.out.print(findMinimum(data,0, data.length-1));
    }
}
