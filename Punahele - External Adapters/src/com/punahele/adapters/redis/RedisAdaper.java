package com.punahele.adapters.redis;

import redis.clients.jedis.Jedis;

public class RedisAdaper {
	// To save user view history. Maintain the position in video where user watched
	// lately.
	//
	public void storeReqToRedis() {
		Jedis jedis = new Jedis("localhost");
		// adding a new key
		jedis.set("key", "value");
		// getting the key value
		System.out.println(jedis.get("key"));
		jedis.close();
	}
	
	public void getRedisValue(String key) {
		Jedis jedis = new Jedis("localhost");
		// adding a new key
		jedis.get(key);
		// getting the key value
		System.out.println(jedis.get("key"));
		jedis.close();
	}
}
