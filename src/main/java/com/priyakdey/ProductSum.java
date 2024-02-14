package com.priyakdey;

import java.util.List;

/**
 * @author Priyak Dey
 */
public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    private static int productSum(List<Object> array, int depth) {
        int sum = 0;

        for (Object obj : array) {
            if (obj instanceof Integer i) {
                sum += i;
            } else if (obj instanceof List list) {
                sum += productSum(list, depth + 1);
            } else {
                throw new IllegalArgumentException("invalid input");
            }
        }

        return depth * sum;
    }
}
