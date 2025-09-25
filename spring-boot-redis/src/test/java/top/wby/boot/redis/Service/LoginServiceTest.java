package top.wby.boot.redis.Service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
@Slf4j
class LoginServiceTest {
    @Test
    public void testLoginFlow() {
        log.info("登录接⼝测试");
        log.info("1. 先调⽤发送短信接⼝: GET /sms?phone=13800138000");
        log.info("2. 再调⽤登录接⼝: POST /login");
        log.info("   请求体示例:");
        log.info("   {");
        log.info("     \"phone\": \"19533161326\",");
        log.info("     \"code\": \"123456\"");
        log.info("   }");
    }
}
