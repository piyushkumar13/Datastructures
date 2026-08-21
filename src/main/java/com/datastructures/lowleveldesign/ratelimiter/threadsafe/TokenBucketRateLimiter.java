package com.datastructures.lowleveldesign.ratelimiter.threadsafe;

import com.datastructures.lowleveldesign.ratelimiter.RateLimiter;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Token Bucket Rate Limiter - Multi Threaded / Thread Safe Version.
 *
 * Reference : https://chatgpt.com/share/6a884e09-2ad0-83ee-ad7f-55cf998e40dc
 *
 Why synchronized (user)?

 This is the important part.

 Suppose two threads simultaneously call:

 grantAccess("user1")

 Without synchronization, you can have:

 Thread 1                 Thread 2


 get tokens = 1           get tokens = 1
 decrement                decrement
 return true              return true

 Now two requests were allowed when only one token existed.

 With:

 synchronized (user) {
 refill(user);


 if (user.getTokens().get() > 0) {
 user.getTokens().decrementAndGet();
 return true;
 }
 }

 only one thread can perform the refill/check/decrement sequence for that particular user at a time.

 At the same time:

 Thread 1 → user1 → locked
 Thread 2 → user1 → waits


 Thread 3 → user2 → can proceed
 Thread 4 → user3 → can proceed

 So you're locking per user, rather than locking the entire rate limiter.
 *
 *
 * @author Piyush Kumar.
 * @since 21/10/22.
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private int tokenRefillWindow = 5; // 5 seconds
    private int tokensCapacityOfBucket;
    private int tokensRefreshRatePerSecond;

    private ConcurrentHashMap<String, Bucket> userTokenBucketMap;

    public TokenBucketRateLimiter(int capacity) {
        this.tokensCapacityOfBucket = capacity;
        this.tokensRefreshRatePerSecond = this.tokensCapacityOfBucket / this.tokenRefillWindow;
        this.userTokenBucketMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        Bucket bucket = userTokenBucketMap.computeIfAbsent(
                userId,
                key -> new Bucket(new AtomicInteger(this.tokensCapacityOfBucket), Instant.now().getEpochSecond())
        );

        synchronized (bucket) {

            refill(bucket);

            if (bucket.getTokens().get() > 0) {
                bucket.getTokens().decrementAndGet();
                return true;
            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        }
    }

    private void refill(Bucket bucket) {

        long now = Instant.now().getEpochSecond();

        long timeElapsed = now - bucket.getLastRefillUpdateTime();

        int refillTokens =
            (int) timeElapsed * tokensRefreshRatePerSecond;

        if (refillTokens > 0) {

            bucket.getTokens().set(Math.min(bucket.getTokens().get() + refillTokens, this.tokensCapacityOfBucket));
            bucket.setLastRefillUpdateTime(now);
        }
    }

    private static class Bucket {

        private AtomicInteger tokens;
        private long lastRefillUpdateTime;

        public Bucket(
            AtomicInteger tokens,
            long lastRefillUpdateTime
        ) {
            this.tokens = tokens;
            this.lastRefillUpdateTime = lastRefillUpdateTime;
        }

        public AtomicInteger getTokens() {
            return tokens;
        }

        public void setTokens(AtomicInteger tokens) {
            this.tokens = tokens;
        }

        public long getLastRefillUpdateTime() {
            return lastRefillUpdateTime;
        }

        public void setLastRefillUpdateTime(long lastRefillUpdateTime) {
            this.lastRefillUpdateTime = lastRefillUpdateTime;
        }
    }
}