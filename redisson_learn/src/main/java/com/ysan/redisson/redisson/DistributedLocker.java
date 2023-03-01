package com.ysan.redisson.redisson;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description
 * @since 2023/2/28 9:30
 **/
public interface DistributedLocker {
    RLock lock(String lockKey);
    RLock lock(String lockKey, long timeout);
    RLock lock(String lockKey, TimeUnit unit, long timeout);
    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);
    void unlock(String lockKey);
    void unlock(RLock lock);
}

