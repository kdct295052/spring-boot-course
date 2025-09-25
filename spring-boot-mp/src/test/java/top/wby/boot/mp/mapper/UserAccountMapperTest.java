package top.wby.boot.mp.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.wby.boot.mp.entity.UserAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserAccountMapperTest {
    @Resource
    private UserAccountMapper userAccountMapper;
    @Test
    void Test(){
        UserAccount userAccount = userAccountMapper.selectById(1);
        assertEquals("user001", userAccount.getUsername());
    }
    @Test
    void insertTest(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user0023");
        userAccount.setNickname("user0099");
        userAccount.setEmail("user002@163.com");
        userAccount.setPhone("12345678901");
        userAccount.setStatus(1);
        int row = userAccountMapper.insert(userAccount);
        assertEquals(1, row);
    }
    @Test
    void updateTest(){
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1L);
        userAccount.setUsername("user0023");
        userAccount.setNickname("user0023");
        userAccount.setEmail("user001@163.com");
        userAccount.setPhone("12345678901");
        userAccount.setStatus(1);
        int row = userAccountMapper.updateById(userAccount);
        assertEquals(1, row);
    }

}