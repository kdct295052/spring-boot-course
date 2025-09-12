package top.wby.boot.config.service.impl;

import jakarta.annotation.Resource;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import top.wby.boot.config.enums.ResultStatus;
import top.wby.boot.config.model.Mail;
import top.wby.boot.config.service.MailService;
@Service
public class Mailimplement implements MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender javaMailSender ;
    @Override
    public ResultStatus sendSimpleEmail(Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getContent());
        try {
            javaMailSender.send(simpleMailMessage);
            return ResultStatus.SUCCESS;
        }catch (Exception e){
            return ResultStatus.FAILED;
        }

    }

    @Override
    public ResultStatus sendHtmlEmail(Mail mail) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper headers ;
        try {
            headers=new MimeMessageHelper(mimeMessage ,true);
            headers.setFrom(from);
            headers.setTo(mail.getTo());
            headers.setSubject(mail.getSubject());
            headers.setText(mail.getContent(),true);
            javaMailSender.send(mimeMessage);
            return ResultStatus.SUCCESS;
        } catch (Exception e) {
            return ResultStatus.FAILED;
        }
    }
}
