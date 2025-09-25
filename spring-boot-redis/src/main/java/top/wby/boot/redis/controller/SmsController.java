package top.wby.boot.redis.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.wby.boot.redis.Result.Result;
import top.wby.boot.redis.Service.SmsService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class SmsController {
    @Resource
    private SmsService smsService;
    @GetMapping("/sms/send")
    public Result<Boolean> sendSms(@RequestParam String phone){
        return Result.ok(smsService.sendSms(phone));
    }
}
