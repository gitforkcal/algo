package com.test.algo.misc;


public class Median {

    public static void main(String [] argv) {
        int [] data1 = {1,2,3};
        int [] data2 = {4,5,6,7,8,9,10};

        //System.out.println("Median => " + getMedian(data1, data2));
        System.out.println("Median => " + getMedian1(data1, data2));
    }

    private static int getMedian(int[] data1, int[] data2) {
        int count = data1.length;
        int f = -1;
        int s = -1;

        int p1 = 0;
        int p2 = 0;

        for(int i = 0 ; i <= count;i++) {
            if(p1 == count) {
                f = s;
                s = data2[0];
                break;
            }
            if(p2 == count) {
                f = s;
                s = data1[0];
                break;
            }
            if(data1[p1] < data2[p2]) {
                f = s;
                s = data1[p1];
                p1++;
            } else {
                f = s;
                s = data2[p2];
                p2++;
            }
        }
        return (f+s)/2;
    }

    public static int getMedian1(int [] data1 , int [] data2) {
        int length1 = data1.length;
        int length2 = data2.length;

        int pointer1 = 0;
        int pointer2 = 0;

        int number1 = -1;
        int number2 = -1;

        int count = (length1+length2)/2;

        for(int i = 0 ; i <= count ; i++) {
            if(pointer1 == length1) {
                number1 = number2;
                number2 = data2[pointer2++];
            } else if (pointer2 == length2) {
                number1 = number2;
                number2 = data1[pointer1++];
            } else {
                number1 = number2;
                if(data1[pointer1] < data2[pointer2]) {
                    number2 = data1[pointer1++];
                } else {
                    number2 = data2[pointer2++];
                }
            }
        }
        if((length1+length2) % 2 == 0) {
            return (number1+number2)/2;
        } else {
            return number2;
        }
    }
}














