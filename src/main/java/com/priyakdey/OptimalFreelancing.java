package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        if (jobs.length == 0) return 0;

        PriorityQueue<Job> heap = new PriorityQueue<>(jobs.length,
                Comparator.comparing((Job j) -> j.deadline)
                        .thenComparing(j -> j.payment,
                                Comparator.reverseOrder()));

        for (Map<String, Integer> j : jobs) {
            Job job = new Job(j.get("deadline"), j.get("payment"));
            heap.offer(job);
        }

        int currDay = 1;
        int totalPayment = 0;

        while (!heap.isEmpty()) {
            while (!heap.isEmpty() && currDay > heap.peek().deadline) {
                heap.poll();
            }

            if (heap.isEmpty()) break;

            Job job = heap.poll();
            totalPayment += job.payment;
            currDay++;
        }

        return totalPayment;
    }

    private record Job(int deadline, int payment) {
    }

}
