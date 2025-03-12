package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MaximizeExpression {

    public int maximizeExpression(int[] array) {
        int[] max = new int[]{Integer.MIN_VALUE};
        int[] expr = new int[4];
        maximizeExpression(array, 0, expr, 0, max);
        return max[0];
    }

    private int maximizeExpression(int[] array, int index, int[] expr, int i,
                                   int[] max) {

        if (index == array.length) {
            return Integer.MIN_VALUE;
        }
        if (i == 4) {
            int value = expr[0] - expr[1] + expr[2] - expr[3];
            max[0] = Math.max(max[0], value);
            return value;
        }

        int value = maximizeExpression(array, index + 1, expr, i, max);

        expr[i] = array[index];
        value = Math.max(value, maximizeExpression(array, index + 1, expr,
                i + 1, max));
        max[0] = Math.max(max[0], value);
        return value;
    }
}
