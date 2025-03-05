package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ArrayOfProducts {

    // Use two pointers to find the prefix and suffix product at each position.

    public int[] arrayOfProducts(int[] array) {
        int length = array.length;
        int prefixProduct = 1, suffixProduct = 1;
        int[] products = new int[length];
        Arrays.fill(products, 1);

        int i = 1, j = length - 2;

        while (i < length) {
            prefixProduct *= array[i - 1];
            products[i] = products[i] * prefixProduct;
            i++;

            suffixProduct *= array[j + 1];
            products[j] = products[j] * suffixProduct;
            j--;
        }

        return products;
    }
}
