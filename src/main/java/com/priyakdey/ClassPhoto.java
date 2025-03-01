package com.priyakdey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * @author Priyak Dey
 */
public class ClassPhoto {

    // Sort both arrays, check if first student is taller or shorter.
    // Whatever it is, define the predicate, and this condition
    // should be true for all other students.

    public boolean classPhotos(ArrayList<Integer> redShirtHeights,
                               ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int redShirtHeightsFirst = redShirtHeights.getFirst();
        int blueShirtHeightsFirst = blueShirtHeights.getFirst();
        if (Objects.equals(redShirtHeightsFirst, blueShirtHeightsFirst)) {
            return false;
        }

        BiPredicate<Integer, Integer> gt = (a, b) -> a > b;
        BiPredicate<Integer, Integer> lt = (a, b) -> a < b;
        BiPredicate<Integer, Integer> predicate = gt;
        if (redShirtHeightsFirst < blueShirtHeightsFirst) {
            predicate = lt;
        }

        for (int i = 0; i < redShirtHeightsFirst; i++) {
            int redShirtHeight  = redShirtHeights.get(i);
            int blueShortHeight = blueShirtHeights.get(i);

            if (!predicate.test(redShirtHeight, blueShortHeight)) {
                return false;
            }
        }

        return true;
    }


}
