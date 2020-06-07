package com.base.self.redis;

import redis.clients.jedis.Jedis;

public class RedisConstant {
	public static final String aliHost = "47.104.185.53";
	public static final String localHost = "127.0.0.1";
	private static final Integer port = 6379;
	private static final String aliHostPasswoard = "libo3788125";
	private static final String localhostPasswoard = "3788125";

	public static Jedis getJedis(String host) {
		Jedis jedis = new Jedis(host, port);
		if (aliHost.equals(host)) {
			jedis.auth(aliHostPasswoard);
		} else if (localHost.equals(host)) {
			jedis.auth(localhostPasswoard);
		}
		return jedis;
	}
}
