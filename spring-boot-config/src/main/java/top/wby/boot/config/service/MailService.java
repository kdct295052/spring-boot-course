package top.wby.boot.config.service;

import top.wby.boot.config.enums.ResultStatus;
import top.wby.boot.config.model.Mail;

/**
 * @author YUU
 */
public interface MailService {
    ResultStatus sendSimpleEmail(Mail mail);
    ResultStatus sendHtmlEmail(Mail mail);
}
