package com.test.algo.misc;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 11/27/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class StackSortingExample {

    public static void main(String []argv) {

        Stack stack = new Stack();

        stack.push(6);
        stack.push(2);
        stack.push(7);
        stack.push(1);
        stack.push(10);
        stack.push(5);

        //stack = sort1(stack);
        stack = sortRecursive(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static Stack sort1(Stack<Integer> stack) {
        Stack<Integer> returnStack = new Stack();

        while(!stack.isEmpty()) {
            int value = stack.pop();

            if (returnStack.isEmpty()) {
                returnStack.push(value);
            } else {
                int oldValue = returnStack.peek();
                if(oldValue > value) {
                    returnStack.push(value);
                } else {
                    stack.push(returnStack.pop());
                    stack.push(value);
                }
            }
        }
        return returnStack;
    }

    private static Stack sortRecursive(Stack<Integer> stack) {
         if(!stack.isEmpty()) {
             int val = stack.pop();
             sortRecursive(stack);
             insert(val,stack);
         }
        return stack;
    }

    private static void insert(int val, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(val);
        } else {
            int top = stack.peek();
            if(top > val) {
                stack.push(val);
            }else {
                stack.pop();
                insert(val, stack);
                stack.push(top);
            }
        }
    }
}
