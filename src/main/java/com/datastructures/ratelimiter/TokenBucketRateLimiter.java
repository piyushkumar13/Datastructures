/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.ratelimiter;

import java.time.Instant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Based on this implementation https://codedaily.in/rate-limiter-design-java-python-code/#Token_Bucket_Algorithm_for_Rate-limiter
 *
 * The above link implementation is not user specific. Below implementation is user specific.
 *
 * Below implementation is not thread safe. We can make it thread safe by using concurrent hashmap.
 *
 * @author Piyush Kumar.
 * @since 21/10/22.
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private int timeWindow = 5; // 5 seconds
    private int tokensCapacity;
    private int refreshCapacityPerSecond;
    private HashMap<String, Value> tokenMap;

    public TokenBucketRateLimiter(int capacity) {
        this.tokensCapacity = capacity;
        this.refreshCapacityPerSecond = this.tokensCapacity / this.timeWindow;
        this.tokenMap = new HashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        refill(userId);

        Value user = tokenMap.get(userId);

        if (user.getTokens().get() > 0) {
            user.getTokens().decrementAndGet();
            return true;
        } else {
            System.out.println("Request limit is reached");
            return false;

        }
    }

    private void refill(String userId) {

        if (tokenMap.containsKey(userId)) {

            long now = Instant.now().getEpochSecond();

            long timeElapsed = now - tokenMap.get(userId).getLastRefillUpdateTime();

            int refillTokens = (int) timeElapsed * refreshCapacityPerSecond;

            if (refillTokens > 0) {
                this.tokenMap.put(userId, new Value(new AtomicInteger(Math.min(this.tokenMap.get(userId).getTokens().get() + refillTokens, this.tokensCapacity)), now));
            }
        } else {

            Value user = new Value(new AtomicInteger(this.tokensCapacity), Instant.now().getEpochSecond());

            tokenMap.put(userId, user);
        }
    }


    private static class Value {

        private AtomicInteger tokens;
        private long lastRefillUpdateTime;

        public Value(AtomicInteger tokens, long lastRefillUpdateTime) {
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
