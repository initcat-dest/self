package com.base.self.redis;

import redis.clients.jedis.Jedis;

public class RedisConstant {
	public static final String host = "47.104.185.53";
	public static final Integer port = 6379;
	public static final String passwoard = "libo3788125";

	public static Jedis getJedis() {
		Jedis jedis = new Jedis(host, port);
		jedis.auth(passwoard);
		return jedis;
	}
}
