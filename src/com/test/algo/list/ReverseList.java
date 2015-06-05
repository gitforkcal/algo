package com.test.algo.list;

/**
 * @author Rahul
 */
public class ReverseList {

    // IMP : important set the first pointer to null.
    public static Node reverse(Node head) {
        Node first = head;
        Node second = first.getNext();
        boolean times = true;
        while(second != null) {
            Node third = second.getNext();
            second.setNext(first);
            if(times) {
                first.setNext(null);
                times = false;
            }
            first = second;
            second = third;
        }
        return first;
    }

    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5};
        Node first = ListUtil.createList(data);
        ListUtil.print(first);
        first = reverse(first);
        ListUtil.print(first);
    }
}
