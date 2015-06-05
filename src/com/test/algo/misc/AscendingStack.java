package com.test.algo.misc;

import java.util.Stack;

/**
 * @author Rahul Bhattacharjee
 */
public class AscendingStack {

    public static void main(String [] argv) {
        int [] data = {6,1,5,3,8,6,4,9,2,7};
        Stack<Integer> stack = new Stack<Integer>();
        for(int val : data) {
            stack.push(val);
        }
        stack = ascendingStack(stack);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    private static Stack<Integer> ascendingStack(Stack<Integer> stack) {
        Stack<Integer> returnStack = new Stack<Integer>();
        while(!stack.isEmpty()) {
            Integer value = stack.pop();
            if(returnStack.isEmpty()) {
                returnStack.push(value);
            } else {
                while(!returnStack.isEmpty() && returnStack.peek() > value) {
                    stack.push(returnStack.pop());
                }
                returnStack.push(value);
            }
        }
        return returnStack;
    }


}
