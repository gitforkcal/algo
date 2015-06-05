package com.test.algo.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PermutationR {

    public static void main(String [] argv) {

        List<String> perm = getPermutations("abcde");
        //private static List<String> insertInAllPositions(String firstPart, String perm) {
        //List<String> perm = insertInAllPositions("x","abc");
        for(String a : perm) {
            System.out.println(a);
        }
    }

    private static List<String> getPermutations(String input) {
        if(input == null || input.length() == 0) {
            return Collections.emptyList();
        }
        if(input.length() == 1) {
            List<String> returnList = new ArrayList<String>();
            returnList.add(input);
            return returnList;
        }
        String firstPart = input.substring(0,1);
        String secondPart = input.substring(1);

        List<String> resultList = new ArrayList<String>();
        List<String> subPermuatation = getPermutations(secondPart);
        for(String perm : subPermuatation) {
            resultList.addAll(insertInAllPositions(firstPart,perm));
        }
        return resultList;
    }

    private static List<String> insertInAllPositions(String firstPart, String perm) {
        List<String> result = new ArrayList<String>();
        for(int i = 0 ; i <= perm.length(); i++) {
            String one = perm.substring(0,i);
            String two = perm.substring(i);
            result.add(one + firstPart + two);
        }
        return result;
    }
}
