package com.punahele.adapters.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnectionFactory {
	private static JedisPool jedisPool;
	//private final RedisConnector _redisConnector;
    public JedisConnectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //JedisPool jedisPool = _redisConnector.getJedisPool(); 
        //Jedis jedis = jedisPool.getResource(); 
    }

    public JedisPool getJedisPool() {
         return jedisPool;
    }

    public static JedisConnectionFactory getInstance() {
    	// if (instance == null) {
        	//instance = new JedisConnectionFactory();
    	//  }
    // return instance;
    	return null;
    }
}
