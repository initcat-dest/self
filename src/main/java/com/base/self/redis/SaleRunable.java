package com.base.self.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SaleRunable implements Runnable {
	public static final String productKey = "iphone8";// 监视的key 当前秒杀商品的数量
	
	String userName;
	public SaleRunable(String userName) {
		this.userName = userName;
	}

	public SaleRunable() {
		super();
	}



//	@Override
//	public void run() {
//		Jedis jedis = getJedis();
//		// 商品的key ， 秒杀有个数量
//		// watch 监视一个key，当事务执行之前这个key发生了改变，事务会被打断
//		jedis.watch(productKey);
//		String value = jedis.get(productKey);
//		int num = Integer.valueOf(value);
//		// 这次秒杀的商品是100个iphone8
//		if (num <= 100 && num >= 1) {
//			// 开启事务
//			Transaction tx = jedis.multi();
//			// 减少一个商品数量
//			tx.incrBy(productKey, -1);
//			// 提交事务，如果商品数量发生了改动 则会返回null
//			List<Object> list = tx.exec();
//			if (list == null || list.size() == 0) {
//				System.out.println(userName + "商品抢购失败！");
//			} else {
//				for (Object success : list) {
//					System.out.println(userName + "(" + success.toString() + ")商品抢购成功,当前抢购成功的人数是：" + (1 - (num - 100)));
//				}
//			}
//		} else {
//			System.out.println(userName + "商品已经被抢完了");
//		}
//		jedis.close();
//	}
	
	@Override
	public void run() {
		Jedis jedis = RedisConstant.getJedis();
		// 商品的key， 秒杀有个数量
		String value = jedis.get(productKey);
		int num = Integer.valueOf(value);
		// 这次秒杀的商品是5个iphone8
		if (num <= 10 && num >= 1) {
			// 减少一个商品数量
			Long count = jedis.decr(productKey);
			if (count == null || count < 0) {
//				System.out.println(System.currentTimeMillis() + ", " + userName + "商品抢购失败！");
			} else {
				System.out.println(System.currentTimeMillis() + ", " + userName + "商品抢购成功,剩余数是：" + count);
			}
		} else {
//			System.out.println(System.currentTimeMillis() + ", " + userName + "商品已经被抢完了");
		}
		jedis.close();
	}
	
	public static void main(String[] args) {
		Jedis jedis = RedisConstant.getJedis();
		jedis.set(productKey, "10");
		jedis.close();

		// 玩多线程
		ExecutorService executor = Executors.newFixedThreadPool(1000);

		for (int i = 1; i <= 1000; i++) {
			executor.execute(new SaleRunable("user" + i));
		}
		executor.shutdown();

	}

}
