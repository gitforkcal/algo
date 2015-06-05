package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class CircularQueueUsingArray {

    private int size;
    private int front,rear,count;
    int [] data;

    public CircularQueueUsingArray(int size) {
        this.size = size;
        this.front = this.rear = this.count = 0;
        this.data = new int[size];
    }

    //get and advance.
    public int get() {
        if(count == 0) {
            System.out.println("empty queue.");
            return -1;
        }
        int val = data[front];
        count--;
        front = (front+1)%size;
        return val;
    }


    // put and advance
    public void put(int val) {
        if(count == size){
            System.out.println("No more space to put item.");
            return;
        }
        data[rear] = val;
        rear = (rear+1)%size;
        count++;
    }

    public void print() {
        System.out.println("Front " + front);
        System.out.println("Rear " + rear);
        System.out.println("Size " + size);
        System.out.println("Count " + count);
        System.out.println("List " + Arrays.asList(data));
    }


    public static void main(String [] arg) {
        CircularQueueUsingArray queueUsingArray = new CircularQueueUsingArray(5);
        queueUsingArray.print();

        queueUsingArray.put(1);
        queueUsingArray.put(2);
        queueUsingArray.put(3);
        queueUsingArray.put(4);
        queueUsingArray.put(5);
        queueUsingArray.put(6);

        queueUsingArray.print();

        System.out.println(queueUsingArray.get());
        System.out.println(queueUsingArray.get());
        System.out.println(queueUsingArray.get());

        queueUsingArray.print();
    }
}
