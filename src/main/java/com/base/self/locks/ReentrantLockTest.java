package com.base.self.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class description TODO
 *
 * @author libo
 * @package com.base.self.locks
 * @company initcat
 * @date 2020/8/17
 */
public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            lock.unlock();
        }
    }
}
