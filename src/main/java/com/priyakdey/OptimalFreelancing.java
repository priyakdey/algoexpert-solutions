package com.priyakdey;

import java.util.*;

/**
 * @author Priyak Dey
 */
public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        if (jobs.length == 0) return 0;

        Comparator<Job> compareFn = Comparator
                .comparing(Job::deadline)
                .thenComparing(Job::payment, Comparator.reverseOrder());
        PriorityQueue<Job> heap = new PriorityQueue<>(jobs.length, compareFn);

        for (Map<String, Integer> entry : jobs) {
            Job job = new Job(entry.get("deadline"), entry.get("payment"));
            heap.offer(job);
        }

        int currDay = 0;
        int maxPayment = 0;
        while (!heap.isEmpty()) {
            Job job = heap.poll();
            maxPayment += job.payment;
            currDay++;

            while (!heap.isEmpty() && heap.peek().deadline == currDay) {
                heap.poll();
            }
        }

        return maxPayment;
    }

    private record Job(int deadline, int payment) {
    }



    public static void main(String[] args) {
        HashMap[] input = new HashMap[9];

        HashMap<String, Integer> job1 = new HashMap<String, Integer>();
        job1.put("deadline", 2);
        job1.put("payment", 1);
        input[0] = job1;

        HashMap<String, Integer> job2 = new HashMap<String, Integer>();
        job2.put("deadline", 1);
        job2.put("payment", 4);
        input[1] = job2;

        HashMap<String, Integer> job3 = new HashMap<String, Integer>();
        job3.put("deadline", 3);
        job3.put("payment", 2);
        input[2] = job3;

        HashMap<String, Integer> job4 = new HashMap<String, Integer>();
        job4.put("deadline", 1);
        job4.put("payment", 3);
        input[3] = job4;

        HashMap<String, Integer> job5 = new HashMap<String, Integer>();
        job5.put("deadline", 4);
        job5.put("payment", 3);
        input[4] = job5;

        HashMap<String, Integer> job6 = new HashMap<String, Integer>();
        job6.put("deadline", 4);
        job6.put("payment", 2);
        input[5] = job6;

        HashMap<String, Integer> job7 = new HashMap<String, Integer>();
        job7.put("deadline", 4);
        job7.put("payment", 1);
        input[6] = job7;

        HashMap<String, Integer> job8 = new HashMap<String, Integer>();
        job8.put("deadline", 5);
        job8.put("payment", 4);
        input[7] = job8;

        HashMap<String, Integer> job9 = new HashMap<String, Integer>();
        job9.put("deadline", 8);
        job9.put("payment", 1);
        input[8] = job9;

        System.out.println(new OptimalFreelancing().optimalFreelancing(input));

    }

}
