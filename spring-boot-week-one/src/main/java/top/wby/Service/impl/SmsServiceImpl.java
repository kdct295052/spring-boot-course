package top.wby.Service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.wby.Service.SmsService;
import top.wby.config.CloopenConfig;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    private CloopenConfig cloopenConfig;
    @Override
    public void sendSms(String phoneNum) {
        int code = ThreadLocalRandom.current().nextInt(1000, 9999);
        log.info("向手机号{}发送验证码{}", phoneNum, code);
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

//        HashMap<String, Object> result = sdk.sendTemplateSMS(phoneNum,templateId,datas,"1234", UUID.randomUUID().toString());
//        if("000000".equals(result.get("statusCode"))){
//            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
//            Set<String> keySet = data.keySet();
//            for(String key:keySet){
//                Object object = data.get(key);
//                log.info(key +" = "+object);
//            }
//        }else{
//            //异常返回输出错误码和错误信息
//            log.error("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
//        }
    }
}
