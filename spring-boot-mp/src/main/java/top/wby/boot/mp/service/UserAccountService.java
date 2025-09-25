package top.wby.boot.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.wby.boot.mp.entity.UserAccount;

import java.util.List;

public interface UserAccountService extends IService<UserAccount> {
    boolean createUserAccount(UserAccount user);
    boolean updateUserAccount(List<UserAccount> users);
}
