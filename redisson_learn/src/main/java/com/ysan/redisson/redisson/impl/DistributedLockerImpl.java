package com.ysan.redisson.redisson.impl;

import com.ysan.redisson.redisson.DistributedLocker;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description
 * @since 2023/2/28 9:32
 **/
@Service
public class DistributedLockerImpl implements DistributedLocker {

    @Autowired
    private RedissonClient redissonClient;

    /**
     *
     * @param lockKey [null]
     * @return org.redisson.api.RLock
     * @since 2023/2/28 9:34
     * @author Administrator
     * @description lock() 拿不到lock就不罢休，不然线程就一直block
     */
    @Override
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     *
     * @param lockKey [null]
     * @param timeout [null]
     * @return org.redisson.api.RLock
     * @since 2023/2/28 9:35
     * @author Administrator
     * @description  timeout 为加锁时间 单位为秒
     */
    @Override
    public RLock lock(String lockKey, long timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, TimeUnit.SECONDS);
        return lock;
    }

    /**
     *
     * @param lockKey [null]
     * @param unit [null]
     * @param timeout [null]
     * @return org.redisson.api.RLock
     * @since 2023/2/28 9:37
     * @author Administrator
     * @description timeout为加锁时间，时间单位由unit确定
     */
    @Override
    public RLock lock(String lockKey, TimeUnit unit, long timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, unit);
        return lock;
    }

    @Override
    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    @Override
    public void unlock(RLock lock) {
        lock.unlock();
    }
}
