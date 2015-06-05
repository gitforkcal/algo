package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class PermutationNewCode {

    public static void permutation(int [] a , int k , int n) {
        if(k == (n-1)) {
            System.out.println(Arrays.toString(a));
            return;
        }
        int o = n-1;
        for(int i = k ; i < n ; i++) {
            swap(a,k,o);
            permutation(a,k+1,n);
            swap(a,k,o);
            o--;
        }
    }

    private static void swap(int [] a , int j , int k) {
        int t = a[j];
        a[j] = a[k];
        a[k] = t;
    }

    public static void main(String [] argv) {
        String a = null;
        String b = null;
        System.out.println(a==b);
        int [] data = {1,2,3};
        permutation(data,0,data.length);
    }
}
