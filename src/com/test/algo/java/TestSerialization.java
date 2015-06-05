package com.test.algo.java;

import java.io.*;

/**
 *
 * Serializable serializes till the point where the class is serialization in the hierchey.
 * If one of the parent classes is not serizable then the default constructor is called while
 * deserialization.
 *
 * @author Rahul
 */
public class TestSerialization {

    public static class Base implements Serializable{
        private int baseVal;
        private String baseString;

        public Base() {
            baseString = "base";
            baseVal = -9;
        }

        public int getBaseVal() {
            return baseVal;
        }

        public String getBaseString() {
            return baseString;
        }

        public void setBaseVal(int baseVal) {
            this.baseVal = baseVal;
        }

        public void setBaseString(String baseString) {
            this.baseString = baseString;
        }
    }

    public static class Extend extends Base  {
        private String extend;

        public Extend(String initVal) {
            this.extend = initVal;
        }
    }

    public static void main(String [] argv) throws Exception {
        Extend extend = new Extend("extended string");
        extend.setBaseString("new");
        extend.setBaseVal(2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);

        out.writeObject(extend);

        byte [] serData = outputStream.toByteArray();

        System.out.println("Ser length => " + serData.length);

        ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(serData));

        Extend extend1 = (Extend) oin.readObject();

        System.out.println(extend1.getBaseString());
        System.out.println(extend1.getBaseVal());


    }
}
