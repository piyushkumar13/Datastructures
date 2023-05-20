/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.lowleveldesign.ratelimiter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Kumar.
 * @since 22/10/22.
 */
public class FixedWindowRateLimiter implements RateLimiter {

    private int windowSizeInSeconds = 5;
    private int capacity;
    private Map<String, Value> fixedWindowPerUserWindow;

    public FixedWindowRateLimiter(int capacity) {
        this.capacity = capacity;
        this.fixedWindowPerUserWindow = new HashMap<>();
    }


    @Override
    public boolean grantAccess(String userId) {
        long stipulatedWindowNum = System.currentTimeMillis() / (windowSizeInSeconds * 1000);

        if (fixedWindowPerUserWindow.containsKey(userId)) {

            Value value = fixedWindowPerUserWindow.get(userId);

            if (value.getCurrentWindowNumber() < stipulatedWindowNum) {
                value.setCurrentWindowNumber(stipulatedWindowNum);
                value.setWindowCapacity(this.capacity);
            }

            if (value.getWindowCapacity() <= this.capacity) {
                value.setWindowCapacity(value.getWindowCapacity() + 1);
                return true;

            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        } else {
            fixedWindowPerUserWindow.put(userId, new Value(0, stipulatedWindowNum));

        }

        return true;
    }

    private static class Value {
        private int windowCapacity;
        private long currentWindowNumber;

        public Value(int windowCapacity, long currentWindowNumber) {
            this.windowCapacity = windowCapacity;
            this.currentWindowNumber = currentWindowNumber;
        }

        public void setWindowCapacity(int windowCapacity) {
            this.windowCapacity = windowCapacity;
        }

        public void setCurrentWindowNumber(long currentWindowNumber) {
            this.currentWindowNumber = currentWindowNumber;
        }

        public int getWindowCapacity() {
            return windowCapacity;
        }

        public long getCurrentWindowNumber() {
            return currentWindowNumber;
        }
    }
}
