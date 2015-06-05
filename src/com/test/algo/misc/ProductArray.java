package com.test.algo.misc;

/**
 * Created by Rahul on 2/28/15.
 */
public class ProductArray {

    public static void main(String [] argv) {
        int [] data = new int [] {1,2,3,4};
        int [] returnArray = getModifiedArray(data);
        getModifiedInPlace(data);
        print(data);
        //print(returnArray);
    }

    private static void getModifiedInPlace(int[] data) {
        int start = 0;
        int length = data.length;
        int end = data.length-1;

        int firstProduct = 1;
        int secondProduct = 1;

        for(int index = 0; index < length ; index++) {
            int temp = data[index];
            data[index] = firstProduct;
            firstProduct *= temp;
        }

        for(int index = length ; index >= 0 ; index++) {

        }
    }

    private static int[] getModifiedArray(int[] data) {
        int [] result = new int[data.length];

        int temp = 1;
        for(int i = 0 ; i < data.length; i++) {
            result[i] = temp;
            temp = temp* data[i];
        }

        temp = 1;
        for(int i = data.length-1 ; i >= 0; i--) {
            result[i] = result[i]* temp;
            temp = temp* data[i];
        }

        return result;
    }

    private static void print(int[] data) {
        for(int i = 0 ; i < data.length ; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
