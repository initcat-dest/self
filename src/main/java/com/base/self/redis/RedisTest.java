package com.base.self.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class RedisTest {
	
	public static void main(String[] args) {
//		Jedis jedis = RedisConstant.getJedis();
//		jedis.set("test", "1");
//		String string = jedis.get("test");
//		System.out.println(string);
//		System.out.println(jedis.ping());
//		jedis.close();
		
		Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost);
//		Boolean bs= jedis.getbit("result", 100);
//		System.out.println(bs);
		Set<Tuple> test = jedis.zrangeWithScores("test", 0L, -1L);
		for (Tuple tuple : test) {
			System.out.print(tuple.getElement() + "; ");
			System.out.print(tuple.getScore());
			System.out.println();
		}
		jedis.close();
	}

	
	/**
	 * 单机单链接方式 使用java代码操作redis 一般只用于测试代码
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost);
		jedis.set("test", "1");
		String string = jedis.get("test");
		System.out.println(string);
		jedis.close();
	}
	
	@Test
	public void byteTest() {
		Jedis jedis = RedisConstant.getJedis(RedisConstant.localHost);
		String bs= jedis.get("result");
		System.out.println(bs);
		jedis.close();
	}
}
