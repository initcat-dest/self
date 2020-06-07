package com.base.self.locks.distributed;

import com.base.self.redis.RedisConstant;
import redis.clients.jedis.Jedis;

/**
 * class description 分布式锁测试
 *
 * @author libo
 * @package com.base.self.locks.distributed
 * @company initcat
 * @date 2020/6/7
 */
public class DistributedLockTest {

    public static void main(String[] args) throws InterruptedException {
//        redisLockTest();
        ZooKeeperDistributedLock zooKeeperDistributedLock = new ZooKeeperDistributedLock("testLock");
        zooKeeperDistributedLock.acquireDistributedLock();
        new Thread(() -> {
            ZooKeeperDistributedLock zooKeeperDistributedLock1 = new ZooKeeperDistributedLock("testLock");
            System.out.println(">>>>>>>>线程2开始尝试获取锁");
            zooKeeperDistributedLock1.acquireDistributedLock();
            System.out.println(">>>>>>>>线程2获取锁");
            zooKeeperDistributedLock1.unlock();
        }).start();
        Thread.sleep(5000);
        zooKeeperDistributedLock.unlock();
    }

    private static void redisLockTest() {
        System.out.println(RedisDistributedLock.tryGetDistributedLock("test", "123456", 6));
        try (Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost)) {
            System.out.println(jedis.get("test"));
            System.out.println(jedis.ttl("test"));
        }
        System.out.println(RedisDistributedLock.tryGetDistributedLock("test", "123456", 6));
    }
}
