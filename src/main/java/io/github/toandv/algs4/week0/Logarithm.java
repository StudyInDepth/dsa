package io.github.toandv.algs4.week0;

/**
 * Created by toan on 5/29/16.
 * http://www.giannistsakiris.com/2010/01/09/base-2-and-base-n-logarithm-calculation-in-java/
 * log b of n = log k of n / log k of b\
 * http://www.rapidtables.com/math/algebra/Logarithm.htm
 */
public class Logarithm {
    public static double log(double n, int b) {
        return Math.log(n) / Math.log(b);
    }

    public static void main(String[] args) {
        System.out.println(log(10, 2));
    }
}
