package com.datastructures.lowleveldesign.ratelimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Below implementation is not thread safe. We can make it thread safe by using concurrent hashmap.
 *
 * @author Piyush Kumar.
 * @since 22/10/22.
 */
public class SlidingWindowRateLimiter implements RateLimiter {

    private int capacity;
    private int windowInSeconds = 5;
    private Map<String, Queue<Long>> slidingWindowMap;

    public SlidingWindowRateLimiter(int capacity) {
        this.capacity = capacity;
        this.slidingWindowMap = new HashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        long currentTimeStamp = System.currentTimeMillis();

        if (slidingWindowMap.containsKey(userId)) {
            evictOlderEntries(userId, currentTimeStamp);

            if (slidingWindowMap.get(userId).size() < this.capacity) {
                slidingWindowMap.get(userId).add(currentTimeStamp);
                return true;
            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        } else {
            Queue<Long> queue = new LinkedList<>();
            queue.add(currentTimeStamp);
            slidingWindowMap.put(userId, queue);
            return true;
        }
    }

    private void evictOlderEntries(String userId, long currentTimeStamp) {

        while (slidingWindowMap.get(userId).size() != 0 && currentTimeStamp - slidingWindowMap.get(userId).peek() >= windowInSeconds * 1000L) {

            slidingWindowMap.get(userId).poll();
        }
    }
}
