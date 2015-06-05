package com.test.algo.tree;

import java.util.PriorityQueue;

/**
 * @author Rahul
 */
public class HuffmanEncoding {

    public static void main(String [] argv) {
        String encodingString = "aaaaaaaaaaaaaaaaaaabbbbbbbbbbbccccdde";
        printHuffmanEncodingTable(encodingString);
        String encodedString = encode(encodingString);
        decode(encodedString);
    }

    private static void printHuffmanEncodingTable(String encodingString) {
        encodingString = encodingString.toLowerCase();
        char [] chars = encodingString.toCharArray();
        int [] freq = getFrequencyArray(chars);

        printFreqTable(freq);

        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for(int i = 0 ; i < freq.length ; i++) {
            if(freq[i] == 0) continue;
            Node node = new Node((char)(i+'a'),freq[i]);
            queue.offer(node);
        }

        while(queue.size() > 1) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();

            Node newNode = new Node(node1,node2);
            queue.offer(newNode);
        }

        Node root = queue.poll();
        //System.out.print("root => " + root);

        char []  buf = new char[10];

        printTable(root,buf,0);
    }

    private static void printFreqTable(int[] freq) {
        for(int i = 0 ; i < freq.length ; i++) {
            if(freq[i] == 0 ) continue;
            System.out.println("char " + (char)('a'+i)  + " , freq " + freq[i]);
        }
    }

    private static void printTable(Node root, char[] buf,int level) {
        if(root.isLeaf()) {
            System.out.println("Char " + root.aChar + " code " + new String(buf));
        } else {
            buf[level] = '0';
            printTable(root.left, buf, level+1);
            buf[level] = '1';
            printTable(root.right, buf, level+1);
        }
    }

    private static int[] getFrequencyArray(char [] chars) {
        int [] freq = new int[26];
        for(char cu : chars) {
            if(Character.isSpaceChar(cu))
                continue;
            int val = freq[cu - 'a'];
            freq[cu - 'a'] = val+1;
        }
        return freq;
    }

    private static void decode(String encodedString) {
        return;
    }

    private static String encode(String encodingString) {
        return null;
    }

    public static class Node implements Comparable<Node>{
        private Node left , right;
        private int val;
        private char aChar;

        public Node(char aChar,int val) {
            this.aChar = aChar;
            this.val = val;
        }

        public Node(Node left , Node right) {
            this.left = left;
            this.right = right;
            this.val = this.left.getVal() + this.right.val;
        }

        public boolean isLeaf() {
            if(left == null && right == null){
                return true;
            }
            return false;
        }

        public int getVal() {
            return this.val;
        }

        public char getChar() {
            return this.aChar;
        }

        @Override
        public int compareTo(Node o) {
            return (o.getVal() - val);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", val=" + val +
                    ", aChar=" + aChar +
                    '}';
        }
    }
}
