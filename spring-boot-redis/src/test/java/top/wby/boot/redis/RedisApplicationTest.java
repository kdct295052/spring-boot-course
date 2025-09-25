package top.wby.boot.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void testRedis() {
        stringRedisTemplate.opsForValue().set("name", "wby", 10, TimeUnit.SECONDS);
//        String name = stringRedisTemplate.opsForValue().get("name");
//        System.out.println(name);
    }
}