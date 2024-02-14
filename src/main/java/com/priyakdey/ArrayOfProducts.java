package com.priyakdey;

import java.util.Arrays;

/**
 * @author Priyak Dey
 */
public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = array.length;
        int prefixProduct = 1, suffixProduct = 1;
        int left = 1, right = length - 2;

        int[] products = new int[length];
        Arrays.fill(products, 1);

        while (left < length) {
            prefixProduct *= array[left - 1];
            products[left] *= prefixProduct;
            left++;

            suffixProduct *= array[right + 1];
            products[right] *= suffixProduct;
            right--;
        }

        return products;
    }

}
