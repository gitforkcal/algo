package com.test.algo.list;

/**
 * @author Rahul
 */
public class MedianFromSortedLists {

    // There are two sorted lists of equal size. Find the median of the combined list.
    public static float findMedian(int [] data , int start , int end) {
        float sum = 0;
        for(int i = start; i <= end; i++) {
            sum += data[i];
        }
        return sum/(end-start+1);
    }

    public static float findMedian(int [] data1 , int start1 , int end1, int [] data2, int start2 , int end2) {
        System.out.println("start1 = " + start1 + " end1 = " + end1 + " , start2 = " + start2 +" , end2= " +end2);

        int n = (end1-start1)+1;

        if(n ==1) {
            return (data1[start1] + data2[start1])/2.0f;
        }

        if(n ==2) {
            System.out.println("data1 => " + data1 [start1] + " , " + data1 [end1]);
            System.out.println("data2 => " + data2 [start2] + " , " + data2 [end2]);
            int sum = ((Math.max(data1[start1],data2[start2]) + Math.min(data1[end1],data2[end2])));
            return sum/2.0f;
        }

        float med1 = findMedian(data1,start1,end1);
        float med2 = findMedian(data2,start2,end1);

        System.out.println("Median a = " + med1 + " , b = " + med2);

        if(med1 == med2) {
            return med1;
        } else if(med1 > med2) {
            int midElement1 = ((end1-start1+1)/2)+start1;
            int midElement2 = ((end2-start2+1)/2)+start2;
            return findMedian(data1,start1,midElement1,data2,midElement2,end2);
        } else {
            int midElement1 = ((end1-start1+1)/2)+start1;
            int midElement2 = ((end2-start2+1)/2)+start2;
            System.out.println("Mid elements are " + midElement1 + " , " + midElement2);
            return findMedian(data1,midElement1,end1,data2,start2,midElement2-1);
        }
    }

    public static void main(String [] argv) {
        //int [] data = {1,2,3,4,5,6};
        //System.out.println("Median " + findMedian(data,0,2));
        int [] data1 = {1,3,5,7};
        int [] data2 = {2,4,6,8};
        System.out.println("Median => " + findMedian(data1,0,data1.length-1,data2,0,data2.length-1));
    }
}
