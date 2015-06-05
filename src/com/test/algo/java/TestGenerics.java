package com.test.algo.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 2/23/14
 * Time: 9:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestGenerics {

    public static void main(String [] argv) {
        List<String> stringList = new ArrayList<String>();
        List<Object> objectList = null;

        // not possible
        //objectList = stringList;

        List<Object> objects = new ArrayList<Object>();
        objects.add("integer");
        objects.add(4);

        System.out.println("List " + objects);

        List<Animal> animals = new ArrayList<Animal>();
        animals.add(new Mouse());
        animals.add(new Dog());

        List<Mouse> mouses = new ArrayList<Mouse>();
        mouses.add(new Mouse());

        // not possible.
        //mouses.add(new Dog());

        // test varargs

        testVarargs(1);

        varargsTest(1,"ok");
    }

    public static void varargsTest(Object ...test) {
        if(test.length != 2) {
            throw new IllegalArgumentException("shoudl have 2 args");
        }
        if(!(test[0] instanceof Integer)) {
            throw new IllegalArgumentException();
        }
        if(!(test[1] instanceof String)) {
            throw new IllegalArgumentException();
        }
        System.out.println("Ok");
    }

    public static void testVarargs(int ...params) {
        System.out.println("Param length " + params.length);
    }


    public static void iterate(List<? extends Animal> list) {
        // we are good here..
    }

    public static abstract class Animal {}

    public static class Mouse extends Animal {}

    public static class Dog extends Animal {}
}
