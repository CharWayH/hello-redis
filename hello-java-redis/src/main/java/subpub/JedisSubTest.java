package subpub;

import org.apache.commons.lang.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.JedisPoolUtil;


/**
 * @author: create by CharwayH
 * @description: PACKAGE_NAME
 * @date:2023/5/15
 */
public class JedisSubTest {

    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPool();
        Jedis jedis = jedisPool.getResource();
        System.out.println("===开启监听===");
        jedis.subscribe(new RedisSubPubListener(),"channel");
        // 可以订阅多个频道
        jedis.subscribe(new RedisSubPubListener(), "channel1","channel2");
        // 通过数组的方式设置多个频道
        jedis.subscribe(new RedisSubPubListener(), new String[]{"channel1","channel2","channel3"});
        // 使用模拟匹配的方式设置频道
        jedis.subscribe(new RedisSubPubListener(), new String[]{"channel*"});
    }


}
