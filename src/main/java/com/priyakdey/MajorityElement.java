package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class MajorityElement {

    // Use Boyer-Moore majority algorithm

    public int majorityElement(int[] array) {
        int majorityElement = array[0];
        int bias = 1;
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int num = array[i];
            if (num == majorityElement) {
                bias++;
            } else {
                bias--;
            }

            if (bias == 0) {
                majorityElement = num;
                bias = 1;
            }
        }

        int count = 0;
        for (int num : array) {
            if (num == majorityElement) {
                count++;
            }
        }

        if (count > length / 2) {
            return majorityElement;
        }

        return -1; // should be unreachable
    }


}
