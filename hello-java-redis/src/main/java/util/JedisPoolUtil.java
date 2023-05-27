package util;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: create by CharwayH
 * @description: util
 * @date:2023/5/18
 */
public class JedisPoolUtil {
    private static JedisPoolUtil jedisPoolUtil = null;
    private static JedisPool jedisPool= null;

    public static JedisPool getJedisPool(){
        if(jedisPoolUtil!=null){
            return jedisPool;
        }else {
            new JedisPoolUtil();
            return jedisPool;
        }
    }

    JedisPoolUtil(){
       jedisPool = initPool();
    }

    //初始化普通pool
    private  JedisPool initPool() {
        String ip = "192.168.1.181";
        int port = 6379;
        String password = null;
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例，通过getResource()来获取；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(100);
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(20);
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(1000 * 100);
        config.setTestOnBorrow(true);
        if (StringUtils.isEmpty(password)) {
            return new JedisPool(config, ip, port, 10000);
        } else {
            return new JedisPool(config, ip, port, 10000, password);
        }
    }
}
