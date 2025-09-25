package top.wby.boot.redis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNAUTHORIZED(401, "登录失败，请重新登录"),INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    CODE_SEND_FAIL(3001, "验证码发送失败"),SMS_CODE_ERROR(3002, "验证码错误"),
    PARAMS_ERROR(3003, "参数错误"),;
    private final int code;
    private final String message;
}
