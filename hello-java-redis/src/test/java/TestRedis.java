import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        // 连接Jedis
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("name","kobe");
        System.out.println(jedis.get("name"));
        jedis.lpush("list1","1","2","3","4","5");
        System.out.println(jedis.llen("list1"));
    }
}
