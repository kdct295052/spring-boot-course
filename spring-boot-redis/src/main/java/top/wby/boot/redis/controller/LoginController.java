package top.wby.boot.redis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.boot.redis.Result.Result;
import top.wby.boot.redis.Service.LoginService;
import top.wby.boot.redis.entity.LoginRequest;
import top.wby.boot.redis.entity.LoginResponse;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = loginService.login(loginRequest);
        return Result.ok(loginResponse);
    }
}

