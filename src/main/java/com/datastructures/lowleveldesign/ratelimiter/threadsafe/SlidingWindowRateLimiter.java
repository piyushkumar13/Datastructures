package com.datastructures.lowleveldesign.ratelimiter.threadsafe;

import com.datastructures.lowleveldesign.ratelimiter.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Thread-safe implementation of Sliding Window Rate Limiter.
 *
 * Reference : https://chatgpt.com/share/6a8856b6-e4d8-83ee-a62b-9c1e468f4186

 Why ConcurrentHashMap alone isn't enough

 Suppose the capacity is 10 and two threads execute this at the same time:

 if (queue.size() < capacity) {
 queue.add(currentTimeStamp);
 }

 Both threads could see:

 queue.size() = 9

 Both conclude:

 9 < 10 → true

 and both add a request.

 Now you have:

 queue.size() = 11

 So the operation:

 evict
 ↓
 check size
 ↓
 add

 needs to be atomic per user.

 That's what this does:

 synchronized (queue) {
 evictOlderEntries(queue, currentTimeStamp);


 if (queue.size() < capacity) {
 queue.add(currentTimeStamp);
 return true;
 }
 }
 Why synchronize on queue instead of the whole method?

 If you did:

 public synchronized boolean grantAccess(String userId)

 then requests for different users would also block each other.

 For example:

 Thread 1 → userA → locked
 Thread 2 → userB → waits
 Thread 3 → userC → waits

 With synchronization on the user's queue:

 Thread 1 → userA → locks queueA
 Thread 2 → userB → locks queueB
 Thread 3 → userC → locks queueC

 They can proceed concurrently because each user has a separate lock.

 * @author Piyush Kumar.
 * @since 22/10/22.
 */
public class SlidingWindowRateLimiter implements RateLimiter {

    private int capacity;
    private int windowInSeconds = 5;

    private Map<String, ConcurrentLinkedQueue<Long>> slidingWindowMap;

    public SlidingWindowRateLimiter(int capacity) {
        this.capacity = capacity;
        this.slidingWindowMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        long currentTimeStamp = System.currentTimeMillis();

        ConcurrentLinkedQueue<Long> queue =
                slidingWindowMap.computeIfAbsent(userId,key -> new ConcurrentLinkedQueue<>());

        synchronized (queue) {

            evictOlderEntries(queue, currentTimeStamp);

            if (queue.size() < this.capacity) {
                queue.add(currentTimeStamp);
                return true;
            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        }
    }

    private void evictOlderEntries(ConcurrentLinkedQueue<Long> queue, long currentTimeStamp) {

        while (!queue.isEmpty() && currentTimeStamp - queue.peek() >= windowInSeconds * 1000L) {

            queue.poll();
        }
    }
}