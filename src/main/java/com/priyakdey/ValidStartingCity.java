package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class ValidStartingCity {

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int currFuel = 0;
        int validStarting = 0;
        int minFuel = 0;

        for (int i = 0; i < distances.length; i++) {
            int distance = distances[i];
            currFuel += fuel[i] * mpg - distance;
            if (currFuel < minFuel) {
                minFuel = currFuel;
                validStarting = i + 1;
            }
        }

        return validStarting % distances.length;
    }

}
