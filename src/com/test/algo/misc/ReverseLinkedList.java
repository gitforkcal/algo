package com.test.algo.misc;

import com.test.algo.list.ListUtil;
import com.test.algo.list.Node;

/**
 * @author Rahul Bhattacharjee
 */
public class ReverseLinkedList {

    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5,6,7,8,9};
        Node start = ListUtil.createList(data);

        start = reverseList(start);
        ListUtil.print(start);
    }

    private static Node reverseList(Node start) {
        Node a = start;
        Node b = start.getNext();
        Node c = null;
        if(b != null) {
            c = b.getNext();
        }
        boolean first = true;
        while(b != null && b.getNext() != null) {
            if(first) {
                a.setNext(null);
                first = false;
            }
            b.setNext(a);
            a=b;
            b=c;
            c = c.getNext();
        }
        return a;
    }
}
