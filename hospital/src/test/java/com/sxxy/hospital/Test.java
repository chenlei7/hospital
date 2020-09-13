package com.sxxy.hospital;

public class Test {


    public int maxCandies(int[] candies, int[] coin, int n) {
        // write code here
        if (candies.length == 0) return 0;

        if (n >= candies.length) {
            int a = candies.length;
            return a;
        } else if (n < candies.length) {
            int c = candies.length - n;
            while (--c > 0) {
                int a = (int) (Math.random() * 2);
                if (a == 0) {
                    n++;
                }
            }
        }
        return n;
    }


    public static void main(String[] args) {
        Test t = new Test();
    }


}
