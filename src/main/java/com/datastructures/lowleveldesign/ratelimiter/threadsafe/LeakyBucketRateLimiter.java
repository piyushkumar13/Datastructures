package com.datastructures.lowleveldesign.ratelimiter.threadsafe;

import com.datastructures.lowleveldesign.ratelimiter.RateLimiter;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Reference : https://chatgpt.com/share/6a886471-b9ac-83e8-a812-222e58bf211d
 *
    Why synchronize on bucket?

This part is the key:

synchronized (bucket) {
    leak(bucket);


    if (bucket.size() < capacity) {
        bucket.add(...);
        return true;
    }
}

Suppose capacity is 5 and there is only one slot left.

Without synchronization:

Thread 1 -> size() = 4
Thread 2 -> size() = 4


Thread 1 -> add()
Thread 2 -> add()


size = 6   ❌

With synchronization:

Thread 1 -> lock bucket
Thread 1 -> size = 4
Thread 1 -> add()
Thread 1 -> unlock


Thread 2 -> lock bucket
Thread 2 -> size = 5
Thread 2 -> reject
Thread 2 -> unlock

So the capacity is respected.
*/
public class LeakyBucketRateLimiter implements RateLimiter {

    private ConcurrentHashMap<String, Queue<Request>> leakyBucket;
    private Integer capacity;
    private AtomicInteger requestId;
    private long leakIntervalMillis;

    public LeakyBucketRateLimiter(int capacity, long leakIntervalMillis) {
        this.leakyBucket = new ConcurrentHashMap<>();
        this.capacity = capacity;
        this.requestId = new AtomicInteger(0);
        this.leakIntervalMillis = leakIntervalMillis;
    }

    @Override
    public boolean grantAccess(String userId) {

        Queue<Request> bucket = leakyBucket.computeIfAbsent(userId,key -> new ConcurrentLinkedQueue<>());

        synchronized (bucket) {

            leak(bucket);

            if (bucket.size() < capacity) {

                bucket.add(new Request(requestId.incrementAndGet(), System.currentTimeMillis()));

                return true;

            } else {

                System.out.println("Requested limit is reached");
                return false;
            }
        }
    }

    private void leak(Queue<Request> bucket) {

        long currentTime = System.currentTimeMillis();

        Iterator<Request> iterator = bucket.iterator();

        while (iterator.hasNext()) {

            Request request = iterator.next();

            if (currentTime - request.timestamp >= leakIntervalMillis) {
                iterator.remove();
            } else {
                break;
            }
        }
    }

    private static class Request {

        private int requestId;
        private long timestamp;

        public Request(int requestId, long timestamp) {
            this.requestId = requestId;
            this.timestamp = timestamp;
        }
    }
}