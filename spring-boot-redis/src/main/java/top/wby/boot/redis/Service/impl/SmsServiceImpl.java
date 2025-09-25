package top.wby.boot.redis.Service.impl;


import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.wby.boot.redis.Exception.ServerException;
import top.wby.boot.redis.Service.SmsService;
import top.wby.boot.redis.cache.RedisCache;
import top.wby.boot.redis.cache.RedisKeys;
import top.wby.boot.redis.config.CloopenConfig;
import top.wby.boot.redis.enums.ErrorCode;
import top.wby.boot.redis.utils.CommonUtils;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final CloopenConfig cloopenConfig;
    private final RedisCache redisCache;
    @Override
    public boolean sendSms(String phoneNum) {
        if (!CommonUtils.checkPhone(phoneNum)){
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }
        int code = CommonUtils.generateCode();
        redisCache.set(RedisKeys.getSmsKey(phoneNum),code,60);
        log.info("向手机号{}发送验证码{}", code);
        boolean flag=true;
//        flag=send(phoneNum,code);
        return flag;
    }
    public boolean send(String phone,int code){
        String serverIp=cloopenConfig.getServerIp();
        String serverPort = cloopenConfig.getPort();
        String accountSId = cloopenConfig.getAccountSId();
        String accountToken = cloopenConfig.getAccountToken();
        String appId = cloopenConfig.getAppId();
        String templateId = cloopenConfig.getTemplateId();
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String[] datas = {String.valueOf(code),"1"};

        HashMap<String, Object> result = sdk.sendTemplateSMS(phone,templateId,datas,"1234", UUID.randomUUID().toString());
        if("000000".equals(result.get("statusCode"))){
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                log.info(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            return false;
        }
        return true;
    }
}
