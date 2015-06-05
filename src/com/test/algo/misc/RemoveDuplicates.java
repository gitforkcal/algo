package com.test.algo.misc;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 11/27/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveDuplicates {

    public static void main(String [] argv) {

        System.out.println("Starting the removal of duplicate");

        String testString = "aabcccccccccccc";
        removeDuplicates(testString.toCharArray());

    }

    public static void removeDuplicates(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
               if (str[i] == str[j]) break;
            }

            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;

        System.out.println(new String(str));
     }

    private static void removeDuplicate1(String test) {
        System.out.println("original " + test);
        char[] data = test.toCharArray();
        char[] out = new char[data.length];
        boolean [] found = new boolean[26];
        int i = 0;

        for(char c : data) {
            if(found[c-'a'] != true) {
                found[c-'a'] = true;
                //System.out.print(c);
                out[i++] = c;
            }
        }

        System.out.println("removed string '" + new String(out)+"'");
    }
}
