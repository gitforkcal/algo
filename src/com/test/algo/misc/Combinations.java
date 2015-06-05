package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author
 */
public class Combinations {
    // number of permutations possible with 2 A's and 3 B's.


    public static void permutations(char first , int noOffirst , char second , int noOfSecond ,
                                         char [] buffer , int count) {
        if(count == 5){
            System.out.println("Print : " + Arrays.toString(buffer));
            return;
        }

        for(int i = 0 ; i < noOffirst; i++) {
            buffer[count] = first;
            permutations(first, noOffirst-1, second, noOfSecond, buffer, count+1);
        }

        for(int i = 0 ; i < noOfSecond; i++) {
            buffer[count] = second;
            permutations(first, noOffirst, second, noOfSecond-1, buffer, count+1);
        }
    }

    public static void main(String [] argv) {
        char [] data = new char[5];
        permutations('a',3,'b',2,data,0);
    }
}
