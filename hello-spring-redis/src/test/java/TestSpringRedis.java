import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Spring访问Redis
 */
@ContextConfiguration("classpath:redis.xml")
public class TestSpringRedis extends AbstractJUnit4SpringContextTests {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Test
    public void testConn(){
        redisTemplate.opsForValue().set("name","kobe");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
