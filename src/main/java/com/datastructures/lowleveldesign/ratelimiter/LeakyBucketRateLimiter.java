package com.datastructures.lowleveldesign.ratelimiter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Below implementation is not thread safe. We can make it thread safe by using concurrent hashmap.
 * Reference : https://chatgpt.com/share/6a886471-b9ac-83e8-a812-222e58bf211d
 *
 * * @author Piyush Kumar.
 *
 * @since 21/10/22.
 */
public class LeakyBucketRateLimiter implements RateLimiter {

    private HashMap<String, Queue<Request>> leakyBucket;
    private Integer capacity;
    private AtomicInteger requestId;
    private long leakIntervalMillis;

    public LeakyBucketRateLimiter(int capacity, long leakIntervalMillis) {
        this.leakyBucket = new HashMap<>();
        this.capacity = capacity;
        this.requestId = new AtomicInteger(0);
        this.leakIntervalMillis = leakIntervalMillis;
    }

    @Override
    public boolean grantAccess(String userId) {

        if (leakyBucket.containsKey(userId)) {

            Queue<Request> bucket = leakyBucket.get(userId);

            /*
            Remove requests that have already leaked out.
            "leak" can simply represent capacity being freed because the request has moved through the system.
            Adding to bucket = request waiting to be serviced
            Removing/leaking = request is considered serviced, freeing bucket space
            Bucket full = cannot accept another request
             */
            leak(bucket);

            if (bucket.size() < capacity) {
                bucket.add(new Request(requestId.incrementAndGet(), System.currentTimeMillis()));
                return true;
            } else {
                System.out.println("Requested limit is reached");
                return false;
            }

        } else {

            Queue<Request> bucket = new LinkedList<>();

            bucket.add(new Request(requestId.incrementAndGet(), System.currentTimeMillis()));

            leakyBucket.put(userId, bucket);

            return true;
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
                // Requests are ordered by time.
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
