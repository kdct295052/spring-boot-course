package top.wby.boot.config.enums;

/**
 * @author YUU
 */

public enum ResultStatus {
    SUCCESS(200, "成功"),
    FAILED(500, "失败");

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private int code;
    private String message;
    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
