package top.wby.boot.mp.utils;

import jakarta.annotation.Resource;
import net.datafaker.Faker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import top.wby.boot.mp.entity.UserAccount;
import top.wby.boot.mp.service.UserAccountService;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

@Component
public class DataFakerUtil {
    public static final Faker ZH_FAKER = new Faker(Locale.CHINA);
    public static final Faker EH_FAKER = new Faker(Locale.ENGLISH);
    public static final String RAW_PASSWORD = "123456";
    public static final String ENCODE_PASSWORD=new BCryptPasswordEncoder().encode(RAW_PASSWORD);
    @Resource
    private UserAccountService userAccountService;
    private UserAccount generateOne(int i){
        UserAccount userAccount = new UserAccount();
        String username = EH_FAKER.name().username();
        userAccount.setUsername(username);
        userAccount.setPassword(ENCODE_PASSWORD);
        userAccount.setNickname(ZH_FAKER.name().fullName());
        userAccount.setEmail(username+"@126.com");
        userAccount.setPhone(EH_FAKER.phoneNumber().cellPhone());
        userAccount.setAvatar(ZH_FAKER.avatar().image());
        userAccount.setStatus(1);
        userAccount.setDeleted(0);
        userAccount.setVersion(0);
        return userAccount;
    }
    public void generateBatch(){
        int total = 1000;
        int step =100;
        for (int start = 0; start < total; start+=step){
            List<UserAccount> batch= IntStream.range(start,start+step).mapToObj(this::generateOne).toList();
            userAccountService.saveBatch(batch,1000);
        }
    }
}
