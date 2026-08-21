package com.datastructures.lowleveldesign.ratelimiter;

/**
 * @author Piyush Kumar.
 * @since 21/10/22.
 */
public interface RateLimiter {

    boolean grantAccess(String userId);
}
