package top.wby.boot.config.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import top.wby.boot.config.common.ApiResponse;
import top.wby.boot.config.enums.ResultStatus;
import top.wby.boot.config.model.Mail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.boot.config.service.MailService;

@RestController
@RequestMapping("/email")
public class SendEmailController {
    @Resource
    private MailService mailService;
   @PostMapping("/send")
    public ResponseEntity<ApiResponse<ResultStatus>> sendEmail(@Valid @RequestBody Mail mail) {
       ResultStatus resultStatus = mailService.sendSimpleEmail(mail);
       if (resultStatus == ResultStatus.SUCCESS){
           return ResponseEntity.ok(ApiResponse.success("发送成功",resultStatus));
       }
       return ResponseEntity.badRequest().body(ApiResponse.failed("发送失败"));
   }
   @PostMapping("/sendHtml")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlEmail(@Valid @RequestBody Mail mail) {
       ResultStatus resultStatus = mailService.sendHtmlEmail(mail);
       if (resultStatus == ResultStatus.SUCCESS){
           return ResponseEntity.ok(ApiResponse.success("发送成功",resultStatus));
       }
       return ResponseEntity.badRequest().body(ApiResponse.failed("发送失败"));
   }
}
