package com.datastructures.lowleveldesign.ratelimiter;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * Referred :
 * https://codedaily.in/rate-limiter-design-java-python-code/#Sliding_window_algorithm
 * https://chatgpt.com/share/6a88454f-0610-83e8-bbf1-2799e1c472d1
 *
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
                value.setWindowCapacity(0); // this should be 0 as it should be reset here
            }

            if (value.getWindowCapacity() < this.capacity) {
                value.setWindowCapacity(value.getWindowCapacity() + 1);
                return true;

            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        } else {
            // First request should also be counted.
            fixedWindowPerUserWindow.put(userId, new Value(1, stipulatedWindowNum));

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
