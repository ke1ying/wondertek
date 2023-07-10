package com.miu.web.controller;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author keying
 * @date 2023-06-21 11:11:37
 */
public class TokenBucket {
    private final long capacity;
    private final double refillTokensPerOneMillis;
    private double availableTokens;
    private long lastRefillTimestamp;

    public TokenBucket(long capacity, long refillTokens, long refillPeriodMillis) {
        this.capacity = capacity;
        this.refillTokensPerOneMillis = (double) refillTokens / (double) refillPeriodMillis;
        this.availableTokens = capacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    synchronized public boolean tryConsume(int numberTokens) {
        refill();
        if (availableTokens < numberTokens) {
            return false;
        } else {
            availableTokens -= numberTokens;
            return true;
        }
    }

    private void refill() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > lastRefillTimestamp) {
            long millisSinceLastRefill = currentTimeMillis - lastRefillTimestamp;
            double refill = millisSinceLastRefill * refillTokensPerOneMillis;
            this.availableTokens = Math.min(capacity, availableTokens + refill);
            this.lastRefillTimestamp = currentTimeMillis;
        }
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(100,100,1000);
    }
}