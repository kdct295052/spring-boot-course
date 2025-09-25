package top.wby.boot.redis.Service;

import top.wby.boot.redis.entity.LoginRequest;
import top.wby.boot.redis.entity.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}