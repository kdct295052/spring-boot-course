package top.wby.boot.redis.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class StudentTest {
@Resource
    private RedisTemplate<String,Student> redisTemplate;
@Test
    void testStudent(){
    Adress build = Adress.builder().city("上海").province("上海").build();
    Student student = Student.builder().id("1").name("张三").build();
    redisTemplate.opsForValue().set("student",student,10, TimeUnit.SECONDS);
}
}