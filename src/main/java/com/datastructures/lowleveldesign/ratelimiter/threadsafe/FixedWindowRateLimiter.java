package com.datastructures.lowleveldesign.ratelimiter.threadsafe;

import com.datastructures.lowleveldesign.ratelimiter.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Refer : https://chatgpt.com/share/6a88454f-0610-83e8-bbf1-2799e1c472d1
 *
 * Why this is better than using synchronized with method grantAccess()

 synchronized with method will effectively did:

 RateLimiter lock
 │
 ┌───────────────┼───────────────┐
 │               │               │
 User A          User B          User C
 │               │               │
 LOCK            WAIT            WAIT

 Even though A, B, and C have completely independent rate limits.

 whereas concurrent hashmap does:

 ConcurrentHashMap
 │
 ├── User A → Value A → lock A
 │
 ├── User B → Value B → lock B
 │
 └── User C → Value C → lock C

 So:

 Thread 1 → User A → lock A → executing
 Thread 2 → User B → lock B → executing
 Thread 3 → User C → lock C → executing

 All three can proceed concurrently.

 But if two requests are for the same user:

 Thread 1 → User A → lock A → executing
 Thread 2 → User A → lock A → WAIT

 That's exactly what we want. This is where synchronized block is helpful

 Why ConcurrentHashMap alone isn't enough

 You might wonder why we don't simply do:

 Value value = fixedWindowPerUserWindow.get(userId);

 if (value.getWindowCapacity() < capacity) {
 value.setWindowCapacity(value.getWindowCapacity() + 1);
 return true;
 }

 Even with ConcurrentHashMap, this isn't thread-safe.

 ConcurrentHashMap protects the map, but it doesn't automatically protect the mutable Value.

 For example:

 Thread 1                  Thread 2
 │                         │
 │ read count = 2          │
 │                         │ read count = 2
 │                         │
 │ 2 < 3 → true            │ 2 < 3 → true
 │                         │
 │ count = 3               │ count = 3
 │                         │
 ▼                         ▼

 Both requests get accepted, but the count should only have allowed one more request.

 That's why we have:

 synchronized (value) {
 ...
 }

 The important thing is that we're locking the individual user's Value, not the entire rate limiter.
 *
 * @author Piyush Kumar.
 * @since 22/10/22.
 */
public class FixedWindowRateLimiter implements RateLimiter {

    private final int windowSizeInSeconds = 5;
    private final int capacity;
    private final Map<String, Value> fixedWindowPerUserWindow;

    public FixedWindowRateLimiter(int capacity) {
        this.capacity = capacity;
        this.fixedWindowPerUserWindow = new ConcurrentHashMap<>();
    }

    @Override
    public boolean grantAccess(String userId) {

        long stipulatedWindowNum =
                System.currentTimeMillis() / (windowSizeInSeconds * 1000);

        Value value = fixedWindowPerUserWindow.computeIfAbsent(
                userId,
                key -> new Value(0, stipulatedWindowNum)
        );

        synchronized (value) {

            if (value.getCurrentWindowNumber() < stipulatedWindowNum) {
                value.setCurrentWindowNumber(stipulatedWindowNum);
                value.setWindowCapacity(0);
            }

            if (value.getWindowCapacity() < this.capacity) {
                value.setWindowCapacity(value.getWindowCapacity() + 1);
                return true;

            } else {
                System.out.println("Request limit is reached");
                return false;
            }
        }
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