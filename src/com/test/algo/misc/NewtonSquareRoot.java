package com.test.algo.misc;

/**
 * @author Rahul
 */
public class NewtonSquareRoot {

    public static void main(String [] args) {
        float number = 142.0f;
        float error = .00000005f;

        System.out.println(sqrt(1.0f, number, error));
    }

    private static float sqrt(float old,float number, float error) {
        float newNumber = (old + number/old)/2;
        if(Math.abs(newNumber - old) < error) {
            return newNumber;
        } else {
            return sqrt(newNumber,number,error);
        }
    }
}
