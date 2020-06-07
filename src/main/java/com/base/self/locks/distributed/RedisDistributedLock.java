package com.base.self.locks.distributed;

import com.base.self.redis.RedisConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * redis 分布式锁
 *
 * @author libo
 * @package com.base.self.locks.distributed
 * @company initcat
 * @date 2020/6/4
 */
public class RedisDistributedLock {

    private static final Logger log = LoggerFactory.getLogger(RedisDistributedLock.class);

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间 单位秒
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
        log.info("tryGetDistributedLock lockKey:{},requestId:{},expireTime:{}", lockKey, requestId, expireTime);
        try (Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost)) {
//            jedis= JedisUtils.getResource();
//            jedis = RedisConstant.getJedis(RedisConstant.localHost);
            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + expireTime * 1000;
            while (System.currentTimeMillis() < end) {
                String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                if (LOCK_SUCCESS.equals(result)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {
        try (Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost);) {
//            jedis= JedisUtils.getResource();
//            jedis = RedisConstant.getJedis(RedisConstant.localHost);
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

            if (RELEASE_SUCCESS.equals(result)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
