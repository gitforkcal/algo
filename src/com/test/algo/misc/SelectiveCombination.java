package com.test.algo.misc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul
 */
public class SelectiveCombination {

    public static void getCombination(int [] data , List<Integer> buf , int index , int sum , int count) {
        int length = data.length;

        if(index == length) {
            return;
        }

        if(count == 0 && sum(buf) == sum) {
            System.out.println(buf);
        }

        buf.add(data[index]);
        getCombination(data, buf, index+1, sum, (count-1));

        // remove last;
        buf.remove(buf.size()-1);
        getCombination(data, buf, index+1, sum, count);
    }

    private static int sum(List<Integer> buf) {
        int sum = 0;
        for(Integer i : buf) {
            sum += i;
        }
        return sum;
    }

    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5,6,7};

        getCombination(data,new LinkedList<Integer>(),0,10,3);

    }
}
