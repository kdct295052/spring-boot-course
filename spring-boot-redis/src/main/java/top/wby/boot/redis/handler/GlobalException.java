package top.wby.boot.redis.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wby.boot.redis.Exception.ServerException;
import top.wby.boot.redis.Result.Result;

@Slf4j
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServerException.class)
    public Result<String> handleBusinessException(ServerException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return Result.error(e.getMessage());
    }
}
