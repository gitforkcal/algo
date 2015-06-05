package com.test.algo.list;

public class ReverseList1 {

    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5};
        Node first = ListUtil.createList(data);
        ListUtil.print(first);
        first = reverse(first);
        ListUtil.print(first);
    }

    private static Node reverse(Node node) {
        while(node.getNext() != null) {
            Node next = node.getNext();
            Node nextToNext = next.getNext();

        }
        return node;
    }

    private Node reverse(Node one , Node two) {
        Node three = null;
        if(two != null){
            three = two.getNext();
        } else {
            reverse(one);
        }
        two.setNext(one);
        return reverse(two,three);
    }
}
