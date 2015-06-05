package com.test.algo.list;

/**
 * @author Rahul
 */
public class ListUtil {

    public static Node createList(int [] data) {
        Node first = null;
        Node last = null;
        for(int val : data) {
            Node fresh = new Node();
            fresh.setVal(val);
            if(last != null) {
                last.setNext(fresh);
            }
            if(first == null) {
                first = fresh;
            }
            last = fresh;
        }
        return first;
    }

    public static void print(Node first) {
        while(first != null) {
            System.out.print(first.getVal() + ",");
            first = first.getNext();
        }
        System.out.println("");
    }

    // unit test
    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5,6,7,8,9};
        Node first = createList(data);
        print(first);
    }
}
