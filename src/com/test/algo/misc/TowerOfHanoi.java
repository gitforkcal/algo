package com.test.algo.misc;

/**
 * @author Rahul
 */
public class TowerOfHanoi {

    public static void move(int count ,char source , char intermediate , char destination) {
        if(count == 0){
            return;
        }
        move(count-1, source, destination, intermediate);
        System.out.println("Move ring from " + source  + " to " + destination);
        move(count-1, intermediate, source , destination);

    }

    public static void main(String [] arguments) {
        move(2,'a','b','c');
    }
}
