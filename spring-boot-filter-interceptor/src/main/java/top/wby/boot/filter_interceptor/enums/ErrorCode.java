package top.wby.boot.filter_interceptor.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    PARAM_ERROE(400, "参数错误"),
    NOTAUTHORIZED(401, "登录失败，请重新登录"),
    NOT_PERMISSION(403, "权限不足"),
    NOT_FOUND(404, "未找到资源"),
    METHOD_ERROR(405, "方法不允许"),
    SERVICE_ERROR(500, "服务器异常");
    private int code;
    private String message;
}
