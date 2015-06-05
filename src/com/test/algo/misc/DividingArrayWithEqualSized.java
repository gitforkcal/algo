package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class DividingArrayWithEqualSized {

    private static void divide(int[] data) {
        boolean [] used = new boolean[data.length];
        int start = 0;
        int end = (data.length-1);

        int [] left = new int[data.length];
        int [] right = new int[data.length];

        for(int i = 0 ; i < data.length ; i++) {
            if(used[i] == true) {
                continue;
            } else {
                int first = i;
                int last  = findNearest(data,used,first);

                if(last == -1) {
                    left[start++] = data[i];
                    break;
                }

                if(sum(left) < sum(right)) {
                    left[start++] = Math.max(data[first],data[last]);
                    right[end--]  = Math.min(data[first],data[last]);
                } else {
                    left[start++] = Math.min(data[first],data[last]);
                    right[end--]  = Math.max(data[first],data[last]);
                }
            }
        }
        print(left);
        print(right);
    }

    public static int sum(int [] data) {
        int sum = 0;
        for(int i = 0 ; i < data.length ; i++) {
            sum += data[i];
        }
        return sum;
    }

    public static int findNearest(int [] data , boolean [] used ,int index) {
        int minData = Integer.MAX_VALUE;
        int retIndex = Integer.MAX_VALUE;

        used[index] = true;
        for(int i = 0 ; i < data.length ; i++) {
            if(used[i] == true) {
                continue;
            }
            if(Math.abs(data[i] - data[index]) < minData) {
                minData = Math.abs(data[i] - data[index]);
                retIndex = i;
                //used[retIndex] = true;
            }
        }
        if(retIndex == Integer.MAX_VALUE) {
            return -1;
        }
        used[retIndex] = true;
        return retIndex;
    }

    public static void print(int [] data) {
        System.out.println("Print : "+ Arrays.toString(data));
    }

    public static void main(String [] argv) {
        int [] data = {3,8,4,1,7,2,5,6,9};
        divide(data);
    }
}
