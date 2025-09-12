package top.wby.boot.config.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wby.boot.config.model.Mail;
@SpringBootTest
class MailServiceTest {
    @Resource
    private MailService mailService;
    @Test
    void sendSimpleEmail() {
        Mail mail = new Mail();
        mail.setTo("wangboyubb@outlook.com");
        mail.setSubject("测试");
        mail.setContent("测试");
        mailService.sendSimpleEmail( mail);


    }
}