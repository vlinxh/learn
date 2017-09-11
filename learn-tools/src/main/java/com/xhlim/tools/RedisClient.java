package com.xhlim.tools;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author xhlim@outlook.com
 * @create 2017-08-30 19:07
 */
public class RedisClient {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池

    public RedisClient() {
        initialPool();
        initialShardedPool();
        shardedJedis = shardedJedisPool.getResource();
        jedis = jedisPool.getResource();


    }

    /**
     * 初始化非切片池
     */
    private void initialPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        // config.setMaxActive(20);
        config.setMaxIdle(5);
        // config.setMaxWait(1000l);
        config.setTestOnBorrow(false);

        // jedisPool = new JedisPool(config, "42.123.125.168", 9736);
        jedisPool = new JedisPool(config, "122.114.226.115", 6379);
    }

    /**
     * 初始化切片池
     */
    private void initialShardedPool() {
        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        // config.setMaxActive(20);
        config.setMaxIdle(5);
        // config.setMaxWait(1000l);
        config.setTestOnBorrow(false);
        // slave链接
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("122.114.226.115", 6379, "master"));

        // 构造池
        shardedJedisPool = new ShardedJedisPool(config, shards);
    }

    public void install(String key, String val) {
        jedis.sadd(key,val);
    }

    public void show() {
        KeyOperate();
        StringOperate();
        ListOperate();
        SetOperate();
        SortedSetOperate();
        HashOperate();
    }

    private void KeyOperate() {
        Set<String> keys = jedis.keys("phone*");
        Iterator<String> iterator = keys.iterator();

        // while (iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }

    }

    private void StringOperate() {

    }

    private void ListOperate() {

    }

    private void SetOperate() {

    }

    private void SortedSetOperate() {

    }

    private void HashOperate() {

    }
}
