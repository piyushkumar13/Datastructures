package com.datastructures.lowleveldesign.ratelimiter;

import java.time.Instant;
import java.util.HashMap;

/**
 * Based on this implementation https://codedaily.in/rate-limiter-design-java-python-code/#Token_Bucket_Algorithm_for_Rate-limiter
 * And https://chatgpt.com/share/6a884e09-2ad0-83ee-ad7f-55cf998e40dc
 *
 * The above link implementation is not user specific. Below implementation is user specific.
 *
 * Below implementation is not thread safe. We can make it thread safe by using concurrent hashmap.
 *
 * @author Piyush Kumar.
 * @since 21/10/22.
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private int tokenRefillWindow = 5; // 5 seconds
    private int tokensCapacityOfBucket;
    private int tokensRefreshRatePerSecond;
    private HashMap<String, Bucket> userTokenBucketMap;

    public TokenBucketRateLimiter(int capacity) {
        this.tokensCapacityOfBucket = capacity;
        this.tokensRefreshRatePerSecond = this.tokensCapacityOfBucket / this.tokenRefillWindow;
        this.userTokenBucketMap = new HashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        refill(userId);

        Bucket bucket = userTokenBucketMap.get(userId);

        if (bucket.getTokens() > 0) {
            bucket.setTokens(bucket.getTokens() - 1);
            return true;
        } else {
            System.out.println("Request limit is reached");
            return false;

        }
    }

    private void refill(String userId) {

        if (userTokenBucketMap.containsKey(userId)) {

            long now = Instant.now().getEpochSecond();

            Bucket bucket = userTokenBucketMap.get(userId);

            long timeElapsed = now - bucket.getLastRefillUpdateTime();

            int refillTokens = (int) timeElapsed * tokensRefreshRatePerSecond;

            if (refillTokens > 0) {
                bucket.setTokens(Math.min(bucket.getTokens() + refillTokens, this.tokensCapacityOfBucket));
            }
        } else {

            Bucket bucket = new Bucket(this.tokensCapacityOfBucket, Instant.now().getEpochSecond());

            userTokenBucketMap.put(userId, bucket);
        }
    }


    private static class Bucket {

        private int tokens;
        private long lastRefillUpdateTime;

        public Bucket(int tokens, long lastRefillUpdateTime) {
            this.tokens = tokens;
            this.lastRefillUpdateTime = lastRefillUpdateTime;
        }

        public int getTokens() {
            return tokens;
        }

        public void setTokens(int tokens) {
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
