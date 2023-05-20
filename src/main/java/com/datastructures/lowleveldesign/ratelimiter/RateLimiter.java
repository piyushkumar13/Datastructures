/*
 *  Copyright (c) 2022 GoTo
 *  All Rights Reserved Worldwide.
 *
 *  THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO GOTO
 *  AND CONSTITUTES A VALUABLE TRADE SECRET.
 */
package com.datastructures.lowleveldesign.ratelimiter;

/**
 * @author Piyush Kumar.
 * @since 21/10/22.
 */
public interface RateLimiter {

    boolean grantAccess(String userId);
}
