package com.datastructures.misc;

/**
 * To multiply a number without %,*, bitwise operator.
 */
public class RecursiveMultipication {

    private static int multiply(int x, int y) {

        if (y == 0) {
            return 0;
        } else if (y > 0) {
            return (x + multiply(x, (y - 1)));
        } else {

            return -multiply(x, -y);
        }

    }

    public static void main(String[] args) {
        System.out.println(multiply(2, -2));
    }

}
