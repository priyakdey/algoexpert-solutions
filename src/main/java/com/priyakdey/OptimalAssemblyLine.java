package com.priyakdey;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

/**
 * @author Priyak Dey
 */
public class OptimalAssemblyLine {

    public int optimalAssemblyLine(int[] stepDurations, int numStations) {

        IntSummaryStatistics stats = IntStream.of(stepDurations).summaryStatistics();
        int sum = (int) stats.getSum();
        int max = stats.getMax();

        int left = max, right = sum;

        int maxProcessingTime = sum;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int lineCount = findNumberOfLines(stepDurations, mid);
            if (lineCount <= numStations) {
                maxProcessingTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return maxProcessingTime;
    }

    private int findNumberOfLines(int[] stepDurations, int maxTime) {
        int totalTime = 0;
        int lineCount = 1;
        for (int stepDuration : stepDurations) {
            if (totalTime + stepDuration <= maxTime) {
                totalTime += stepDuration;
            } else {
                lineCount++;
                totalTime = stepDuration;
            }
        }

        return lineCount;
    }

}
