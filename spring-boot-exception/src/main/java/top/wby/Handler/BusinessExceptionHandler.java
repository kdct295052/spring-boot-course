package top.wby.Handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.wby.common.Result;
import top.wby.exception.Myexception;

@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {
    @ExceptionHandler(Myexception.class)
    public Result<String> handleBusinessException(Myexception e) {
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
