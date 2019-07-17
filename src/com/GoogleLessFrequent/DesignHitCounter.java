package com.GoogleLessFrequent;

/*
 * Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.

It is possible that several hits arrive roughly at the same time.

Example:
HitCounter counter = new HitCounter();

// hit at timestamp 1.
counter.hit(1);

// hit at timestamp 2.
counter.hit(2);

// hit at timestamp 3.
counter.hit(3);

// get hits at timestamp 4, should return 3.
counter.getHits(4);

// hit at timestamp 300.
counter.hit(300);

// get hits at timestamp 300, should return 4.
counter.getHits(300);

// get hits at timestamp 301, should return 3.
counter.getHits(301);
 *
 *
 */

public class DesignHitCounter {

    private static int[] times;
    private static int[] hits;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        times = new int[5];
        hits = new int[5];
    }

    public static void main(String[] args) {
        DesignHitCounter counter = new DesignHitCounter();

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        counter.getHits(4);

// hit at timestamp 300.
        counter.hit(5);

// get hits at timestamp 300, should return 4.
        counter.getHits(5);

// get hits at timestamp 301, should return 3.
        counter.getHits(6);
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public static void hit(int timestamp) {
        int index = timestamp % 5;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public static int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            if (timestamp - times[i] < 5) {
                total += hits[i];
            }
        }
        return total;
    }
}
