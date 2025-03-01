package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class ProductSum {

    // Use a recursive approach to find sum of nested lists.

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int sum = 0;

        for (Object o : array) {
            if (o instanceof List) {
                sum += productSum((List<Object>) o, depth + 1);
            } else {
                sum += (Integer) o;
            }
        }

        return sum * depth;
    }

}
