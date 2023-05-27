package subpub;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.JedisPoolUtil;

/**
 * 消息推送方
 * @author: create by CharwayH
 * @description: subpub
 * @date:2023/5/15
 */
public class JedisPubTest {
    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        System.out.println("===发送消息===");
        jedis.publish("channel","haha");
    }



}
