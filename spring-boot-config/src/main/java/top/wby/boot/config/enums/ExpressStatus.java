package top.wby.boot.config.enums;
/**
 * @author YUU
 */

//快递的状态
public enum ExpressStatus {
    CREATE("已揽收"),
    SEND("在途中"),
    ARRIVE("已签收"),
    FAIL("派送失败"),
    CANCEL("取消签收");
private final String lable;
    ExpressStatus(String lable) {
        this.lable= lable;
    }

    public String getLable() {
        return lable;
    }
}
