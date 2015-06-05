package com.test.algo.misc;

public class FindingLongestFlips {

    private static int [] data = {0,0,0,0,1,0,1,0,1,0,1,1,1};

    public static void main(String [] argv) {
        findMax(data);
    }

    private static void findMax(int[] data) {
        int maxTillNow = 1;
        int currentMax = 1;
        int lastNum = data[0];

        for(int i = 1; i < data.length ; i++) {
            int num = data[i];
            if(lastNum == num) {
                if(currentMax > maxTillNow) {
                    maxTillNow = currentMax;
                }
                currentMax = 1;
            } else {
                currentMax++;
                lastNum = num;
            }
        }
        if(currentMax>maxTillNow) {
            maxTillNow = currentMax;
        }
        System.out.println(maxTillNow);
    }
}
