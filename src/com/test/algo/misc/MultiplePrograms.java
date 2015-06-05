package com.test.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rahul Bhattacharjee
 */
public class MultiplePrograms {

    private static void perm(char[] data) {
        char [] result = new char[data.length];
        perm(data,result,0);
    }

    private static void perm(char[] data, char[] result, int index) {
        int length = data.length;
        if(index == length) {
            print(result);
            return;
        }
        for(int i = 0 ; i < length ; i++) {
            result[index] = data[i];
            perm(data, result, index+1);
        }
    }

    private static void print(char[] data) {
        for(char c : data) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static void parenthisis(char[] data, int left, int right, int count) {
        if(right < left) {
            return;
        }
        if(right == 0 && left == 0) {
            print(data);
            return;
        }

        if(left > 0) {
            data[count] = '{';
            parenthisis(data, left-1, right, count+1);
        }

        if(right > 0) {
            data[count] = '}';
            parenthisis(data, left, right-1, count+1);
        }
    }

    public static void main(String [] argv) {
        //1. permutation problem.
        //char [] data = "ab".toCharArray();
        //perm(data);

        //2. parenthisis matching  problem.
        //char[] data = new char[6];
        //parenthisis(data,3,3,0);

        //3. n choose k combination problem.
        char [] elements = "abcd".toCharArray();
        char [] out = new char[elements.length];
        combination(elements,0,out,0,2);
    }

    private static void combination(char[] elements, int index ,char []result , int outIndex ,int noToChoose) {
        if(outIndex == noToChoose) {
            for(int i = 0 ; i < noToChoose ; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
            return;
        }
        if(index == elements.length) {
            return;
        }

        combination(elements, index+1, result, outIndex, noToChoose);

        result[outIndex] = elements[index];
        combination(elements, index+1, result, outIndex+1, noToChoose);
    }
}
