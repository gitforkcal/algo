package com.test.algo.dp;

/**
 * @author Rahul
 */
public class LongestCommonSubsequence {

    public static int longestSubsequence(char [] data1, int first , char [] data2 ,int second) {
        if(first < 0 || second < 0) {
            return 0;
        }
        if(data1[first] == data2[second]) {
            return 1 + longestSubsequence(data1,  first-1, data2,second-1);
        } else {
            return Math.max(longestSubsequence(data1, first-1, data2, second),
                    longestSubsequence(data1, first, data2, second-1));
        }
    }

    public static void main(String [] argv) {
        String first = "abcde";
        String second = "cxdxe";

        System.out.println(longestSubsequence(first.toCharArray(),first.toCharArray().length-1,
                second.toCharArray(),second.toCharArray().length-1));
    }
}
