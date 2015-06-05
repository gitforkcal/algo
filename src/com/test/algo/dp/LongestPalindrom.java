package com.test.algo.dp;

/**
 * @author Rahul
 */
public class LongestPalindrom {

    public static int maxPalindrome(char [] data , int start , int end) {
        if(start == end) {
            return 1;
        }
        if(start+1 == end) {
            if(data[start+1] == data[end]) {
                return 2;
            } else {
                return 0;
            }
        }
        if(data[start] == data[end]) {
            return 2 + maxPalindrome(data, start+1, end-1);
        } else {
            return Math.max(maxPalindrome(data, start+1, end),maxPalindrome(data, start, end-1));
        }
    }

    public static void main(String [] argv) {
        String data = "abccba";
        System.out.println(maxPalindrome(data.toCharArray(),0,(data.length()-1)));
    }
}
