/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.ratelimiter;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Below implementation is not thread safe. We can make it thread safe by using concurrent hashmap.
 *
 * * @author Piyush Kumar.
 * @since 21/10/22.
 */
public class LeakyBucketRateLimiter implements RateLimiter{

    private HashMap<String, LinkedBlockingQueue<Integer>> leakyBucket;
    private Integer capacity;
    private AtomicInteger requestId;

    public LeakyBucketRateLimiter(int capacity){

        this.leakyBucket = new HashMap<>();
        this.capacity = capacity;
        this.requestId = new AtomicInteger(0);
    }


    @Override
    public boolean grantAccess(String userId) {

        if (leakyBucket.containsKey(userId)){
            LinkedBlockingQueue<Integer> bucket = leakyBucket.get(userId);

            if (bucket.remainingCapacity() > 0){
                bucket.add(requestId.incrementAndGet());
            }else{
                System.out.println("Requested limit is reached");
                return false;
            }
        }else{
            leakyBucket.put(userId, new LinkedBlockingQueue<>(this.capacity));
        }

        return true;
    }
}
