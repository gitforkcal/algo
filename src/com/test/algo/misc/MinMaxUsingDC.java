package com.test.algo.misc;

/**
 * @author Rahul
 */
public class MinMaxUsingDC {

    private static class MaxMin {
        private int max , mix;

        private int getMax() {
            return max;
        }

        private void setMax(int max) {
            this.max = max;
        }

        private int getMin() {
            return mix;
        }

        private void setMin(int mix) {
            this.mix = mix;
        }

        @Override
        public String toString() {
            return "MaxMin{" +
                    "max=" + max +
                    ", mix=" + mix +
                    '}';
        }
    }


    public static MaxMin findMaxMin(int [] data , int start , int end) {
        MaxMin ret = new MaxMin();

        if(start == end) {
            ret.setMax(data[start]);
            ret.setMin(data[start]);
            return ret;
        }

        if(start+1 == end) {
            if(data[start] < data[end]) {
                ret.setMax(data[end]);
                ret.setMin(data[start]);
            } else {
                ret.setMax(data[start]);
                ret.setMin(data[end]);
            }
            return ret;
        }

        int mid  = (start+end)/2;

        MaxMin first = findMaxMin(data, start, mid);
        MaxMin second = findMaxMin(data, mid+1, end);

        ret.setMax(Math.max(first.getMax(), second.getMax()));
        ret.setMin(Math.min(first.getMin(), second.getMin()));
        return ret;
    }

    public static void main(String [] argv) {
        int [] data = {2,8,4,7,6,1,5,9,6,3};

        System.out.print(findMaxMin(data,0,data.length-1));
    }
}
