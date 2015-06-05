package com.test.algo.misc;

/**
 * @author Rahul
 */
public class PalindromeRecursive {

    public static void main(String [] argv) {
        System.out.print(palindrome("abcdcjba"));
    }

    private static boolean palindrome(String test) {
        int len  = test.length();
        char [] data = test.toCharArray();
        return palindrome(data,0,len-1);
    }

    private static boolean palindrome(char[] data, int start, int end) {
        if(start>end) {
            return true;
        }

        if(start == end) {
            return true;
        }
        if(data[start] != data[end]) {
            return false;
        }
        return palindrome(data, start+1, end-1);

    }
}
