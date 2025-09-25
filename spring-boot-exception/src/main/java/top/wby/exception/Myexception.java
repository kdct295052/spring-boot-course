package top.wby.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.wby.enums.ErrorCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class Myexception extends RuntimeException{
    private int code;
    private String msg;

    public Myexception(String msg) {
        super( msg);
        this.code = ErrorCode.SERVICE_ERROR.getCode();
        this.msg= msg;
    }

    public Myexception(ErrorCode errorCode) {
        super( errorCode.getMessage());
        this.code = errorCode.getCode();
    }
    public Myexception(ErrorCode errorCode,Throwable e) {
        super( errorCode.getMessage());
        this.code = errorCode.getCode();
    }
}
