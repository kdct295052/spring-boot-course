package top.wby.boot.config.common;

import lombok.Getter;
import top.wby.boot.config.enums.ResultStatus;

@Getter
public class ApiResponse <T>{
    private final int code;
    private final String msg;
    private final T data;

    public ApiResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static <T> ApiResponse<T> success(String msg,T data){
        return new ApiResponse<>(ResultStatus.SUCCESS.getCode(),msg,data);
    }
    public static <T> ApiResponse<T> failed(String msg){
        return new ApiResponse<>(ResultStatus.FAILED.getCode(),msg,null);
    }
}
