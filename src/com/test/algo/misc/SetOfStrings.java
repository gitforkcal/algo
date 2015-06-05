package com.test.algo.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 12/2/13
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetOfStrings {

    static String [] inputs = {"a","b"};

    public static void addElementToEachOfTheElements(ArrayList<ArrayList<String>> superSet , String element) {
        ArrayList<ArrayList<String>> newSet = new ArrayList<ArrayList<String>>();

        for(ArrayList<String> collection : superSet) {
            ArrayList<String> colnedCollection = (ArrayList<String>) collection.clone();
            colnedCollection.add(element);
            newSet.add(colnedCollection);
        }
        superSet.addAll(newSet);
    }

    public static void printSets2(String [] inputs) {
        ArrayList<ArrayList<String>> superSet = new ArrayList<ArrayList<String>>();
        superSet.add(new ArrayList<String>());
        for(String element : inputs) {
            addElementToEachOfTheElements(superSet,element);
        }
        System.out.println(superSet);
    }

    public static void printSets1(ArrayList<ArrayList<String>> superSet, String [] inputs) {
        if(superSet.isEmpty()) {
            superSet.add(new ArrayList<String>());
        }

        for(String element : inputs) {
            ArrayList<ArrayList<String>> newSet = new ArrayList<ArrayList<String>>();
            for(ArrayList<String> item : superSet) {
                ArrayList<String> clone = (ArrayList<String>) item.clone();
                clone.add(element);
                newSet.add(clone);
            }
            superSet.addAll(newSet);
        }
    }

    private static void printSetOfStrings(String [] array) {
        int size = array.length;
        List<List<String>> sets = new ArrayList<List<String>>();

        int total = 1 << size;

        for(int k = 0 ; k < total ; k++) {
            List<String> subList = new ArrayList<String>();
            int current = k;
            int index = 0;

            while(current > 0){
                if((current & 1) == 1) {
                    subList.add(array[index]);
                }
                index++;
                current >>= 1;
            }

            sets.add(subList);
            //total--;
        }
        System.out.println("sets => " + sets);
    }



    public static void main(String [] argv) {
        ArrayList<ArrayList<String>> superSet = new ArrayList<ArrayList<String>>();

        //printSets1(superSet,inputs);
        //System.out.println("Sets " + superSet);
        //printSets2(inputs);

        printSetOfStrings(inputs);
    }
}
