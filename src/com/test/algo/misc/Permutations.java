package com.test.algo.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Rahul Bhattacharjee
 */
public class Permutations {

    public static void perm(int [] input,int [] out , int count) {
        int length = input.length;
        if(count == length) {
            print(out);
            return;
        }
        for(int i = 0 ; i < length ; i++) {
            out[count] = input[i];
            perm(input, out, count+1);
        }
    }

    private static void print(int[] input) {
        for(int a : input) {
            System.out.print(a + ",");
        }
        System.out.println("");
    }

    private static List<String> allPerm(String a) {
        if(a.isEmpty())
            return Arrays.asList("");

        char first = a.charAt(0);
        String rest = a.substring(1);

        return appendInEveryPosition(first,allPerm(rest));
    }

    private static List<String> appendInEveryPosition(char c, List<String> perms) {
        List<String> finalList = new ArrayList<String>();
        for(String perm : perms) {
            for(int i = 0 ; i <= perm.length() ; i++) {
                StringBuffer sb = new StringBuffer(perm);
                sb.insert(i, c);
                finalList.add(sb.toString());
            }
        }
        return finalList;
    }

    public static void main(String [] argv) {
        /*int [] input = {1,2,3};
        int [] out  = new int[3];
        perm(input,out, 0);*/

        //System.out.println("Print => " + appendInEveryPosition('a', Arrays.asList("bc")));
        System.out.println(allPerm("ab"));
    }
}
