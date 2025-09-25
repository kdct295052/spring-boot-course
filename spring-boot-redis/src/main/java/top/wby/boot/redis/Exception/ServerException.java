package top.wby.boot.redis.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.wby.boot.redis.enums.ErrorCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ServerException extends RuntimeException{
    private int code;
    private String msg;

    public ServerException(String msg) {
        super( msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg= msg;
    }

    public ServerException(ErrorCode errorCode) {
        super( errorCode.getMessage());
        this.code = errorCode.getCode();
    }
    public ServerException(ErrorCode errorCode,Throwable e) {
        super( errorCode.getMessage());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }
}
