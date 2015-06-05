package com.test.algo.misc;

/**
 * @author Rahul
 */
public class RemoveDuplicate {

    public static void main(String [] argv) {
        System.out.println(new String(removeDuplicate("aavvbdgdddd".toCharArray())));
    }

    private static char[] removeDuplicate(char[] chars) {
        int [] cache = new int[256];
        int count = 0;
        char[] ret = new char[chars.length];
        for(char currentChar : chars ) {
            if(cache[currentChar] != 1) {
                cache[currentChar] = 1;
                ret[count++] = currentChar;
            }
        }
        return ret;
    }
}
