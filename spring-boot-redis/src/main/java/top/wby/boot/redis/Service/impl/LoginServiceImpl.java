package top.wby.boot.redis.Service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.wby.boot.redis.Exception.ServerException;
import top.wby.boot.redis.Service.LoginService;
import top.wby.boot.redis.cache.RedisCache;
import top.wby.boot.redis.cache.RedisKeys;
import top.wby.boot.redis.entity.LoginRequest;
import top.wby.boot.redis.entity.LoginResponse;
import top.wby.boot.redis.utils.CommonUtils;

import java.util.UUID;
@Slf4j
@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {
    private final RedisCache redisCache;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String phone=loginRequest.getPhone();
        String code=loginRequest.getCode();
        if (!CommonUtils.checkPhone( phone)){
            throw new ServerException("验证码不能为空");
        }
        String smsKey = RedisKeys.getSmsKey(phone);
        String string = redisCache.get(smsKey).toString();
        if (string==null){
            throw new ServerException("验证码已过期");
        }
        if (!string.equals(code)){
            throw new ServerException("验证码错误");
        }
        redisCache.delete(smsKey);
        // 返回登录响应对象
        return new LoginResponse(generateToken(phone), phone);

    }
    private String generateToken(String phone) {
        return UUID.randomUUID().toString().replace("-", "")+phone.hashCode();
    }
}
