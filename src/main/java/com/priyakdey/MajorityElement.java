package com.priyakdey;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class MajorityElement {

    public int majorityElement(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : array) {
            countMap.compute(num, (k, v) -> v == null ? 1 : v + 1);
            if (countMap.get(num) > array.length / 2) {
                return num;
            }
        }

        return -1;
    }

}
