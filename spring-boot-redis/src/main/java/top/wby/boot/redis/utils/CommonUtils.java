package top.wby.boot.redis.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

public class CommonUtils {
    public static boolean checkPhone(String phone){
        if (phone ==null||phone.length()!=11){
            return false;
        }
        String REGEX_PHONE = "^1[3-9]\\d{9}$";
        Pattern compile = Pattern.compile(REGEX_PHONE);
        return compile.matcher(phone).matches();

    }
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}
